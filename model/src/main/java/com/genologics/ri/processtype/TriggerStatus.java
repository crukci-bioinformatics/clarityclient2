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
 * The trigger-status enumeration lists the possible values of the EPP Trigger status attribute.
 *
 * @since 2.25
 */
@XmlType(name = "trigger-status")
@XmlEnum
public enum TriggerStatus
{
    /**
     * The step has been started.
     */
    STARTED,

    /**
     * The step is in the setup phase.
     */
    STEP_SETUP,

    /**
     * The step is in the pooling phase.
     */
    POOLING,

    /**
     * The step is in the placement phase.
     */
    PLACEMENT,

    /**
     * The step is in the add reagent phase.
     */
    ADD_REAGENT,

    /**
     * The step is in the record details phase.
     */
    RECORD_DETAILS,

    /**
     * The step has been completed.
     */
    COMPLETE;

    /**
     * Gets the XML value of this trigger status.
     *
     * @return the XML value (the enum name).
     */
    public String value()
    {
        return name();
    }

    /**
     * Gets the trigger status corresponding to the specified XML value.
     *
     * @param v the XML value.
     * @return the corresponding trigger status.
     */
    public static TriggerStatus fromValue(String v)
    {
        return valueOf(v);
    }

}
