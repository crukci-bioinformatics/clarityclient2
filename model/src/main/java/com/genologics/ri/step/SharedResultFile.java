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
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.LimsEntityLinkBase;
import com.genologics.ri.LimsEntityLinkable;
import com.genologics.ri.Linkable;
import com.genologics.ri.artifact.Artifact;

/**
 *
 * The file element describes a shared result file output that will be displayed
 * in the step-setup view.
 *
 * @since 2.18
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "file")
public class SharedResultFile extends LimsEntityLinkBase<Artifact>
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = -1481534271853089634L;

    /**
     * Error message associated with the shared result file.
     */
    @XmlElement
    protected String message;

    /**
     * Index of the shared result file in the configuration.
     */
    @XmlAttribute(name = "shared-result-file-index")
    protected String sharedResultFileIndex;

    /**
     * The URI of the artifact representing the shared result file.
     */
    @XmlAttribute(name = "artifact-uri")
    @XmlSchemaType(name = "anyURI")
    protected URI artifactUri;

    /**
     * The LIMS id of the artifact.
     */
    @XmlAttribute(name = "limsid")
    protected String limsid;

    /**
     * The name of the artifact.
     */
    @XmlAttribute(name = "name")
    protected String name;

    /**
     * Creates an empty shared result file.
     */
    public SharedResultFile()
    {
    }

    /**
     * Creates a shared result file with the given artifact URI.
     *
     * @param artifactUri The URI of the artifact.
     */
    public SharedResultFile(URI artifactUri)
    {
        this.artifactUri = artifactUri;
    }

    /**
     * Creates a shared result file with the given artifact URI and LIMS id.
     *
     * @param artifactUri The URI of the artifact.
     * @param limsid The LIMS id of the artifact.
     */
    public SharedResultFile(URI artifactUri, String limsid)
    {
        this.artifactUri = artifactUri;
        this.limsid = limsid;
    }

    /**
     * Creates a shared result file from a linkable artifact.
     *
     * @param link The linkable artifact to extract the URI from.
     *
     * @throws NullPointerException if {@code link} is null.
     */
    public SharedResultFile(Linkable<Artifact> link)
    {
        requireNonNull(link, "link cannot be null");
        artifactUri = link.getUri();
    }

    /**
     * Creates a shared result file from a LIMS entity linkable artifact.
     *
     * @param link The LIMS entity linkable artifact to extract the URI and LIMS id from.
     *
     * @throws NullPointerException if {@code link} is null.
     */
    public SharedResultFile(LimsEntityLinkable<Artifact> link)
    {
        requireNonNull(link, "link cannot be null");
        artifactUri = link.getUri();
        limsid = link.getLimsid();
    }

    /**
     * Creates a shared result file from an artifact.
     *
     * @param artifact The artifact to extract the URI, LIMS id, and name from.
     *
     * @throws NullPointerException if {@code artifact} is null.
     */
    public SharedResultFile(Artifact artifact)
    {
        requireNonNull(artifact, "artifact cannot be null");
        artifactUri = artifact.getUri();
        limsid = artifact.getLimsid();
        name = artifact.getName();
    }

    /**
     * Gets the error message.
     *
     * @return The error message, or null if none.
     */
    public String getMessage()
    {
        return message;
    }

    /**
     * Sets the error message.
     *
     * @param message The error message.
     */
    public void setMessage(String message)
    {
        this.message = message;
    }

    /**
     * Gets the shared result file index.
     *
     * @return The shared result file index.
     */
    public String getSharedResultFileIndex()
    {
        return sharedResultFileIndex;
    }

    /**
     * Sets the shared result file index.
     *
     * @param sharedResultFileIndex The shared result file index.
     */
    public void setSharedResultFileIndex(String sharedResultFileIndex)
    {
        this.sharedResultFileIndex = sharedResultFileIndex;
    }

    /**
     * Gets the URI of the artifact.
     *
     * @return The artifact URI.
     */
    public URI getUri()
    {
        return artifactUri;
    }

    /**
     * Sets the URI of the artifact.
     *
     * @param artifactUri The artifact URI.
     */
    public void setUri(URI artifactUri)
    {
        this.artifactUri = artifactUri;
    }

    /**
     * Gets the LIMS id of the artifact.
     *
     * @return The LIMS id.
     */
    public String getLimsid()
    {
        return limsid;
    }

    /**
     * Sets the LIMS id of the artifact.
     *
     * @param limsid The LIMS id.
     */
    public void setLimsid(String limsid)
    {
        this.limsid = limsid;
    }

    /**
     * Gets the name of the artifact.
     *
     * @return The artifact name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of the artifact.
     *
     * @param name The artifact name.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Class<Artifact> getEntityClass()
    {
        return Artifact.class;
    }
}
