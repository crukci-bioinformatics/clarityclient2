package org.cruk.clarity.api.impl;

import java.io.IOException;
import java.text.MessageFormat;

import org.cruk.clarity.api.ClarityUpdateException;
import org.cruk.clarity.api.filestore.ClaritySFTPUploader;

import com.genologics.ri.file.ClarityFile;

/**
 * A no-op implementation of {@code ClaritySFTPUploader} that is set on the client
 * at creation to provide an object that will stop operations if it is used.
 */
class NullSFTPUploader implements ClaritySFTPUploader
{
    /**
     * Basis of the exception message.
     */
    private static final String REJECTION_MESSAGE = "Cannot access the file store for {0}. No SFTP implementation is available.";

    /**
     * Constructor.
     */
    NullSFTPUploader()
    {
    }

    /**
     * {@inheritDoc}
     * This implementation does nothing with this method.
     */
    @Override
    public void setTimeout(int timeout)
    {
    }

    /**
     * {@inheritDoc}
     * This implementation does nothing with this method.
     */
    @Override
    public void setFilestoreCredentials(String username, String password)
    {
    }

    /**
     * {@inheritDoc}
     * This implementation cannot perform an upload, so always throws an exception.
     *
     * @throws ClarityUpdateException always.
     */
    @Override
    public void upload(URLInputStreamResource fileURLResource, ClarityFile targetFile) throws IOException
    {
        throw new ClarityUpdateException(MessageFormat.format(REJECTION_MESSAGE, "upload"));
    }

    /**
     * {@inheritDoc}
     * This implementation cannot perform a delete, so always throws an exception.
     *
     * @throws ClarityUpdateException always.
     */
    @Override
    public void delete(ClarityFile targetFile) throws IOException
    {
        throw new ClarityUpdateException(MessageFormat.format(REJECTION_MESSAGE, "delete"));
    }
}
