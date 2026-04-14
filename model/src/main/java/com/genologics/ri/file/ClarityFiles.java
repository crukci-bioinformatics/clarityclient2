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
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.ClarityQueryResult;
import com.genologics.ri.Page;
import com.genologics.ri.PaginatedBatch;

/**
 * The representation for a list of file links.
 * <p>
 * The system enforces a maximum number of elements when generating the list of
 * links. When the size of the request result set is larger than the system
 * maximum, the list represents a paged view of the overall results, and the
 * previous-page and next-page elements provide URIs linking to the previous or
 * next page of links in the overall results.
 * </p>
 */
@ClarityQueryResult(entityClass = ClarityFile.class)
@XmlRootElement(name = "files")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "files", propOrder = { "files", "previousPage", "nextPage" })
public class ClarityFiles implements PaginatedBatch<FileLink>, Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = -1824449685486824569L;

    /**
     * The list of file links.
     */
    @XmlElement(name = "file")
    protected List<FileLink> files;

    /**
     * A link to the previous page of results, if available.
     */
    @XmlElement(name = "previous-page")
    protected Page previousPage;

    /**
     * A link to the next page of results, if available.
     */
    @XmlElement(name = "next-page")
    protected Page nextPage;

    /**
     * Creates a new, empty ClarityFiles instance.
     */
    public ClarityFiles()
    {
    }

    /**
     * Gets the list of file links. If the list is null, it will be
     * initialized to an empty list.
     *
     * @return The list of file links.
     */
    public List<FileLink> getFiles()
    {
        if (files == null)
        {
            files = new ArrayList<>();
        }
        return files;
    }

    /**
     * Gets the list of file links. This method is required by the
     * {@link PaginatedBatch} interface.
     *
     * @return The list of file links.
     */
    @Override
    public List<FileLink> getList()
    {
        return getFiles();
    }

    /**
     * Gets the number of file links in this collection.
     *
     * @return The number of file links, or 0 if the files list is null.
     */
    @Override
    public int getSize()
    {
        return files == null ? 0 : files.size();
    }

    /**
     * Gets the link to the previous page of results.
     *
     * @return The previous page link, or null if there is no previous page.
     */
    public Page getPreviousPage()
    {
        return previousPage;
    }

    /**
     * Sets the link to the previous page of results.
     *
     * @param previousPage The previous page link.
     */
    public void setPreviousPage(Page previousPage)
    {
        this.previousPage = previousPage;
    }

    /**
     * Gets the link to the next page of results.
     *
     * @return The next page link, or null if there is no next page.
     */
    public Page getNextPage()
    {
        return nextPage;
    }

    /**
     * Sets the link to the next page of results.
     *
     * @param nextPage The next page link.
     */
    public void setNextPage(Page nextPage)
    {
        this.nextPage = nextPage;
    }

}
