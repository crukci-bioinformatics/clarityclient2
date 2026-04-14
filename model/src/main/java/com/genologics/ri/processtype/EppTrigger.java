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

import java.io.Serial;
import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


/**
 * EPP trigger configuration for the Master Step.
 *
 * @since 2.25
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "epp-trigger")
public class EppTrigger implements Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 3481787346877063815L;

    /**
     * The name of the EPP trigger.
     */
    @XmlAttribute(name = "name")
    protected String name;

    /**
     * The type of the trigger (manual, automatic, or unused).
     */
    @XmlAttribute(name = "type")
    protected TriggerType type;

    /**
     * The point at which the trigger executes (before or after).
     */
    @XmlAttribute(name = "point")
    protected TriggerPoint point;

    /**
     * The status at which the trigger executes.
     */
    @XmlAttribute(name = "status")
    protected TriggerStatus status;

    /**
     * Constructs a new EPP trigger.
     */
    public EppTrigger()
    {
    }

    /**
     * Constructs a new EPP trigger with the specified name.
     *
     * @param name the name of the EPP trigger.
     */
    public EppTrigger(String name)
    {
        this.name = name;
    }

    /**
     * Gets the name of the EPP trigger.
     *
     * @return the EPP trigger name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of the EPP trigger.
     *
     * @param name the EPP trigger name.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Gets the type of the trigger.
     *
     * @return the trigger type.
     */
    public TriggerType getType()
    {
        return type;
    }

    /**
     * Sets the type of the trigger.
     *
     * @param type the trigger type.
     */
    public void setType(TriggerType type)
    {
        this.type = type;
    }

    /**
     * Gets the point at which the trigger executes.
     *
     * @return the trigger point.
     */
    public TriggerPoint getPoint()
    {
        return point;
    }

    /**
     * Sets the point at which the trigger executes.
     *
     * @param point the trigger point.
     */
    public void setPoint(TriggerPoint point)
    {
        this.point = point;
    }

    /**
     * Gets the status at which the trigger executes.
     *
     * @return the trigger status.
     */
    public TriggerStatus getStatus()
    {
        return status;
    }

    /**
     * Sets the status at which the trigger executes.
     *
     * @param status the trigger status.
     */
    public void setStatus(TriggerStatus status)
    {
        this.status = status;
    }
}
