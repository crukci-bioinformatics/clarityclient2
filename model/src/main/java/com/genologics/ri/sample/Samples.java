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

package com.genologics.ri.sample;

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
 * The representation for a list of sample links.
 * <p>
 * The system enforces a maximum number of elements when generating the list of
 * links. When the size of the request result set is larger than the system
 * maximum, the list represents a paged view of the overall results, and the
 * previous-page and next-page elements provide URIs linking to the previous or
 * next page of links in the overall results.
 * </p>
 */
@ClarityQueryResult(entityClass = Sample.class)
@XmlRootElement(name = "samples")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "samples", propOrder = { "samples", "previousPage", "nextPage" })
public class Samples implements PaginatedBatch<SampleLink>, Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 7481910467952402185L;

    /**
     * The list of sample links.
     */
    @XmlElement(name = "sample")
    protected List<SampleLink> samples;

    /**
     * The previous page link for pagination.
     */
    @XmlElement(name = "previous-page")
    protected Page previousPage;

    /**
     * The next page link for pagination.
     */
    @XmlElement(name = "next-page")
    protected Page nextPage;

    /**
     * Constructor for an empty samples list.
     */
    public Samples() { }

    /**
     * Gets the list of sample links.
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Any modification to the returned list will be
     * reflected in the object.
     * </p>
     *
     * @return The list of sample links.
     */
    public List<SampleLink> getSamples()
    {
        if (samples == null)
        {
            samples = new ArrayList<>();
        }
        return samples;
    }

    /**
     * Gets the list of sample links for batch operations.
     *
     * @return The list of sample links.
     */
    @Override
    public List<SampleLink> getList()
    {
        return getSamples();
    }

    /**
     * Gets the size of the sample links list.
     *
     * @return The number of sample links in the list.
     */
    @Override
    public int getSize()
    {
        return samples == null ? 0 : samples.size();
    }

    /**
     * Gets the previous page link.
     *
     * @return The previous page link.
     */
    public Page getPreviousPage()
    {
        return previousPage;
    }

    /**
     * Sets the previous page link.
     *
     * @param previousPage The previous page link.
     */
    public void setPreviousPage(Page previousPage)
    {
        this.previousPage = previousPage;
    }

    /**
     * Gets the next page link.
     *
     * @return The next page link.
     */
    public Page getNextPage()
    {
        return nextPage;
    }

    /**
     * Sets the next page link.
     *
     * @param nextPage The next page link.
     */
    public void setNextPage(Page nextPage)
    {
        this.nextPage = nextPage;
    }
}
