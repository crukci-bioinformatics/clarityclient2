/*
 * CRUK-CI Clarity REST API Java Client.
 * Copyright (C) 2015 Cancer Research UK Cambridge Institute.
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

import static java.util.Objects.requireNonNull;

import java.io.Serial;
import java.net.URI;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.genologics.ri.LimsLink;
import com.genologics.ri.LimsLinkBase;
import com.genologics.ri.Linkable;
import com.genologics.ri.stage.Stage;

/**
 * Provides links to workflow stages, stage names and their respective statuses.
 *
 * @since 2.20
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "workflow-stage")
public class WorkflowStage extends LimsLinkBase<Stage>
{
    /**
     * Regular expression to extract workflow id and workflow stage id from a
     * workflow stage URI.
     *
     * @since 2.22
     */
    public static final Pattern ID_EXTRACTOR_PATTERN = Stage.ID_EXTRACTOR_PATTERN;

    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 8029803456211993608L;

    /**
     * The URI of this workflow stage.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * The name of this workflow stage.
     */
    @XmlAttribute(name = "name")
    protected String name;

    /**
     * The status of this workflow stage.
     */
    @XmlAttribute(name = "status")
    protected Status status;

    /**
     * Default constructor.
     */
    public WorkflowStage()
    {
    }

    /**
     * Constructor taking a URI.
     *
     * @param uri The workflow stage URI.
     */
    public WorkflowStage(URI uri)
    {
        setUri(uri);
    }

    /**
     * Constructor taking a URI and name.
     *
     * @param uri The workflow stage URI.
     * @param name The workflow stage name.
     */
    public WorkflowStage(URI uri, String name)
    {
        setUri(uri);
        setName(name);
    }

    /**
     * Constructor taking a URI, name and status.
     *
     * @param uri The workflow stage URI.
     * @param name The workflow stage name.
     * @param status The workflow stage status.
     */
    public WorkflowStage(URI uri, String name, Status status)
    {
        setUri(uri);
        setName(name);
        setStatus(status);
    }

    /**
     * Constructor from a Linkable.
     *
     * @param link The linkable object to copy.
     */
    public WorkflowStage(Linkable<Stage> link)
    {
        requireNonNull(link, "link cannot be null");
        uri = link.getUri();
    }

    /**
     * Constructor from a Stage.
     *
     * @param stage The stage to copy.
     */
    public WorkflowStage(Stage stage)
    {
        requireNonNull(stage, "stage cannot be null");
        uri = stage.getUri();
        name = stage.getName();
    }

    /**
     * Constructor from a Stage with status.
     *
     * @param stage The stage to copy.
     * @param status The workflow stage status.
     */
    public WorkflowStage(Stage stage, Status status)
    {
        this(stage);
        this.status = status;
    }

    /**
     * Get the numeric identifier for this workflow stage from its URI.
     *
     * @return The workflow stage id, or null if either the URI is not set
     * or it doesn't match the form expected for a workflow stage URI.
     *
     * @since 2.22
     */
    public Integer getId()
    {
        Integer id = null;
        if (uri != null)
        {
            Matcher m = ID_EXTRACTOR_PATTERN.matcher(uri.toString());
            if (m.matches())
            {
                id = Integer.valueOf(m.group(2));
            }
        }
        return id;
    }

    /**
     * Get the numeric identifier for this stage's workflow from its URI.
     *
     * @return The workflow id, or null if either the URI is not set
     * or it doesn't match the form expected for a workflow stage URI.
     *
     * @since 2.22
     */
    public Integer getWorkflowId()
    {
        Integer id = null;
        if (uri != null)
        {
            Matcher m = ID_EXTRACTOR_PATTERN.matcher(uri.toString());
            if (m.matches())
            {
                id = Integer.valueOf(m.group(1));
            }
        }
        return id;
    }

    /**
     * Gets the URI.
     *
     * @return The workflow stage URI.
     */
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI.
     *
     * @param uri The workflow stage URI.
     */
    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Gets the name.
     *
     * @return The workflow stage name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name The workflow stage name.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Gets the status.
     *
     * @return The workflow stage status.
     */
    public Status getStatus()
    {
        return status;
    }

    /**
     * Sets the status.
     *
     * @param status The workflow stage status.
     */
    public void setStatus(Status status)
    {
        this.status = status;
    }

    /**
     * Gets the entity class.
     *
     * @return The Stage class.
     */
    @Override
    public Class<Stage> getEntityClass()
    {
        return Stage.class;
    }

    /**
     * Returns a string representation of this workflow stage.
     *
     * @return The stage URI, name and status.
     */
    @Override
    public String toString()
    {
        ToStringBuilder b = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
        b.append("researcher", LimsLink.toString(this));
        b.append("name", name);
        b.append("status", status);
        return b.toString();
    }
}
