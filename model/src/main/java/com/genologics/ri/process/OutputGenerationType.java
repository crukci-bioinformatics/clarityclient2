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

package com.genologics.ri.process;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;

/**
 * The output generation type enumeration.
 * Defines how outputs are generated from inputs in a process.
 */
@XmlType(name = "output-generation-type")
@XmlEnum
public enum OutputGenerationType
{
    /**
     * One output per input.
     */
    @XmlEnumValue("PerInput")
    PER_INPUT("PerInput"),

    /**
     * One output for all inputs.
     */
    @XmlEnumValue("PerAllInputs")
    PER_ALL_INPUTS("PerAllInputs"),

    /**
     * One output per reagent label.
     */
    @XmlEnumValue("PerReagentLabel")
    PER_REAGENT_LABEL("PerReagentLabel");

    /**
     * The XML value.
     */
    private final String value;

    /**
     * Constructor.
     *
     * @param v The XML value.
     */
    OutputGenerationType(String v)
    {
        value = v;
    }

    /**
     * Gets the XML value.
     *
     * @return The XML value.
     */
    public String value()
    {
        return value;
    }

    /**
     * Converts from an XML value to an enum constant.
     *
     * @param v The XML value.
     *
     * @return The enum constant.
     *
     * @throws IllegalArgumentException if the value is not recognized.
     */
    public static OutputGenerationType fromValue(String v)
    {
        for (OutputGenerationType c : OutputGenerationType.values())
        {
            if (c.value.equals(v))
            {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
