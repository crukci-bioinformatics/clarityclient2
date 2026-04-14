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

package com.genologics.ri.reagentlot;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.ClarityQueryResult;
import com.genologics.ri.Page;
import com.genologics.ri.PaginatedBatch;

/**
 * Represents a paginated collection of reagent lot links returned by the API.
 * <p>
 * This class provides access to a batch of reagent lot links with support for
 * pagination through previous and next page references. It implements the
 * {@link PaginatedBatch} interface to provide consistent batch operations.
 * </p>
 *
 * @since 2.18
 */
@ClarityQueryResult(entityClass = ReagentLot.class)
@XmlRootElement(name = "reagent-lots")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reagent-lots", propOrder = { "reagentLots", "nextPage", "previousPage" })
public class ReagentLots implements PaginatedBatch<ReagentLotLink>, Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = -7760282244017305741L;

    /**
     * The list of reagent lot links.
     */
    @XmlElement(name = "reagent-lot")
    protected List<ReagentLotLink> reagentLots;

    /**
     * Link to the next page of results, if available.
     */
    @XmlElement(name = "next-page")
    protected Page nextPage;

    /**
     * Link to the previous page of results, if available.
     */
    @XmlElement(name = "previous-page")
    protected Page previousPage;

    /**
     * The URI of this reagent lots collection.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected String uri;

    /**
     * Default constructor.
     */
    public ReagentLots()
    {
    }

    /**
     * Gets the list of reagent lot links in this batch.
     * Creates an empty list if none exists.
     *
     * @return The list of reagent lot links.
     */
    public List<ReagentLotLink> getReagentLots()
    {
        if (reagentLots == null)
        {
            reagentLots = new ArrayList<>();
        }
        return reagentLots;
    }

    @Override
    public List<ReagentLotLink> getList()
    {
        return getReagentLots();
    }

    @Override
    public int getSize()
    {
        return reagentLots == null ? 0 : reagentLots.size();
    }

    @Override
    public Page getNextPage()
    {
        return nextPage;
    }

    @Override
    public void setNextPage(Page nextPage)
    {
        this.nextPage = nextPage;
    }

    @Override
    public Page getPreviousPage()
    {
        return previousPage;
    }

    @Override
    public void setPreviousPage(Page previousPage)
    {
        this.previousPage = previousPage;
    }

    /**
     * Gets the URI of this reagent lots collection.
     *
     * @return The URI.
     */
    public String getUri()
    {
        return uri;
    }

    /**
     * Sets the URI of this reagent lots collection.
     *
     * @param uri The URI to set.
     */
    public void setUri(String uri)
    {
        this.uri = uri;
    }

}
