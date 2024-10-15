package org.cruk.clarity.api.sftp.mina;

import static org.apache.commons.lang3.StringUtils.isEmpty;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.util.Objects;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.ClassUtils;
import org.apache.sshd.client.SshClient;
import org.apache.sshd.client.auth.keyboard.UserInteraction;
import org.apache.sshd.client.config.hosts.HostConfigEntryResolver;
import org.apache.sshd.client.keyverifier.AcceptAllServerKeyVerifier;
import org.apache.sshd.client.session.ClientSession;
import org.apache.sshd.common.SshConstants;
import org.apache.sshd.common.util.io.IoUtils;
import org.apache.sshd.core.CoreModuleProperties;
import org.apache.sshd.sftp.client.SftpClient;
import org.apache.sshd.sftp.client.SftpClient.Attributes;
import org.apache.sshd.sftp.client.SftpClientFactory;
import org.apache.sshd.sftp.common.SftpConstants;
import org.apache.sshd.sftp.common.SftpException;
import org.cruk.clarity.api.impl.URLInputStreamResource;
import org.cruk.clarity.api.sftp.ClaritySFTPUploader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.genologics.ri.file.ClarityFile;

/**
 * Apache Mina SSH implementation of {@code ClaritySFTPUploader}.
 */
@Component
public class ClarityMinaSSHFileUploader implements ClaritySFTPUploader
{
    /**
     * Logger.
     */
    protected Logger logger = LoggerFactory.getLogger(ClaritySFTPUploader.class);

    /**
     * Apache Mina {@code SshClient} instance.
     */
    protected SshClient sshClient;

    /**
     * Connection time out in milliseconds.
     */
    private int timeout = 10000;

    /**
     * The user to connect as.
     */
    private String username;

    /**
     * The password to use.
     */
    private String password;

    /**
     * Constructor.
     */
    public ClarityMinaSSHFileUploader()
    {
        sshClient = SshClient.setUpDefaultClient();
        sshClient.setServerKeyVerifier(AcceptAllServerKeyVerifier.INSTANCE);
        sshClient.setUserInteraction(UserInteraction.NONE);
        sshClient.setHostConfigEntryResolver(HostConfigEntryResolver.EMPTY);

        CoreModuleProperties.PREFERRED_AUTHS.set(sshClient, "password");
        CoreModuleProperties.AUTH_METHODS.set(sshClient, "password");

        logger.debug("SFTP functionality provided by {}", ClassUtils.getShortClassName(getClass()));
    }

    /**
     * Constructor with a preconfigured {@code SshClient} instance.
     *
     * @param client The SshClient instance.
     */
    public ClarityMinaSSHFileUploader(SshClient client)
    {
        Objects.requireNonNull(client, "client cannot be set to null");
        this.sshClient = client;
    }

    @PostConstruct
    public void start()
    {
        sshClient.start();
    }

