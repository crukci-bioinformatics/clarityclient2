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

import java.io.Serializable;
import java.net.URI;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.genologics.ri.LimsLink;
import com.genologics.ri.Linkable;
import com.genologics.ri.artifact.Artifact;
import com.genologics.ri.stepconfiguration.ProtocolStep;

/**
 *
 * Sample next action or step.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "next-action")
public class NextAction implements LimsLink<Artifact>, Serializable
{
    /**
     * Class version for serialisation.
     */
    @java.io.Serial
    private static final long serialVersionUID = -8061858911629830727L;

    /**
     * URI of the artifact.
     */
    @XmlAttribute(name = "artifact-uri")
    @XmlSchemaType(name = "anyURI")
    protected URI artifactUri;

    /**
     * The action type.
     */
    @XmlAttribute(name = "action")
    protected ActionType action;

    /**
     * URI of the next step.
     */
    @XmlAttribute(name = "step-uri")
    @XmlSchemaType(name = "anyURI")
    protected URI stepUri;

    /**
     * URI of the rework step.
     *
     * @since 2.20
     */
    @XmlAttribute(name = "rework-step-uri")
    @XmlSchemaType(name = "anyURI")
    protected URI reworkStepUri;


    /**
     * Default constructor.
     */
    public NextAction()
    {
    }

    /**
     * Constructor with artifact URI.
     *
     * @param artifactUri The URI of the artifact.
     */
    public NextAction(URI artifactUri)
    {
        setArtifactUri(artifactUri);
    }

    /**
     * Constructor with artifact URI and action.
     *
     * @param artifactUri The URI of the artifact.
     * @param action The action type.
     */
    public NextAction(URI artifactUri, ActionType action)
    {
        setArtifactUri(artifactUri);
        setAction(action);
    }

    /**
     * Constructor with artifact URI, action, and next step.
     *
     * @param artifactUri The URI of the artifact.
     * @param action The action type.
     * @param nextStep The linkable next protocol step.
     */
    public NextAction(URI artifactUri, ActionType action, Linkable<ProtocolStep> nextStep)
    {
        setArtifactUri(artifactUri);
        setAction(action);
        setStep(nextStep);
    }

    /**
     * Constructor from a linkable artifact.
     *
     * @param link The linkable artifact.
     */
    public NextAction(Linkable<Artifact> link)
    {
        setArtifact(link);
    }

    /**
     * Constructor from a linkable artifact and action.
     *
     * @param link The linkable artifact.
     * @param action The action type.
     */
    public NextAction(Linkable<Artifact> link, ActionType action)
    {
        setArtifact(link);
        setAction(action);
    }

    /**
     * Constructor from a linkable artifact, action, and next step.
     *
     * @param link The linkable artifact.
     * @param action The action type.
     * @param nextStep The linkable next protocol step.
     */
    public NextAction(Linkable<Artifact> link, ActionType action, Linkable<ProtocolStep> nextStep)
    {
        setArtifact(link);
        setAction(action);
        setStep(nextStep);
    }

    /**
     * Gets the artifact URI.
     *
     * @return The artifact URI.
     */
    public URI getArtifactUri()
    {
        return artifactUri;
    }

    /**
     * Sets the artifact URI.
     *
     * @param artifactUri The artifact URI.
     */
    public void setArtifactUri(URI artifactUri)
    {
        this.artifactUri = artifactUri;
    }

    /**
     * Sets the artifact.
     *
     * @param link The linkable artifact.
     */
    public void setArtifact(Linkable<Artifact> link)
    {
        artifactUri = link == null ? null : link.getUri();
    }

    /**
     * Gets the action type.
     *
     * @return The action type.
     */
    public ActionType getAction()
    {
        return action;
    }

    /**
     * Sets the action type.
     *
     * @param action The action type.
     */
    public void setAction(ActionType action)
    {
        this.action = action;
    }

    /**
     * Gets the step URI.
     *
     * @return The step URI.
     */
    public URI getStepUri()
    {
        return stepUri;
    }

    /**
     * Sets the step URI.
     *
     * @param stepUri The step URI.
     */
    public void setStepUri(URI stepUri)
    {
        this.stepUri = stepUri;
    }

    /**
     * Sets the next step.
     *
     * @param step The linkable protocol step.
     */
    public void setStep(Linkable<ProtocolStep> step)
    {
        stepUri = step == null ? null : step.getUri();
    }

    /**
     * Gets the rework step URI.
     *
     * @return The rework step URI.
     */
    public URI getReworkStepUri()
    {
        return reworkStepUri;
    }

    /**
     * Sets the rework step URI.
     *
     * @param reworkStepUri The rework step URI.
     */
    public void setReworkStepUri(URI reworkStepUri)
    {
        this.reworkStepUri = reworkStepUri;
    }

    /**
     * Sets the rework step.
     *
     * @param step The linkable protocol step.
     */
    public void setReworkStep(Linkable<ProtocolStep> step)
    {
        reworkStepUri = step == null ? null : step.getUri();
    }

    /**
     * Sets the URI (artifact URI).
     *
     * @param uri The URI.
     */
    @Override
    public void setUri(URI uri)
    {
        this.artifactUri = uri;
    }

    /**
     * Gets the URI (artifact URI).
     *
     * @return The URI.
     */
    @Override
    public URI getUri()
    {
        return artifactUri;
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
     * Produces a string representation of this next action.
     *
     * @return A string representation.
     */
    @Override
    public String toString()
    {
        ToStringBuilder b = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
        b.append("artifactUri", artifactUri);
        b.append("action", action);
        if (reworkStepUri != null)
        {
            b.append("reworkStepUri", reworkStepUri);
        }
        return b.toString();
    }
}
