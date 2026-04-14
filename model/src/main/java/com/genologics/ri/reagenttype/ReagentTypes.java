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

package com.genologics.ri.reagenttype;

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
 * The representation for a list of reagent type links.
 * <p>
 * The system enforces a maximum number of elements when generating the list of
 * links. When the size of the request result set is larger than the system
 * maximum, the list represents a paged view of the overall results, and the
 * previous-page and next-page elements provide URIs linking to the previous or
 * next page of links in the overall results.
 * </p>
 */
@ClarityQueryResult(entityClass = ReagentType.class)
@XmlRootElement(name = "reagent-types")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reagent-types", propOrder = { "reagentTypes", "previousPage", "nextPage" })
public class ReagentTypes implements PaginatedBatch<ReagentTypeLink>, Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = -3173542275521810830L;

    /**
     * The list of reagent type links.
     */
    @XmlElement(name = "reagent-type")
    protected List<ReagentTypeLink> reagentTypes;

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
     * Default constructor.
     */
    public ReagentTypes()
    {
    }

    /**
     * Gets the list of reagent type links.
     *
     * @return A list of reagent type links.
     */
    public List<ReagentTypeLink> getReagentTypes()
    {
        if (reagentTypes == null)
        {
            reagentTypes = new ArrayList<>();
        }
        return reagentTypes;
    }

    /**
     * Gets the list of reagent type links for batch processing.
     *
     * @return A list of reagent type links.
     */
    @Override
    public List<ReagentTypeLink> getList()
    {
        return getReagentTypes();
    }

    /**
     * Gets the size of the reagent types list.
     *
     * @return The number of reagent type links, or 0 if the list is null.
     */
    @Override
    public int getSize()
    {
        return reagentTypes == null ? 0 : reagentTypes.size();
    }

    /**
     * Gets the link to the previous page of results.
     *
     * @return The previous page link, or null if on the first page.
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
     * @return The next page link, or null if on the last page.
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
