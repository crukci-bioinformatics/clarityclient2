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

package com.genologics.ri.containertype;

import java.io.Serial;
import java.io.Serializable;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.ClarityEntity;
import com.genologics.ri.LimsLink;
import com.genologics.ri.Linkable;

/**
 *
 * The detailed representation of a container type.
 * <p>
 * The container type describes the physical characteristics of a class of
 * containers such as the number of wells in the container as well as describing
 * the coordinate system used for identifying those wells.
 * </p>
 * <p>
 * The container type is described using a rectangular coordinate system. The
 * characteristics of the horizontal axis are described by the x-dimension
 * element, and the characteristics of the vertical dimension are described by
 * the y-dimension child elements. The characteristics of each dimension
 * included both the size in that dimension as well as the identification method
 * for values in that dimension. Values can be identified either numerically
 * where 0 is the first item or alphabetically where A is the first element.
 * Additionally an offset can be specified which shifts the value of the first
 * element by a fixed amount. When a well location is represented using the
 * coordinate system, it is shown as Y-Value:X-Value (for example A:1).
 *
 * <p>
 * The following are examples of the coordinate system:
 * </p>
 * <ul>
 * <li>Y-Dimension: alphabetic, size 1, offset 0. X-Dimension: numeric, size 1,
 * offset 0. Size: 1. Valid value: A:0</li>
 * <li>Y-Dimension: alphabetic, size 12, offset 0. X-Dimension: numeric, size 8,
 * offset 0. Size: 96. Valid values: A:0 ... L:7</li>
 * <li>Y-Dimension: alphabetic, size 8, offset 0. X-Dimension: numeric, size 12,
 * offset 1. Size: 96. Valid values: A:1 ... H:12</li>
 * </ul>
 * <p>
 * The container type also identifies wells in the container that are not available for storing
 * samples or reagents, either because the configuration of the container requires those wells to
 * be empty for the instrument configuration or because the well contains specific calibrants that
 * are required by the instrument. The well location of the unavailable wells is specified
 * using the coordinate system that is described by the x-dimension and y-dimension of the container
 * type.
 * </p>
 * <p>
 * <i>Note: calibrant-well is no longer supported and will be ignored if provided.</i>
 * </p>
 */
@ClarityEntity(uriSection = "containertypes", creatable = true, updateable = true)
@XmlRootElement(name = "container-type")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "container-type",
         propOrder = { "tube", "calibrantWells", "unavailableWells", "columns", "rows" })
public class ContainerType implements Linkable<ContainerType>, Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = -3778472967085446652L;

    /**
     * Indicates whether this container type represents a tube (single well) or a multi-well container.
     */
    @XmlElement(name = "is-tube")
    protected Boolean tube;

    /**
     * List of calibrant wells that are reserved for calibrants in containers of this type.
     *
     * @deprecated This property is no longer supported and will be ignored if provided.
     */
    @XmlElement(name = "calibrant-well")
    @Deprecated
    protected List<CalibrantWell> calibrantWells;

    /**
     * List of well locations that are not available for storing samples or reagents.
     * Well locations are specified using the coordinate system defined by the x-dimension and y-dimension.
     */
    @XmlElement(name = "unavailable-well")
    protected List<String> unavailableWells;

    /**
     * The x-dimension (horizontal/columns) of the container's coordinate system.
     */
    @XmlElement(name = "x-dimension")
    protected Dimension columns;

    /**
     * The y-dimension (vertical/rows) of the container's coordinate system.
     */
    @XmlElement(name = "y-dimension")
    protected Dimension rows;

    /**
     * The name of the container type.
     */
    @XmlAttribute(name = "name")
    protected String name;

    /**
     * The URI for accessing this container type resource.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * Checks if this container type represents a tube (single well container).
     *
     * @return {@code true} if this is a tube, {@code false} if it is a multi-well container.
     */
    public Boolean isTube()
    {
        return tube;
    }

    /**
     * Sets whether this container type represents a tube.
     *
     * @param tube {@code true} if this is a tube, {@code false} if it is a multi-well container.
     */
    public void setTube(Boolean tube)
    {
        this.tube = tube;
    }

    /**
     * Each calibrant well identifies a well location that is reserved for calibrants in containers of the container type.
     *
     * @deprecated This property is no longer supported and will be ignored if provided.
     *
     * @return A list of calibrant wells.
     */
    @Deprecated
    public List<CalibrantWell> getCalibrantWells()
    {
        if (calibrantWells == null)
        {
            calibrantWells = new ArrayList<CalibrantWell>();
        }
        return calibrantWells;
    }

    /**
     * Gets the list of unavailable wells for this container type.
     * <p>
     * Unavailable wells are locations that are not available for storing samples or reagents,
     * either because they must remain empty for instrument configuration or contain specific
     * calibrants required by the instrument. Well locations are specified using the coordinate
     * system defined by the x-dimension and y-dimension.
     * </p>
     *
     * @return The list of unavailable well locations. Never {@code null}.
     */
    public List<String> getUnavailableWells()
    {
        if (unavailableWells == null)
        {
            unavailableWells = new ArrayList<String>();
        }
        return unavailableWells;
    }

    /**
     * Gets the name of the container type.
     *
     * @return The container type name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of the container type.
     *
     * @param name The container type name to set.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Gets the URI for accessing this container type resource.
     *
     * @return The container type URI.
     */
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI for this container type.
     *
     * @param uri The container type URI to set.
     */
    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Gets the x-dimension (horizontal/columns) of the container's coordinate system.
     *
     * @return The column dimension specification.
     */
    public Dimension getColumns()
    {
        return columns;
    }

    /**
     * Sets the x-dimension (horizontal/columns) of the container's coordinate system.
     *
     * @param columns The column dimension specification to set.
     */
    public void setColumns(Dimension columns)
    {
        this.columns = columns;
    }

    /**
     * Gets the y-dimension (vertical/rows) of the container's coordinate system.
     *
     * @return The row dimension specification.
     */
    public Dimension getRows()
    {
        return rows;
    }

    /**
     * Sets the y-dimension (vertical/rows) of the container's coordinate system.
     *
     * @param rows The row dimension specification to set.
     */
    public void setRows(Dimension rows)
    {
        this.rows = rows;
    }

    /**
     * Get the capacity of a container of this type, i.e. the columns * rows.
     *
     * @return The capacity (number of lanes/wells). If this cannot be calculated
     * through missing values, returns null.
     *
     * @since 2.31.2
     */
    public Integer getCapacity()
    {
        try
        {
            return columns.getSize() * rows.getSize();
        }
        catch (NullPointerException e)
        {
            return null;
        }
    }

    /**
     * Returns a string representation of this container type, which is its name.
     *
     * @return The container type name.
     */
    @Override
    public String toString()
    {
        return name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LimsLink<ContainerType> getLink()
    {
        return new ContainerTypeLink(this);
    }
}
