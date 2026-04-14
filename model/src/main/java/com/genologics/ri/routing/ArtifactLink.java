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

package com.genologics.ri.routing;

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
 * Link to an artifact for routing purposes.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "artifact")
public class ArtifactLink extends LimsLinkBase<Artifact>
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = -5098969484639468234L;

    /**
     * The URI of the artifact.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * Default constructor.
     */
    public ArtifactLink()
    {
    }

    /**
     * Constructor with URI.
     *
     * @param uri The URI of the artifact.
     */
    public ArtifactLink(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructor from a Linkable.
     *
     * @param link The linkable artifact.
     */
    public ArtifactLink(Linkable<Artifact> link)
    {
        requireNonNull(link, "link cannot be null");
        this.uri = link.getUri();
    }

    /**
     * Gets the URI of the artifact.
     *
     * @return The artifact URI.
     */
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI of the artifact.
     *
     * @param value The artifact URI.
     */
    public void setUri(URI value)
    {
        this.uri = value;
    }

    /**
     * Gets the entity class for this link.
     *
     * @return The Artifact class.
     */
    @Override
    public Class<Artifact> getEntityClass()
    {
        return Artifact.class;
    }

}
