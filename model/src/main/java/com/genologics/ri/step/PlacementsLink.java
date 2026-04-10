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
 *
 * Identifies the resource that represents the output placements for the step.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "placements-link")
public class PlacementsLink implements LimsLink<Placements>, Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 2017533453426861528L;

    /**
     * The URI of the placements resource.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * Default constructor.
     */
    public PlacementsLink()
    {
    }

    /**
     * Constructor with URI.
     *
     * @param uri The URI of the placements resource.
     */
    public PlacementsLink(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructor with placements object.
     *
     * @param placements The placements object to link to.
     */
    public PlacementsLink(Linkable<Placements> placements)
    {
        requireNonNull(placements, "placements cannot be null");
        uri = placements.getUri();
    }

    /**
     * Gets the entity class for this link.
     *
     * @return The Placements class.
     */
    @Override
    public Class<Placements> getEntityClass()
    {
        return Placements.class;
    }

    /**
     * Gets the URI of the placements resource.
     *
     * @return The URI.
     */
    @Override
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI of the placements resource.
     *
     * @param uri The URI to set.
     */
    @Override
    public void setUri(URI uri)
    {
        this.uri = uri;
    }

}
