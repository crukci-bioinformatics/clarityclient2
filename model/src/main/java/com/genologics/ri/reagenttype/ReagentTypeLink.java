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
import java.net.URI;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.genologics.ri.LimsEntityLinkBase;
import com.genologics.ri.LimsLink;
import com.genologics.ri.Link;
import com.genologics.ri.Linkable;

/**
 *
 * Reagent-type-link is a child element type of reagent types and provides a URI
 * linking to the detailed representation of a reagent type.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reagent-type-link")
public class ReagentTypeLink extends LimsEntityLinkBase<ReagentType>
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = -628102520150401023L;

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
    public ReagentTypeLink()
    {
    }

    /**
     * Constructor with URI.
     *
     * @param uri The URI of the reagent type.
     */
    public ReagentTypeLink(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructor with URI and name.
     *
     * @param uri The URI of the reagent type.
     * @param name The name of the reagent type.
     */
    public ReagentTypeLink(URI uri, String name)
    {
        this.uri = uri;
        this.name = name;
    }

    /**
     * Constructor from a Linkable object.
     *
     * @param link The linkable object to extract the URI from.
     */
    public ReagentTypeLink(Linkable<ReagentType> link)
    {
        uri = link.getUri();
        /*
        try
        {
            name = (String)PropertyUtils.getProperty(link, "name");
        }
        catch (Exception e)
        {
            // Ignore.
        }
        */
    }

    /**
     * Constructor from a ReagentType entity.
     *
     * @param type The reagent type to create the link from.
     */
    public ReagentTypeLink(ReagentType type)
    {
        uri = type.getUri();
        name = type.getName();
    }

    /**
     * Gets the entity class for this link.
     *
     * @return The ReagentType class.
     */
    @Override
    public Class<ReagentType> getEntityClass()
    {
        return ReagentType.class;
    }

    /**
     * Gets the name of the reagent type.
     *
     * @return The reagent type name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of the reagent type.
     *
     * @param name The reagent type name.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Gets the URI of the reagent type.
     *
     * @return The reagent type URI.
     */
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI of the reagent type.
     *
     * @param uri The reagent type URI.
     */
    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Returns a string representation of this link.
     *
     * @return The name of the reagent type.
     */
    @Override
    public String toString()
    {
        ToStringBuilder b = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
        b.append("reagentType", LimsLink.toString(this));
        b.append("name", name);
        return b.toString();
    }

    /**
     * Gets the LIMS id from the URI.
     *
     * @return The LIMS id extracted from the URI.
     */
    @Override
    public String getLimsid()
    {
        return Link.limsIdFromUri(uri);
    }

    /**
     * Sets the LIMS id. This method does nothing as the id is extracted from the URI.
     *
     * @param id The LIMS id (ignored).
     */
    @Override
    public void setLimsid(String id)
    {
        // Does nothing.
    }
}
