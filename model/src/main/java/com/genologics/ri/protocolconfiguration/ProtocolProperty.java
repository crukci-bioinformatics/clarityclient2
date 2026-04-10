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

package com.genologics.ri.protocolconfiguration;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;

/**
 * Protocol-property is a child element of protocol containing key/value pairs for
 * setting specific attributes of protocols.
 * This information contains internally used properties that will change. These properties are
 * suitable for use when copying protocols, but should not be manipulated.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "protocol-property")
public class ProtocolProperty implements Serializable
{
    /**
     * Class version for serialisation.
     */
    @java.io.Serial
    private static final long serialVersionUID = -2121684009872156372L;

    /**
     * The name of the protocol property.
     */
    @XmlAttribute(name = "name")
    protected String name;

    /**
     * The value of the protocol property.
     */
    @XmlAttribute(name = "value")
    protected String value;

    /**
     * Default constructor.
     */
    public ProtocolProperty()
    {
    }

    /**
     * Constructor with name and value.
     *
     * @param name The name of the protocol property.
     * @param value The value of the protocol property.
     */
    public ProtocolProperty(String name, String value)
    {
        this.name = name;
        this.value = value;
    }

    /**
     * Gets the name of the protocol property.
     *
     * @return The protocol property name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of the protocol property.
     *
     * @param name The protocol property name.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Gets the value of the protocol property.
     *
     * @return The protocol property value.
     */
    public String getValue()
    {
        return value;
    }

    /**
     * Sets the value of the protocol property.
     *
     * @param value The protocol property value.
     */
    public void setValue(String value)
    {
        this.value = value;
    }

}
