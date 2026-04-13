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

package com.genologics.ri.stage;

import static java.util.Objects.requireNonNull;

import java.io.Serial;
import java.net.URI;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.LimsLinkBase;
import com.genologics.ri.Linkable;
import com.genologics.ri.workflowconfiguration.Workflow;

/**
 *
 * Workflow link for the stage.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "workflow")
public class WorkflowLink extends LimsLinkBase<Workflow>
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 7790581332424089347L;

    /**
     * The URI of the workflow.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * Default constructor.
     */
    public WorkflowLink()
    {
    }

    /**
     * Constructor with URI.
     *
     * @param uri The URI of the workflow.
     */
    public WorkflowLink(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructor from a linkable workflow object.
     *
     * @param link The linkable workflow object.
     */
    public WorkflowLink(Linkable<Workflow> link)
    {
        requireNonNull(link, "link cannot be null");
        uri = link.getUri();
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
     * @return The URI of the workflow.
     */
    @Override
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI of the workflow.
     *
     * @param uri The URI of the workflow.
     */
    @Override
    public void setUri(URI uri)
    {
        this.uri = uri;
    }

}
