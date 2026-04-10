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

package com.genologics.ri.controltype;

import java.io.Serial;
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
 * Represents a control type in the Clarity LIMS system.
 */
@ClarityEntity(uriSection = "controltypes", creatable = true, updateable = true)
@XmlRootElement(name = "control-type")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "control-type",
         propOrder = { "supplier", "catalogueNumber", "website", "concentration", "archived", "singleStep" })
public class ControlType implements Linkable<ControlType>, Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = -3152986669595427342L;

    /**
     * The supplier of the control type.
     */
    @XmlElement
    protected String supplier;

    /**
     * The catalogue number of the control type.
     */
    @XmlElement(name = "catalogue-number")
    protected String catalogueNumber;

    /**
     * The website URL for the control type.
     */
    @XmlSchemaType(name = "anyURI")
    protected String website;

    /**
     * The concentration of the control type.
     *
     * @since 2.20
     */
    @XmlElement
    protected String concentration;

    /**
     * Flag indicating if the control type is archived.
     */
    @XmlElement
    protected Boolean archived;

    /**
     * Flag indicating if the control type is for single step.
     */
    @XmlElement(name = "single-step")
    protected Boolean singleStep;

    /**
     * The URI of the control type.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * The name of the control type.
     */
    @XmlAttribute(name = "name")
    protected String name;


    /**
     * Gets the supplier of the control type.
     *
     * @return The supplier.
     */
    public String getSupplier()
    {
        return supplier;
    }

    /**
     * Sets the supplier of the control type.
     *
     * @param supplier The supplier.
     */
    public void setSupplier(String supplier)
    {
        this.supplier = supplier;
    }

    /**
     * Gets the catalogue number of the control type.
     *
     * @return The catalogue number.
     */
    public String getCatalogueNumber()
    {
        return catalogueNumber;
    }

    /**
     * Sets the catalogue number of the control type.
     *
     * @param catalogueNumber The catalogue number.
     */
    public void setCatalogueNumber(String catalogueNumber)
    {
        this.catalogueNumber = catalogueNumber;
    }

    /**
     * Gets the website URL for the control type.
     *
     * @return The website URL.
     */
    public String getWebsite()
    {
        return website;
    }

    /**
     * Sets the website URL for the control type.
     *
     * @param website The website URL.
     */
    public void setWebsite(String website)
    {
        this.website = website;
    }

    /**
     * Gets the concentration of the control type.
     *
     * @return The concentration.
     */
    public String getConcentration()
    {
        return concentration;
    }

    /**
     * Sets the concentration of the control type.
     *
     * @param concentration The concentration.
     */
    public void setConcentration(String concentration)
    {
        this.concentration = concentration;
    }

    /**
     * Gets the archived flag.
     *
     * @return The archived flag.
     */
    public Boolean getArchived()
    {
        return archived;
    }

    /**
     * Sets the archived flag.
     *
     * @param archived The archived flag.
     */
    public void setArchived(Boolean archived)
    {
        this.archived = archived;
    }

    /**
     * Gets the single step flag.
     *
     * @return The single step flag.
     */
    public Boolean getSingleStep()
    {
        return singleStep;
    }

    /**
     * Sets the single step flag.
     *
     * @param singleStep The single step flag.
     */
    public void setSingleStep(Boolean singleStep)
    {
        this.singleStep = singleStep;
    }

    /**
     * Gets the URI of the control type.
     *
     * @return The URI.
     */
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI of the control type.
     *
     * @param uri The URI.
     */
    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Gets the name of the control type.
     *
     * @return The name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of the control type.
     *
     * @param name The name.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LimsLink<ControlType> getLink()
    {
        return new ControlTypeLink(this);
    }
}
