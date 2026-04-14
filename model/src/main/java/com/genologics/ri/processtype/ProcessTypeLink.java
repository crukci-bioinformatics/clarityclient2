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

package com.genologics.ri.processtype;

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
 * Process-type-link is a child element type of process types and provides a URI
 * linking to the detailed representation of a process type.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "process-type-link")
public class ProcessTypeLink extends LimsLinkBase<ProcessType>
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 5914216290949476076L;

    /**
     * The URI of the process type.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * The name of the process type.
     */
    @XmlAttribute(name = "name")
    protected String name;

    /**
     * Constructs a new process type link.
     */
    public ProcessTypeLink()
    {
    }

    /**
     * Constructs a new process type link with the specified URI.
     *
     * @param uri the URI of the process type.
     */
    public ProcessTypeLink(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructs a new process type link with the specified URI and name.
     *
     * @param uri the URI of the process type.
     * @param name the name of the process type.
     */
    public ProcessTypeLink(URI uri, String name)
    {
        this.uri = uri;
        this.name = name;
    }

    /**
     * Constructs a new process type link from a linkable object.
     *
     * @param link the linkable object providing the URI.
     */
    public ProcessTypeLink(Linkable<ProcessType> link)
    {
        requireNonNull(link, "link cannot be null");
        this.uri = link.getUri();
    }

    /**
     * Constructs a new process type link from a process type entity.
     *
     * @param processType the process type entity.
     */
    public ProcessTypeLink(ProcessType processType)
    {
        requireNonNull(processType, "processType cannot be null");
        uri = processType.getUri();
        name = processType.getName();
    }

    /**
     * Gets the entity class for this link.
     *
     * @return the ProcessType class.
     */
    @Override
    public Class<ProcessType> getEntityClass()
    {
        return ProcessType.class;
    }

    /**
     * Gets the name of the process type.
     *
     * @return the process type name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of the process type.
     *
     * @param name the process type name.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Gets the URI of the process type.
     *
     * @return the process type URI.
     */
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI of the process type.
     *
     * @param uri the process type URI.
     */
    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Returns a string representation of this process type link.
     *
     * @return the process type name.
     */
    @Override
    public String toString()
    {
        return name;
    }
}
