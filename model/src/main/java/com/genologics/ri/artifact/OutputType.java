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

package com.genologics.ri.artifact;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;

/**
 * Enumeration of artifact output types.
 */
@XmlEnum
public enum OutputType
{
    /**
     * Sample output type.
     */
    @XmlEnumValue("Sample")
    SAMPLE("Sample"),

    /**
     * Analyte output type.
     */
    @XmlEnumValue("Analyte")
    ANALYTE("Analyte"),

    /**
     * Result file output type.
     */
    @XmlEnumValue("ResultFile")
    RESULT_FILE("ResultFile"),

    /**
     * Shared result file output type.
     */
    @XmlEnumValue("SharedResultFile")
    SHARED_RESULT_FILE("SharedResultFile"),

    /**
     * Search result file output type.
     */
    @XmlEnumValue("SearchResultFile")
    SEARCH_RESULT_FILE("SearchResultFile"),

    /**
     * Spot list output type.
     */
    @XmlEnumValue("SpotList")
    SPOT_LIST("SpotList");

    /**
     * The string value of this output type.
     */
    private final String value;

    /**
     * Constructor.
     *
     * @param v The string value.
     */
    OutputType(String v)
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
     * Gets the OutputType from a string value.
     *
     * @param v The string value.
     * @return The corresponding OutputType.
     * @throws NullPointerException if v is null.
     * @throws IllegalArgumentException if v is not a valid output type.
     */
    public static OutputType fromValue(String v)
    {
        if (v == null)
        {
            throw new NullPointerException("Output type cannot be null");
        }

        for (OutputType c : OutputType.values())
        {
            if (c.value.equals(v))
            {
                return c;
            }
        }
        throw new IllegalArgumentException("'" + v + "' is not a known output type.");
    }

}
