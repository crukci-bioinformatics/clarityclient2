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

package com.genologics.ri.property;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.ClarityQueryResult;
import com.genologics.ri.Page;
import com.genologics.ri.PaginatedBatch;
import com.genologics.ri.protocolconfiguration.Protocol;

/**
 *
 * The representation for a list of property links.
 * <p>
 * The system enforces a maximum number of elements when generating the list of
 * links. When the size of the request result set is larger than the system
 * maximum, the list represents a paged view of the overall results, and the
 * previous-page and next-page elements provide URIs linking to the previous or
 * next page of links in the overall results.
 * </p>
 */
@ClarityQueryResult(entityClass = Protocol.class)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "properties", propOrder = { "properties", "previousPage", "nextPage" })
public class Properties implements PaginatedBatch<PropertyLink>, Serializable
{
    /**
     * Class version for serialisation.
     */
    @java.io.Serial
    private static final long serialVersionUID = -4193984606951017687L;

    /**
     * The list of property links.
     */
    @XmlElement(name = "property")
    protected List<PropertyLink> properties;

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
    public Properties() {}

    /**
     * Gets the list of property links.
     *
     * @return The list of property links.
     */
    public List<PropertyLink> getProperties()
    {
        if (properties == null)
        {
            properties = new ArrayList<>();
        }
        return properties;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<PropertyLink> getList()
    {
        return getProperties();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getSize()
    {
        return properties == null ? 0 : properties.size();
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
