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
import java.io.Serializable;
import java.net.URI;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.genologics.ri.LimsLink;
import com.genologics.ri.Linkable;


/**
 * Clarity global token. There is currently no end point in Clarity, hence there
 * is no {@code @XmlRootElement} annotation here. It will need to be added if there is
 * an end point in a later release.
 *
 * @since 2.34
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "global-token", propOrder = { "name", "value", "description", "isCustom" })
public class GlobalToken implements Linkable<GlobalToken>, Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 8999326250541104054L;

    /**
     * The token name.
     */
    @XmlElement
    protected String name;

    /**
     * The token value.
     */
    @XmlElement
    protected String value;

    /**
     * The token description.
     */
    @XmlElement
    protected String description;

    /**
     * Flag indicating whether this is a custom token.
     */
    @XmlElement(name = "is-custom")
    protected Boolean isCustom;

    /**
     * The URI of this global token.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;


    /**
     * Default constructor.
     */
    public GlobalToken()
    {
    }

    /**
     * Constructor with URI.
     *
     * @param uri The URI of the global token.
     */
    public GlobalToken(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructor with URI and name.
     *
     * @param uri The URI of the global token.
     * @param name The token name.
     */
    public GlobalToken(URI uri, String name)
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
     * Get the token value.
     *
     * @return The token value.
     */
    public String getValue()
    {
        return value;
    }

    /**
     * Set the token value.
     *
     * @param value The token value.
     */
    public void setValue(String value)
    {
        this.value = value;
    }

    /**
     * Get the token description.
     *
     * @return The token description.
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Set the token description.
     *
     * @param description The token description.
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * Check whether this is a custom token.
     *
     * @return True if this is a custom token, false otherwise.
     */
    public boolean isCustom()
    {
        return isCustom == null ? false : isCustom.booleanValue();
    }

    /**
     * Set whether this is a custom token.
     *
     * @param isCustom True if this is a custom token, false otherwise.
     */
    public void setCustom(Boolean isCustom)
    {
        this.isCustom = isCustom;
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
     * Returns a string representation of this global token.
     *
     * @return A string containing the name and value.
     */
    @Override
    public String toString()
    {
        ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
        sb.append("name", name);
        sb.append("value", value);
        return sb.toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LimsLink<GlobalToken> getLink()
    {
        return new GlobalTokenLink(uri, name);
    }
}
