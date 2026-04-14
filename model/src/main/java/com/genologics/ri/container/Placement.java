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

package com.genologics.ri.container;

import static com.genologics.ri.Location.WELL_POSITION_SPLITTER;
import static java.util.Objects.requireNonNull;

import java.io.Serial;
import java.net.URI;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import org.apache.commons.lang3.StringUtils;

import com.genologics.ri.LimsEntityLinkBase;
import com.genologics.ri.LimsEntityLinkable;
import com.genologics.ri.artifact.Artifact;

/**
 *
 * Placement is a child element of container and provides a URI linking to the
 * detailed representation of the artifact that is located in a specific well of
 * the container.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "placement", propOrder = { "wellPosition" })
public class Placement extends LimsEntityLinkBase<Artifact> implements Comparable<Placement>
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = -4089394834813900531L;

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
     * The well position in the container.
     */
    @XmlElement(name = "value")
    protected String wellPosition;

    /**
     * Default constructor.
     */
    public Placement()
    {
    }

    /**
     * Constructor with URI.
     *
     * @param uri The URI.
     */
    public Placement(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructor with URI and well position.
     *
     * @param uri The URI.
     * @param wellPosition The well position.
     */
    public Placement(URI uri, String wellPosition)
    {
        this.uri = uri;
        this.wellPosition = wellPosition;
    }

    /**
     * Constructor with URI, LIMS id, and well position.
     *
     * @param uri The URI.
     * @param limsid The LIMS id.
     * @param wellPosition The well position.
     */
    public Placement(URI uri, String limsid, String wellPosition)
    {
        this.uri = uri;
        this.limsid = limsid;
        this.wellPosition = wellPosition;
    }

    /**
     * Constructor from a LIMS entity linkable artifact.
     *
     * @param artifact The artifact.
     */
    public Placement(LimsEntityLinkable<Artifact> artifact)
    {
        requireNonNull(artifact, "artifact cannot be null");
        this.uri = artifact.getUri();
    }

    /**
     * Constructor from a LIMS entity linkable artifact with well position.
     *
     * @param artifact The artifact.
     * @param wellPosition The well position.
     */
    public Placement(LimsEntityLinkable<Artifact> artifact, String wellPosition)
    {
        requireNonNull(artifact, "artifact cannot be null");
        this.uri = artifact.getUri();
        this.wellPosition = wellPosition;
    }

    /**
     * Constructor from an artifact.
     * Extracts the well position from the artifact's location if available.
     *
     * @param artifact The artifact.
     */
    public Placement(Artifact artifact)
    {
        requireNonNull(artifact, "artifact cannot be null");
        uri = artifact.getUri();
        limsid = artifact.getLimsid();
        wellPosition = artifact.getLocation() == null ? null : artifact.getLocation().getWellPosition();
    }

    /**
     * Gets the entity class for this placement.
     *
     * @return The Artifact class.
     */
    @Override
    public Class<Artifact> getEntityClass()
    {
        return Artifact.class;
    }

    /**
     * Gets the URI of the artifact.
     *
     * @return The URI.
     */
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI of the artifact.
     *
     * @param uri The URI.
     */
    public void setUri(URI uri)
    {
        this.uri = uri;
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
     * Gets the well position in the container.
     *
     * @return The well position.
     */
    public String getWellPosition()
    {
        return wellPosition;
    }

    /**
     * Sets the well position in the container.
     *
     * @param wellPosition The well position.
     */
    public void setWellPosition(String wellPosition)
    {
        this.wellPosition = wellPosition;
    }

    /**
     * Compares this placement to another based on well position.
     * Well positions are compared intelligently, taking into account numeric and alphabetic parts.
     *
     * @param o The other placement to compare to.
     * @return A negative integer, zero, or a positive integer as this placement is less than,
     *         equal to, or greater than the specified placement.
     */
    @Override
    public int compareTo(Placement o)
    {
        if (o == null)
        {
            return 1;
        }

        if (StringUtils.isBlank(wellPosition) || StringUtils.isBlank(o.wellPosition))
        {
            return 0;
        }

        String[] myparts = WELL_POSITION_SPLITTER.split(wellPosition);
        String[] itsparts = WELL_POSITION_SPLITTER.split(o.wellPosition);

        int result = 0;
        for (int p = 0; result == 0 && p < Math.min(myparts.length, itsparts.length); p++)
        {
            try
            {
                int p1v = Integer.parseInt(myparts[p]);
                int p2v = Integer.parseInt(itsparts[p]);
                result = p1v - p2v;
            }
            catch (NumberFormatException e)
            {
                result = myparts[p].compareTo(itsparts[p]);
            }
        }
        return result;
    }

    /**
     * Returns a string representation of the placement.
     *
     * @return A string representation containing the LIMS id and well position.
     */
    @Override
    public String toString()
    {
        return limsid + " " + wellPosition;
    }
}
