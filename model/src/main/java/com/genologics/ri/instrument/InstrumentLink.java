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

package com.genologics.ri.instrument;

import static java.util.Objects.requireNonNull;

import java.io.Serializable;
import java.net.URI;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.LimsEntityLink;
import com.genologics.ri.Link;
import com.genologics.ri.Linkable;

/**
 *
 * Instrument-link is a child element type of instruments and provides a URI
 * linking to the detailed representation of an instrument.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "instrument-link", propOrder = { "name" })
public class InstrumentLink implements LimsEntityLink<Instrument>, Serializable
{
    private static final long serialVersionUID = 4463465224415870496L;

    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    protected String name;

    public InstrumentLink()
    {
    }

    public InstrumentLink(URI uri)
    {
        this.uri = uri;
    }

    public InstrumentLink(URI uri, String name)
    {
        this.uri = uri;
        this.name = name;
    }

    public InstrumentLink(Linkable<Instrument> link)
    {
        requireNonNull(link, "link cannot be null");
        uri = link.getUri();
    }

    public InstrumentLink(Instrument instrument)
    {
        requireNonNull(instrument, "instrument cannot be null");
        uri = instrument.getUri();
        name = instrument.getName();
    }

    @Override
    public Class<Instrument> getEntityClass()
    {
        return Instrument.class;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public URI getUri()
    {
        return uri;
    }

    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    @Override
    public String toString()
    {
        return name;
    }

    @Override
    public String getLimsid()
    {
        return Link.limsIdFromUri(uri);
    }

    @Override
    public void setLimsid(String id)
    {
        // Does nothing.
    }
}
