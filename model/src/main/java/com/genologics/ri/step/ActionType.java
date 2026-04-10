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
 * Enumeration of action types that can be performed on artifacts in a step.
 */
@XmlType(name = "action-type")
@XmlEnum
public enum ActionType
{
    /**
     * Leave the artifact as is.
     */
    @XmlEnumValue("leave")
    LEAVE("leave"),

    /**
     * Repeat the action on the artifact.
     */
    @XmlEnumValue("repeat")
    REPEAT("repeat"),

    /**
     * Remove the artifact.
     */
    @XmlEnumValue("remove")
    REMOVE("remove"),

    /**
     * Review the artifact.
     */
    @XmlEnumValue("review")
    REVIEW("review"),

    /**
     * Complete the action.
     */
    @XmlEnumValue("complete")
    COMPLETE("complete"),

    /**
     * Store the artifact.
     */
    @XmlEnumValue("store")
    STORE("store"),

    /**
     * Move to the next step.
     */
    @XmlEnumValue("nextstep")
    NEXTSTEP("nextstep"),

    /**
     * Rework the artifact.
     */
    @XmlEnumValue("rework")
    REWORK("rework"),

    /**
     * Complete and repeat.
     */
    @XmlEnumValue("completerepeat")
    COMPLETE_REPEAT("completerepeat"),

    /**
     * Unknown action type.
     */
    @XmlEnumValue("unknown")
    UNKNOWN("unknown");

    /**
     * The string value of the action type.
     */
    private final String value;

    /**
     * Constructor.
     *
     * @param v The string value.
     */
    ActionType(String v)
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
     * Converts a string value to an ActionType.
     *
     * @param v The string value.
     * @return The corresponding ActionType.
     * @throws IllegalArgumentException if the value doesn't match any action type.
     */
    public static ActionType fromValue(String v)
    {
        for (ActionType c : ActionType.values())
        {
            if (c.value.equals(v))
            {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
