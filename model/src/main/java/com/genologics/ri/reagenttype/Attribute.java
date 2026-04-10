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

package com.genologics.ri.reagenttype;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;

/**
 *
 * Attribute is a child element of special type and provides a name-value pair
 * of the special type.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "attribute")
public class Attribute implements Serializable
{
    /**
     * Class version for serialisation.
     */
    @java.io.Serial
    private static final long serialVersionUID = -1114923515136408861L;

    /**
     * The name of the attribute.
     */
    @XmlAttribute(name = "name")
    protected String name;

    /**
     * The value of the attribute.
     */
    @XmlAttribute(name = "value")
    protected String value;


    /**
     * Default constructor.
     */
    public Attribute()
    {
    }

    /**
     * Constructor with name.
     *
     * @param name The attribute name.
     */
    public Attribute(String name)
    {
        this.name = name;
    }

    /**
     * Constructor with name and value.
     *
     * @param name The attribute name.
     * @param value The attribute value.
     */
    public Attribute(String name, String value)
    {
        this.name = name;
        this.value = value;
    }

    /**
     * Gets the name of the attribute.
     *
     * @return The attribute name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of the attribute.
     *
     * @param name The attribute name.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Gets the value of the attribute.
     *
     * @return The attribute value.
     */
    public String getValue()
    {
        return value;
    }

    /**
     * Sets the value of the attribute.
     *
     * @param value The attribute value.
     */
    public void setValue(String value)
    {
        this.value = value;
    }

}
