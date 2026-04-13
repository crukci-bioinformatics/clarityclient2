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

package com.genologics.ri.processexecution;

import static java.util.Objects.requireNonNull;

import java.io.Serial;
import java.net.URI;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.LimsLinkBase;
import com.genologics.ri.Linkable;
import com.genologics.ri.researcher.Researcher;

/**
 *
 * The technician element provides a URI to the user that is responsible for the
 * Process. Once the Process completes, this user is listed as the technician
 * that ran the Process.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "technician")
public class Technician extends LimsLinkBase<Researcher>
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 6342603327961394878L;

    /**
     * The URI of the researcher acting as technician.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * Default constructor.
     */
    public Technician()
    {
    }

    /**
     * Constructor with URI.
     *
     * @param uri The researcher URI.
     */
    public Technician(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructor from a linkable researcher.
     *
     * @param link The researcher link.
     */
    public Technician(Linkable<Researcher> link)
    {
        requireNonNull(link, "link cannot be null");
        uri = link.getUri();
    }

    /**
     * Gets the entity class.
     *
     * @return The Researcher class.
     */
    @Override
    public Class<Researcher> getEntityClass()
    {
        return Researcher.class;
    }

    /**
     * Gets the URI of the researcher.
     *
     * @return The researcher URI.
     */
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI of the researcher.
     *
     * @param value The researcher URI to set.
     */
    public void setUri(URI value)
    {
        this.uri = value;
    }

}
