
package com.genologics.ri.step;

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
    private static final long serialVersionUID = 1531522948721112254L;

    @XmlElement(name = "rack-index")
    protected Integer rackIndex;

    @XmlElement(name = "rack-row")
    protected Integer rackRow;

    @XmlElement(name = "rack-column")
    protected Integer rackColumn;

    public RackLocation() {}

    public Integer getRackIndex()
    {
        return rackIndex;
    }

    public void setRackIndex(Integer rackIndex)
    {
        this.rackIndex = rackIndex;
    }

    public Integer getRackRow()
    {
        return rackRow;
    }

    public void setRackRow(Integer rackRow)
    {
        this.rackRow = rackRow;
    }

    public Integer getRackColumn()
    {
        return rackColumn;
    }

    public void setRackColumn(Integer rackColumn)
    {
        this.rackColumn = rackColumn;
    }
}
