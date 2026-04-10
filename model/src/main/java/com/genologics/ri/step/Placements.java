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
import com.genologics.ri.artifact.Artifact;
import com.genologics.ri.container.Container;

/**
 *
 * The detailed representation of a step's output artifact container placements
 */
@ClarityEntity(uriSection = "steps", uriSubsection = "placements", creatable = true)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "placements", propOrder = { "step", "configuration", "selectedContainers", "outputPlacements" })
@XmlRootElement(name = "placements")
public class Placements implements Linkable<Placements>, Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = -1949893881292269955L;

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
     * The list of selected containers.
     */
    @XmlElementWrapper(name = "selected-containers")
    @XmlElement(name = "container")
    protected List<ContainerLink> selectedContainers;

    /**
     * The list of output placements.
     */
    @XmlElementWrapper(name = "output-placements")
    @XmlElement(name = "output-placement")
    protected List<OutputPlacement> outputPlacements;

    /**
     * The URI of this placements resource.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * Default constructor.
     */
    public Placements()
    {
    }

    /**
     * Constructor with URI.
     *
     * @param uri The URI of this placements resource.
     */
    public Placements(URI uri)
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
     * Sets the step from a linkable process step.
     *
     * @param step The process step to link to.
     */
    public void setStep(Linkable<ProcessStep> step)
    {
        this.step = step == null ? null : new Link(step);
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
     * Gets the list of selected containers.
     * Creates the list if it doesn't exist.
     *
     * @return The list of selected containers.
     */
    public List<ContainerLink> getSelectedContainers()
    {
        if (selectedContainers == null)
        {
            selectedContainers = new ArrayList<>();
        }
        return selectedContainers;
    }

    /**
     * Adds a selected container.
     *
     * @param container The container to add.
     * @return The created container link.
     */
    public ContainerLink addSelectedContainer(Linkable<Container> container)
    {
        ContainerLink link = new ContainerLink(container);
        getSelectedContainers().add(link);
        return link;
    }

    /**
     * Gets the list of output placements.
     * Creates the list if it doesn't exist.
     *
     * @return The list of output placements.
     */
    public List<OutputPlacement> getOutputPlacements()
    {
        if (outputPlacements == null)
        {
            outputPlacements = new ArrayList<>();
        }
        return outputPlacements;
    }

    /**
     * Adds an output placement.
     *
     * @param placement The placement to add.
     * @return The added placement.
     */
    public OutputPlacement addOutputPlacement(OutputPlacement placement)
    {
        getOutputPlacements().add(placement);
        return placement;
    }

    /**
     * Creates and adds an output placement.
     *
     * @param artifact The output artifact.
     * @param container The container for the output.
     * @param wellPosition The well position in the container.
     * @return The created output placement.
     */
    public OutputPlacement addOutputPlacement(Linkable<Artifact> artifact, Linkable<Container> container, String wellPosition)
    {
        OutputPlacement placement = new OutputPlacement(artifact, container, wellPosition);
        getOutputPlacements().add(placement);
        return placement;
    }

    /**
     * Gets the URI of this placements resource.
     *
     * @return The URI.
     */
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI of this placements resource.
     *
     * @param uri The URI to set.
     */
    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LimsLink<Placements> getLink()
    {
        return new PlacementsLink(this);
    }
}
