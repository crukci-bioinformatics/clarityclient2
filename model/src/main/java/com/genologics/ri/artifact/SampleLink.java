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
import com.genologics.ri.sample.Sample;

/**
 *
 * Sample is a child element of Artifact and provides a URI linking to the
 * detailed representation of a submitted Sample for the Artifact.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sample")
public class SampleLink extends LimsEntityLinkBase<Sample>
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = -7708212302820162281L;

    /**
     * The URI of this sample.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * The LIMS id of this sample.
     */
    @XmlAttribute(name = "limsid")
    protected String limsid;

    /**
     * Default constructor.
     */
    public SampleLink()
    {
    }

    /**
     * Constructor taking a URI.
     *
     * @param uri The sample URI.
     */
    public SampleLink(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructor taking a URI and LIMS id.
     *
     * @param uri The sample URI.
     * @param limsid The sample LIMS id.
     */
    public SampleLink(URI uri, String limsid)
    {
        this.uri = uri;
        this.limsid = limsid;
    }

    /**
     * Constructor from a Linkable.
     *
     * @param link The linkable object to copy.
     */
    public SampleLink(Linkable<Sample> link)
    {
        requireNonNull(link, "link cannot be null");
        this.uri = link.getUri();
    }

    /**
     * Constructor from a LimsEntityLinkable.
     *
     * @param link The LIMS entity linkable object to copy.
     */
    public SampleLink(LimsEntityLinkable<Sample> link)
    {
        requireNonNull(link, "link cannot be null");
        this.uri = link.getUri();
        this.limsid = link.getLimsid();
    }

    /**
     * Gets the entity class.
     *
     * @return The Sample class.
     */
    @Override
    public Class<Sample> getEntityClass()
    {
        return Sample.class;
    }

    /**
     * Gets the LIMS id.
     *
     * @return The sample LIMS id.
     */
    public String getLimsid()
    {
        return limsid;
    }

    /**
     * Sets the LIMS id.
     *
     * @param value The sample LIMS id.
     */
    public void setLimsid(String value)
    {
        this.limsid = value;
    }

    /**
     * Gets the URI.
     *
     * @return The sample URI.
     */
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI.
     *
     * @param value The sample URI.
     */
    public void setUri(URI value)
    {
        this.uri = value;
    }

    /**
     * Returns a string representation of this link.
     *
     * @return The LIMS id.
     */
    @Override
    public String toString()
    {
        return limsid;
    }
}
