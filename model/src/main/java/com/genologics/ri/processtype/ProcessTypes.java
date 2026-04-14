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

package com.genologics.ri.processtype;

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
 *
 * The representation for a list of process type links.
 * <p>
 * The system enforces a maximum number of elements when generating the list of
 * links. When the size of the request result set is larger than the system
 * maximum, the list represents a paged view of the overall results, and the
 * previous-page and next-page elements provide URIs linking to the previous or
 * next page of links in the overall results.
 * </p>
 */
@ClarityQueryResult(entityClass = ProcessType.class)
@XmlRootElement(name = "process-types")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "process-types", propOrder = { "processTypes", "previousPage", "nextPage" })
public class ProcessTypes implements PaginatedBatch<ProcessTypeLink>, Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 747260766479912084L;

    /**
     * The list of process type links.
     */
    @XmlElement(name = "process-type")
    protected List<ProcessTypeLink> processTypes;

    /**
     * Link to the previous page of results.
     */
    @XmlElement(name = "previous-page")
    protected Page previousPage;

    /**
     * Link to the next page of results.
     */
    @XmlElement(name = "next-page")
    protected Page nextPage;

    /**
     * Constructs a new process types batch.
     */
    public ProcessTypes()
    {
    }

    /**
     * Gets the list of process type links.
     *
     * @return a list of process type links.
     */
    public List<ProcessTypeLink> getProcessTypes()
    {
        if (processTypes == null)
        {
            processTypes = new ArrayList<>();
        }
        return processTypes;
    }

    /**
     * Gets the list of process type links.
     *
     * @return a list of process type links.
     */
    @Override
    public List<ProcessTypeLink> getList()
    {
        return getProcessTypes();
    }

    /**
     * Gets the size of the process types list.
     *
     * @return the number of process types in this batch.
     */
    @Override
    public int getSize()
    {
        return processTypes == null ? 0 : processTypes.size();
    }

    /**
     * Gets the link to the previous page of results.
     *
     * @return the previous page link, or null if on the first page.
     */
    public Page getPreviousPage()
    {
        return previousPage;
    }

    /**
     * Sets the link to the previous page of results.
     *
     * @param previousPage the previous page link.
     */
    public void setPreviousPage(Page previousPage)
    {
        this.previousPage = previousPage;
    }

    /**
     * Gets the link to the next page of results.
     *
     * @return the next page link, or null if on the last page.
     */
    public Page getNextPage()
    {
        return nextPage;
    }

    /**
     * Sets the link to the next page of results.
     *
     * @param nextPage the next page link.
     */
    public void setNextPage(Page nextPage)
    {
        this.nextPage = nextPage;
    }

}
