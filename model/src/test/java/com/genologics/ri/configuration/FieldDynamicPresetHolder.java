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

package com.genologics.ri.configuration;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * A class that's not in the API but can be used as a root element to check
 * that the serialisation of {@link FieldDynamicPreset} and {@link FieldDynamicPresetDetails}
 * works. When there is something in the API that actually uses these types,
 * this field is unnecessary.
 */
@XmlType(name = "fieldDynamicPresetHolder")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "dynamic-preset-holder")
public class FieldDynamicPresetHolder implements Serializable
{
    private static final long serialVersionUID = 638758143207691588L;

    @XmlElement(name = "details")
    FieldDynamicPresetDetails details;

    public FieldDynamicPresetHolder()
    {
    }

    public FieldDynamicPresetDetails getDetails()
    {
        return details;
    }

    public void setDetails(FieldDynamicPresetDetails details)
    {
        this.details = details;
    }
}
