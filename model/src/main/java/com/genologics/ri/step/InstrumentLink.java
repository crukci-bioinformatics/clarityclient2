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
import jakarta.xml.bind.annotation.XmlValue;

import com.genologics.ri.LimsEntityLink;
import com.genologics.ri.Link;
import com.genologics.ri.Linkable;
import com.genologics.ri.instrument.Instrument;

/**
 *
 * The instrument element provides a URI to the selected instrument for the
 * step.
 *
 * @since 2.18
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "instrument")
public class InstrumentLink implements LimsEntityLink<Instrument>, Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = -8476139725814009464L;

    /**
     * URI of the instrument.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * Name of the instrument.
     */
    @XmlValue
    protected String name;

    /**
     * Default constructor.
     */
    public InstrumentLink()
    {
    }

    /**
     * Constructor with URI.
     *
     * @param uri The URI of the instrument.
     */
    public InstrumentLink(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructor with URI and name.
     *
     * @param uri The URI of the instrument.
     * @param name The name of the instrument.
     */
    public InstrumentLink(URI uri, String name)
    {
        this.uri = uri;
        this.name = name;
    }

    /**
     * Constructor from a linkable object.
     *
     * @param link The linkable instrument.
     */
    public InstrumentLink(Linkable<Instrument> link)
    {
        requireNonNull(link, "link cannot be null");
        uri = link.getUri();
    }

    /**
     * Constructor from an instrument.
     *
     * @param instrument The instrument.
     */
    public InstrumentLink(Instrument instrument)
    {
        requireNonNull(instrument, "instrument cannot be null");
        uri = instrument.getUri();
        name = instrument.getName();
    }

    /**
     * Gets the name.
     *
     * @return The name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name The name.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Gets the URI.
     *
     * @return The URI.
     */
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI.
     *
     * @param uri The URI.
     */
    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Gets the entity class.
     *
     * @return The Instrument class.
     */
    @Override
    public Class<Instrument> getEntityClass()
    {
        return Instrument.class;
    }

    /**
     * Produces a string representation of this instrument link.
     *
     * @return The instrument name as a string.
     */
    @Override
    public String toString()
    {
        return name;
    }

    /**
     * Gets the LIMS id from the URI.
     *
     * @return The LIMS id.
     */
    @Override
    public String getLimsid()
    {
        return Link.limsIdFromUri(uri);
    }

    /**
     * Sets the LIMS id (does nothing for this implementation).
     *
     * @param id The LIMS id.
     */
    @Override
    public void setLimsid(String id)
    {
        // Does nothing.
    }
}
