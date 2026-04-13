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

import java.io.Serial;
import java.net.URI;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.LimsLinkBase;
import com.genologics.ri.Linkable;

/**
 * Identifies the resource that will demultiplex this artifact. This will only
 * be present if the artifact is a pool.
 *
 * @since 2.26
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "demux-link")
public class DemuxLink extends LimsLinkBase<DemuxArtifact>
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = -3140263256856604670L;

    /**
     * The URI of this demux artifact.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * Default constructor.
     */
    public DemuxLink()
    {
    }

    /**
     * Constructor taking a URI.
     *
     * @param uri The demux artifact URI.
     */
    public DemuxLink(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructor from a Linkable.
     *
     * @param link The linkable object to copy.
     */
    public DemuxLink(Linkable<DemuxArtifact> link)
    {
        requireNonNull(link, "link cannot be null");
        this.uri = link.getUri();
    }

    /**
     * Gets the URI.
     *
     * @return The demux artifact URI.
     */
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI.
     *
     * @param uri The demux artifact URI.
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
    public void setArtifact(Linkable<DemuxArtifact> artifact)
    {
        this.uri = artifact == null ? null : artifact.getUri();
    }

    /**
     * Gets the entity class.
     *
     * @return The DemuxArtifact class.
     */
    @Override
    public Class<DemuxArtifact> getEntityClass()
    {
        return DemuxArtifact.class;
    }
}
