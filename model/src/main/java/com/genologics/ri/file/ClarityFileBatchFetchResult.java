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

package com.genologics.ri.file;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.BatchUpdate;
import com.genologics.ri.ClarityBatchRetrieveResult;
import com.genologics.ri.Namespaces;

/**
 * The representation of a batch of file resources.
 * <p>
 * This class is used to encapsulate multiple {@link ClarityFile} objects for batch
 * operations such as fetching, creating, or updating files in the Clarity LIMS system.
 * It implements the {@link BatchUpdate} interface to support batch create and update
 * operations on file resources.
 * </p>
 *
 * @since 2.18
 */
@ClarityBatchRetrieveResult(entityClass = ClarityFile.class, batchUpdate = true)
@XmlRootElement(name = "details")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "details")
public class ClarityFileBatchFetchResult implements BatchUpdate<ClarityFile>, Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = -536166874357106044L;

    /**
     * The list of file resources in this batch.
     */
    @XmlElement(name = "file", namespace = Namespaces.FILE_NAMESPACE)
    protected List<ClarityFile> files;

    /**
     * Creates a new, empty ClarityFileBatchFetchResult.
     */
    public ClarityFileBatchFetchResult()
    {
    }

    /**
     * Gets the list of files in this batch. If the list is null, it will be
     * initialized to an empty list.
     *
     * @return The list of files in this batch.
     */
    public List<ClarityFile> getFiles()
    {
        if (files == null)
        {
            files = new ArrayList<>();
        }
        return files;
    }

    /**
     * Gets the list of files in this batch. This method is required by the
     * {@link BatchUpdate} interface.
     *
     * @return The list of files in this batch.
     */
    @Override
    public List<ClarityFile> getList()
    {
        return getFiles();
    }

    /**
     * Gets the number of files in this batch.
     *
     * @return The number of files, or 0 if the files list is null.
     */
    @Override
    public int getSize()
    {
        return files == null ? 0 : files.size();
    }

    /**
     * Adds a collection of file entities to this batch for creation.
     * The entities are added to the internal files list.
     *
     * @param entities The collection of file entities to add for creation.
     */
    @Override
    public void addForCreate(Collection<ClarityFile> entities)
    {
        getFiles().addAll(entities);
    }

    /**
     * Adds a collection of file entities to this batch for update.
     * The entities are added to the internal files list. Note that there are
     * no state parameters to worry about for file resources.
     *
     * @param entities The collection of file entities to add for update.
     */
    @Override
    public void addForUpdate(Collection<ClarityFile> entities)
    {
        // Nothing to worry about with state parameters for files.
        getFiles().addAll(entities);
    }

}
