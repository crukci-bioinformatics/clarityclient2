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
 * Enumeration of step statuses at which EPP triggers can execute.
 */
@XmlType(name = "trigger-status")
@XmlEnum
public enum TriggerStatus
{
    /**
     * Trigger executes when the step is started.
     */
    STARTED,

    /**
     * Trigger executes during step setup.
     */
    STEP_SETUP,

    /**
     * Trigger executes during pooling.
     */
    POOLING,

    /**
     * Trigger executes during placement.
     */
    PLACEMENT,

    /**
     * Trigger executes when adding reagents.
     */
    ADD_REAGENT,

    /**
     * Trigger executes when recording details.
     */
    RECORD_DETAILS,

    /**
     * Trigger executes when the step is completed.
     */
    COMPLETE;

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
     * Converts a string value to a TriggerStatus enum constant.
     *
     * @param v The string value.
     * @return The corresponding TriggerStatus enum constant.
     */
    public static TriggerStatus fromValue(String v)
    {
        return valueOf(v);
    }

}
