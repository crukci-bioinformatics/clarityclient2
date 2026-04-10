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
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.Linkable;
import com.genologics.ri.artifact.Artifact;

/**
 *
 * Provides pooled input groups.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pooled-inputs", propOrder = { "inputs" })
public class PooledInputs implements Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = -3807477794297469797L;

    /**
     * The list of input artifacts in this pool.
     */
    @XmlElement(name = "input")
    protected List<Input> inputs;

    /**
     * The name of this pool.
     */
    @XmlAttribute(name = "name")
    protected String name;

    /**
     * The URI of the output artifact created from this pool.
     */
    @XmlAttribute(name = "output-uri")
    @XmlSchemaType(name = "anyURI")
    protected URI outputUri;

    /**
     * Default constructor.
     */
    public PooledInputs()
    {
    }

    /**
     * Constructor with input artifacts and pool name.
     *
     * @param inputArtifacts The collection of input artifacts to pool.
     * @param poolName The name of the pool.
     */
    public PooledInputs(Collection<? extends Linkable<Artifact>> inputArtifacts, String poolName)
    {
        setInputArtifacts(inputArtifacts);
        setName(poolName);
    }

    /**
     * Constructor with input artifacts, pool name and output artifact.
     *
     * @param inputArtifacts The collection of input artifacts to pool.
     * @param poolName The name of the pool.
     * @param outputArtifact The output artifact created from this pool.
     */
    public PooledInputs(Collection<? extends Linkable<Artifact>> inputArtifacts, String poolName, Linkable<Artifact> outputArtifact)
    {
        setInputArtifacts(inputArtifacts);
        setName(poolName);
        setOutputArtifact(outputArtifact);
    }

    /**
     * Gets the name of this pool.
     *
     * @return The pool name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of this pool.
     *
     * @param name The pool name to set.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Gets the URI of the output artifact.
     *
     * @return The output artifact URI.
     */
    public URI getOutputUri()
    {
        return outputUri;
    }

    /**
     * Sets the URI of the output artifact.
     *
     * @param outputUri The output artifact URI to set.
     */
    public void setOutputUri(URI outputUri)
    {
        this.outputUri = outputUri;
    }

    /**
     * Sets the output from an Output object.
     *
     * @param output The output object.
     */
    public void setOutput(Output output)
    {
        outputUri = output == null ? null : output.getUri();
    }

    /**
     * Sets the output artifact.
     *
     * @param artifact The output artifact to set.
     */
    public void setOutputArtifact(Linkable<Artifact> artifact)
    {
        outputUri = artifact == null ? null : artifact.getUri();
    }

    /**
     * Gets the list of input artifacts.
     * Creates the list if it doesn't exist.
     *
     * @return The list of inputs.
     */
    public List<Input> getInputs()
    {
        if (inputs == null)
        {
            inputs = new ArrayList<Input>();
        }
        return inputs;
    }

    /**
     * Adds an input to this pool.
     *
     * @param input The input to add.
     * @return The added input.
     */
    public Input addInput(Input input)
    {
        getInputs().add(input);
        return input;
    }

    /**
     * Creates and adds an input from an artifact.
     *
     * @param artifact The artifact to add as an input.
     * @return The created input.
     */
    public Input addInput(Linkable<Artifact> artifact)
    {
        return addInput(new Input(artifact));
    }

    /**
     * Sets the input artifacts, replacing any existing inputs.
     *
     * @param artifacts The collection of artifacts to set as inputs.
     */
    public void setInputArtifacts(Collection<? extends Linkable<Artifact>> artifacts)
    {
        getInputs().clear();
        for (Linkable<Artifact> a : artifacts)
        {
            inputs.add(new Input(a));
        }
    }
}
