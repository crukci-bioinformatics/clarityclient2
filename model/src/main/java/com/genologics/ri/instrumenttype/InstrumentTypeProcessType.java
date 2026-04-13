/*
 * CRUK-CI Clarity REST API Java Client.
 * Copyright (C) 2016 Cancer Research UK Cambridge Institute.
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

package com.genologics.ri.instrumenttype;

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

import com.genologics.ri.LimsLink;
import com.genologics.ri.Linkable;
import com.genologics.ri.processtype.ProcessType;

/**
 * Process type link for instrument types.
 *
 * @since 2.24
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "instrument-type-process-type")
public class InstrumentTypeProcessType implements LimsLink<ProcessType>, Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 89917917703984734L;

    /**
     * The process type name.
     */
    @XmlValue
    protected String name;

    /**
     * The process type URI.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * Default constructor.
     */
    public InstrumentTypeProcessType()
    {
    }

    /**
     * Constructor with URI.
     *
     * @param uri The process type URI.
     */
    public InstrumentTypeProcessType(URI uri)
    {
        setUri(uri);
    }

    /**
     * Constructor with URI and name.
     *
     * @param uri The process type URI.
     * @param name The process type name.
     */
    public InstrumentTypeProcessType(URI uri, String name)
    {
        setUri(uri);
        setName(name);
    }

    /**
     * Constructor from a linkable process type.
     *
     * @param link The linkable process type.
     */
    public InstrumentTypeProcessType(Linkable<ProcessType> link)
    {
        requireNonNull(link, "link cannot be null");
        uri = link.getUri();
    }

    /**
     * Constructor from a process type.
     *
     * @param processType The process type.
     */
    public InstrumentTypeProcessType(ProcessType processType)
    {
        requireNonNull(processType, "processType cannot be null");
        uri = processType.getUri();
        name = processType.getName();
    }

    /**
     * Get the process type name.
     *
     * @return The process type name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Set the process type name.
     *
     * @param value The process type name.
     */
    public void setName(String value)
    {
        this.name = value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public URI getUri()
    {
        return uri;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setUri(URI value)
    {
        this.uri = value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Class<ProcessType> getEntityClass()
    {
        return ProcessType.class;
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

    /**
     * {@inheritDoc}
     * @see LimsLink#toString(LimsLink)
     */
    public String toString()
    {
        return LimsLink.toString(this);
    }
}
