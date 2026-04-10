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
import java.io.Serializable;
import java.net.URI;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.LimsEntityLink;
import com.genologics.ri.LimsEntityLinkable;
import com.genologics.ri.Linkable;

/**
 * Parent-process is a child element of Artifact and provides a URI linking to
 * the Process that created the Artifact.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "parent-process")
public class ParentProcessLink implements LimsEntityLink<ClarityProcess>, Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = -6557381570589306115L;

    /**
     * The URI of the parent process.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * The LIMS id of the parent process.
     */
    @XmlAttribute(name = "limsid")
    protected String limsid;

    /**
     * Default constructor.
     */
    public ParentProcessLink()
    {
    }

    /**
     * Constructor with URI.
     *
     * @param uri the URI of the parent process.
     */
    public ParentProcessLink(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructor with URI and LIMS id.
     *
     * @param uri the URI of the parent process.
     * @param limsid the LIMS id of the parent process.
     */
    public ParentProcessLink(URI uri, String limsid)
    {
        this.uri = uri;
        this.limsid = limsid;
    }

    /**
     * Constructor from a linkable object.
     *
     * @param link the linkable object.
     */
    public ParentProcessLink(Linkable<ClarityProcess> link)
    {
        requireNonNull(link, "link cannot be null");
        this.uri = link.getUri();
    }

    /**
     * Constructor from a LIMS entity linkable object.
     *
     * @param link the LIMS entity linkable object.
     */
    public ParentProcessLink(LimsEntityLinkable<ClarityProcess> link)
    {
        requireNonNull(link, "link cannot be null");
        this.uri = link.getUri();
        this.limsid = link.getLimsid();
    }

    /**
     * Gets the entity class.
     *
     * @return the ClarityProcess class.
     */
    @Override
    public Class<ClarityProcess> getEntityClass()
    {
        return ClarityProcess.class;
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
