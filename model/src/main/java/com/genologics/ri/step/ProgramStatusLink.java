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
 *
 * Identifies the resource that represents the program status for the step.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "program-status-link")
public class ProgramStatusLink implements LimsLink<ProgramStatus>, Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial
    private static final long serialVersionUID = 1364271013485882177L;

    /**
     * The URI of the program status.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * Constructs a new empty ProgramStatusLink.
     */
    public ProgramStatusLink()
    {
    }

    /**
     * Constructs a new ProgramStatusLink with the given URI.
     *
     * @param uri the URI of the program status.
     */
    public ProgramStatusLink(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructs a new ProgramStatusLink from a linkable program status.
     *
     * @param link the linkable program status.
     *
     * @throws NullPointerException if link is null.
     */
    public ProgramStatusLink(Linkable<ProgramStatus> link)
    {
        requireNonNull(link, "link cannot be null");
        this.uri = link.getUri();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Class<ProgramStatus> getEntityClass()
    {
        return ProgramStatus.class;
    }

    /**
     * Gets the URI of the program status.
     *
     * @return the URI.
     */
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI of the program status.
     *
     * @param uri the URI.
     */
    public void setUri(URI uri)
    {
        this.uri = uri;
    }

}
