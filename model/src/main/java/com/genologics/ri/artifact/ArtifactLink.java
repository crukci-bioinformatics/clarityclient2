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

package com.genologics.ri.artifact;

import static java.util.Objects.requireNonNull;

import java.io.Serial;
import java.net.URI;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.LimsEntityLinkBase;
import com.genologics.ri.LimsEntityLinkable;
import com.genologics.ri.Linkable;

/**
 * Artifact-link is a child element type of artifacts and provides a URI linking
 * to the detailed representation of an artifact.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "artifact-link")
public class ArtifactLink extends LimsEntityLinkBase<Artifact>
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = -7338824559555981618L;

    /**
     * The URI of this artifact.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * The LIMS id of this artifact.
     */
    @XmlAttribute(name = "limsid")
    protected String limsid;

    /**
     * Default constructor.
     */
    public ArtifactLink()
    {
    }

    /**
     * Constructor taking a URI.
     *
     * @param uri The artifact URI.
     */
    public ArtifactLink(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructor taking a URI and LIMS id.
     *
     * @param uri The artifact URI.
     * @param limsid The artifact LIMS id.
     */
    public ArtifactLink(URI uri, String limsid)
    {
        this.uri = uri;
        this.limsid = limsid;
    }

    /**
     * Constructor from a Linkable.
     *
     * @param link The linkable object to copy.
     */
    public ArtifactLink(Linkable<Artifact> link)
    {
        requireNonNull(link, "link cannot be null");
        uri = link.getUri();
    }

    /**
     * Constructor from a LimsEntityLinkable.
     *
     * @param link The LIMS entity linkable object to copy.
     */
    public ArtifactLink(LimsEntityLinkable<Artifact> link)
    {
        requireNonNull(link, "link cannot be null");
        uri = link.getUri();
        limsid = link.getLimsid();
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
     * Gets the LIMS id.
     *
     * @return The artifact LIMS id.
     */
    public String getLimsid()
    {
        return limsid;
    }

    /**
     * Sets the LIMS id.
     *
     * @param limsid The artifact LIMS id.
     */
    public void setLimsid(String limsid)
    {
        this.limsid = limsid;
    }

    /**
     * Returns a string representation of this link.
     *
     * @return The LIMS id.
     */
    @Override
    public String toString()
    {
        return limsid;
    }
}
