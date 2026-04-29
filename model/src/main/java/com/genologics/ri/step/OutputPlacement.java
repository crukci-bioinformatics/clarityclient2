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
import java.net.URI;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.genologics.ri.LimsEntityLinkable;
import com.genologics.ri.LimsLink;
import com.genologics.ri.LimsLinkBase;
import com.genologics.ri.Linkable;
import com.genologics.ri.Location;
import com.genologics.ri.artifact.Artifact;
import com.genologics.ri.container.Container;

/**
 *
 * Provides a URI linking to the output artifact and container placement.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "output-placement")
public class OutputPlacement extends LimsLinkBase<Artifact>
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 5187719712136408829L;

    /**
     * The location of the output artifact in a container.
     */
    protected Location location;

    /**
     * The URI of the output artifact.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * Default constructor.
     */
    public OutputPlacement()
    {
    }

    /**
     * Constructor with artifact.
     *
     * @param artifact The output artifact.
     */
    public OutputPlacement(Linkable<Artifact> artifact)
    {
        setArtifact(artifact);
    }

    /**
     * Constructor with artifact, container and well position.
     *
     * @param artifact The output artifact.
     * @param container The container for the output artifact.
     * @param wellPosition The well position in the container.
     */
    public OutputPlacement(Linkable<Artifact> artifact, LimsEntityLinkable<Container> container, String wellPosition)
    {
        setArtifact(artifact);
        setLocation(container, wellPosition);
    }

    /**
     * Constructor with artifact, container and well position.
     *
     * @param artifact The output artifact.
     * @param container The container for the output artifact.
     * @param wellPosition The well position in the container.
     */
    public OutputPlacement(Linkable<Artifact> artifact, Linkable<Container> container, String wellPosition)
    {
        setArtifact(artifact);
        setLocation(container, wellPosition);
    }

    /**
     * Gets the location of the output artifact.
     *
     * @return The location.
     */
    public Location getLocation()
    {
        return location;
    }

    /**
     * Sets the location of the output artifact.
     *
     * @param location The location to set.
     */
    public void setLocation(Location location)
    {
        this.location = location;
    }

    /**
     * Sets the location from a container and well position.
     *
     * @param container The container for the output artifact.
     * @param wellPosition The well position in the container.
     */
    public void setLocation(LimsEntityLinkable<Container> container, String wellPosition)
    {
        this.location = new Location(container, wellPosition);
    }

    /**
     * Sets the location from a container and well position.
     *
     * @param container The container for the output artifact.
     * @param wellPosition The well position in the container.
     */
    public void setLocation(Linkable<Container> container, String wellPosition)
    {
        this.location = new Location(container, wellPosition);
    }

    /**
     * Gets the URI of the output artifact.
     *
     * @return The artifact URI.
     */
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI of the output artifact.
     *
     * @param artifactUri The artifact URI to set.
     */
    public void setUri(URI artifactUri)
    {
        this.uri = artifactUri;
    }

    /**
     * Sets the artifact for this output placement.
     *
     * @param artifact The artifact to set.
     */
    public void setArtifact(Linkable<Artifact> artifact)
    {
        requireNonNull(artifact, "artifact cannot be null");
        uri = artifact.getUri();
    }

    /**
     * Gets the entity class for this link.
     *
     * @return The Artifact class.
     */
    @Override
    public Class<Artifact> getEntityClass()
    {
        return Artifact.class;
    }

    /**
     * Returns a string representation of this output placement.
     *
     * @return The artifact LIMS id and the location.
     */
    @Override
    public String toString()
    {
        ToStringBuilder b = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
        b.append("artifact", LimsLink.toString(this));
        b.append("location", location);
        return b.toString();
    }
}
