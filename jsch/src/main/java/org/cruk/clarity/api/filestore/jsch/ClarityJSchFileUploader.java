/*
 * CRUK-CI Clarity REST API Java Client.
 * Copyright (C) 2013 Cancer Research UK Cambridge Institute.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.cruk.clarity.api.filestore.jsch;

import static org.apache.commons.lang3.StringUtils.isEmpty;

import java.io.IOException;
import java.net.URI;
import java.util.Objects;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.ClassUtils;
import org.cruk.clarity.api.filestore.ClaritySFTPUploader;
import org.cruk.clarity.api.impl.URLInputStreamResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.genologics.ri.file.ClarityFile;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.ConfigRepository;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.OpenSSHConfig;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpATTRS;
import com.jcraft.jsch.SftpException;

/**
 * JCraft Jsch implementation of {@code ClaritySFTPUploader}.
 */
@Component
public class ClarityJSchFileUploader implements ClaritySFTPUploader
{
    /**
     * The default SSH port (22). Not seemingly present as a JSch constant that I could find.
     */
    static final int DEFAULT_SSH_PORT = 22;

    /**
     * Logger.
     */
    protected Logger logger = LoggerFactory.getLogger(ClaritySFTPUploader.class);

    /**
     * {@code JSch} instance.
     */
    protected JSch jsch;

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
     *
     * @throws IOException if there is a problem initialising the JSch instance
     * (but in practice it won't happen).
     */
    public ClarityJSchFileUploader() throws IOException
    {
        ConfigRepository config = OpenSSHConfig.parse("StrictHostKeyChecking=no;PreferredAuthentications=password;");

        jsch = new JSch();
        jsch.setConfigRepository(config);

        logger.debug("SFTP functionality provided by {}", ClassUtils.getShortClassName(getClass()));
    }

    /**
     * Constructor with a preconfigured {@code JSch} instance.
     *
     * @param jsch The JSch instance.
     */
    public ClarityJSchFileUploader(JSch jsch)
    {
        Objects.requireNonNull(jsch, "jsch cannot be set to null");
        this.jsch = jsch;
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
    @Override
    public void upload(URLInputStreamResource fileURLResource, ClarityFile targetFile)
    throws IOException
    {
        final URI targetURI = targetFile.getContentLocation();
        final String host = targetURI.getHost();
        final int port = getPort(targetURI);

        checkProtocol(targetURI);

        try
        {
            Session session = jsch.getSession(username, targetFile.getContentLocation().getHost(), port);
            session.setPassword(password);
            session.connect(timeout);

            try
            {
                ChannelSftp sftp = (ChannelSftp)session.openChannel("sftp");
                sftp.connect(timeout);
                try
                {
                    logger.info("Uploading {} over SFTP to {} on {}",
                                fileURLResource.getURL().getPath(),
                                targetURI.getPath(),
                                host);

                    String directory = FilenameUtils.getFullPathNoEndSeparator(targetURI.getPath());

                    if (!remoteDirectoryExists(sftp, directory))
                    {
                        String[] directoryParts = directory.split("/+");

                        StringBuilder incrementalPath = new StringBuilder(directory.length());

                        for (int i = 1; i < directoryParts.length; i++)
                        {
                            incrementalPath.append('/').append(directoryParts[i]);

                            String currentPath = incrementalPath.toString();

                            if (!remoteDirectoryExists(sftp, currentPath))
                            {
                                sftp.mkdir(currentPath);
                                if (!remoteDirectoryExists(sftp, currentPath))
                                {
                                    throw new IOException("Could not create file store directory " + directory);
                                }
                            }
                        }
                    }

                    sftp.put(fileURLResource.getInputStream(), targetURI.getPath());
                }
                finally
                {
                    sftp.disconnect();
                }
            }
            finally
            {
                session.disconnect();
            }
        }
        catch (JSchException | SftpException e)
        {
            throw new IOException("SSH problem with file upload:", e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(ClarityFile targetFile) throws IOException
    {
        final URI targetURI = targetFile.getContentLocation();
        final String host = targetURI.getHost();
        final int port = getPort(targetURI);

        checkProtocol(targetURI);

        try
        {
            Session session = jsch.getSession(username, host, port);
            session.setPassword(password);
            session.connect(timeout);

            try
            {
                ChannelSftp sftp = (ChannelSftp)session.openChannel("sftp");
                sftp.connect(timeout);
                try
                {
                    sftp.rm(targetURI.getPath());
                }
                catch (SftpException e)
                {
                    throwUnlessNotFound(e);
                }
                finally
                {
                    sftp.disconnect();
                }
            }
            finally
            {
                session.disconnect();
            }
        }
        catch (JSchException | SftpException e)
        {
            throw new IOException("SSH problem with file delete:", e);
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
    private SftpATTRS remoteAttrs(ChannelSftp sftp, String path) throws SftpException
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
    private boolean remoteDirectoryExists(ChannelSftp sftp, String path) throws SftpException
    {
        SftpATTRS info = remoteAttrs(sftp, path);
        return info != null && info.isDir();
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
        if (e.id != ChannelSftp.SSH_FX_NO_SUCH_FILE)
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
            port = DEFAULT_SSH_PORT;
        }
        return port;
    }
}
