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
import java.net.URI;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.LimsLinkBase;
import com.genologics.ri.Linkable;
import com.genologics.ri.artifact.Artifact;

/**
 *
 * Provides input URI links.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "input")
public class Input extends LimsLinkBase<Artifact>
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = -2525215280378480778L;

    /**
     * URI of the input artifact.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * Number of replicates for the input.
     *
     * @since 2.18
     */
    @XmlAttribute
    protected Long replicates;

    /**
     * Default constructor.
     */
    public Input()
    {
    }

    /**
     * Constructor with URI.
     *
     * @param uri The URI of the input artifact.
     */
    public Input(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructor from a linkable object.
     *
     * @param link The linkable artifact.
     */
    public Input(Linkable<Artifact> link)
    {
        requireNonNull(link, "link cannot be null");
        uri = link.getUri();
    }

    /**
     * Gets the entity class.
     *
     * @return The Artifact class.
     */
    @Override
    public Class<Artifact> getEntityClass()
    {
        return Artifact.class;
    }

    /**
     * Gets the URI.
     *
     * @return The URI.
     */
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI.
     *
     * @param uri The URI.
     */
    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Gets the number of replicates.
     *
     * @return The number of replicates.
     */
    public Long getReplicates()
    {
        return replicates;
    }

    /**
     * Sets the number of replicates.
     *
     * @param replicates The number of replicates.
     */
    public void setReplicates(Long replicates)
    {
        this.replicates = replicates;
    }
}
