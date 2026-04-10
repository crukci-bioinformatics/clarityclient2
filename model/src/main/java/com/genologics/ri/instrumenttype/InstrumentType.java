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

import java.io.Serial;
import java.io.Serializable;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.ClarityEntity;
import com.genologics.ri.LimsLink;
import com.genologics.ri.Linkable;

/**
 * An instrument describes properties common to all instruments of that type.
 *
 * @since 2.24
 */
@ClarityEntity(uriSection = "configuration/instrumenttypes")
@XmlRootElement(name = "instrument-type")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "instrument-type", propOrder = { "name", "vendor", "processTypes" })
public class InstrumentType implements Linkable<InstrumentType>, Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 7273963191417975L;

    /**
     * The instrument type name.
     */
    protected String name;

    /**
     * The instrument vendor.
     */
    protected String vendor;

    /**
     * The list of process types associated with this instrument type.
     */
    @XmlElementWrapper(name = "process-types")
    @XmlElement(name = "process-type")
    protected List<InstrumentTypeProcessType> processTypes;

    /**
     * The URI of the instrument type.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * Default constructor.
     */
    public InstrumentType()
    {
    }

    /**
     * Constructor with URI.
     *
     * @param uri The instrument type URI.
     */
    public InstrumentType(URI uri)
    {
        setUri(uri);
    }

    /**
     * Constructor with URI and name.
     *
     * @param uri The instrument type URI.
     * @param name The instrument type name.
     */
    public InstrumentType(URI uri, String name)
    {
        setUri(uri);
        setName(name);
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
     * Get the list of process types associated with this instrument type.
     *
     * @return The list of process types.
     */
    public List<InstrumentTypeProcessType> getProcessTypes()
    {
        if (processTypes == null)
        {
            processTypes = new ArrayList<InstrumentTypeProcessType>();
        }
        return processTypes;
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
    public LimsLink<InstrumentType> getLink()
    {
        return new InstrumentTypeLink(this);
    }
}
