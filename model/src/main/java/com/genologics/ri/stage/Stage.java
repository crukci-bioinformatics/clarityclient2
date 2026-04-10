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

import java.io.Serializable;
import java.net.URI;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.ClarityEntity;
import com.genologics.ri.LimsLink;
import com.genologics.ri.Linkable;
import com.genologics.ri.protocolconfiguration.Protocol;
import com.genologics.ri.protocolconfiguration.ProtocolLink;
import com.genologics.ri.stepconfiguration.ProtocolStep;
import com.genologics.ri.workflowconfiguration.StageLink;
import com.genologics.ri.workflowconfiguration.Workflow;

/**
 *
 * The detailed representation of a stage.
 */
@ClarityEntity(uriSection = "stages", primaryEntity = Workflow.class)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "stage", propOrder = { "workflow", "protocol", "step" })
@XmlRootElement(name = "stage")
public class Stage implements Linkable<Stage>, Serializable
{
    /**
     * Regular expression to extract workflow id and workflow stage id from a
     * workflow stage URI.
     *
     * @since 2.22
     */
    public static final Pattern ID_EXTRACTOR_PATTERN;

    /**
     * Class version for serialisation.
     */
    @java.io.Serial
    private static final long serialVersionUID = -7190421220331989537L;

    /**
     * Link to the workflow this stage belongs to.
     */
    @XmlElement(name = "workflow")
    protected WorkflowLink workflow;

    /**
     * Link to the protocol for this stage.
     */
    @XmlElement(name = "protocol")
    protected ProtocolLink protocol;

    /**
     * Link to the protocol step for this stage.
     */
    @XmlElement(name = "step")
    protected ProtocolStepLink step;

    /**
     * The URI of the stage.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * The name of the stage.
     */
    @XmlAttribute(name = "name")
    protected String name;

    /**
     * The index of the stage in the workflow.
     */
    @XmlAttribute(name = "index")
    protected Integer index;


    static
    {
        ClarityEntity innerAnno = Stage.class.getAnnotation(ClarityEntity.class);
        ClarityEntity outerAnno = innerAnno.primaryEntity().getAnnotation(ClarityEntity.class);

        StringBuilder b = new StringBuilder();
        b.append("^.*/").append(outerAnno.uriSection()).append("/(\\d+)/");
        b.append(innerAnno.uriSection()).append("/(\\d+)$");

        ID_EXTRACTOR_PATTERN = Pattern.compile(b.toString());
    }

    /**
     * Default constructor.
     */
    public Stage()
    {
    }

    /**
     * Constructor with URI.
     *
     * @param uri The URI of the stage.
     */
    public Stage(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructor with URI and name.
     *
     * @param uri The URI of the stage.
     * @param name The name of the stage.
     */
    public Stage(URI uri, String name)
    {
        this.uri = uri;
        this.name = name;
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
     * Gets the workflow link for this stage.
     *
     * @return The workflow link.
     */
    public WorkflowLink getWorkflow()
    {
        return workflow;
    }

    /**
     * Sets the workflow for this stage.
     *
     * @param workflow The workflow to set.
     */
    public void setWorkflow(Linkable<Workflow> workflow)
    {
        this.workflow = new WorkflowLink(workflow);
    }

    /**
     * Gets the protocol link for this stage.
     *
     * @return The protocol link.
     */
    public ProtocolLink getProtocol()
    {
        return protocol;
    }

    /**
     * Sets the protocol for this stage.
     *
     * @param protocol The protocol to set.
     */
    public void setProtocol(Linkable<Protocol> protocol)
    {
        this.protocol = new ProtocolLink(protocol);
    }

    /**
     * Gets the protocol step link for this stage.
     *
     * @return The protocol step link.
     */
    public ProtocolStepLink getStep()
    {
        return step;
    }

    /**
     * Sets the protocol step for this stage.
     *
     * @param step The protocol step to set.
     */
    public void setStep(Linkable<ProtocolStep> step)
    {
        this.step = new ProtocolStepLink(step);
    }

    /**
     * Gets the URI of the stage.
     *
     * @return The URI of the stage.
     */
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI of the stage.
     *
     * @param uri The URI of the stage.
     */
    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Gets the name of the stage.
     *
     * @return The name of the stage.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of the stage.
     *
     * @param name The name of the stage.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Gets the index of the stage in the workflow.
     *
     * @return The index of the stage.
     */
    public Integer getIndex()
    {
        return index;
    }

    /**
     * Sets the index of the stage in the workflow.
     *
     * @param index The index of the stage.
     */
    public void setIndex(Integer index)
    {
        this.index = index;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LimsLink<Stage> getLink()
    {
        // StageLink is in a different package but that shouldn't cause problems.
        return new StageLink(this);
    }
}
