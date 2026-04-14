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

package com.genologics.ri.containertype;

import static java.util.Objects.requireNonNull;

import java.io.Serial;
import java.net.URI;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.LimsLinkBase;
import com.genologics.ri.Linkable;

/**
 *
 * Container-type-link is a child element type of containers and provides a URI
 * linking to the detailed representation of a container type.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "container-type-link")
public class ContainerTypeLink extends LimsLinkBase<ContainerType>
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 7125345264225985052L;

    /**
     * The URI for accessing the container type resource.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * The name of the container type.
     */
    @XmlAttribute(name = "name")
    protected String name;

    /**
     * Default constructor for creating a new container type link.
     */
    public ContainerTypeLink()
    {
    }

    /**
     * Constructor for creating a container type link with a specified URI.
     *
     * @param uri The URI of the container type resource.
     */
    public ContainerTypeLink(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructor for creating a container type link with a specified URI and name.
     *
     * @param uri The URI of the container type resource.
     * @param name The name of the container type.
     */
    public ContainerTypeLink(URI uri, String name)
    {
        this.uri = uri;
        this.name = name;
    }

    /**
     * Constructor for creating a container type link from a linkable object.
     *
     * @param link A linkable object that provides the URI for the container type.
     *
     * @throws NullPointerException if {@code link} is {@code null}.
     */
    public ContainerTypeLink(Linkable<ContainerType> link)
    {
        requireNonNull(link, "link cannot be null");
        this.uri = link.getUri();
    }

    /**
     * Constructor for creating a container type link from a container type object.
     *
     * @param containerType The container type from which to extract the URI and name.
     *
     * @throws NullPointerException if {@code containerType} is {@code null}.
     */
    public ContainerTypeLink(ContainerType containerType)
    {
        requireNonNull(containerType, "containerType cannot be null");
        this.uri = containerType.getUri();
        this.name = containerType.getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Class<ContainerType> getEntityClass()
    {
        return ContainerType.class;
    }

    /**
     * Gets the name of the container type.
     *
     * @return The container type name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of the container type.
     *
     * @param name The container type name to set.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Gets the URI for accessing the container type resource.
     *
     * @return The container type URI.
     */
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI for the container type resource.
     *
     * @param uri The container type URI to set.
     */
    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Returns a string representation of this container type link, which is its name.
     *
     * @return The container type name.
     */
    @Override
    public String toString()
    {
        return name;
    }
}
