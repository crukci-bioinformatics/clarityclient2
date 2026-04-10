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
import com.genologics.ri.artifact.Artifact;
import com.genologics.ri.controltype.ControlType;

/**
 *
 * Typically, provides a URI linking to the input artifact. Can also be used to
 * designate control sample inputs (via its control type). One of 'uri' or
 * 'control-type-uri' attributes must be provided, but not both.
 *
 * @since 2.18
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "creation-input")
public class CreationInput implements LimsLink<Artifact>, Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 8275002091544701688L;

    /**
     * URI of the input artifact.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * URI of the control type.
     */
    @XmlAttribute(name = "control-type-uri")
    @XmlSchemaType(name = "anyURI")
    protected URI controlTypeUri;

    /**
     * Number of replicates.
     */
    @XmlAttribute(name = "replicates")
    protected Long replicates;

    /**
     * Default constructor.
     */
    public CreationInput()
    {
    }

    /**
     * Constructor with URI.
     *
     * @param uri The URI of the input artifact.
     */
    public CreationInput(URI uri)
    {
        this(uri, null, null);
    }

    /**
     * Constructor with URI and control type URI.
     *
     * @param uri The URI of the input artifact.
     * @param controlTypeUri The URI of the control type.
     */
    public CreationInput(URI uri, URI controlTypeUri)
    {
        this(uri, controlTypeUri, null);
    }

    /**
     * Constructor with URI, control type URI, and replicates.
     *
     * @param uri The URI of the input artifact.
     * @param controlTypeUri The URI of the control type.
     * @param replicates The number of replicates.
     */
    public CreationInput(URI uri, URI controlTypeUri, Long replicates)
    {
        this.uri = uri;
        this.controlTypeUri = controlTypeUri;
        this.replicates = replicates;
    }

    /**
     * Constructor from a linkable artifact.
     *
     * @param artifact The linkable artifact.
     */
    public CreationInput(Linkable<Artifact> artifact)
    {
        this(artifact, null, null);
    }

    /**
     * Constructor from a linkable artifact and control type.
     *
     * @param artifact The linkable artifact.
     * @param controlType The linkable control type.
     */
    public CreationInput(Linkable<Artifact> artifact, Linkable<ControlType> controlType)
    {
        this(artifact, controlType, null);
    }

    /**
     * Constructor from a linkable artifact, control type, and replicates.
     *
     * @param artifact The linkable artifact.
     * @param controlType The linkable control type.
     * @param replicates The number of replicates.
     */
    public CreationInput(Linkable<Artifact> artifact, Linkable<ControlType> controlType, Long replicates)
    {
        this.uri = artifact.getUri();
        this.controlTypeUri = controlType == null ? null : controlType.getUri();
        this.replicates = replicates;
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
     * Sets the artifact.
     *
     * @param a The linkable artifact.
     */
    public void setArtifact(Linkable<Artifact> a)
    {
        this.uri = a == null ? null : a.getUri();
    }

    /**
     * Gets the control type URI.
     *
     * @return The control type URI.
     */
    public URI getControlTypeUri()
    {
        return controlTypeUri;
    }

    /**
     * Sets the control type URI.
     *
     * @param controlTypeUri The control type URI.
     */
    public void setControlTypeUri(URI controlTypeUri)
    {
        this.controlTypeUri = controlTypeUri;
    }

    /**
     * Sets the control type.
     *
     * @param type The linkable control type.
     */
    public void setControlType(Linkable<ControlType> type)
    {
        this.controlTypeUri = type == null ? null : type.getUri();
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
}
