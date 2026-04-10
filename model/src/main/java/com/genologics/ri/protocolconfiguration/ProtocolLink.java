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

import java.io.Serial;
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
 * Link to a protocol configuration.
 */
/**
 * Protocol-Link provides a URI linking to the detailed representation of a protocol.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "protocol-link")
public class ProtocolLink implements LimsLink<Protocol>, Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 5561496957381579448L;

    /**
     * The name of the protocol.
     */
    @XmlAttribute(name = "name")
    protected String name;

    /**
     * The URI to the protocol.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * Default constructor.
     */
    public ProtocolLink()
    {
    }

    /**
     * Constructor with URI.
     *
     * @param uri The URI to the protocol.
     */
    public ProtocolLink(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructor with URI and name.
     *
     * @param uri The URI to the protocol.
     * @param name The name of the protocol.
     */
    public ProtocolLink(URI uri, String name)
    {
        this.uri = uri;
        this.name = name;
    }

    /**
     * Constructor from a linkable object.
     *
     * @param link The linkable object containing the protocol.
     */
    public ProtocolLink(Linkable<Protocol> link)
    {
        requireNonNull(link, "link cannot be null");
        uri = link.getUri();
    }

    /**
     * Constructor from a protocol.
     *
     * @param protocol The protocol.
     */
    public ProtocolLink(Protocol protocol)
    {
        requireNonNull(protocol, "protocol cannot be null");
        uri = protocol.getUri();
        name = protocol.getName();
    }

    /**
     * Gets the name of the protocol.
     *
     * @return The name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of the protocol.
     *
     * @param value The name.
     */
    public void setName(String value)
    {
        this.name = value;
    }

    /**
     * Gets the URI to the protocol.
     *
     * @return The URI.
     */
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI to the protocol.
     *
     * @param value The URI.
     */
    public void setUri(URI value)
    {
        this.uri = value;
    }

    /**
     * Gets the entity class this link refers to.
     *
     * @return The Protocol class.
     */
    @Override
    public Class<Protocol> getEntityClass()
    {
        return Protocol.class;
    }

    /**
     * Gets a string representation of the protocol link.
     *
     * @return The protocol name, or "null" if the name is null.
     */
    @Override
    public String toString()
    {
        return name == null ? "null" : name;
    }
}
