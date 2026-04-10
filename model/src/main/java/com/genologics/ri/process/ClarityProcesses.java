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

package com.genologics.ri.process;

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
 * The representation of a list of process links.
 * <p>
 * The system enforces a maximum number of elements when generating the list of
 * links. When the size of the request result set is larger than the system
 * maximum, the list represents a paged view of the overall results, and the
 * previous-page and next-page elements provide URIs linking to the previous or
 * next page of links in the overall results.
 * </p>
 */
@ClarityQueryResult(entityClass = ClarityProcess.class)
@XmlRootElement(name = "processes")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "processes", propOrder = { "processes", "previousPage", "nextPage" })
public class ClarityProcesses implements PaginatedBatch<ProcessLink>, Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = -4214726592787580002L;

    /**
     * The list of process links.
     */
    @XmlElement(name = "process")
    protected List<ProcessLink> processes;

    /**
     * The link to the previous page of results.
     */
    @XmlElement(name = "previous-page")
    protected Page previousPage;

    /**
     * The link to the next page of results.
     */
    @XmlElement(name = "next-page")
    protected Page nextPage;

    /**
     * Default constructor.
     */
    public ClarityProcesses()
    {
    }

    /**
     * Gets the list of processes.
     *
     * @return the list of process links.
     */
    public List<ProcessLink> getProcesses()
    {
        if (processes == null)
        {
            processes = new ArrayList<>();
        }
        return this.processes;
    }

    /**
     * Gets the list of process links.
     *
     * @return the list of process links.
     */
    @Override
    public List<ProcessLink> getList()
    {
        return getProcesses();
    }

    /**
     * Gets the size of the list.
     *
     * @return the number of process links in the list.
     */
    @Override
    public int getSize()
    {
        return processes == null ? 0 : processes.size();
    }

    /**
     * Gets the previous page link.
     *
     * @return the previous page link.
     */
    public Page getPreviousPage()
    {
        return previousPage;
    }

    /**
     * Sets the previous page link.
     *
     * @param previousPage the previous page link to set.
     */
    public void setPreviousPage(Page previousPage)
    {
        this.previousPage = previousPage;
    }

    /**
     * Gets the next page link.
     *
     * @return the next page link.
     */
    public Page getNextPage()
    {
        return nextPage;
    }

    /**
     * Sets the next page link.
     *
     * @param nextPage the next page link to set.
     */
    public void setNextPage(Page nextPage)
    {
        this.nextPage = nextPage;
    }

}
