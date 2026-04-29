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

package com.genologics.ri.stepconfiguration;

import static java.util.Objects.requireNonNull;

import java.io.Serial;
import java.net.URI;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.genologics.ri.LimsLink;
import com.genologics.ri.LimsLinkBase;
import com.genologics.ri.Linkable;

/**
 *
 * List of step transitions including the URI allowing access to the specific
 * next step
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "next-step")
public class NextStep extends LimsLinkBase<ProtocolStep>
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = -955680094983735241L;

    /**
     * The name of the next step.
     */
    @XmlAttribute(name = "name")
    protected String name;

    /**
     * The sequence index of the next step.
     */
    @XmlAttribute(name = "sequence")
    protected Integer sequence;

    /**
     * The URI of the next step.
     */
    @XmlAttribute(name = "next-step-uri")
    @XmlSchemaType(name = "anyURI")
    protected URI nextStepUri;

    /**
     * Default constructor.
     */
    public NextStep()
    {
    }

    /**
     * Constructor with next step URI.
     *
     * @param nextStepUri The URI of the next step.
     */
    public NextStep(URI nextStepUri)
    {
        this.nextStepUri = nextStepUri;
    }

    /**
     * Constructor with next step URI and name.
     *
     * @param nextStepUri The URI of the next step.
     * @param name The name of the next step.
     */
    public NextStep(URI nextStepUri, String name)
    {
        this.nextStepUri = nextStepUri;
        this.name = name;
    }

    /**
     * Constructor with next step URI, name, and sequence.
     *
     * @param nextStepUri The URI of the next step.
     * @param name The name of the next step.
     * @param sequence The sequence index of the next step.
     */
    public NextStep(URI nextStepUri, String name, Integer sequence)
    {
        this.nextStepUri = nextStepUri;
        this.name = name;
        this.sequence = sequence;
    }

    /**
     * Constructor from a protocol step entity.
     *
     * @param step The protocol step entity.
     */
    public NextStep(ProtocolStep step)
    {
        requireNonNull(step, "step cannot be null");
        nextStepUri = step.getUri();
        name = step.getName();
        sequence = step.getProtocolStepIndex();
    }

    /**
     * Gets the name of the next step.
     *
     * @return The next step name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of the next step.
     *
     * @param name The next step name.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Gets the sequence index of the next step.
     *
     * @return The sequence index.
     */
    public Integer getSequence()
    {
        return sequence;
    }

    /**
     * Sets the sequence index of the next step.
     *
     * @param sequence The sequence index.
     */
    public void setSequence(Integer sequence)
    {
        this.sequence = sequence;
    }

    /**
     * Gets the URI of the next step.
     *
     * @return The next step URI.
     */
    public URI getNextStepUri()
    {
        return nextStepUri;
    }

    /**
     * Gets the URI of the next step (alias for getNextStepUri).
     *
     * @return The next step URI.
     */
    public URI getUri()
    {
        return nextStepUri;
    }

    /**
     * Sets the URI of the next step.
     *
     * @param nextStepUri The next step URI.
     */
    public void setNextStepUri(URI nextStepUri)
    {
        this.nextStepUri = nextStepUri;
    }

    /**
     * Sets the next step from a linkable protocol step.
     *
     * @param step The linkable protocol step.
     */
    public void setNextStep(Linkable<ProtocolStep> step)
    {
        this.nextStepUri = step.getUri();
    }

    /**
     * Sets the URI of the next step (alias for setNextStepUri).
     *
     * @param nextStepUri The next step URI.
     */
    public void setUri(URI nextStepUri)
    {
        this.nextStepUri = nextStepUri;
    }

    /**
     * Gets the entity class for this link.
     *
     * @return The ProtocolStep class.
     */
    @Override
    public Class<ProtocolStep> getEntityClass()
    {
        return ProtocolStep.class;
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
        b.append("nextStep", LimsLink.toString(this));
        b.append("name", name);
        return b.toString();
    }
}
