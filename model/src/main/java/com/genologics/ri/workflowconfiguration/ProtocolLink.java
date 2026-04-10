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

package com.genologics.ri.workflowconfiguration;

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
import com.genologics.ri.protocolconfiguration.Protocol;

/**
 *
 * Protocol-link is a child element type of workflow and provides a URI linking
 * to the detailed representation of a protocol.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "protocol-link")
public class ProtocolLink implements LimsLink<Protocol>, Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 2721431278437928217L;

    /**
     * The URI of the protocol.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * The name of the protocol.
     */
    @XmlAttribute(name = "name")
    protected String name;

    /**
     * Default constructor.
     */
    public ProtocolLink()
    {
    }

    /**
     * Constructor accepting a URI.
     *
     * @param uri The protocol URI.
     */
    public ProtocolLink(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructor accepting a URI and name.
     *
     * @param uri The protocol URI.
     * @param name The protocol name.
     */
    public ProtocolLink(URI uri, String name)
    {
        this.uri = uri;
        this.name = name;
    }

    /**
     * Constructor accepting a Linkable object.
     *
     * @param link The linkable protocol object.
     */
    public ProtocolLink(Linkable<Protocol> link)
    {
        requireNonNull(link, "link cannot be null");
        uri = link.getUri();
    }

    /**
     * Constructor accepting a Protocol object.
     *
     * @param protocol The protocol to link to.
     */
    public ProtocolLink(Protocol protocol)
    {
        requireNonNull(protocol, "protocol cannot be null");
        uri = protocol.getUri();
        name = protocol.getName();
    }

    /**
     * Gets the entity class for this link.
     *
     * @return The Protocol class.
     */
    @Override
    public Class<Protocol> getEntityClass()
    {
        return Protocol.class;
    }

    /**
     * Gets the URI of the protocol.
     *
     * @return The protocol URI.
     */
    @Override
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI of the protocol.
     *
     * @param uri The protocol URI.
     */
    @Override
    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Gets the name of the protocol.
     *
     * @return The protocol name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of the protocol.
     *
     * @param name The protocol name.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Returns a string representation of this protocol link.
     *
     * @return The protocol name.
     */
    @Override
    public String toString()
    {
        return name;
    }
}
