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

package com.genologics.ri.step;

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

/**
 *
 * Identifies the resource that represents the reagents added by the step.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reagents-link")
public class ReagentsLink extends LimsLinkBase<Reagents>
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 606802593515729159L;

    /**
     * The URI of the reagents resource.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * Creates an empty reagents link.
     */
    public ReagentsLink()
    {
    }

    /**
     * Creates a reagents link with the given URI.
     *
     * @param uri The URI of the reagents resource.
     */
    public ReagentsLink(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Creates a reagents link from a linkable object.
     *
     * @param link The linkable object to extract the URI from.
     *
     * @throws NullPointerException if {@code link} is null.
     */
    public ReagentsLink(Linkable<Reagents> link)
    {
        requireNonNull(link, "link cannot be null");
        uri = link.getUri();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Class<Reagents> getEntityClass()
    {
        return Reagents.class;
    }

    /**
     * Gets the URI of the reagents resource.
     *
     * @return The URI.
     */
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI of the reagents resource.
     *
     * @param uri The URI.
     */
    public void setUri(URI uri)
    {
        this.uri = uri;
    }

}