    @PreDestroy
    public void stop()
    {
        sshClient.stop();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setTimeout(int timeout)
    {
        if (timeout < 0)
        {
            throw new IllegalArgumentException("timeout must be >= 0");
        }
        this.timeout = timeout;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setFilestoreCredentials(String username, String password)
    {
        if (isEmpty(username))
        {
            throw new IllegalArgumentException("username cannot be empty.");
        }
        this.username = username;
        this.password = password;
    }

    /**
     * {@inheritDoc}
     */
    public void upload(URLInputStreamResource fileURLResource, ClarityFile targetFile)
    throws IOException
    {
        final URI targetURI = targetFile.getContentLocation();
        final String host = targetFile.getContentLocation().getHost();
        final int port = getPort(targetURI);

        checkProtocol(targetURI);

        try (ClientSession session = sshClient.connect(username, host, port).verify(timeout).getSession())
        {
            session.addPasswordIdentity(password);
            session.auth().verify(timeout);

            logger.info("Uploading {} over SFTP to {} on {}",
                        fileURLResource.getURL().getPath(),
                        targetURI.getPath(),
                        host);

            try (SftpClient sftpClient = SftpClientFactory.instance().createSftpClient(session))
            {
                String directory = FilenameUtils.getFullPathNoEndSeparator(targetURI.getPath());

                if (!remoteDirectoryExists(sftpClient, directory))
                {
                    String[] directoryParts = directory.split("/+");

                    StringBuilder incrementalPath = new StringBuilder(directory.length());

                    for (int i = 1; i < directoryParts.length; i++)
                    {
                        incrementalPath.append('/').append(directoryParts[i]);

                        String currentPath = incrementalPath.toString();

                        if (!remoteDirectoryExists(sftpClient, currentPath))
                        {
                            sftpClient.mkdir(currentPath);
                            if (!remoteDirectoryExists(sftpClient, currentPath))
                            {
                                throw new IOException("Could not create file store directory " + directory);
                            }
                        }
                    }
                }

                try (OutputStream out = sftpClient.write(targetURI.getPath()))
                {
                    IoUtils.copy(fileURLResource.getInputStream(), out);
                }
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(ClarityFile targetFile) throws IOException
    {
        final URI targetURI = targetFile.getContentLocation();
        final String host = targetFile.getContentLocation().getHost();
        final int port = getPort(targetURI);

        checkProtocol(targetURI);

        try (ClientSession session = sshClient.connect(username, host, port).verify(timeout).getSession())
        {
            session.addPasswordIdentity(password);
            session.auth().verify(timeout);

            try (SftpClient sftpClient = SftpClientFactory.instance().createSftpClient(session))
            {
                sftpClient.remove(targetURI.getPath());
            }
            catch (SftpException e)
            {
                throwUnlessNotFound(e);
            }
        }
    }

    /**
     * Ensure that the protocol for the URI is "sftp".
     *
     * @param uri The URI.
     *
     * @throws UnsupportedOperationException if the protocol is not "sftp".
     */
    private void checkProtocol(URI uri)
    {
        if (!"sftp".equalsIgnoreCase(uri.getScheme()))
        {
            throw new UnsupportedOperationException(ClassUtils.getShortClassName(getClass()) + " can only handle SFTP operations.");
        }
    }

    /**
     * Get the attributes of a remote file or directory.
     *
     * @param sftp The ChannelSftp from JSch.
     * @param path The path of the file to access.
     *
     * @return The attributes of the file, or null if the file does not exist.
     *
     * @throws SftpException if there is a problem accessing the file.
     */
    private Attributes remoteAttrs(SftpClient sftp, String path) throws IOException
    {
        try
        {
            return sftp.stat(path);
        }
        catch (SftpException e)
        {
            throwUnlessNotFound(e);
            return null;
        }
    }

    /**
     * Test whether a remote directory exists.
     *
     * @param sftp The ChannelSftp from JSch.
     * @param path The path of the directory.
     *
     * @return true if the remote path exists and is a directory, false otherwise.
     *
     * @throws SftpException if there is a problem accessing the directory.
     */
    private boolean remoteDirectoryExists(SftpClient sftp, String path) throws IOException
    {
        Attributes info = remoteAttrs(sftp, path);
        return info != null && info.isDirectory();
    }

    /**
     * Test whether an SftpException indicates a remote path that doesn't exist.
     *
     * @param e The exception.
     *
     * @throws SftpException a rethrow of {@code e} unless {@code e} indicated a
     * file not found.
     */
    private void throwUnlessNotFound(SftpException e) throws SftpException
    {
        if (e.getStatus() != SftpConstants.SSH_FX_NO_SUCH_FILE)
        {
            throw e;
        }
    }

    /**
     * Get the port used in the URI. If it's not set, return the SSH default.
     *
     * @param uri The URI.
     *
     * @return The port specified by the URI.
     */
    private int getPort(URI uri)
    {
        int port = uri.getPort();
        if (port < 1)
        {
            port = SshConstants.DEFAULT_PORT;
        }
        return port;
    }
}
