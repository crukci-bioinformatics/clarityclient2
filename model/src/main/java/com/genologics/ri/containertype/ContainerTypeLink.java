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

import java.io.Serializable;
import java.net.URI;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.LimsLink;
import com.genologics.ri.Linkable;

/**
 *
 * Container-type-link is a child element type of containers and provides a URI
 * linking to the detailed representation of a container type.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "container-type-link")
public class ContainerTypeLink implements LimsLink<ContainerType>, Serializable
{
    private static final long serialVersionUID = 7125345264225985052L;

    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    @XmlAttribute(name = "name")
    protected String name;

    public ContainerTypeLink()
    {
    }

    public ContainerTypeLink(URI uri)
    {
        this.uri = uri;
    }

    public ContainerTypeLink(URI uri, String name)
    {
        this.uri = uri;
        this.name = name;
    }

    public ContainerTypeLink(Linkable<ContainerType> link)
    {
        requireNonNull(link, "link cannot be null");
        this.uri = link.getUri();
    }

    public ContainerTypeLink(ContainerType containerType)
    {
        requireNonNull(containerType, "containerType cannot be null");
        this.uri = containerType.getUri();
        this.name = containerType.getName();
    }

    @Override
    public Class<ContainerType> getEntityClass()
    {
        return ContainerType.class;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public URI getUri()
    {
        return uri;
    }

    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    @Override
    public String toString()
    {
        return name;
    }
}
