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

package com.genologics.ri.project;

import static java.util.Objects.requireNonNull;

import java.io.Serial;
import java.net.URI;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.LimsEntityLinkBase;
import com.genologics.ri.Link;
import com.genologics.ri.Linkable;
import com.genologics.ri.researcher.Researcher;

/**
 *
 * Researcher is a child element of Project and provides a URI linking to the
 * detailed representation of the Researcher for the Project.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "researcher")
public class ResearcherLink extends LimsEntityLinkBase<Researcher>
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = -7754124824899651369L;

    /**
     * The URI of the researcher.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * Constructor for ResearcherLink.
     */
    public ResearcherLink()
    {
    }

    /**
     * Constructor for ResearcherLink with a URI.
     *
     * @param uri The URI of the researcher.
     */
    public ResearcherLink(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructor for ResearcherLink from a Linkable.
     *
     * @param link The linkable object.
     */
    public ResearcherLink(Linkable<Researcher> link)
    {
        requireNonNull(link, "link cannot be null");
        this.uri = link.getUri();
    }

    /**
     * Get the entity class for this link.
     *
     * @return The Researcher class.
     */
    @Override
    public Class<Researcher> getEntityClass()
    {
        return Researcher.class;
    }

    /**
     * Get the URI of the researcher.
     *
     * @return The URI.
     */
    public URI getUri()
    {
        return uri;
    }

    /**
     * Set the URI of the researcher.
     *
     * @param value The new URI.
     */
    public void setUri(URI value)
    {
        this.uri = value;
    }

    /**
     * Get the LIMS id of the researcher.
     *
     * @return The LIMS id extracted from the URI.
     */
    @Override
    public String getLimsid()
    {
        return Link.limsIdFromUri(uri);
    }

    /**
     * Set the LIMS id of the researcher.
     *
     * @param id The new LIMS id (ignored by this implementation).
     */
    @Override
    public void setLimsid(String id)
    {
        // Does nothing.
    }
}
