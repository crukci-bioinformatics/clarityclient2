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

package com.genologics.ri.stage;

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
import com.genologics.ri.protocolconfiguration.Protocol;

/**
 * Protocol link for a stage in a workflow.
 * <p>
 * This class represents a reference to a protocol within the Clarity LIMS system.
 * It extends {@link LimsLinkBase} to provide a typed link to a {@link Protocol} entity,
 * enabling navigation to the detailed configuration of the protocol associated with a stage.
 * </p>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "protocol")
public class ProtocolLink extends LimsLinkBase<Protocol>
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 2132801688423667843L;

    /**
     * The URI of the protocol.
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
     * @param uri The URI of the protocol.
     */
    public ProtocolLink(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructor from a linkable protocol object.
     *
     * @param link The linkable protocol object.
     */
    public ProtocolLink(Linkable<Protocol> link)
    {
        requireNonNull(link, "link cannot be null");
        uri = link.getUri();
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
     * @return The URI of the protocol.
     */
    @Override
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI of the protocol.
     *
     * @param uri The URI of the protocol.
     */
    @Override
    public void setUri(URI uri)
    {
        this.uri = uri;
    }
}
