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

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.ClarityEntity;
import com.genologics.ri.LimsLink;
import com.genologics.ri.Linkable;

/**
 *
 * The detailed representation of a reagent kit.
 * @since 2.18
 */
@ClarityEntity(uriSection = "reagentkits", creatable = true, updateable = true)
@XmlRootElement(name = "reagent-kit")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reagent-kit", propOrder = { "name", "supplier", "catalogueNumber", "website", "archived" })
public class ReagentKit implements Linkable<ReagentKit>, Serializable
{
    /**
     * Class version for serialisation.
     */
    @java.io.Serial
    private static final long serialVersionUID = 7467244485974104986L;

    /**
     * The name of the reagent kit.
     */
    @XmlElement
    protected String name;

    /**
     * The supplier of the reagent kit.
     */
    @XmlElement
    protected String supplier;

    /**
     * The catalogue number of the reagent kit.
     */
    @XmlElement(name = "catalogue-number")
    protected String catalogueNumber;

    /**
     * The website of the reagent kit.
     */
    @XmlSchemaType(name = "anyURI")
    protected String website;

    /**
     * Whether the reagent kit is archived.
     */
    @XmlElement
    protected Boolean archived;

    /**
     * The URI of the reagent kit.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;


    /**
     * Default constructor.
     */
    public ReagentKit()
    {
    }

    /**
     * Constructor with URI.
     *
     * @param uri The URI of the reagent kit.
     */
    public ReagentKit(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructor with URI and name.
     *
     * @param uri The URI of the reagent kit.
     * @param name The name of the reagent kit.
     */
    public ReagentKit(URI uri, String name)
    {
        this.uri = uri;
        this.name = name;
    }

    /**
     * Gets the name of the reagent kit.
     *
     * @return The reagent kit name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of the reagent kit.
     *
     * @param name The reagent kit name.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Gets the supplier of the reagent kit.
     *
     * @return The supplier name.
     */
    public String getSupplier()
    {
        return supplier;
    }

    /**
     * Sets the supplier of the reagent kit.
     *
     * @param supplier The supplier name.
     */
    public void setSupplier(String supplier)
    {
        this.supplier = supplier;
    }

    /**
     * Gets the catalogue number of the reagent kit.
     *
     * @return The catalogue number.
     */
    public String getCatalogueNumber()
    {
        return catalogueNumber;
    }

    /**
     * Sets the catalogue number of the reagent kit.
     *
     * @param catalogueNumber The catalogue number.
     */
    public void setCatalogueNumber(String catalogueNumber)
    {
        this.catalogueNumber = catalogueNumber;
    }

    /**
     * Gets the website of the reagent kit.
     *
     * @return The website URL.
     */
    public String getWebsite()
    {
        return website;
    }

    /**
     * Sets the website of the reagent kit.
     *
     * @param website The website URL.
     */
    public void setWebsite(String website)
    {
        this.website = website;
    }

    /**
     * Gets whether the reagent kit is archived.
     *
     * @return True if archived, false otherwise.
     */
    public Boolean getArchived()
    {
        return archived;
    }

    /**
     * Sets whether the reagent kit is archived.
     *
     * @param archived True if archived, false otherwise.
     */
    public void setArchived(Boolean archived)
    {
        this.archived = archived;
    }

    /**
     * Gets the URI of the reagent kit.
     *
     * @return The reagent kit URI.
     */
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI of the reagent kit.
     *
     * @param uri The reagent kit URI.
     */
    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LimsLink<ReagentKit> getLink()
    {
        return new ReagentKitLink(this);
    }
}
