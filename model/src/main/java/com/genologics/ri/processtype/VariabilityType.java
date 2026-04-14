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
 * Enumeration of variability types for process outputs.
 * Specifies how the process determines the number of outputs to generate.
 */
@XmlType(name = "variability-type")
@XmlEnum
public enum VariabilityType
{
    /**
     * A fixed number of outputs is generated.
     */
    @XmlEnumValue("Fixed")
    FIXED("Fixed"),

    /**
     * A variable number of outputs is generated.
     */
    @XmlEnumValue("Variable")
    VARIABLE("Variable"),

    /**
     * The number of outputs varies based on the input.
     */
    @XmlEnumValue("VariableByInput")
    VARIABLE_BY_INPUT("VariableByInput");

    /**
     * The XML value of the enumeration constant.
     */
    private final String value;

    /**
     * Constructs a variability type with the specified value.
     *
     * @param v the XML value.
     */
    VariabilityType(String v)
    {
        value = v;
    }

    /**
     * Gets the XML value of this variability type.
     *
     * @return the XML value.
     */
    public String value()
    {
        return value;
    }

    /**
     * Gets the variability type corresponding to the specified XML value.
     *
     * @param v the XML value.
     * @return the corresponding variability type.
     * @throws IllegalArgumentException if no matching type is found.
     */
    public static VariabilityType fromValue(String v)
    {
        for (VariabilityType c : VariabilityType.values())
        {
            if (c.value.equals(v))
            {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
