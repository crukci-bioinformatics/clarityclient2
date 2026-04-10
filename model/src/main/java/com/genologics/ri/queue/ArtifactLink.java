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

package com.genologics.ri.queue;

import static java.util.Objects.requireNonNull;

import java.io.Serial;
import java.io.Serializable;
import java.net.URI;
import java.util.Date;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.genologics.ri.jaxb.LongTimestampAdapter;

import com.genologics.ri.LimsEntityLink;
import com.genologics.ri.LimsEntityLinkable;
import com.genologics.ri.Linkable;
import com.genologics.ri.Location;
import com.genologics.ri.artifact.Artifact;


/**
 * Artifact-Link provides a URI linking to the detailed representation of an artifact in a queue.
 * @since 2.19
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "artifact-link", propOrder = { "queueTime", "location" })
public class ArtifactLink implements LimsEntityLink<Artifact>, Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = -531351200403814712L;

    /**
     * The time when the artifact was queued.
     */
    @XmlElement(name = "queue-time")
    @XmlSchemaType(name = "dateTime")
    @XmlJavaTypeAdapter(LongTimestampAdapter.class)
    protected Date queueTime;

    /**
     * The location of the artifact.
     */
    protected Location location;

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
     * Constructor with URI and LIMS id.
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
     * Constructor from a Linkable.
     *
     * @param link The linkable artifact.
     */
    public ArtifactLink(Linkable<Artifact> link)
    {
        requireNonNull(link, "link cannot be null");
        uri = link.getUri();
    }

    /**
     * Constructor from a LimsEntityLinkable.
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
     * Constructor from an Artifact.
     *
     * @param artifact The artifact.
     */
    public ArtifactLink(Artifact artifact)
    {
        requireNonNull(artifact, "artifact cannot be null");
        uri = artifact.getUri();
        limsid = artifact.getLimsid();
        location = artifact.getLocation();
    }

    /**
     * Gets the time when the artifact was queued.
     *
     * @return The queue time.
     */
    public Date getQueueTime()
    {
        return queueTime;
    }

    /**
     * Sets the time when the artifact was queued.
     *
     * @param queueTime The queue time.
     */
    public void setQueueTime(Date queueTime)
    {
        this.queueTime = queueTime;
    }

    /**
     * Gets the location of the artifact.
     *
     * @return The artifact location.
     */
    public Location getLocation()
    {
        return location;
    }

    /**
     * Sets the location of the artifact.
     *
     * @param location The artifact location.
     */
    public void setLocation(Location location)
    {
        this.location = location;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public URI getUri()
    {
        return uri;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getLimsid()
    {
        return limsid;
    }

    /**
     * Sets the LIMS id of the artifact.
     *
     * @param limsid The LIMS id.
     */
    public void setLimsid(String limsid)
    {
        this.limsid = limsid;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Class<Artifact> getEntityClass()
    {
        return Artifact.class;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString()
    {
        return limsid;
    }
}
