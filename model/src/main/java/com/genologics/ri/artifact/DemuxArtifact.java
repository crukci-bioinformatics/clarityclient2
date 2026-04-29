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
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.genologics.ri.LimsLinkBase;

/**
 * Details of an individual artifact that is part of a pooled artifact.
 *
 * @since 2.26
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "demux-artifact", propOrder = { "samples", "reagentLabels", "demux" })
public class DemuxArtifact extends LimsLinkBase<Artifact>
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 8205564798487086835L;

    /**
     * The samples in this demux artifact.
     */
    @XmlElementWrapper(name = "samples")
    @XmlElement(name = "sample")
    protected List<DemuxArtifactSample> samples;

    /**
     * The reagent labels in this demux artifact.
     */
    @XmlElementWrapper(name = "reagent-labels")
    @XmlElement(name = "reagent-label")
    protected List<ReagentLabel> reagentLabels;

    /**
     * The demux details of this demux artifact.
     */
    @XmlElement
    protected DemuxDetails demux;

    /**
     * The name of this demux artifact.
     */
    @XmlAttribute(name = "name")
    protected String name;

    /**
     * The URI of this demux artifact.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * Default constructor.
     */
    public DemuxArtifact()
    {
    }

    /**
     * Gets the demux details.
     *
     * @return The demux details.
     */
    public DemuxDetails getDemux()
    {
        return demux;
    }

    /**
     * Sets the demux details.
     *
     * @param demux The demux details.
     */
    public void setDemux(DemuxDetails demux)
    {
        this.demux = demux;
    }

    /**
     * Gets the name.
     *
     * @return The demux artifact name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name The demux artifact name.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Gets the URI.
     *
     * @return The demux artifact URI.
     */
    @Override
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI.
     *
     * @param uri The demux artifact URI.
     */
    @Override
    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Gets the list of samples.
     * Creates an empty list if it doesn't exist.
     *
     * @return The list of demux artifact samples.
     */
    public List<DemuxArtifactSample> getSamples()
    {
        if (samples == null)
        {
            samples = new ArrayList<>();
        }
        return samples;
    }

    /**
     * Gets the list of reagent labels.
     * Creates an empty list if it doesn't exist.
     *
     * @return The list of reagent labels.
     */
    public List<ReagentLabel> getReagentLabels()
    {
        if (reagentLabels == null)
        {
            reagentLabels = new ArrayList<>();
        }
        return reagentLabels;
    }

    /**
     * Gets the entity class.
     *
     * @return The Artifact class.
     */
    @Override
    public Class<Artifact> getEntityClass()
    {
        return Artifact.class;
    }

    /**
     * Produces a string representation of this demux artifact.
     *
     * @return A string representation.
     */
    @Override
    public String toString()
    {
        ToStringBuilder b = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
        b.append("artifact", uri);
        b.append("name", name);
        return b.toString();
    }
}
