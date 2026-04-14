/*
 * CRUK-CI Clarity REST API Java Client.
 * Copyright (C) 2018 Cancer Research UK Cambridge Institute.
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

package com.genologics.ri.automation;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;

/**
 * The available options for the automation context.
 *
 * @since 2.26
 */
@XmlType(name = "context")
@XmlEnum
public enum Context
{
    /**
     * Step context.
     */
    STEP,

    /**
     * Derived sample context.
     *
     * @since 2.31
     */
    DERIVED_SAMPLE,

    /**
     * Project context.
     *
     * @since 2.31
     */
    PROJECT;

    /**
     * Gets the string value of this context.
     *
     * @return The context name.
     */
    public String value()
    {
        return name();
    }

    /**
     * Creates a Context from a string value.
     *
     * @param v The string value.
     * @return The corresponding Context.
     */
    public static Context fromValue(String v)
    {
        return valueOf(v);
    }
}
