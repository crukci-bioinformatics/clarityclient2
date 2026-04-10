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

package com.genologics.ri.researcher;

import static java.util.Objects.requireNonNull;

import java.io.Serial;
import java.io.Serializable;
import java.net.URI;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.LimsEntityLink;
import com.genologics.ri.Link;
import com.genologics.ri.Linkable;
import com.genologics.ri.lab.Lab;

/**
 * Lab is a child element of researcher and provides a URI linking to the
 * detailed representation of the lab for the researcher.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "lab")
public class LabLink implements LimsEntityLink<Lab>, Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = -2199818978989305791L;

    /**
     * The URI to the lab.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * Default constructor.
     */
    public LabLink()
    {
    }

    /**
     * Constructor with URI.
     *
     * @param uri The URI to the lab.
     */
    public LabLink(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructor from a linkable object.
     *
     * @param link The linkable object containing the lab URI.
     */
    public LabLink(Linkable<Lab> link)
    {
        requireNonNull(link, "link cannot be null");
        uri = link.getUri();
    }

    /**
     * Gets the entity class this link refers to.
     *
     * @return The Lab class.
     */
    public Class<Lab> getEntityClass()
    {
        return Lab.class;
    }

    /**
     * Gets the URI to the lab.
     *
     * @return The URI.
     */
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI to the lab.
     *
     * @param value The URI.
     */
    public void setUri(URI value)
    {
        this.uri = value;
    }

    /**
     * Gets the LIMS id from the URI.
     *
     * @return The LIMS id.
     */
    @Override
    public String getLimsid()
    {
        return Link.limsIdFromUri(uri);
    }

    /**
     * Sets the LIMS id. This operation does nothing for this link type.
     *
     * @param id The LIMS id.
     */
    @Override
    public void setLimsid(String id)
    {
        // Does nothing.
    }
}
