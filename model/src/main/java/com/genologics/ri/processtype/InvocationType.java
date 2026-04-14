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
 * Enumeration of EPP invocation types.
 * Specifies whether an EPP runs before or after process execution.
 */
@XmlType(name = "invocation-type")
@XmlEnum
public enum InvocationType
{
    /**
     * EPP runs after the process.
     */
    @XmlEnumValue("PostProcess")
    POST_PROCESS("PostProcess"),

    /**
     * EPP runs before the process.
     */
    @XmlEnumValue("PreProcess")
    PRE_PROCESS("PreProcess");

    /**
     * The XML value of the enumeration constant.
     */
    private final String value;

    /**
     * Constructs an invocation type with the specified value.
     *
     * @param v the XML value.
     */
    InvocationType(String v)
    {
        value = v;
    }

    /**
     * Gets the XML value of this invocation type.
     *
     * @return the XML value.
     */
    public String value()
    {
        return value;
    }

    /**
     * Gets the invocation type corresponding to the specified XML value.
     *
     * @param v the XML value.
     * @return the corresponding invocation type.
     * @throws IllegalArgumentException if no matching type is found.
     */
    public static InvocationType fromValue(String v)
    {
        for (InvocationType c : InvocationType.values())
        {
            if (c.value.equals(v))
            {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
