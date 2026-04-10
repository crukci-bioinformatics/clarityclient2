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
import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.ClarityEntity;
import com.genologics.ri.LimsLink;
import com.genologics.ri.Link;
import com.genologics.ri.Linkable;


/**
 * The detailed representation of a step's output container Tube Rack arrangements only for an Add Label Step.
 *
 * @since 2.34
 */
@ClarityEntity(uriSection = "steps", uriSubsection = "arrangements", creatable = true)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "arrangements", propOrder = { "step", "configuration", "outputArrangements" })
@XmlRootElement(name = "arrangements")
public class Arrangements implements Linkable<Arrangements>, Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = -5065733682752946764L;

    /**
     * Link to the step.
     */
    @XmlElement
    protected Link step;

    /**
     * Configuration of the step.
     */
    @XmlElement
    protected StepConfiguration configuration;

    /**
     * List of output arrangements.
     */
    @XmlElementWrapper(name = "output-arrangements")
    @XmlElement(name = "output-arrangement")
    protected List<OutputArrangement> outputArrangements;

    /**
     * URI of the arrangements resource.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * Default constructor.
     */
    public Arrangements()
    {
    }

    /**
     * Gets the step link.
     *
     * @return The step link.
     */
    public Link getStep()
    {
        return step;
    }

    /**
     * Sets the step link.
     *
     * @param step The step link.
     */
    public void setStep(Link step)
    {
        this.step = step;
    }

    /**
     * Gets the step configuration.
     *
     * @return The step configuration.
     */
    public StepConfiguration getConfiguration()
    {
        return configuration;
    }

    /**
     * Sets the step configuration.
     *
     * @param configuration The step configuration.
     */
    public void setConfiguration(StepConfiguration configuration)
    {
        this.configuration = configuration;
    }

    /**
     * Gets the list of output arrangements, creating it if it doesn't exist.
     *
     * @return The list of output arrangements.
     */
    public List<OutputArrangement> getOutputArrangements()
    {
        if (outputArrangements == null)
        {
            outputArrangements = new ArrayList<>();
        }
        return outputArrangements;
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
     * {@inheritDoc}
     */
    @Override
    public LimsLink<Arrangements> getLink()
    {
        return new ArrangementsLink(this);
    }
}
