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

package com.genologics.ri.processexecution;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.LimsEntityLinkable;
import com.genologics.ri.Location;
import com.genologics.ri.artifact.OutputType;
import com.genologics.ri.container.Container;

/**
 *
 * The output element provides information about the Artifacts that will be
 * created by the Process. Output is a child element of the input-output-map
 * element.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "output", propOrder = { "location" })
public class Output extends ArtifactBase
{
    /**
     * Class version for serialisation.
     */
    @java.io.Serial
    private static final long serialVersionUID = -923589090274221714L;

    /**
     * The location of the output artifact.
     */
    protected Location location;

    /**
     * The output type.
     */
    @XmlAttribute(name = "type")
    protected OutputType type;

    /**
     * Default constructor.
     */
    public Output()
    {
    }

    /**
     * Constructor with output type.
     *
     * @param type The output type.
     */
    public Output(OutputType type)
    {
        this.type = type;
    }

    /**
     * Constructor with output type, container, and position.
     *
     * @param type The output type.
     * @param container The container link.
     * @param position The position in the container.
     */
    public Output(OutputType type, LimsEntityLinkable<Container> container, String position)
    {
        this.type = type;
        setLocation(container, position);
    }

    /**
     * Gets the location of the output artifact.
     *
     * @return The location.
     */
    public Location getLocation()
    {
        return location;
    }

    /**
     * Sets the location of the output artifact.
     *
     * @param location The location to set.
     * @return The location that was set.
     */
    public Location setLocation(Location location)
    {
        this.location = location;
        return this.location;
    }

    /**
     * Sets the location of the output artifact with container and position.
     *
     * @param container The container link.
     * @param position The position in the container.
     * @return The created location.
     */
    public Location setLocation(LimsEntityLinkable<Container> container, String position)
    {
        this.location = container == null ? null : new Location(container, position);
        return this.location;
    }

    /**
     * Gets the output type.
     *
     * @return The output type.
     */
    public OutputType getType()
    {
        return type;
    }

    /**
     * Sets the output type.
     *
     * @param type The output type to set.
     */
    public void setType(OutputType type)
    {
        this.type = type;
    }


}
