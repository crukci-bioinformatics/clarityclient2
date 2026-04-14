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

package com.genologics.ri.processexecution;

import static java.util.Objects.requireNonNull;

import java.io.Serial;
import java.net.URI;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.LimsLink;
import com.genologics.ri.Linkable;
import com.genologics.ri.artifact.Artifact;

/**
 *
 * The input element provides URIs to one or more Artifacts that will be used by
 * the Process. Input is a child element of input-output-map.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "input")
public class Input extends ArtifactBase implements LimsLink<Artifact>
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = -8366721361957628940L;

    /**
     * The URI of the input artifact.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * Default constructor.
     */
    public Input()
    {
    }

    /**
     * Constructor with URI.
     *
     * @param uri The artifact URI.
     */
    public Input(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructor with URI and QC flag.
     *
     * @param uri The artifact URI.
     * @param qc The QC flag.
     */
    public Input(URI uri, QCFlag qc)
    {
        this.uri = uri;
        this.qcFlag = qc;
    }

    /**
     * Constructor from a linkable artifact.
     *
     * @param link The artifact link.
     */
    public Input(Linkable<Artifact> link)
    {
        requireNonNull(link, "link cannot be null");
        this.uri = link.getUri();
        updateQCFlag(link);
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
     * Gets the URI of the input artifact.
     *
     * @return The artifact URI.
     */
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI of the input artifact.
     *
     * @param uri The artifact URI to set.
     */
    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    /**
     * {@inheritDoc}
     * @see LimsLink#hashCode(LimsLink)
     */
    @Override
    public int hashCode()
    {
        return LimsLink.hashCode(this);
    }

    /**
     * {@inheritDoc}
     * @see LimsLink#equals(LimsLink, Object)
     */
    @Override
    public boolean equals(Object obj)
    {
        return LimsLink.equals(this, obj);
    }

    /**
     * Returns a string representation of the input.
     *
     * @return A string representation.
     */
    public String toString()
    {
        return LimsLink.toString(this);
    }
}
