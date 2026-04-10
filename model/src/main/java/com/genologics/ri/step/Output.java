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

import static java.util.Objects.requireNonNull;

import java.io.Serial;
import java.io.Serializable;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.LimsLink;
import com.genologics.ri.Linkable;
import com.genologics.ri.artifact.Artifact;

/**
 *
 * Provides a URI linking to the output artifact and reagent label.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "output")
public class Output implements LimsLink<Artifact>, Serializable
{
    /**
     * Class version for serialisation.
     */
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = -5292196293632912589L;

    /**
     * List of reagent labels for the output.
     */
    @XmlElement(name = "reagent-label")
    protected List<ReagentLabel> reagentLabels;

    /**
     * URI of the output artifact.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI artifactUri;


    /**
     * Default constructor.
     */
    public Output()
    {
    }

    /**
     * Constructor with artifact URI.
     *
     * @param artifactUri The URI of the output artifact.
     */
    public Output(URI artifactUri)
    {
        this.artifactUri = artifactUri;
    }

    /**
     * Constructor from a LIMS link.
     *
     * @param link The LIMS link to the artifact.
     */
    public Output(LimsLink<Artifact> link)
    {
        requireNonNull(link, "link cannot be null");
        this.artifactUri = link.getUri();
    }

    /**
     * Gets the list of reagent labels, creating it if it doesn't exist.
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
     * Gets the URI.
     *
     * @return The URI.
     */
    public URI getUri()
    {
        return artifactUri;
    }

    /**
     * Sets the URI.
     *
     * @param artifactUri The artifact URI.
     */
    public void setUri(URI artifactUri)
    {
        this.artifactUri = artifactUri;
    }

    /**
     * Sets the artifact.
     *
     * @param artifact The linkable artifact.
     */
    public void setArtifact(Linkable<Artifact> artifact)
    {
        artifactUri = artifact.getUri();
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

}
