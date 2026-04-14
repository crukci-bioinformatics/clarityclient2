/*
 * CRUK-CI Clarity REST API Java Client.
 * Copyright (C) 2018 Cancer Research UK Cambridge Institute.
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

package com.genologics.ri.automation;

import java.io.Serial;
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
 * A list of automation links returned from a query.
 * <p>
 * This class supports pagination through previous-page and next-page links.
 * </p>
 *
 * @since 2.26
 */
@ClarityQueryResult(entityClass = Automation.class)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "automations", propOrder = { "automations", "previousPage", "nextPage" })
@XmlRootElement(name = "automations")
public class Automations implements PaginatedBatch<AutomationLink>, Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = -3048084395718929498L;

    /**
     * The list of automation links.
     */
    @XmlElement(name = "automation")
    protected List<AutomationLink> automations;

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
     * The URI of this automations resource.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * Default constructor.
     */
    public Automations()
    {
    }

    /**
     * Gets the list of automation links.
     *
     * @return The list of automation links.
     */
    @Override
    public List<AutomationLink> getList()
    {
        return getAutomations();
    }

    /**
     * Gets the size of the automation list.
     *
     * @return The number of automations.
     */
    @Override
    public int getSize()
    {
        return automations == null ? 0 : automations.size();
    }

    /**
     * Gets the list of automations.
     *
     * @return The list of automation links.
     */
    public List<AutomationLink> getAutomations()
    {
        if (automations == null)
        {
            automations = new ArrayList<>();
        }
        return automations;
    }

    /**
     * Gets the previous page of results.
     *
     * @return The previous page, or null if there is no previous page.
     */
    public Page getPreviousPage()
    {
        return previousPage;
    }

    /**
     * Sets the previous page of results.
     *
     * @param value The previous page.
     */
    public void setPreviousPage(Page value)
    {
        this.previousPage = value;
    }

    /**
     * Gets the next page of results.
     *
     * @return The next page, or null if there is no next page.
     */
    public Page getNextPage()
    {
        return nextPage;
    }

    /**
     * Sets the next page of results.
     *
     * @param value The next page.
     */
    public void setNextPage(Page value)
    {
        this.nextPage = value;
    }

    /**
     * Gets the URI of this automations resource.
     *
     * @return The URI.
     */
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI of this automations resource.
     *
     * @param value The URI.
     */
    public void setUri(URI value)
    {
        this.uri = value;
    }
}
