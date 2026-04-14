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

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;

/**
 * Enumeration of output generation types for process outputs.
 * Specifies how outputs are generated in relation to inputs.
 */
@XmlType(name = "output-generation-type")
@XmlEnum
public enum OutputGenerationType
{
    /**
     * One output is generated per input.
     */
    @XmlEnumValue("PerInput")
    PER_INPUT("PerInput"),

    /**
     * One output is generated for all inputs combined.
     */
    @XmlEnumValue("PerAllInputs")
    PER_ALL_INPUTS("PerAllInputs"),

    /**
     * Outputs are generated based on reagent labels.
     */
    @XmlEnumValue("PerReagentLabel")
    PER_REAGENT_LABEL("PerReagentLabel");

    /**
     * The XML value of the enumeration constant.
     */
    private final String value;

    /**
     * Constructs an output generation type with the specified value.
     *
     * @param v the XML value.
     */
    OutputGenerationType(String v)
    {
        value = v;
    }

    /**
     * Gets the XML value of this output generation type.
     *
     * @return the XML value.
     */
    public String value()
    {
        return value;
    }

    /**
     * Gets the output generation type corresponding to the specified XML value.
     *
     * @param v the XML value.
     * @return the corresponding output generation type.
     * @throws IllegalArgumentException if no matching type is found.
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
