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

package com.genologics.ri.containertype;

import java.io.Serial;
import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.XmlValue;

/**
 *
 * Calibrant-well is a child element of container type and identifies a well
 * location that is reserved for calibrants in containers of the container type.
 *
 * @deprecated This type is no longer supported.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "calibrant-well")
@Deprecated
public class CalibrantWell implements Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 218110772739169852L;

    /**
     * The name of the calibrant well.
     */
    @XmlAttribute(name = "name")
    protected String name;

    /**
     * The value or content of the calibrant well.
     */
    @XmlValue
    protected String value;


    /**
     * Default constructor for creating a new calibrant well.
     */
    public CalibrantWell()
    {
    }

    /**
     * Constructor for creating a calibrant well with a specified name.
     *
     * @param name The name of the calibrant well.
     */
    public CalibrantWell(String name)
    {
        this.name = name;
    }

    /**
     * Constructor for creating a calibrant well with a specified name and value.
     *
     * @param name The name of the calibrant well.
     * @param value The value or content of the calibrant well.
     */
    public CalibrantWell(String name, String value)
    {
        this.name = name;
        this.value = value;
    }

    /**
     * Gets the value or content of the calibrant well.
     *
     * @return The calibrant well value.
     */
    public String getValue()
    {
        return value;
    }

    /**
     * Sets the value or content of the calibrant well.
     *
     * @param value The calibrant well value to set.
     */
    public void setValue(String value)
    {
        this.value = value;
    }

    /**
     * Gets the name of the calibrant well.
     *
     * @return The calibrant well name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of the calibrant well.
     *
     * @param name The calibrant well name to set.
     */
    public void setName(String name)
    {
        this.name = name;
    }

}
