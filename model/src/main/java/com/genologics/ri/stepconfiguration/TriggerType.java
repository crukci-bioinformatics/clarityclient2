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

package com.genologics.ri.stepconfiguration;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;

/**
 * Enumeration of EPP trigger types.
 */
@XmlType(name = "trigger-type")
@XmlEnum
public enum TriggerType
{
    /**
     * Manual trigger that must be invoked by a user.
     */
    MANUAL,

    /**
     * Automatic trigger that executes automatically.
     */
    AUTOMATIC,

    /**
     * Unused trigger.
     */
    UNUSED;

    /**
     * Gets the value of this enum constant.
     *
     * @return The name of this enum constant.
     */
    public String value()
    {
        return name();
    }

    /**
     * Converts a string value to a TriggerType enum constant.
     *
     * @param v The string value.
     * @return The corresponding TriggerType enum constant.
     */
    public static TriggerType fromValue(String v)
    {
        return valueOf(v);
    }

}
