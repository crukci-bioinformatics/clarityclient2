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

package com.genologics.ri.stepconfiguration;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


/**
 * EPP trigger configuration for the Protocol Step.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "epp-trigger")
public class EppTrigger extends LockableSetting
{
    /**
     * Class version for serialisation.
     */
    @java.io.Serial
    private static final long serialVersionUID = 8850458905996420686L;

    /**
     * The name of the EPP trigger.
     */
    @XmlAttribute(name = "name")
    protected String name;

    /**
     * The type of the EPP trigger.
     */
    @XmlAttribute(name = "type")
    protected TriggerType type;

    /**
     * The point when the EPP trigger executes.
     */
    @XmlAttribute(name = "point")
    protected TriggerPoint point;

    /**
     * The status at which the EPP trigger executes.
     */
    @XmlAttribute(name = "status")
    protected TriggerStatus status;


    /**
     * Gets the name of the EPP trigger.
     *
     * @return The EPP trigger name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of the EPP trigger.
     *
     * @param name The EPP trigger name.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Gets the type of the EPP trigger.
     *
     * @return The EPP trigger type.
     */
    public TriggerType getType()
    {
        return type;
    }

    /**
     * Sets the type of the EPP trigger.
     *
     * @param type The EPP trigger type.
     */
    public void setType(TriggerType type)
    {
        this.type = type;
    }

    /**
     * Gets the point when the EPP trigger executes.
     *
     * @return The trigger point.
     */
    public TriggerPoint getPoint()
    {
        return point;
    }

    /**
     * Sets the point when the EPP trigger executes.
     *
     * @param point The trigger point.
     */
    public void setPoint(TriggerPoint point)
    {
        this.point = point;
    }

    /**
     * Gets the status at which the EPP trigger executes.
     *
     * @return The trigger status.
     */
    public TriggerStatus getStatus()
    {
        return status;
    }

    /**
     * Sets the status at which the EPP trigger executes.
     *
     * @param status The trigger status.
     */
    public void setStatus(TriggerStatus status)
    {
        this.status = status;
    }


}
