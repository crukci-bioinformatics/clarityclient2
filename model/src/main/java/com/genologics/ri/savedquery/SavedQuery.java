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

package com.genologics.ri.savedquery;

import static com.genologics.ri.Link.UNSET;

import java.io.Serial;
import java.io.Serializable;
import java.net.URI;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.ClarityEntity;
import com.genologics.ri.LimsLink;
import com.genologics.ri.Linkable;

/**
 * Represents a saved query in the Clarity LIMS system.
 *
 * @since 2.34
 */
@ClarityEntity(uriSection = "saved-queries")
@XmlRootElement(name = "saved-query")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "saved-query")
public class SavedQuery implements Linkable<SavedQuery>, Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = -7815486399547221485L;

    /**
     * The name of the saved query.
     */
    @XmlElement
    protected String name;

    /**
     * The unique identifier of the saved query.
     */
    @XmlAttribute(name = "id")
    protected String id;

    /**
     * The URI of the saved query.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * Default constructor.
     */
    public SavedQuery()
    {
    }

    /**
     * Constructor with URI.
     *
     * @param uri The URI of the saved query.
     */
    public SavedQuery(URI uri)
    {
        setUri(uri);
    }

    /**
     * Gets the name of the saved query.
     *
     * @return The name of the saved query.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of the saved query.
     *
     * @param name The name of the saved query.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Gets the unique identifier of the saved query.
     *
     * @return The identifier of the saved query.
     */
    public String getId()
    {
        return id;
    }

    /**
     * Sets the unique identifier of the saved query.
     *
     * @param id The identifier of the saved query.
     */
    public void setId(String id)
    {
        this.id = id;
    }

    /**
     * Gets the URI of the saved query.
     *
     * @return The URI of the saved query.
     */
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI of the saved query.
     *
     * @param uri The URI of the saved query.
     */
    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Gets a link to this saved query.
     *
     * @return A link to this saved query.
     */
    @Override
    public LimsLink<SavedQuery> getLink()
    {
        return new SavedQueryLink();
    }

    /**
     * Returns the string representation of the saved query.
     *
     * @return The name of the saved query, or "unset" if name is null.
     */
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder(80);
        sb.append("SavedQuery[").append(name == null ? UNSET : name).append(']');
        return sb.toString();
    }
}
