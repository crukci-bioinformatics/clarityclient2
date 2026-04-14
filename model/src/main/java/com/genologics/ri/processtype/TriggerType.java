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
import jakarta.xml.bind.annotation.XmlType;

/**
 * The trigger-type enumeration lists the possible values of the EPP Trigger type attribute.
 *
 * @since 2.25
 */
@XmlType(name = "trigger-type")
@XmlEnum
public enum TriggerType
{
    /**
     * The trigger must be invoked manually.
     */
    MANUAL,

    /**
     * The trigger is invoked automatically.
     */
    AUTOMATIC,

    /**
     * The trigger is not currently used.
     */
    UNUSED;

    /**
     * Gets the XML value of this trigger type.
     *
     * @return the XML value (the enum name).
     */
    public String value()
    {
        return name();
    }

    /**
     * Gets the trigger type corresponding to the specified XML value.
     *
     * @param v the XML value.
     * @return the corresponding trigger type.
     */
    public static TriggerType fromValue(String v)
    {
        return valueOf(v);
    }

}
