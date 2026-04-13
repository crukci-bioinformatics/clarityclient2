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
import java.io.Serializable;
import java.net.URI;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.XmlValue;

import com.genologics.ri.LimsLink;
import com.genologics.ri.Linkable;
import com.genologics.ri.stepconfiguration.ProtocolStep;


/**
 *
 *         Identifies the configuration information for the step run.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "step-configuration")
public class StepConfiguration implements LimsLink<ProtocolStep>, Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 7902167896883448736L;

    /**
     * The URI of the protocol step configuration.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI protocolStepUri;

    /**
     * The name of the protocol step.
     */
    @XmlValue
    protected String stepName;

    /**
     * Creates an empty step configuration.
     */
    public StepConfiguration()
    {
    }

    /**
     * Creates a step configuration with the given protocol step URI.
     *
     * @param protocolStepUri The URI of the protocol step.
     */
    public StepConfiguration(URI protocolStepUri)
    {
        this.protocolStepUri = protocolStepUri;
    }

    /**
     * Creates a step configuration with the given protocol step URI and name.
     *
     * @param protocolStepUri The URI of the protocol step.
     * @param stepName The name of the protocol step.
     */
    public StepConfiguration(URI protocolStepUri, String stepName)
    {
        this.protocolStepUri = protocolStepUri;
        this.stepName = stepName;
    }

    /**
     * Creates a step configuration from a linkable protocol step.
     *
     * @param step The linkable protocol step to extract the URI from.
     *
     * @throws NullPointerException if {@code step} is null.
     */
    public StepConfiguration(Linkable<ProtocolStep> step)
    {
        requireNonNull(step, "step cannot be null");
        protocolStepUri = step.getUri();
    }

    /**
     * Creates a step configuration from a protocol step.
     *
     * @param step The protocol step to extract the URI and name from.
     *
     * @throws NullPointerException if {@code step} is null.
     */
    public StepConfiguration(ProtocolStep step)
    {
        requireNonNull(step, "step cannot be null");
        protocolStepUri = step.getUri();
        stepName = step.getName();
    }

    /**
     * Gets the protocol step URI.
     *
     * @return The protocol step URI.
     */
    public URI getProtocolStepUri()
    {
        return protocolStepUri;
    }

    /**
     * Sets the protocol step URI.
     *
     * @param protocolStepUri The protocol step URI.
     */
    public void setProtocolStepUri(URI protocolStepUri)
    {
        this.protocolStepUri = protocolStepUri;
    }

    /**
     * Sets the protocol step from a linkable object.
     *
     * @param protocolStep The linkable protocol step to extract the URI from.
     */
    public void setProtocolStep(Linkable<ProtocolStep> protocolStep)
    {
        this.protocolStepUri = protocolStep.getUri();
    }

    /**
     * Gets the name of the protocol step.
     *
     * @return The protocol step name.
     */
    public String getStepName()
    {
        return stepName;
    }

    /**
     * Sets the name of the protocol step.
     *
     * @param stepName The protocol step name.
     */
    public void setStepName(String stepName)
    {
        this.stepName = stepName;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public URI getUri()
    {
        return protocolStepUri;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setUri(URI uri)
    {
        this.protocolStepUri = uri;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Class<ProtocolStep> getEntityClass()
    {
        return ProtocolStep.class;
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
     * {@inheritDoc}
     * @see LimsLink#toString(LimsLink)
     */
    public String toString()
    {
        return LimsLink.toString(this);
    }
}
