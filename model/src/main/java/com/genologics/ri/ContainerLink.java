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

package com.genologics.ri;

import static java.util.Objects.requireNonNull;

import java.io.Serial;
import java.net.URI;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.container.Container;

/**
 *
 * Container is a child element of location and provides a URI linking to the
 * detailed representation of the Container for the location.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "container")
public class ContainerLink extends LimsEntityLinkBase<Container>
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 4920381830737280136L;

    /**
     * The URI of the container.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * The LIMS id of the container.
     */
    @XmlAttribute(name = "limsid")
    protected String limsid;

    /**
     * Default constructor.
     */
    public ContainerLink()
    {
    }

    /**
     * Constructor with URI.
     *
     * @param uri The URI of the container.
     */
    public ContainerLink(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructor with URI and LIMS id.
     *
     * @param uri The URI of the container.
     * @param limsid The LIMS id of the container.
     */
    public ContainerLink(URI uri, String limsid)
    {
        this.uri = uri;
        this.limsid = limsid;
    }

    /**
     * Constructor from a linkable container.
     *
     * @param link The linkable container.
     */
    public ContainerLink(Linkable<Container> link)
    {
        requireNonNull(link, "link cannot be null");
        uri = link.getUri();
    }

    /**
     * Constructor from a LIMS entity linkable container.
     *
     * @param link The LIMS entity linkable container.
     */
    public ContainerLink(LimsEntityLinkable<Container> link)
    {
        requireNonNull(link, "link cannot be null");
        uri = link.getUri();
        limsid = link.getLimsid();
    }

    /**
     * Gets the entity class for this link.
     *
     * @return The Container class.
     */
    @Override
    public Class<Container> getEntityClass()
    {
        return Container.class;
    }

    /**
     * Gets the URI of the container.
     *
     * @return The URI.
     */
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI of the container.
     *
     * @param uri The URI.
     */
    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Gets the LIMS id of the container.
     *
     * @return The LIMS id.
     */
    public String getLimsid()
    {
        return limsid;
    }

    /**
     * Sets the LIMS id of the container.
     *
     * @param limsid The LIMS id.
     */
    public void setLimsid(String limsid)
    {
        this.limsid = limsid;
    }

    /**
     * Computes a hash code for this container link.
     *
     * @return The hash code.
     */
    @Override
    public int hashCode()
    {
        return uri == null ? 41 : uri.hashCode();
    }

    /**
     * Compares this container link with another object for equality.
     *
     * @param obj The object to compare with.
     * @return {@code true} if the objects are equal, {@code false} otherwise.
     */
    @Override
    public boolean equals(Object obj)
    {
        boolean equal = obj == this;
        if (!equal && obj != null)
        {
            if (getClass().equals(obj.getClass()))
            {
                ContainerLink other = (ContainerLink)obj;
                if (uri != null)
                {
                    equal = uri.equals(other.getUri());
                }
            }
        }
        return equal;
    }

    /**
     * Returns a string representation of this container link.
     *
     * @return The LIMS id as a string.
     */
    @Override
    public String toString()
    {
        return limsid;
    }
}
