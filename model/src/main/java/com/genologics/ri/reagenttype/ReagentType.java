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

import java.io.Serializable;
import java.net.URI;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.genologics.ri.ClarityEntity;
import com.genologics.ri.LimsEntity;
import com.genologics.ri.LimsEntityLink;
import com.genologics.ri.Link;

/**
 *
 * The detailed representation of a reagent type.
 */
@ClarityEntity(uriSection = "reagenttypes")
@XmlRootElement(name = "reagent-type")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reagent-type", propOrder = { "specialType", "reagentCategory" })
public class ReagentType implements LimsEntity<ReagentType>, Serializable
{
    /**
     * Class version for serialisation.
     */
    @java.io.Serial
    private static final long serialVersionUID = -7390347729777321516L;

    /**
     * The special type of this reagent type.
     */
    @XmlElement(name = "special-type")
    protected SpecialType specialType;

    /**
     * The category of this reagent.
     */
    @XmlElement(name = "reagent-category")
    protected String reagentCategory;

    /**
     * The name of the reagent type.
     */
    @XmlAttribute(name = "name")
    protected String name;

    /**
     * The URI of the reagent type.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;


    /**
     * Default constructor.
     */
    public ReagentType()
    {
    }

    /**
     * Constructor with URI.
     *
     * @param uri The reagent type URI.
     */
    public ReagentType(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructor with URI and name.
     *
     * @param uri The reagent type URI.
     * @param name The reagent type name.
     */
    public ReagentType(URI uri, String name)
    {
        this.uri = uri;
        this.name = name;
    }

    /**
     * Gets the special type.
     *
     * @return The special type.
     */
    public SpecialType getSpecialType()
    {
        return specialType;
    }

    /**
     * Sets the special type.
     *
     * @param specialType The special type.
     */
    public void setSpecialType(SpecialType specialType)
    {
        this.specialType = specialType;
    }

    /**
     * Gets the reagent category.
     *
     * @return The reagent category.
     */
    public String getReagentCategory()
    {
        return reagentCategory;
    }

    /**
     * Sets the reagent category.
     *
     * @param reagentCategory The reagent category.
     */
    public void setReagentCategory(String reagentCategory)
    {
        this.reagentCategory = reagentCategory;
    }

    /**
     * Gets the name.
     *
     * @return The reagent type name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name The reagent type name.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Gets the URI.
     *
     * @return The reagent type URI.
     */
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI.
     *
     * @param uri The reagent type URI.
     */
    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Gets the LIMS id.
     *
     * @return The LIMS id extracted from the URI.
     */
    @Override
    public String getLimsid()
    {
        return Link.limsIdFromUri(uri);
    }

    /**
     * Sets the LIMS id. This operation does nothing.
     *
     * @param id The LIMS id (ignored).
     */
    @Override
    public void setLimsid(String id)
    {
        // Does nothing.
    }

    /**
     * Returns a string representation of this reagent type.
     *
     * @return A string representation.
     */
    @Override
    public String toString()
    {
        ToStringBuilder b = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
        b.append("id", getLimsid());
        b.append("category", reagentCategory);
        b.append("name", name);
        return b.toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LimsEntityLink<ReagentType> getLink()
    {
        return new ReagentTypeLink(this);
    }
}
