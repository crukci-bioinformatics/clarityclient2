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
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.LimsEntityLinkBase;
import com.genologics.ri.LimsEntityLinkable;
import com.genologics.ri.Linkable;

/**
 *
 * Project-link is a child element type of projects and provides a URI linking
 * to the detailed representation of a project.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "project-link")
public class ProjectLink extends LimsEntityLinkBase<Project>
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 5015998464762805841L;

    /**
     * The name of the project.
     */
    @XmlElement(name = "name")
    protected String name;

    /**
     * The LIMS id of the project.
     */
    @XmlAttribute(name = "limsid")
    protected String limsid;

    /**
     * The URI of the project.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * Constructor for ProjectLink.
     */
    public ProjectLink()
    {
    }

    /**
     * Constructor for ProjectLink with a URI.
     *
     * @param uri The URI of the project.
     */
    public ProjectLink(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructor for ProjectLink with a URI and LIMS id.
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
     * Constructor for ProjectLink with a URI, LIMS id, and name.
     *
     * @param uri The URI of the project.
     * @param limsid The LIMS id of the project.
     * @param name The name of the project.
     */
    public ProjectLink(URI uri, String limsid, String name)
    {
        this.uri = uri;
        this.limsid = limsid;
        this.name = name;
    }

    /**
     * Constructor for ProjectLink from a Linkable.
     *
     * @param link The linkable object.
     */
    public ProjectLink(Linkable<Project> link)
    {
        requireNonNull(link, "link cannot be null");
        uri = link.getUri();
    }

    /**
     * Constructor for ProjectLink from a LimsEntityLinkable.
     *
     * @param link The linkable object.
     */
    public ProjectLink(LimsEntityLinkable<Project> link)
    {
        requireNonNull(link, "link cannot be null");
        uri = link.getUri();
        limsid = link.getLimsid();
    }

    /**
     * Constructor for ProjectLink from a Project.
     *
     * @param project The project.
     */
    public ProjectLink(Project project)
    {
        requireNonNull(project, "project cannot be null");
        uri = project.getUri();
        limsid = project.getLimsid();
        name = project.getName();
    }

    /**
     * Get the entity class for this link.
     *
     * @return The Project class.
     */
    @Override
    public Class<Project> getEntityClass()
    {
        return Project.class;
    }

    /**
     * Get the name of the project.
     *
     * @return The project name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Set the name of the project.
     *
     * @param name The new project name.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Get the LIMS id of the project.
     *
     * @return The LIMS id.
     */
    public String getLimsid()
    {
        return limsid;
    }

    /**
     * Set the LIMS id of the project.
     *
     * @param limsid The new LIMS id.
     */
    public void setLimsid(String limsid)
    {
        this.limsid = limsid;
    }

    /**
     * Get the URI of the project.
     *
     * @return The URI.
     */
    public URI getUri()
    {
        return uri;
    }

    /**
     * Set the URI of the project.
     *
     * @param uri The new URI.
     */
    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Return a string representation of the project link.
     *
     * @return The LIMS id of the project.
     */
    @Override
    public String toString()
    {
        return limsid;
    }
}
