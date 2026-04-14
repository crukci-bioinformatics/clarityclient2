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

package com.genologics.ri.globaltoken;

import java.io.Serial;
import java.net.URI;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.LimsLinkBase;


/**
 * global-token-link is a child element type of global tokens and provides a URI linking to the detailed representation of a global token.
 *
 * @since 2.34
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "global-token-link")
public class GlobalTokenLink extends LimsLinkBase<GlobalToken>
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 2340905402174078413L;

    /**
     * The URI of the global token.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * The token name.
     */
    @XmlElement
    protected String name;

    /**
     * Default constructor.
     */
    public GlobalTokenLink()
    {
    }

    /**
     * Constructor with URI.
     *
     * @param uri The URI of the global token.
     */
    public GlobalTokenLink(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructor with URI and name.
     *
     * @param uri The URI of the global token.
     * @param name The token name.
     */
    public GlobalTokenLink(URI uri, String name)
    {
        this.uri = uri;
        this.name = name;
    }

    /**
     * Get the token name.
     *
     * @return The token name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Set the token name.
     *
     * @param name The token name.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Get the URI of this global token.
     *
     * @return The URI.
     */
    public URI getUri()
    {
        return uri;
    }

    /**
     * Set the URI of this global token.
     *
     * @param uri The URI.
     */
    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Class<GlobalToken> getEntityClass()
    {
        return GlobalToken.class;
    }

    /**
     * Returns a string representation of this global token link.
     *
     * @return The token name.
     */
    @Override
    public String toString()
    {
        return name;
    }
}
