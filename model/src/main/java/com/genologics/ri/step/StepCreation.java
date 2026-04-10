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
import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.ClarityEntity;
import com.genologics.ri.Linkable;
import com.genologics.ri.artifact.Artifact;
import com.genologics.ri.containertype.ContainerType;
import com.genologics.ri.controltype.ControlType;
import com.genologics.ri.stepconfiguration.ProtocolStep;

/**
 *
 * A request to create a step.
 *
 * @since 2.18
 */
@ClarityEntity(uriSection = "steps", creatable = true)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "step-creation", propOrder = { "configuration", "containerType", "reagentCategory", "inputs" })
@XmlRootElement(name = "step-creation")
public class StepCreation implements Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 3624008363559662022L;

    /**
     * The configuration for the step.
     */
    @XmlElement
    protected StepConfiguration configuration;

    /**
     * The name of the container type to be used for outputs.
     */
    @XmlElement(name = "container-type")
    protected String containerType;

    /**
     * The reagent category name.
     */
    @XmlElement(name = "reagent-category")
    protected String reagentCategory;

    /**
     * The list of input artifacts for the step.
     */
    @XmlElementWrapper(name = "inputs")
    @XmlElement(name = "input")
    protected List<CreationInput> inputs;

    /**
     * Default constructor.
     */
    public StepCreation()
    {
    }

    /**
     * Constructor taking the step configuration.
     *
     * @param configuration The step configuration.
     */
    public StepCreation(StepConfiguration configuration)
    {
        setConfiguration(configuration);
    }

    /**
     * Constructor taking a protocol step link.
     *
     * @param step The protocol step link.
     */
    public StepCreation(Linkable<ProtocolStep> step)
    {
        setConfiguration(step);
    }

    /**
     * Constructor taking a protocol step.
     *
     * @param step The protocol step.
     */
    public StepCreation(ProtocolStep step)
    {
        setConfiguration(step);
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
     * Sets the step configuration from a protocol step link.
     *
     * @param step The protocol step link.
     */
    public void setConfiguration(Linkable<ProtocolStep> step)
    {
        this.configuration = step == null ? null : new StepConfiguration(step);
    }

    /**
     * Sets the step configuration from a protocol step.
     *
     * @param step The protocol step.
     */
    public void setConfiguration(ProtocolStep step)
    {
        this.configuration = step == null ? null : new StepConfiguration(step);
    }

    /**
     * Gets the container type name.
     *
     * @return The container type name.
     */
    public String getContainerType()
    {
        return containerType;
    }

    /**
     * Sets the container type name.
     *
     * @param containerType The container type name.
     */
    public void setContainerType(String containerType)
    {
        this.containerType = containerType;
    }

    /**
     * Sets the container type from a container type object.
     *
     * @param containerType The container type object.
     */
    public void setContainerType(ContainerType containerType)
    {
        this.containerType = containerType == null ? null : containerType.getName();
    }

    /**
     * Gets the reagent category name.
     *
     * @return The reagent category name.
     */
    public String getReagentCategory()
    {
        return reagentCategory;
    }

    /**
     * Sets the reagent category name.
     *
     * @param reagentCategory The reagent category name.
     */
    public void setReagentCategory(String reagentCategory)
    {
        this.reagentCategory = reagentCategory;
    }

    /**
     * Gets the list of input artifacts for the step.
     *
     * @return The list of inputs.
     */
    public List<CreationInput> getInputs()
    {
        if (inputs == null)
        {
            inputs = new ArrayList<>();
        }
        return inputs;
    }

    /**
     * Adds an input to the step.
     *
     * @param input The input to add.
     *
     * @return The added input.
     */
    public CreationInput addInput(CreationInput input)
    {
        getInputs().add(input);
        return input;
    }

    /**
     * Creates and adds an input to the step.
     *
     * @param artifact The input artifact.
     * @param controlType The control type for the input, or null if not a control.
     * @param replicates The number of replicates for the input.
     *
     * @return The created and added input.
     */
    public CreationInput addInput(Linkable<Artifact> artifact, Linkable<ControlType> controlType, Long replicates)
    {
        return addInput(new CreationInput(artifact, controlType, replicates));
    }
}
