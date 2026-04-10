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

package com.genologics.ri.reagentkit;

import java.io.Serializable;
import java.net.URI;
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
 *
 * The representation for a list of reagent type links.
 * @since 2.18
 */
@ClarityQueryResult(entityClass = ReagentKit.class)
@XmlRootElement(name = "reagent-kits")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reagent-kits", propOrder = { "reagentKits", "nextPage", "previousPage" })
public class ReagentKits implements PaginatedBatch<ReagentKitLink>, Serializable
{
    /**
     * Class version for serialisation.
     */
    @java.io.Serial
    private static final long serialVersionUID = 719305311109268363L;

    /**
     * The list of reagent kit links.
     */
    @XmlElement(name = "reagent-kit")
    protected List<ReagentKitLink> reagentKits;

    /**
     * The link to the next page of results.
     */
    @XmlElement(name = "next-page")
    protected Page nextPage;

    /**
     * The link to the previous page of results.
     */
    @XmlElement(name = "previous-page")
    protected Page previousPage;

    /**
     * The URI of the reagent kits list.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * Default constructor.
     */
    public ReagentKits() {}

    /**
     * Gets the list of reagent kit links.
     *
     * @return The list of reagent kit links.
     */
    public List<ReagentKitLink> getReagentKits()
    {
        if (reagentKits == null)
        {
            reagentKits = new ArrayList<>();
        }
        return reagentKits;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ReagentKitLink> getList()
    {
        return getReagentKits();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getSize()
    {
        return reagentKits == null ? 0 : reagentKits.size();
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
     * Gets the URI of the reagent kits list.
     *
     * @return The reagent kits list URI.
     */
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI of the reagent kits list.
     *
     * @param uri The reagent kits list URI.
     */
    public void setUri(URI uri)
    {
        this.uri = uri;
    }
}
