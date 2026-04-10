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

package com.genologics.ri.workflowconfiguration;

import static java.util.Objects.requireNonNull;

import java.io.Serial;
import java.io.Serializable;
import java.net.URI;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.LimsLink;
import com.genologics.ri.Linkable;

/**
 *
 * Workflow-link is a child element type of workflows and provides a URI linking
 * to the detailed representation of a workflow.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "workflow-link")
public class WorkflowLink implements LimsLink<Workflow>, Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 1335890809720204629L;

    /**
     * The URI of the workflow.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * The name of the workflow.
     */
    @XmlAttribute(name = "name")
    protected String name;

    /**
     * The status of the workflow.
     */
    @XmlAttribute(name = "status")
    protected Status status;

    /**
     * Default constructor.
     */
    public WorkflowLink()
    {
    }

    /**
     * Constructor accepting a URI.
     *
     * @param uri The workflow URI.
     */
    public WorkflowLink(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructor accepting a URI and name.
     *
     * @param uri The workflow URI.
     * @param name The workflow name.
     */
    public WorkflowLink(URI uri, String name)
    {
        this.uri = uri;
        this.name = name;
    }

    /**
     * Constructor accepting a URI, name, and status.
     *
     * @param uri The workflow URI.
     * @param name The workflow name.
     * @param status The workflow status.
     */
    public WorkflowLink(URI uri, String name, Status status)
    {
        this.uri = uri;
        this.name = name;
        this.status = status;
    }

    /**
     * Constructor accepting a Linkable object.
     *
     * @param link The linkable workflow object.
     */
    public WorkflowLink(Linkable<Workflow> link)
    {
        requireNonNull(link, "link cannot be null");
        uri = link.getUri();
    }

    /**
     * Constructor accepting a Workflow object.
     *
     * @param workflow The workflow to link to.
     */
    public WorkflowLink(Workflow workflow)
    {
        requireNonNull(workflow, "workflow cannot be null");
        uri = workflow.getUri();
        name = workflow.getName();
        status = workflow.getStatus();
    }

    /**
     * Gets the entity class for this link.
     *
     * @return The Workflow class.
     */
    @Override
    public Class<Workflow> getEntityClass()
    {
        return Workflow.class;
    }

    /**
     * Gets the URI of the workflow.
     *
     * @return The workflow URI.
     */
    @Override
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI of the workflow.
     *
     * @param uri The workflow URI.
     */
    @Override
    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Gets the name of the workflow.
     *
     * @return The workflow name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of the workflow.
     *
     * @param name The workflow name.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Gets the status of the workflow.
     *
     * @return The workflow status.
     */
    public Status getStatus()
    {
        return status;
    }

    /**
     * Sets the status of the workflow.
     *
     * @param status The workflow status.
     */
    public void setStatus(Status status)
    {
        this.status = status;
    }

    /**
     * Returns a string representation of this workflow link.
     *
     * @return The workflow name.
     */
    @Override
    public String toString()
    {
        return name;
    }
}
