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
import java.net.URI;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.LimsLinkBase;
import com.genologics.ri.Linkable;


/**
 * Instrument-type-link provides a URI linking to the detailed representation of an instrument type.
 *
 * @since 2.24
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "instrument-type-link")
public class InstrumentTypeLink extends LimsLinkBase<InstrumentType>
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 3927957034901059387L;

    /**
     * The URI of the instrument type.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * The instrument type name.
     */
    @XmlAttribute(name = "name")
    protected String name;

    /**
     * The instrument vendor.
     */
    @XmlAttribute(name = "vendor")
    protected String vendor;

    /**
     * Default constructor.
     */
    public InstrumentTypeLink()
    {
    }

    /**
     * Constructor with URI.
     *
     * @param uri The instrument type URI.
     */
    public InstrumentTypeLink(URI uri)
    {
        setUri(uri);
    }

    /**
     * Constructor with URI and name.
     *
     * @param uri The instrument type URI.
     * @param name The instrument type name.
     */
    public InstrumentTypeLink(URI uri, String name)
    {
        setUri(uri);
        setName(name);
    }

    /**
     * Constructor with URI, name and vendor.
     *
     * @param uri The instrument type URI.
     * @param name The instrument type name.
     * @param vendor The instrument vendor.
     */
    public InstrumentTypeLink(URI uri, String name, String vendor)
    {
        setUri(uri);
        setName(name);
        setVendor(vendor);
    }

    /**
     * Constructor from a linkable instrument type.
     *
     * @param link The linkable instrument type.
     */
    public InstrumentTypeLink(Linkable<InstrumentType> link)
    {
        requireNonNull(link, "link cannot be null");
        uri = link.getUri();
    }

    /**
     * Constructor from an instrument type.
     *
     * @param instrumentType The instrument type.
     */
    public InstrumentTypeLink(InstrumentType instrumentType)
    {
        requireNonNull(instrumentType, "instrumentType cannot be null");
        uri = instrumentType.getUri();
        name = instrumentType.getName();
        vendor = instrumentType.getVendor();
    }

    /**
     * Get the instrument type name.
     *
     * @return The instrument type name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Set the instrument type name.
     *
     * @param value The instrument type name.
     */
    public void setName(String value)
    {
        this.name = value;
    }

    /**
     * Get the instrument vendor.
     *
     * @return The instrument vendor.
     */
    public String getVendor()
    {
        return vendor;
    }

    /**
     * Set the instrument vendor.
     *
     * @param value The instrument vendor.
     */
    public void setVendor(String value)
    {
        this.vendor = value;
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
    public Class<InstrumentType> getEntityClass()
    {
        return InstrumentType.class;
    }
}
