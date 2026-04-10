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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.LimsEntityLinkable;
import com.genologics.ri.Linkable;
import com.genologics.ri.artifact.Artifact;
import com.genologics.ri.artifact.OutputType;
import com.genologics.ri.container.Container;

/**
 *
 * Processes link inputs to outputs and this relationship is called an
 * input-output map. Input-output-map is a child element of the Process element.
 * <p>
 * When a Process creates multiple outputs per input, there is a distinct
 * input-output map for each input to output relationship. When a Process
 * produces a shared output, there is a single input-output map for the shared
 * output and all its related inputs.
 * <p>
 * In situations where a Process is used to affect the properties of inputs only
 * and therefore, does not create outputs, you can omit the output element.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "input-output-map", propOrder = { "inputs", "output" })
public class ExecutableInputOutputMap implements Serializable
{
    /**
     * Class version for serialisation.
     */
    @java.io.Serial
    private static final long serialVersionUID = -5751963471358280360L;

    /**
     * List of input artifacts.
     */
    @XmlElement(name = "input")
    protected List<Input> inputs;

    /**
     * The output artifact.
     */
    @XmlElement(name = "output")
    protected Output output;

    /**
     * Indicates whether the output is shared among multiple inputs.
     */
    @XmlAttribute(name = "shared")
    protected Boolean shared;

    /**
     * Default constructor.
     */
    public ExecutableInputOutputMap()
    {
    }

    /**
     * Constructor with shared flag.
     *
     * @param shared Whether the output is shared.
     */
    public ExecutableInputOutputMap(Boolean shared)
    {
        this.shared = shared;
    }

    /**
     * Gets the list of inputs.
     *
     * @return The input list (never null).
     */
    public List<Input> getInputs()
    {
        if (inputs == null)
        {
            inputs = new ArrayList<Input>();
        }
        return this.inputs;
    }

    /**
     * Sets the inputs from a collection of artifact links.
     *
     * @param links The artifact links to set as inputs.
     */
    public void setInputs(Collection<? extends Linkable<Artifact>> links)
    {
        getInputs().clear();
        for (Linkable<Artifact> link : links)
        {
            inputs.add(new Input(link));
        }
    }

    /**
     * Adds an input to the input list.
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
     * Adds an input with a QC flag to the input list.
     *
     * @param link The artifact link.
     * @param qc The QC flag.
     * @return The added input.
     */
    public Input addInput(Linkable<Artifact> link, QCFlag qc)
    {
        Input input = new Input(link);
        input.setQCFlag(qc);
        getInputs().add(input);
        return input;
    }

    /**
     * Gets the output artifact.
     *
     * @return The output.
     */
    public Output getOutput()
    {
        return output;
    }

    /**
     * Sets the output artifact.
     *
     * @param output The output to set.
     * @return The output that was set.
     */
    public Output setOutput(Output output)
    {
        this.output = output;
        return this.output;
    }

    /**
     * Sets the output artifact with type, container, and position.
     *
     * @param type The output type.
     * @param container The container link.
     * @param position The position in the container.
     * @return The created output.
     */
    public Output setOutput(OutputType type, LimsEntityLinkable<Container> container, String position)
    {
        this.output = new Output(type, container, position);
        return this.output;
    }

    /**
     * Checks if the output is shared among multiple inputs.
     *
     * @return True if shared, false otherwise.
     */
    public Boolean isShared()
    {
        return shared;
    }

    /**
     * Sets whether the output is shared.
     *
     * @param shared Whether the output is shared.
     */
    public void setShared(Boolean shared)
    {
        this.shared = shared;
    }

}
