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

package com.genologics.ri.artifact;

import java.io.Serial;
import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;

/**
 * Reagent-label is a child element of Artifact and provides the name of a label
 * or reagent that has been added to the Artifact.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reagent-label")
public class ReagentLabel implements Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 7859734987217470470L;

    /**
     * The name of this reagent label.
     */
    @XmlAttribute(name = "name")
    protected String name;

    /**
     * Default constructor.
     */
    public ReagentLabel()
    {
    }

    /**
     * Constructor taking a name.
     *
     * @param name The reagent label name.
     */
    public ReagentLabel(String name)
    {
        this.name = name;
    }

    /**
     * Gets the name.
     *
     * @return The reagent label name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param value The reagent label name.
     */
    public void setName(String value)
    {
        this.name = value;
    }

    /**
     * Returns a string representation of this reagent label.
     *
     * @return The name, or "null" if not set.
     */
    @Override
    public String toString()
    {
        return name == null ? "null" : name;
    }
}
