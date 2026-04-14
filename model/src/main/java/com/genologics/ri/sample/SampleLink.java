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

package com.genologics.ri.sample;

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
 * Sample-link is a child element type of samples and provides a URI linking to
 * the detailed representation of a sample.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sample-link")
public class SampleLink extends LimsEntityLinkBase<Sample>
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = -5247716763134908401L;

    /**
     * The URI of the sample.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * The LIMS id of the sample.
     */
    @XmlAttribute(name = "limsid")
    protected String limsid;

    /**
     * Constructor for an empty sample link.
     */
    public SampleLink()
    {
    }

    /**
     * Constructor for a sample link with a URI.
     *
     * @param uri The URI of the sample.
     */
    public SampleLink(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructor for a sample link with a URI and LIMS id.
     *
     * @param uri The URI of the sample.
     * @param limsid The LIMS id of the sample.
     */
    public SampleLink(URI uri, String limsid)
    {
        this.uri = uri;
        this.limsid = limsid;
    }

    /**
     * Constructor for a sample link from a linkable sample.
     *
     * @param link The linkable sample.
     */
    public SampleLink(Linkable<Sample> link)
    {
        requireNonNull(link, "link cannot be null");
        this.uri = link.getUri();
    }

    /**
     * Constructor for a sample link from a LIMS entity linkable sample.
     *
     * @param link The LIMS entity linkable sample.
     */
    public SampleLink(LimsEntityLinkable<Sample> link)
    {
        requireNonNull(link, "link cannot be null");
        this.uri = link.getUri();
        this.limsid = link.getLimsid();
    }

    /**
     * Gets the entity class for this link.
     *
     * @return The Sample class.
     */
    @Override
    public Class<Sample> getEntityClass()
    {
        return Sample.class;
    }

    /**
     * Gets the URI of the sample.
     *
     * @return The sample URI.
     */
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI of the sample.
     *
     * @param uri The sample URI.
     */
    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Gets the LIMS id of the sample.
     *
     * @return The LIMS id.
     */
    public String getLimsid()
    {
        return limsid;
    }

    /**
     * Sets the LIMS id of the sample.
     *
     * @param limsid The LIMS id.
     */
    public void setLimsid(String limsid)
    {
        this.limsid = limsid;
    }

    /**
     * Returns a string representation of this sample link.
     *
     * @return The LIMS id.
     */
    @Override
    public String toString()
    {
        return limsid;
    }
}
