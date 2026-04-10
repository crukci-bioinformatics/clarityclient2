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

package com.genologics.ri.step;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;

/**
 * Enumeration of output generation types for step artifacts.
 *
 * @since 2.18
 */
@XmlType(name = "output-generation-type")
@XmlEnum
public enum OutputGenerationType
{
    /**
     * Generate one output per input.
     */
    @XmlEnumValue("PerInput")
    PER_INPUT("PerInput"),

    /**
     * Generate one output per all inputs.
     */
    @XmlEnumValue("PerAllInputs")
    PER_ALL_INPUTS("PerAllInputs"),

    /**
     * Generate one output per reagent label.
     */
    @XmlEnumValue("PerReagentLabel")
    PER_REAGENT_LABEL("PerReagentLabel");

    /**
     * The string value of the output generation type.
     */
    private final String value;

    /**
     * Constructor.
     *
     * @param v The string value.
     */
    private OutputGenerationType(String v)
    {
        value = v;
    }

    /**
     * Gets the string value.
     *
     * @return The string value.
     */
    public String value()
    {
        return value;
    }

    /**
     * Converts a string value to an OutputGenerationType.
     *
     * @param v The string value.
     * @return The corresponding OutputGenerationType.
     * @throws IllegalArgumentException if the value doesn't match any output generation type.
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
