
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

package com.genologics.ri.step;

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
 * Identifies the resource that represents the arrangements (if any) for the step.
 *
 * @since 2.34
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "arrangements-link")
public class ArrangementsLink implements LimsLink<Arrangements>, Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 3342543381947203376L;

    /**
     * URI of the arrangements resource.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * Default constructor.
     */
    public ArrangementsLink()
    {
    }

    /**
     * Constructor with URI.
     *
     * @param uri The URI of the arrangements resource.
     */
    public ArrangementsLink(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructor from a linkable object.
     *
     * @param link The linkable object.
     */
    public ArrangementsLink(Linkable<Arrangements> link)
    {
        requireNonNull(link, "link cannot be null");
        this.uri = link.getUri();
    }

    /**
     * Gets the URI.
     *
     * @return The URI.
     */
    @Override
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI.
     *
     * @param uri The URI.
     */
    @Override
    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Gets the entity class.
     *
     * @return The Arrangements class.
     */
    @Override
    public Class<Arrangements> getEntityClass()
    {
        return Arrangements.class;
    }
}
