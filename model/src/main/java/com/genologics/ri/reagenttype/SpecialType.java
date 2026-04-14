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

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * Special-type is a child element of reagent type and provides a name and
 * attributes describing a special type of reagent type.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "special-type")
public class SpecialType implements Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 2227997075421321531L;

    /**
     * The list of attributes for this special type.
     */
    @XmlElement(name = "attribute")
    protected List<Attribute> attributes;

    /**
     * The name of the special type.
     */
    @XmlAttribute(name = "name")
    protected String name;

    /**
     * Default constructor.
     */
    public SpecialType()
    {
    }

    /**
     * Constructor with name.
     *
     * @param name The name of the special type.
     */
    public SpecialType(String name)
    {
        this.name = name;
    }

    /**
     * Gets the list of attributes for this special type.
     *
     * @return A list of attributes.
     */
    public List<Attribute> getAttributes()
    {
        if (attributes == null)
        {
            attributes = new ArrayList<Attribute>();
        }
        return this.attributes;
    }

    /**
     * Adds an attribute to this special type.
     *
     * @param a The attribute to add.
     */
    public void addAttribute(Attribute a)
    {
        if (a != null)
        {
            getAttributes().add(a);
        }
    }

    /**
     * Adds an attribute to this special type using name and value.
     *
     * @param name The name of the attribute.
     * @param value The value of the attribute.
     */
    public void addAttribute(String name, String value)
    {
        getAttributes().add(new Attribute(name, value));
    }

    /**
     * Gets the name of the special type.
     *
     * @return The special type name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of the special type.
     *
     * @param value The special type name.
     */
    public void setName(String value)
    {
        this.name = value;
    }

}
