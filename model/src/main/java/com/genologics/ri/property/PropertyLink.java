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

package com.genologics.ri.property;

import java.io.Serializable;
import java.net.URI;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

/**
 *
 * property-link is a child element type of property and provides a URI linking
 * to the detailed representation of a property.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "property-link")
public class PropertyLink implements Serializable
{
    /**
     * Class version for serialisation.
     */
    @java.io.Serial
    private static final long serialVersionUID = -6134863203392574429L;

    /**
     * The URI of the property.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * The name of the property.
     */
    @XmlAttribute(name = "name")
    protected String name;

    /**
     * The value of the property.
     */
    @XmlAttribute(name = "value")
    protected String value;


    /**
     * Default constructor.
     */
    public PropertyLink()
    {
    }

    /**
     * Constructor with URI.
     *
     * @param uri The URI of the property.
     */
    public PropertyLink(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructor with URI, name, and value.
     *
     * @param uri The URI of the property.
     * @param name The name of the property.
     * @param value The value of the property.
     */
    public PropertyLink(URI uri, String name, String value)
    {
        this.uri = uri;
        this.name = name;
        this.value = value;
    }

    /**
     * Gets the URI of the property.
     *
     * @return The property URI.
     */
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI of the property.
     *
     * @param uri The property URI.
     */
    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Gets the name of the property.
     *
     * @return The property name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of the property.
     *
     * @param name The property name.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Gets the value of the property.
     *
     * @return The property value.
     */
    public String getValue()
    {
        return value;
    }

    /**
     * Sets the value of the property.
     *
     * @param value The property value.
     */
    public void setValue(String value)
    {
        this.value = value;
    }


}
