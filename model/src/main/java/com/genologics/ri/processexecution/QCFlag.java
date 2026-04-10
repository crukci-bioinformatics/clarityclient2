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

package com.genologics.ri.processexecution;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;

/**
 * Quality control flag enumeration for artifacts in process execution.
 * Represents the QC status of an artifact during or after processing.
 */
@XmlType(name = "qc-flag")
@XmlEnum
public enum QCFlag
{
    /**
     * QC status is unknown.
     */
    UNKNOWN,
    
    /**
     * QC check passed.
     */
    PASSED,
    
    /**
     * QC check failed.
     */
    FAILED,
    
    /**
     * Continue processing despite QC concerns.
     */
    CONTINUE;

    /**
     * Gets the string value of the enum constant.
     *
     * @return The name of this enum constant.
     */
    public String value()
    {
        return name();
    }

    /**
     * Converts a string value to a QCFlag enum constant.
     *
     * @param v The string value.
     * @return The corresponding QCFlag enum constant.
     */
    public static QCFlag fromValue(String v)
    {
        return valueOf(v);
    }

}
