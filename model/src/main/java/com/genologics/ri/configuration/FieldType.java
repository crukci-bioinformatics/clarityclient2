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

package com.genologics.ri.configuration;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;

/**
 * UDF field types.
 */
@XmlType(name = "field-type")
@XmlEnum
public enum FieldType
{
    /**
     * String field type.
     */
    @XmlEnumValue("String")
    STRING("String"),

    /**
     * Text field type for longer text content.
     */
    @XmlEnumValue("Text")
    TEXT("Text"),

    /**
     * Boolean field type.
     */
    @XmlEnumValue("Boolean")
    BOOLEAN("Boolean"),

    /**
     * Numeric field type.
     */
    @XmlEnumValue("Numeric")
    NUMERIC("Numeric"),

    /**
     * Date field type.
     */
    @XmlEnumValue("Date")
    DATE("Date"),

    /**
     * URI field type.
     */
    @XmlEnumValue("URI")
    URI("URI");

    /**
     * The string value of this field type.
     */
    private final String value;

    /**
     * Constructor for FieldType enum values.
     *
     * @param v The string value.
     */
    FieldType(String v)
    {
        value = v;
    }

    /**
     * Gets the string value of this field type.
     *
     * @return The string value.
     */
    public String value()
    {
        return value;
    }

    /**
     * Gets the FieldType enum value from its string representation.
     *
     * @param v The string value.
     * @return The corresponding FieldType enum value.
     * @throws IllegalArgumentException if the value doesn't match any FieldType.
     */
    public static FieldType fromValue(String v)
    {
        for (FieldType c : FieldType.values())
        {
            if (c.value.equals(v))
            {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
