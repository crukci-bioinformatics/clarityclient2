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
import jakarta.xml.bind.annotation.XmlType;

/**
 * Enumeration of status values for a step.
 */
@XmlType(name = "status")
@XmlEnum
public enum Status
{
    /**
     * The step completed successfully.
     */
    OK,

    /**
     * The step completed with errors.
     */
    ERROR,

    /**
     * The step completed with warnings.
     */
    WARNING,

    /**
     * The step is currently running.
     */
    RUNNING,

    /**
     * The step is queued for execution.
     *
     * @since 2.18
     */
    QUEUED;


    /**
     * Gets the string value of the status.
     *
     * @return The name of the status.
     */
    public String value()
    {
        return name();
    }

    /**
     * Creates a status from a string value.
     *
     * @param v The string value of the status.
     *
     * @return The status corresponding to the value.
     *
     * @throws IllegalArgumentException if the value does not match any status.
     */
    public static Status fromValue(String v)
    {
        return valueOf(v);
    }

}
