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

package com.genologics.ri.artifact;

import static java.util.Objects.requireNonNull;

import java.io.Serial;
import java.net.URI;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.LimsEntityLinkBase;
import com.genologics.ri.LimsEntityLinkable;
import com.genologics.ri.Linkable;
import com.genologics.ri.process.ClarityProcess;

/**
 *
 * Parent-process is a child element of Artifact and provides a URI linking to
 * the detailed representation of the process that produced the Artifact.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "parent-process")
public class ParentProcessLink extends LimsEntityLinkBase<ClarityProcess>
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = -4561570030979835552L;

    /**
     * The URI of this parent process.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * The LIMS id of this parent process.
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
     * Constructor taking a URI.
     *
     * @param uri The parent process URI.
     */
    public ParentProcessLink(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructor taking a URI and LIMS id.
     *
     * @param uri The parent process URI.
     * @param limsid The parent process LIMS id.
     */
    public ParentProcessLink(URI uri, String limsid)
    {
        this.uri = uri;
        this.limsid = limsid;
    }

    /**
     * Constructor from a Linkable.
     *
     * @param link The linkable object to copy.
     */
    public ParentProcessLink(Linkable<ClarityProcess> link)
    {
        requireNonNull(link, "link cannot be null");
        this.uri = link.getUri();
    }

    /**
     * Constructor from a LimsEntityLinkable.
     *
     * @param link The LIMS entity linkable object to copy.
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
     * @return The ClarityProcess class.
     */
    @Override
    public Class<ClarityProcess> getEntityClass()
    {
        return ClarityProcess.class;
    }

    /**
     * Gets the LIMS id.
     *
     * @return The parent process LIMS id.
     */
    public String getLimsid()
    {
        return limsid;
    }

    /**
     * Sets the LIMS id.
     *
     * @param value The parent process LIMS id.
     */
    public void setLimsid(String value)
    {
        this.limsid = value;
    }

    /**
     * Gets the URI.
     *
     * @return The parent process URI.
     */
    @Override
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI.
     *
     * @param value The parent process URI.
     */
    public void setUri(URI value)
    {
        this.uri = value;
    }
}
