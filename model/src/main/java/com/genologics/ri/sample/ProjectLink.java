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
import com.genologics.ri.project.Project;

/**
 * Project is a child element of Sample and provides a URI linking to the
 * detailed representation of the Project for the Sample.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "project")
public class ProjectLink extends LimsEntityLinkBase<Project>
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = -4874099265690719737L;

    /**
     * The URI of the project.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * The LIMS id of the project.
     */
    @XmlAttribute(name = "limsid")
    protected String limsid;

    /**
     * Constructor for an empty project link.
     */
    public ProjectLink()
    {
    }

    /**
     * Constructor for a project link with a URI.
     *
     * @param uri The URI of the project.
     */
    public ProjectLink(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructor for a project link with a URI and LIMS id.
     *
     * @param uri The URI of the project.
     * @param limsid The LIMS id of the project.
     */
    public ProjectLink(URI uri, String limsid)
    {
        this.uri = uri;
        this.limsid = limsid;
    }

    /**
     * Constructor for a project link from a linkable project.
     *
     * @param link The linkable project.
     */
    public ProjectLink(Linkable<Project> link)
    {
        requireNonNull(link, "link cannot be null");
        uri = link.getUri();
    }

    /**
     * Constructor for a project link from a LIMS entity linkable project.
     *
     * @param link The LIMS entity linkable project.
     */
    public ProjectLink(LimsEntityLinkable<Project> link)
    {
        requireNonNull(link, "link cannot be null");
        uri = link.getUri();
        limsid = link.getLimsid();
    }

    /**
     * Gets the entity class for this link.
     *
     * @return The Project class.
     */
    public Class<Project> getEntityClass()
    {
        return Project.class;
    }

    /**
     * Gets the URI of the project.
     *
     * @return The project URI.
     */
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI of the project.
     *
     * @param value The project URI.
     */
    public void setUri(URI value)
    {
        this.uri = value;
    }

    /**
     * Gets the LIMS id of the project.
     *
     * @return The LIMS id.
     */
    public String getLimsid()
    {
        return limsid;
    }

    /**
     * Sets the LIMS id of the project.
     *
     * @param value The LIMS id.
     */
    public void setLimsid(String value)
    {
        this.limsid = value;
    }

    /**
     * Returns a string representation of this project link.
     *
     * @return The LIMS id.
     */
    @Override
    public String toString()
    {
        return limsid;
    }
}
