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
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.genologics.ri.LimsLink;
import com.genologics.ri.LimsLinkBase;
import com.genologics.ri.Linkable;
import com.genologics.ri.containertype.ContainerType;

/**
 *
 * Container-type is a child element of container and provides a URI linking to
 * the detailed representation of the container type that the container is
 * associated with. A container type describes the physical characteristics of
 * the container, such as the number of wells in the container and how the wells
 * are labelled.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "container-type")
public class ContainerTypeLink extends LimsLinkBase<ContainerType>
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 8897150572324942993L;

    /**
     * The URI of the container type.
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
     * Default constructor.
     */
    public ContainerTypeLink()
    {
    }

    /**
     * Constructor with URI.
     *
     * @param uri The URI.
     */
    public ContainerTypeLink(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructor with URI and name.
     *
     * @param uri The URI.
     * @param name The name.
     */
    public ContainerTypeLink(URI uri, String name)
    {
        this.uri = uri;
        this.name = name;
    }

    /**
     * Constructor from a linkable container type.
     *
     * @param link The linkable container type.
     */
    public ContainerTypeLink(Linkable<ContainerType> link)
    {
        requireNonNull(link, "link cannot be null");
        uri = link.getUri();
    }

    /**
     * Constructor from a container type.
     *
     * @param containerType The container type.
     */
    public ContainerTypeLink(ContainerType containerType)
    {
        requireNonNull(containerType, "containerType cannot be null");
        uri = containerType.getUri();
        name = containerType.getName();
    }

    /**
     * Gets the entity class for this link.
     *
     * @return The ContainerType class.
     */
    @Override
    public Class<ContainerType> getEntityClass()
    {
        return ContainerType.class;
    }

    /**
     * Gets the URI of the container type.
     *
     * @return The URI.
     */
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI of the container type.
     *
     * @param uri The URI.
     */
    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Gets the name of the container type.
     *
     * @return The name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of the container type.
     *
     * @param name The name.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Returns a string representation of this link.
     *
     * @return The container type LIMS id and the name.
     */
    @Override
    public String toString()
    {
        ToStringBuilder b = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
        b.append("containerType", LimsLink.toString(this));
        b.append("name", name);
        return b.toString();
    }
}
