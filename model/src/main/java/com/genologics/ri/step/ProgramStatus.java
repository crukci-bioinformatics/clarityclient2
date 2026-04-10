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
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.ClarityEntity;
import com.genologics.ri.LimsLink;
import com.genologics.ri.Link;
import com.genologics.ri.Linkable;

/**
 *
 * The current EPP status for a step (supports automatically triggered programs
 * only).
 */
@ClarityEntity(uriSection = "steps", uriSubsection = "programstatus", updateable = true)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "program-status", propOrder = { "step", "configuration", "status", "message" })
@XmlRootElement(name = "program-status")
public class ProgramStatus implements Linkable<ProgramStatus>, Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial
    private static final long serialVersionUID = -3133977224031042653L;

    /**
     * Link to the step associated with this program status.
     */
    @XmlElement(name = "step")
    protected Link step;

    /**
     * The configuration of the step.
     */
    @XmlElement(name = "configuration")
    protected StepConfiguration configuration;

    /**
     * The current status of the program.
     */
    @XmlElement(name = "status")
    protected Status status;

    /**
     * The message associated with the program status.
     */
    @XmlElement(name = "message")
    protected String message;

    /**
     * The URI of the program status.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * Constructs a new empty ProgramStatus.
     */
    public ProgramStatus()
    {
    }

    /**
     * Constructs a new ProgramStatus with the given URI.
     *
     * @param uri the URI of the program status.
     */
    public ProgramStatus(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Gets the link to the step associated with this program status.
     *
     * @return the step link.
     */
    public Link getStep()
    {
        return step;
    }

    /**
     * Sets the link to the step associated with this program status.
     *
     * @param step the step link.
     */
    public void setStep(Link step)
    {
        this.step = step;
    }

    /**
     * Gets the configuration of the step.
     *
     * @return the step configuration.
     */
    public StepConfiguration getConfiguration()
    {
        return configuration;
    }

    /**
     * Sets the configuration of the step.
     *
     * @param configuration the step configuration.
     */
    public void setConfiguration(StepConfiguration configuration)
    {
        this.configuration = configuration;
    }

    /**
     * Gets the current status of the program.
     *
     * @return the status.
     */
    public Status getStatus()
    {
        return status;
    }

    /**
     * Sets the current status of the program.
     *
     * @param status the status.
     */
    public void setStatus(Status status)
    {
        this.status = status;
    }

    /**
     * Gets the message associated with the program status.
     *
     * @return the message.
     */
    public String getMessage()
    {
        return message;
    }

    /**
     * Sets the message associated with the program status.
     *
     * @param message the message.
     */
    public void setMessage(String message)
    {
        this.message = message;
    }

    /**
     * Gets the URI of the program status.
     *
     * @return the URI.
     */
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI of the program status.
     *
     * @param uri the URI.
     */
    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LimsLink<ProgramStatus> getLink()
    {
        return new ProgramStatusLink(this);
    }
}
