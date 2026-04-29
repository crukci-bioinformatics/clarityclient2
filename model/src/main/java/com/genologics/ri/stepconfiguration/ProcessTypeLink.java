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


package com.genologics.ri.stepconfiguration;

import static java.util.Objects.requireNonNull;

import java.io.Serial;
import java.io.Serializable;
import java.net.URI;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.XmlValue;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.genologics.ri.LimsLink;
import com.genologics.ri.Linkable;
import com.genologics.ri.processtype.ProcessType;


/**
 *
 *         Process-type is a child element that provides a URI linking to the detailed
 * representation of the process type that the step is associated with.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "process-type")
public class ProcessTypeLink implements LimsLink<ProcessType>, Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 8671368236853188031L;

    /**
     * The name of the process type.
     */
    @XmlValue
    protected String name;

    /**
     * The URI of the process type.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;


    /**
     * Default constructor.
     */
    public ProcessTypeLink()
    {
    }

    /**
     * Constructor with URI.
     *
     * @param uri The URI of the process type.
     */
    public ProcessTypeLink(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructor with URI and name.
     *
     * @param uri The URI of the process type.
     * @param name The name of the process type.
     */
    public ProcessTypeLink(URI uri, String name)
    {
        this.uri = uri;
        this.name = name;
    }

    /**
     * Constructor from a linkable process type.
     *
     * @param link The linkable process type.
     */
    public ProcessTypeLink(Linkable<ProcessType> link)
    {
        requireNonNull(link, "link cannot be null");
        this.uri = link.getUri();
    }

    /**
     * Constructor from a process type entity.
     *
     * @param processType The process type entity.
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
     * @return The ProcessType class.
     */
    @Override
    public Class<ProcessType> getEntityClass()
    {
        return ProcessType.class;
    }

    /**
     * Gets the name of the process type.
     *
     * @return The process type name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of the process type.
     *
     * @param name The process type name.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Gets the URI of the process type.
     *
     * @return The process type URI.
     */
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI of the process type.
     *
     * @param uri The process type URI.
     */
    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Returns a string representation of this process type link.
     *
     * @return The process type name.
     */
    @Override
    public String toString()
    {
        ToStringBuilder b = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
        b.append("processType", LimsLink.toString(this));
        b.append("name", name);
        return b.toString();
    }

    /**
     * {@inheritDoc}
     * @see LimsLink#hashCode(LimsLink)
     */
    @Override
    public int hashCode()
    {
        return LimsLink.hashCode(this);
    }

    /**
     * {@inheritDoc}
     * @see LimsLink#equals(LimsLink, Object)
     */
    @Override
    public boolean equals(Object obj)
    {
        return LimsLink.equals(this, obj);
    }
}
