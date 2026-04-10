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

import java.io.Serial;
import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Provides the row and column location within a Tube Rack.
 *
 * @since 2.34
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rack-location", propOrder = { "rackIndex", "rackRow", "rackColumn" })
public class RackLocation implements Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial
    private static final long serialVersionUID = 1531522948721112254L;

    /**
     * The index of the rack.
     */
    @XmlElement(name = "rack-index")
    protected Integer rackIndex;

    /**
     * The row position within the rack.
     */
    @XmlElement(name = "rack-row")
    protected Integer rackRow;

    /**
     * The column position within the rack.
     */
    @XmlElement(name = "rack-column")
    protected Integer rackColumn;

    /**
     * Constructs a new empty RackLocation.
     */
    public RackLocation()
    {
    }

    /**
     * Gets the index of the rack.
     *
     * @return the rack index.
     */
    public Integer getRackIndex()
    {
        return rackIndex;
    }

    /**
     * Sets the index of the rack.
     *
     * @param rackIndex the rack index.
     */
    public void setRackIndex(Integer rackIndex)
    {
        this.rackIndex = rackIndex;
    }

    /**
     * Gets the row position within the rack.
     *
     * @return the rack row.
     */
    public Integer getRackRow()
    {
        return rackRow;
    }

    /**
     * Sets the row position within the rack.
     *
     * @param rackRow the rack row.
     */
    public void setRackRow(Integer rackRow)
    {
        this.rackRow = rackRow;
    }

    /**
     * Gets the column position within the rack.
     *
     * @return the rack column.
     */
    public Integer getRackColumn()
    {
        return rackColumn;
    }

    /**
     * Sets the column position within the rack.
     *
     * @param rackColumn the rack column.
     */
    public void setRackColumn(Integer rackColumn)
    {
        this.rackColumn = rackColumn;
    }
}
