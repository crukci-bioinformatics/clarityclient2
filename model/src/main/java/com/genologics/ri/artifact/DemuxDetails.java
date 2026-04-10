/*
 * CRUK-CI Clarity REST API Java Client.
 * Copyright (C) 2018 Cancer Research UK Cambridge Institute.
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

package com.genologics.ri.artifact;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.Linkable;
import com.genologics.ri.step.ProcessStep;

/**
 * Demultiplexing of the Artifact showing all pooling steps that this artifact has been part of.
 *
 * @since 2.26
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "demux-details", propOrder = { "poolStep", "artifacts" })
public class DemuxDetails implements Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = -6725351237693935651L;

    /**
     * The pool step of this demux details.
     */
    @XmlElement(name = "pool-step")
    protected PoolStep poolStep;

    /**
     * The artifacts in this demux details.
     */
    @XmlElementWrapper(name = "artifacts")
    @XmlElement(name = "artifact")
    protected List<DemuxArtifact> artifacts;

    /**
     * Default constructor.
     */
    public DemuxDetails()
    {
    }

    /**
     * Gets the pool step.
     *
     * @return The pool step.
     */
    public PoolStep getPoolStep()
    {
        return poolStep;
    }

    /**
     * Sets the pool step.
     *
     * @param poolStep The pool step.
     */
    public void setPoolStep(PoolStep poolStep)
    {
        this.poolStep = poolStep;
    }

    /**
     * Sets the pool step from a Linkable.
     *
     * @param poolStep The linkable pool step.
     */
    public void setPoolStep(Linkable<ProcessStep> poolStep)
    {
        this.poolStep = poolStep == null ? null : new PoolStep(poolStep.getUri());
    }

    /**
     * Gets the list of artifacts.
     * Creates an empty list if it doesn't exist.
     *
     * @return The list of demux artifacts.
     */
    public List<DemuxArtifact> getArtifacts()
    {
        if (artifacts == null)
        {
            artifacts = new ArrayList<>();
        }
        return artifacts;
    }
}
