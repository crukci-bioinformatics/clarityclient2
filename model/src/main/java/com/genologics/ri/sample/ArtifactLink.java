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

package com.genologics.ri.sample;

import static java.util.Objects.requireNonNull;

import java.io.Serializable;
import java.net.URI;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.LimsEntityLink;
import com.genologics.ri.LimsEntityLinkable;
import com.genologics.ri.Linkable;
import com.genologics.ri.artifact.Artifact;

/**
 * Artifact is a child element of Sample and provides a URI linking to the
 * detailed representation of the artifact for the Sample.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "artifact")
public class ArtifactLink implements LimsEntityLink<Artifact>, Serializable
{
    /**
     * Class version for serialisation.
     */
    @java.io.Serial
    private static final long serialVersionUID = 3393329302381963246L;

    /**
     * The URI of the artifact.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * The LIMS id of the artifact.
     */
    @XmlAttribute(name = "limsid")
    protected String limsid;

    /**
     * Constructor for an empty artifact link.
     */
    public ArtifactLink()
    {
    }

    /**
     * Constructor for an artifact link with a URI.
     *
     * @param uri The URI of the artifact.
     */
    public ArtifactLink(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructor for an artifact link with a URI and LIMS id.
     *
     * @param uri The URI of the artifact.
     * @param limsid The LIMS id of the artifact.
     */
    public ArtifactLink(URI uri, String limsid)
    {
        this.uri = uri;
        this.limsid = limsid;
    }

    /**
     * Constructor for an artifact link from a linkable artifact.
     *
     * @param link The linkable artifact.
     */
    public ArtifactLink(Linkable<Artifact> link)
    {
        requireNonNull(link, "link cannot be null");
        uri = link.getUri();
    }

    /**
     * Constructor for an artifact link from a LIMS entity linkable artifact.
     *
     * @param link The LIMS entity linkable artifact.
     */
    public ArtifactLink(LimsEntityLinkable<Artifact> link)
    {
        requireNonNull(link, "link cannot be null");
        uri = link.getUri();
        limsid = link.getLimsid();
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
     * Gets the LIMS id of the artifact.
     *
     * @return The LIMS id.
     */
    public String getLimsid()
    {
        return limsid;
    }

    /**
     * Sets the LIMS id of the artifact.
     *
     * @param value The LIMS id.
     */
    public void setLimsid(String value)
    {
        this.limsid = value;
    }

    /**
     * Returns a string representation of this artifact link.
     *
     * @return The LIMS id.
     */
    @Override
    public String toString()
    {
        return limsid;
    }
}
