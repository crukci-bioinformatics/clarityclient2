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

package com.genologics.ri.routing;

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
import com.genologics.ri.stage.Stage;
import com.genologics.ri.workflowconfiguration.Workflow;

/**
 * External artifact assignments for routing to workflows and stages.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "extArtifactAssignments")
public class ExtArtifactAssignments implements Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 5445690350646421054L;

    /**
     * The list of artifact links.
     */
    @XmlElement(name = "artifact")
    protected List<ArtifactLink> artifacts;

    /**
     * The URI of the workflow.
     */
    @XmlAttribute(name = "workflow-uri")
    @XmlSchemaType(name = "anyURI")
    protected URI workflowUri;

    /**
     * The URI of the stage.
     */
    @XmlAttribute(name = "stage-uri")
    @XmlSchemaType(name = "anyURI")
    protected URI stageUri;

    /**
     * Gets the list of artifact links.
     *
     * @return A list of artifact links.
     */
    public List<ArtifactLink> getArtifacts()
    {
        if (artifacts == null)
        {
            artifacts = new ArrayList<ArtifactLink>();
        }
        return artifacts;
    }

    /**
     * Adds an artifact to the list.
     *
     * @param artifact The artifact to add.
     */
    public void addArtifact(Linkable<Artifact> artifact)
    {
        getArtifacts().add(new ArtifactLink(artifact));
    }

    /**
     * Adds all artifacts from a collection to the list.
     *
     * @param links The collection of artifact links to add.
     */
    public void addAll(Collection<? extends Linkable<Artifact>> links)
    {
        getArtifacts();
        for (Linkable<Artifact> l : links)
        {
            if (l != null && l.getUri() != null)
            {
                artifacts.add(new ArtifactLink(l));
            }
        }
    }

    /**
     * Gets the workflow URI.
     *
     * @return The workflow URI.
     */
    public URI getWorkflowUri()
    {
        return workflowUri;
    }

    /**
     * Sets the workflow URI.
     *
     * @param workflowUri The workflow URI.
     */
    public void setWorkflowUri(URI workflowUri)
    {
        this.workflowUri = workflowUri;
    }

    /**
     * Sets the workflow from a Linkable.
     *
     * @param workflow The workflow to set.
     */
    public void setWorkflow(Linkable<Workflow> workflow)
    {
        this.workflowUri = workflow.getUri();
    }

    /**
     * Gets the stage URI.
     *
     * @return The stage URI.
     */
    public URI getStageUri()
    {
        return stageUri;
    }

    /**
     * Sets the stage URI.
     *
     * @param stageUri The stage URI.
     */
    public void setStageUri(URI stageUri)
    {
        this.stageUri = stageUri;
    }

    /**
     * Sets the stage from a Linkable.
     *
     * @param stage The stage to set.
     */
    public void setStage(Linkable<Stage> stage)
    {
        this.stageUri = stage.getUri();
    }

}
