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
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.LimsEntityLinkBase;
import com.genologics.ri.LimsEntityLinkable;
import com.genologics.ri.Linkable;

/**
 * Process-link is a child element type of process and provides a URI linking to
 * the detailed representation of a process.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "process-link")
public class ProcessLink extends LimsEntityLinkBase<ClarityProcess>
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 6298646614909486599L;

    /**
     * The URI of the process.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * The LIMS id of the process.
     */
    @XmlAttribute(name = "limsid")
    protected String limsid;

    /**
     * Default constructor.
     */
    public ProcessLink()
    {
    }

    /**
     * Constructor with URI.
     *
     * @param uri the URI of the process.
     */
    public ProcessLink(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructor with URI and LIMS id.
     *
     * @param uri the URI of the process.
     * @param limsid the LIMS id of the process.
     */
    public ProcessLink(URI uri, String limsid)
    {
        this.uri = uri;
        this.limsid = limsid;
    }

    /**
     * Constructor from a linkable object.
     *
     * @param link the linkable object.
     */
    public ProcessLink(Linkable<ClarityProcess> link)
    {
        requireNonNull(link, "link cannot be null");
        uri = link.getUri();
    }

    /**
     * Constructor from a LIMS entity linkable object.
     *
     * @param link the LIMS entity linkable object.
     */
    public ProcessLink(LimsEntityLinkable<ClarityProcess> link)
    {
        requireNonNull(link, "link cannot be null");
        uri = link.getUri();
        limsid = link.getLimsid();
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
