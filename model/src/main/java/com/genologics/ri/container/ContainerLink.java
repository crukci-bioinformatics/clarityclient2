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

package com.genologics.ri.container;

import static java.util.Objects.requireNonNull;

import java.io.Serial;
import java.net.URI;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.LimsEntityLinkBase;
import com.genologics.ri.LimsEntityLinkable;
import com.genologics.ri.Linkable;

/**
 * Container-link is a child element type of containers and provides a URI
 * linking to the detailed representation of a container.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "container-link")
public class ContainerLink extends LimsEntityLinkBase<Container>
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = -3079266542140961317L;

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
     * The name of the container.
     */
    @XmlElement(name = "name")
    protected String name;

    /**
     * Default constructor.
     */
    public ContainerLink()
    {
    }

    /**
     * Constructor with URI.
     *
     * @param uri the URI.
     */
    public ContainerLink(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructor with URI and LIMS id.
     *
     * @param uri the URI.
     * @param limsid the LIMS id.
     */
    public ContainerLink(URI uri, String limsid)
    {
        this.uri = uri;
        this.limsid = limsid;
    }

    /**
     * Constructor with URI, LIMS id, and name.
     *
     * @param uri the URI.
     * @param limsid the LIMS id.
     * @param name the name.
     */
    public ContainerLink(URI uri, String limsid, String name)
    {
        this.uri = uri;
        this.limsid = limsid;
        this.name = name;
    }

    /**
     * Constructor from a linkable container.
     *
     * @param link the linkable container.
     */
    public ContainerLink(Linkable<Container> link)
    {
        requireNonNull(link, "link cannot be null");
        uri = link.getUri();
    }

    /**
     * Constructor from a LIMS entity linkable container.
     *
     * @param link the LIMS entity linkable container.
     */
    public ContainerLink(LimsEntityLinkable<Container> link)
    {
        requireNonNull(link, "link cannot be null");
        uri = link.getUri();
        limsid = link.getLimsid();
    }

    /**
     * Constructor from a container.
     *
     * @param container the container.
     */
    public ContainerLink(Container container)
    {
        requireNonNull(container, "container cannot be null");
        uri = container.getUri();
        limsid = container.getLimsid();
        name = container.getName();
    }

    /**
     * Gets the entity class.
     *
     * @return the container class.
     */
    @Override
    public Class<Container> getEntityClass()
    {
        return Container.class;
    }

    /**
     * Gets the name.
     *
     * @return the name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name the name.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Gets the LIMS id.
     *
     * @return the LIMS id.
     */
    public String getLimsid()
    {
        return limsid;
    }

    /**
     * Sets the LIMS id.
     *
     * @param limsid the LIMS id.
     */
    public void setLimsid(String limsid)
    {
        this.limsid = limsid;
    }

    /**
     * Gets the URI.
     *
     * @return the URI.
     */
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI.
     *
     * @param uri the URI.
     */
    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Returns a string representation of the container link.
     *
     * @return a string representation.
     */
    @Override
    public String toString()
    {
        return limsid + " " + name;
    }
}
