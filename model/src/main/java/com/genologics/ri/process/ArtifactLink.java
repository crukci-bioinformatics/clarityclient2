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

package com.genologics.ri.process;

import static java.util.Objects.requireNonNull;

import java.io.Serial;
import java.net.URI;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.LimsEntityLinkBase;
import com.genologics.ri.LimsEntityLinkable;
import com.genologics.ri.Linkable;
import com.genologics.ri.artifact.Artifact;
import com.genologics.ri.artifact.OutputType;

/**
 *
 * Artifact is a child element of input-output-map and provides a link to an
 * Artifact that was either an input or output of the Process for the
 * input-output-map.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "artifact", propOrder = { "parentProcess" })
public class ArtifactLink extends LimsEntityLinkBase<Artifact>
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 5173462831311577367L;

    /**
     * The URI of the artifact.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * The LIMS id of the artifact.
     */
    @XmlAttribute(name = "limsid")
    protected String limsid;

    /**
     * The output type of the artifact.
     */
    @XmlAttribute(name = "output-type")
    protected OutputType outputType;

    /**
     * The output generation type of the artifact.
     */
    @XmlAttribute(name = "output-generation-type")
    protected OutputGenerationType outputGenerationType;

    /**
     * The post-process URI of the artifact.
     */
    @XmlAttribute(name = "post-process-uri")
    @XmlSchemaType(name = "anyURI")
    protected URI postProcessUri;

    /**
     * The parent process link.
     */
    @XmlElement(name = "parent-process")
    protected ParentProcessLink parentProcess;

    /**
     * Default constructor.
     */
    public ArtifactLink()
    {
    }

    /**
     * Constructor with URI.
     *
     * @param uri the URI of the artifact.
     */
    public ArtifactLink(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructor with URI and LIMS id.
     *
     * @param uri the URI of the artifact.
     * @param limsid the LIMS id of the artifact.
     */
    public ArtifactLink(URI uri, String limsid)
    {
        this.uri = uri;
        this.limsid = limsid;
    }

    /**
     * Constructor from a linkable object.
     *
     * @param link the linkable object.
     */
    public ArtifactLink(Linkable<Artifact> link)
    {
        requireNonNull(link, "link cannot be null");
        uri = link.getUri();
    }

    /**
     * Constructor from a LIMS entity linkable object.
     *
     * @param link the LIMS entity linkable object.
     */
    public ArtifactLink(LimsEntityLinkable<Artifact> link)
    {
        requireNonNull(link, "link cannot be null");
        uri = link.getUri();
        limsid = link.getLimsid();
    }

    /**
     * Constructor from an artifact.
     *
     * @param artifact the artifact.
     */
    public ArtifactLink(Artifact artifact)
    {
        requireNonNull(artifact, "artifact cannot be null");
        uri = artifact.getUri();
        limsid = artifact.getLimsid();
        outputType = artifact.getOutputType();
        parentProcess = artifact.getParentProcess() == null ? null : new ParentProcessLink(artifact.getParentProcess());
    }

    /**
     * Gets the entity class.
     *
     * @return the Artifact class.
     */
    @Override
    public Class<Artifact> getEntityClass()
    {
        return Artifact.class;
    }

    /**
     * Gets the parent process link.
     *
     * @return the parent process link.
     */
    public ParentProcessLink getParentProcess()
    {
        return parentProcess;
    }

    /**
     * Sets the parent process from a LIMS entity linkable object.
     *
     * @param parentProcess the parent process LIMS entity linkable.
     *
     * @return the created parent process link.
     */
    public ParentProcessLink setParentProcess(LimsEntityLinkable<ClarityProcess> parentProcess)
    {
        this.parentProcess = new ParentProcessLink(parentProcess);
        return this.parentProcess;
    }

    /**
     * Gets the LIMS id.
     *
     * @return the LIMS id.
     */
    public String getLimsid()
    {
        return limsid;
    }

    /**
     * Sets the LIMS id.
     *
     * @param limsid the LIMS id to set.
     */
    public void setLimsid(String limsid)
    {
        this.limsid = limsid;
    }

    /**
     * Gets the output type.
     *
     * @return the output type.
     */
    public OutputType getOutputType()
    {
        return outputType;
    }

    /**
     * Sets the output type.
     *
     * @param outputType the output type to set.
     */
    public void setOutputType(OutputType outputType)
    {
        this.outputType = outputType;
    }

    /**
     * Gets the output generation type.
     *
     * @return the output generation type.
     */
    public OutputGenerationType getOutputGenerationType()
    {
        return outputGenerationType;
    }

    /**
     * Sets the output generation type.
     *
     * @param outputGenerationType the output generation type to set.
     */
    public void setOutputGenerationType(OutputGenerationType outputGenerationType)
    {
        this.outputGenerationType = outputGenerationType;
    }

    /**
     * Gets the URI.
     *
     * @return the URI.
     */
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI.
     *
     * @param uri the URI to set.
     */
    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Gets the post-process URI.
     *
     * @return the post-process URI.
     */
    public URI getPostProcessUri()
    {
        return postProcessUri;
    }

    /**
     * Sets the post-process URI.
     *
     * @param postProcessUri the post-process URI to set.
     */
    public void setPostProcessUri(URI postProcessUri)
    {
        this.postProcessUri = postProcessUri;
    }

    /**
     * Returns a string representation of this object.
     *
     * @return the LIMS id as a string.
     */
    @Override
    public String toString()
    {
        return limsid;
    }
}
