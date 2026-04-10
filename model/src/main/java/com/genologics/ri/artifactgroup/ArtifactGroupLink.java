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

package com.genologics.ri.artifactgroup;

import static java.util.Objects.requireNonNull;

import java.io.Serial;
import java.io.Serializable;
import java.net.URI;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.LimsLink;
import com.genologics.ri.Linkable;

/**
 * artifactGroup-link is a child element type of artifactGroup and provides a
 * URI linking to the detailed representation of a artifactGroup.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "artifactgroup-link")
public class ArtifactGroupLink implements LimsLink<ArtifactGroup>, Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 3168021328679428589L;

    /**
     * The URI of the artifact group.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * The name of the artifact group.
     */
    protected String name;

    /**
     * Default constructor.
     */
    public ArtifactGroupLink()
    {
    }

    /**
     * Constructs a link with the given URI.
     *
     * @param uri The URI of the artifact group.
     */
    public ArtifactGroupLink(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructs a link with the given URI and name.
     *
     * @param uri The URI of the artifact group.
     * @param name The name of the artifact group.
     */
    public ArtifactGroupLink(URI uri, String name)
    {
        this.uri = uri;
        this.name = name;
    }

    /**
     * Constructs a link from a Linkable object.
     *
     * @param link The linkable object to create a link from.
     */
    public ArtifactGroupLink(Linkable<ArtifactGroup> link)
    {
        requireNonNull(link, "link cannot be null");
        this.uri = link.getUri();
    }

    /**
     * Gets the entity class this link refers to.
     *
     * @return The ArtifactGroup class.
     */
    @Override
    public Class<ArtifactGroup> getEntityClass()
    {
        return ArtifactGroup.class;
    }

    /**
     * Gets the name of the artifact group.
     *
     * @return The name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of the artifact group.
     *
     * @param value The name to set.
     */
    public void setName(String value)
    {
        this.name = value;
    }

    /**
     * Gets the URI of the artifact group.
     *
     * @return The URI.
     */
    @Override
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI of the artifact group.
     *
     * @param value The URI to set.
     */
    public void setUri(URI value)
    {
        this.uri = value;
    }

    /**
     * Returns a string representation of this link.
     *
     * @return The name of the artifact group.
     */
    @Override
    public String toString()
    {
        return name;
    }
}
