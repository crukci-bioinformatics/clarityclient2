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
import java.util.Collection;
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
import com.genologics.ri.artifact.Artifact;

/**
 *
 * The detailed representation of a step's pooled inputs.
 */
@ClarityEntity(uriSection = "steps", uriSubsection = "pools", updateable = true)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pools", propOrder = { "step", "configuration", "pooledInputs", "availableInputs" })
@XmlRootElement(name = "pools")
public class Pools implements Linkable<Pools>, Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 5682428399776236959L;

    /**
     * The link to the step.
     */
    @XmlElement(name = "step")
    protected Link step;

    /**
     * The configuration for this step.
     */
    @XmlElement(name = "configuration")
    protected StepConfiguration configuration;

    /**
     * The list of pooled input groups.
     */
    @XmlElementWrapper(name = "pooled-inputs")
    @XmlElement(name = "pool")
    protected List<PooledInputs> pooledInputs;

    /**
     * The list of available input artifacts that can be pooled.
     */
    @XmlElementWrapper(name = "available-inputs")
    @XmlElement(name = "input")
    protected List<Input> availableInputs;

    /**
     * The URI of this pools resource.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * Default constructor.
     */
    public Pools()
    {
    }

    /**
     * Constructor with URI.
     *
     * @param uri The URI of this pools resource.
     */
    public Pools(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Gets the link to the step.
     *
     * @return The step link.
     */
    public Link getStep()
    {
        return step;
    }

    /**
     * Sets the link to the step.
     *
     * @param step The step link to set.
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
     * @param configuration The configuration to set.
     */
    public void setConfiguration(StepConfiguration configuration)
    {
        this.configuration = configuration;
    }

    /**
     * Gets the URI of this pools resource.
     *
     * @return The URI.
     */
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI of this pools resource.
     *
     * @param uri The URI to set.
     */
    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Gets the list of pooled input groups.
     * Creates the list if it doesn't exist.
     *
     * @return The list of pooled inputs.
     */
    public List<PooledInputs> getPooledInputs()
    {
        if (pooledInputs == null)
        {
            pooledInputs = new ArrayList<PooledInputs>();
        }
        return pooledInputs;
    }

    /**
     * Adds a pooled input group.
     *
     * @param inputs The pooled inputs to add.
     * @return The added pooled inputs.
     */
    public PooledInputs addPooledInputs(PooledInputs inputs)
    {
        getPooledInputs().add(inputs);
        return inputs;
    }

    /**
     * Creates and adds a pooled input group.
     *
     * @param inputArtifacts The collection of input artifacts to pool.
     * @param poolName The name of the pool.
     * @param outputArtifact The output artifact created from this pool.
     * @return The created pooled inputs.
     */
    public PooledInputs addPooledInputs(Collection<? extends Linkable<Artifact>> inputArtifacts, String poolName, Linkable<Artifact> outputArtifact)
    {
        return addPooledInputs(new PooledInputs(inputArtifacts, poolName, outputArtifact));
    }

    /**
     * Gets the list of available input artifacts.
     * Creates the list if it doesn't exist.
     *
     * @return The list of available inputs.
     */
    public List<Input> getAvailableInputs()
    {
        if (availableInputs == null)
        {
            availableInputs = new ArrayList<Input>();
        }
        return availableInputs;
    }

    /**
     * Adds an available input artifact.
     *
     * @param input The input to add.
     * @return The added input.
     */
    public Input addAvailableInput(Input input)
    {
        getAvailableInputs().add(input);
        return input;
    }

    /**
     * Creates and adds an available input from an artifact.
     *
     * @param artifact The artifact to add as an available input.
     * @return The created input.
     */
    public Input addAvailableInput(Linkable<Artifact> artifact)
    {
        return addAvailableInput(new Input(artifact));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LimsLink<Pools> getLink()
    {
        return new PoolsLink(this);
    }
}
