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

package com.genologics.ri;

import java.io.Serial;
import java.io.Serializable;
import java.net.URI;
import java.util.regex.Pattern;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

/**
 * A link provides a URI linking to an additional resource.
 * <p>
 * The link is modelled on the link element defined by the
 * <a href="http://atompub.org/rfc4287.html">Atom Syndication Format</a>.
 * The link includes a rel attribute that describes the URI of the link.
 * </p>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "link")
public class Link implements Locatable, Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 7144458168274015747L;

    /**
     * Shared constant for use throughout this library to indicate a field is not set.
     */
    public static final String UNSET = "unset";

    /**
     * Pattern for splitting URI paths.
     */
    private static final Pattern PATH_SPLITTER = Pattern.compile("/+");

    /**
     * The relative part of the link.
     */
    @XmlAttribute(name = "rel")
    protected String relative;

    /**
     * The URI of the link.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * Default constructor.
     */
    public Link()
    {
    }

    /**
     * Constructor with relative part.
     *
     * @param rel The relative part of the link.
     */
    public Link(String rel)
    {
        this.relative = rel;
    }

    /**
     * Constructor with relative part and URI.
     *
     * @param rel The relative part of the link.
     * @param uri The URI.
     */
    public Link(String rel, URI uri)
    {
        this.relative = rel;
        this.uri = uri;
    }

    /**
     * Constructor from a linkable object.
     *
     * @param limsLink The linkable object.
     */
    public Link(Linkable<?> limsLink)
    {
        uri = limsLink.getUri();

        String[] pathParts = PATH_SPLITTER.split(uri.getPath());

        // LIMS id should be the last part of the path.
        // The relative part should be the second to last part.

        relative = pathParts[pathParts.length - 2];
    }

    /**
     * Gets the relative part of the link.
     *
     * @return The relative part.
     */
    public String getRelative()
    {
        return relative;
    }

    /**
     * Sets the relative part of the link.
     *
     * @param rel The relative part.
     */
    public void setRelative(String rel)
    {
        this.relative = rel;
    }

    /**
     * Gets the URI of the link.
     *
     * @return The URI.
     */
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI of the link.
     *
     * @param uri The URI.
     */
    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Gets a string representation of the link.
     *
     * @return The URI as a string, or "unset" if the URI is null.
     */
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder(80);
        sb.append("Link[").append(uri == null ? UNSET : uri.toString()).append(']');
        return sb.toString();
    }

    /**
     * Extract the LIMS identifier from a URI. The identifier is the
     * last part of the URI path.
     *
     * @param uri The URI.
     *
     * @return The id from the URI path, or null if {@code uri} is null.
     */
    public static String limsIdFromUri(URI uri)
    {
        String id = null;

        if (uri != null)
        {
            String[] parts = PATH_SPLITTER.split(uri.getPath());

            id = parts[parts.length - 1];
        }

        return id;
    }

    /**
     * Extract the LIMS identifier from the URI of a Locatable object.
     *
     * @param thing The Locatable object.
     *
     * @return The id from the object's URI, or null if {@code thing} is null.
     */
    public static String limsIdFromUri(Locatable thing)
    {
        return thing == null ? null : limsIdFromUri(thing.getUri());
    }
}
