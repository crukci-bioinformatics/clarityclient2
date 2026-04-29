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

import static com.genologics.ri.Link.UNSET;

import java.io.Serial;
import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;

/**
 *
 * Reagent-label is a child element of ExtStepReagentListElement and provides
 * the name of a label or reagent that has been added to the Artifact.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reagent-label")
public class ReagentLabel implements Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial
    private static final long serialVersionUID = -5256319945578711720L;

    /**
     * The name of the reagent label.
     */
    @XmlAttribute(name = "name")
    protected String name;

    /**
     * Constructs a new empty ReagentLabel.
     */
    public ReagentLabel()
    {
    }

    /**
     * Constructs a new ReagentLabel with the given name.
     *
     * @param name the name of the reagent label.
     */
    public ReagentLabel(String name)
    {
        this.name = name;
    }

    /**
     * Gets the name of the reagent label.
     *
     * @return the name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of the reagent label.
     *
     * @param name the name.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Returns a string representation of the reagent label.
     *
     * @return the name, or "unset" if the name is null.
     */
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder(80);
        sb.append("ReagentLabel[").append(name == null ? UNSET : name).append(']');
        return sb.toString();
    }
}
