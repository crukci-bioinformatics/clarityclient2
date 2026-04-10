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

package com.genologics.ri.lab;

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

/**
 *
 * Lab-link is a child element type of labs and provides a URI linking to the
 * detailed representation of a lab.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "lab-link", propOrder = { "name" })
public class LabLink implements LimsEntityLink<Lab>, Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 5826900114630147822L;

    /**
     * The URI of the lab resource.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * The name of the lab.
     */
    protected String name;

    /**
     * Constructs a new LabLink instance.
     */
    public LabLink()
    {
    }

    /**
     * Constructs a new LabLink instance with the specified URI.
     *
     * @param uri the URI of the lab resource.
     */
    public LabLink(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructs a new LabLink instance with the specified URI and name.
     *
     * @param uri the URI of the lab resource.
     * @param name the name of the lab.
     */
    public LabLink(URI uri, String name)
    {
        this.uri = uri;
        this.name = name;
    }

    /**
     * Constructs a new LabLink instance from a linkable object.
     *
     * @param link the linkable object to create the link from.
     * @throws NullPointerException if link is null.
     */
    public LabLink(Linkable<Lab> link)
    {
        requireNonNull(link, "link cannot be null");
        uri = link.getUri();
    }

    /**
     * Constructs a new LabLink instance from a Lab object.
     *
     * @param lab the lab to create the link from.
     * @throws NullPointerException if lab is null.
     */
    public LabLink(Lab lab)
    {
        requireNonNull(lab, "lab cannot be null");
        uri = lab.getUri();
        name = lab.getName();
    }

    /**
     * Gets the entity class for this link.
     *
     * @return the Lab class.
     */
    @Override
    public Class<Lab> getEntityClass()
    {
        return Lab.class;
    }

    /**
     * Gets the name of the lab.
     *
     * @return the name of the lab.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of the lab.
     *
     * @param name the name to set.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Gets the URI of the lab resource.
     *
     * @return the URI of the lab.
     */
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI of the lab resource.
     *
     * @param uri the URI to set.
     */
    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Gets the LIMS id extracted from the URI.
     *
     * @return the LIMS id.
     */
    @Override
    public String getLimsid()
    {
        return Link.limsIdFromUri(uri);
    }

    /**
     * Sets the LIMS id. This operation does nothing as the id is derived from the URI.
     *
     * @param id the LIMS id (ignored).
     */
    @Override
    public void setLimsid(String id)
    {
        // Does nothing.
    }

    /**
     * Returns a string representation of the lab link.
     *
     * @return the name of the lab.
     */
    @Override
    public String toString()
    {
        return name;
    }
}
