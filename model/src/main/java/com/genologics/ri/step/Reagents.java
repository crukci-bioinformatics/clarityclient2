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
 *
 * The detailed representation of a step's output artifact reagents.
 */
@ClarityEntity(uriSection = "steps", uriSubsection = "reagents", creatable = true)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reagents", propOrder = { "step", "configuration", "reagentCategory", "outputReagents" })
@XmlRootElement(name = "reagents")
public class Reagents implements Linkable<Reagents>, Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 4896945008573422890L;

    /**
     * Link to the step.
     */
    @XmlElement(name = "step")
    protected Link step;

    /**
     * Configuration of the step.
     */
    @XmlElement(name = "configuration")
    protected StepConfiguration configuration;

    /**
     * The reagent category for the step.
     */
    @XmlElement(name = "reagent-category")
    protected String reagentCategory;

    /**
     * List of output reagents.
     */
    @XmlElementWrapper(name = "output-reagents")
    @XmlElement(name = "output")
    protected List<Output> outputReagents;

    /**
     * URI of the reagents resource.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * Default constructor.
     */
    public Reagents()
    {
    }

    /**
     * Constructor with URI.
     *
     * @param uri The URI of the reagents resource.
     */
    public Reagents(URI uri)
    {
        this.uri = uri;
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
     * The permitted reagent category of the step. Reagent labels used in the POST must be from this reagent category.
     *
     * @return The reagent category.
     */
    public String getReagentCategory()
    {
        return reagentCategory;
    }

    /**
     * Sets the reagent category.
     *
     * @param reagentCategory The reagent category.
     */
    public void setReagentCategory(String reagentCategory)
    {
        this.reagentCategory = reagentCategory;
    }

    /**
     * Gets the list of output reagents, creating it if it doesn't exist.
     *
     * @return The list of output reagents.
     */
    public List<Output> getOutputReagents()
    {
        if (outputReagents == null)
        {
            outputReagents = new ArrayList<Output>();
        }
        return outputReagents;
    }

    /**
     * Adds an output reagent to the list.
     *
     * @param output The output reagent to add.
     * @return The added output reagent.
     */
    public Output addOutputReagent(Output output)
    {
        getOutputReagents().add(output);
        return output;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LimsLink<Reagents> getLink()
    {
        return new ReagentsLink(this);
    }
}
