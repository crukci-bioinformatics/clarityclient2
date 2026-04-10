/*
 * CRUK-CI Clarity REST API Java Client.
 * Copyright (C) 2018 Cancer Research UK Cambridge Institute.
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

package com.genologics.ri.artifact;

import static java.util.Objects.requireNonNull;

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
 * Link to a source artifact for demultiplexing.
 *
 * @since 2.26
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "demux-source-artifact")
public class DemuxSourceArtifact implements LimsLink<Artifact>, Serializable
{
    /**
     * Class version for serialisation.
     */
    @java.io.Serial
    private static final long serialVersionUID = -3058956251238626047L;

    /**
     * The URI of this demux source artifact.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * The name of this demux source artifact.
     */
    @XmlAttribute(name = "name")
    protected String name;

    /**
     * Default constructor.
     */
    public DemuxSourceArtifact()
    {
    }

    /**
     * Constructor taking a URI.
     *
     * @param uri The artifact URI.
     */
    public DemuxSourceArtifact(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructor taking a URI and name.
     *
     * @param uri The artifact URI.
     * @param name The artifact name.
     */
    public DemuxSourceArtifact(URI uri, String name)
    {
        this.uri = uri;
        this.name = name;
    }

    /**
     * Constructor from a Linkable.
     *
     * @param link The linkable object to copy.
     */
    public DemuxSourceArtifact(Linkable<Artifact> link)
    {
        requireNonNull(link, "link cannot be null");
        this.uri = link.getUri();
    }

    /**
     * Constructor from an Artifact.
     *
     * @param artifact The artifact to copy.
     */
    public DemuxSourceArtifact(Artifact artifact)
    {
        requireNonNull(artifact, "artifact cannot be null");
        this.uri = artifact.getUri();
        this.name = artifact.getName();
    }

    /**
     * Gets the URI.
     *
     * @return The artifact URI.
     */
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI.
     *
     * @param uri The artifact URI.
     */
    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Sets the artifact from a Linkable.
     *
     * @param artifact The linkable artifact to set.
     */
    public void setArtifact(Linkable<Artifact> artifact)
    {
        this.uri = artifact == null ? null : artifact.getUri();
    }

    /**
     * Gets the name.
     *
     * @return The artifact name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name The artifact name.
     */
    public void setName(String name)
    {
        this.name = name;
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
     * Returns a string representation of this artifact.
     *
     * @return The name, or "null" if not set.
     */
    @Override
    public String toString()
    {
        return name == null ? "null" : name;
    }
}
