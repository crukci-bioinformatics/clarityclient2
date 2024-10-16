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

package org.cruk.clarity.api.filestore;

import java.io.IOException;

import org.cruk.clarity.api.impl.URLInputStreamResource;

import com.genologics.ri.file.ClarityFile;

/**
 * Interface for SFTP file store upload and delete implementations to adhere to. These
 * implementations allow the Clarity API Client to upload to and delete from
 * the Clarity file store on the server. Without an implementation present the client
 * will work but only through HTTP, which has limitations.
 *
 * @since 2.31.0
 */
public interface ClaritySFTPUploader
{
    /**
     * Set how long an SSH connection will take to time out (in milliseconds).
     *
     * @param timeout The time out, in milliseconds. Generally 0 means infinite.
     *
     * @throws IllegalArgumentException if {@code timeout} is negative.
     */
    void setTimeout(int timeout);

    /**
     * Set the credentials used to connect to the file store.
     *
     * @param username The file store user account.
     * @param password The file store user password.
     *
     * @throws IllegalArgumentException if {@code username} is null.
     */
    void setFilestoreCredentials(String username, String password);

    /**
     * Upload a file to the Clarity file store.
     *
     * @param fileURLResource The URL resource of the file on the local machine.
     * @param targetFile The ClarityFile object that holds the reference to the
     * uploaded file, which was newly created using the API.
     *
     * @throws IOException if there is a problem with the transfer.
     */
    void upload(URLInputStreamResource fileURLResource, ClarityFile targetFile)
    throws IOException;

    /**
     * Delete a file from the Clarity file store.
     *
     * @param targetFile The ClarityFile object that holds the reference to the
     * file to delete.
     *
     * @throws IOException if there is a problem with the delete.
     */
    void delete(ClarityFile targetFile) throws IOException;
}
