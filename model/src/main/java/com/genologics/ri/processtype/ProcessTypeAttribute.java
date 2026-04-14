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

package com.genologics.ri.processtype;

import java.io.Serial;
import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.XmlValue;

/**
 *
 * Process-type-attributes is a child element of process type containing
 * key/value pairs for setting specific attributes that can be set for process
 * types. This information contains internally used parameters that will change.
 * These parameters are suitable for use when copying process types, but should
 * not be manipulated.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "process-type-attribute")
public class ProcessTypeAttribute implements Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 2626426609413434344L;

    /**
     * The value of the attribute.
     */
    @XmlValue
    protected String value;

    /**
     * The name of the attribute.
     */
    @XmlAttribute(name = "name")
    protected String name;

    /**
     * Constructs a new process type attribute.
     */
    public ProcessTypeAttribute()
    {
    }

    /**
     * Constructs a new process type attribute with the specified name.
     *
     * @param name the name of the attribute.
     */
    public ProcessTypeAttribute(String name)
    {
        this.name = name;
    }

    /**
     * Constructs a new process type attribute with the specified name and value.
     *
     * @param name the name of the attribute.
     * @param value the value of the attribute.
     */
    public ProcessTypeAttribute(String name, String value)
    {
        this.name = name;
        this.value = value;
    }

    /**
     * Gets the value of the attribute.
     *
     * @return the attribute value.
     */
    public String getValue()
    {
        return value;
    }

    /**
     * Sets the value of the attribute.
     *
     * @param value the attribute value.
     */
    public void setValue(String value)
    {
        this.value = value;
    }

    /**
     * Gets the name of the attribute.
     *
     * @return the attribute name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of the attribute.
     *
     * @param name the attribute name.
     */
    public void setName(String name)
    {
        this.name = name;
    }

}
