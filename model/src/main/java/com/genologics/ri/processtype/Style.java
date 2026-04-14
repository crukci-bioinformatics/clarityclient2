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
 * The different styles of Fields.
 *
 * @since 2.25
 */
@XmlType(name = "style")
@XmlEnum
public enum Style
{
    /**
     * User-defined field.
     */
    USER_DEFINED,

    /**
     * Built-in field.
     */
    BUILT_IN;

    /**
     * Gets the XML value of this style.
     *
     * @return the XML value (the enum name).
     */
    public String value()
    {
        return name();
    }

    /**
     * Gets the style corresponding to the specified XML value.
     *
     * @param v the XML value.
     * @return the corresponding style.
     */
    public static Style fromValue(String v)
    {
        return valueOf(v);
    }

}
