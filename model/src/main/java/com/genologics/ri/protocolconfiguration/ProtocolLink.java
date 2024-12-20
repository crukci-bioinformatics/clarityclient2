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

package com.genologics.ri.protocolconfiguration;

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

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "protocol-link")
public class ProtocolLink implements LimsLink<Protocol>, Serializable
{
    private static final long serialVersionUID = 5561496957381579448L;

    @XmlAttribute(name = "name")
    protected String name;

    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;


    public ProtocolLink()
    {
    }

    public ProtocolLink(URI uri)
    {
        this.uri = uri;
    }

    public ProtocolLink(URI uri, String name)
    {
        this.uri = uri;
        this.name = name;
    }

    public ProtocolLink(Linkable<Protocol> link)
    {
        requireNonNull(link, "link cannot be null");
        uri = link.getUri();
    }

    public ProtocolLink(Protocol protocol)
    {
        requireNonNull(protocol, "protocol cannot be null");
        uri = protocol.getUri();
        name = protocol.getName();
    }

    public String getName()
    {
        return name;
    }

    public void setName(String value)
    {
        this.name = value;
    }

    public URI getUri()
    {
        return uri;
    }

    public void setUri(URI value)
    {
        this.uri = value;
    }

    @Override
    public Class<Protocol> getEntityClass()
    {
        return Protocol.class;
    }

    @Override
    public String toString()
    {
        return name == null ? "null" : name;
    }
}
