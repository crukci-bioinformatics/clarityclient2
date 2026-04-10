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

import java.io.Serial;
import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;

/**
 * A protocol step setting is considered locked if the Master Step has defined
 * that setting.
 *
 * @since 2.25
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "lockable-setting")
@XmlSeeAlso({ StepSetup.class, EppTrigger.class, Field.class,
              ControlTypeLink.class, ReagentKitLink.class, StepProperty.class })
public class LockableSetting implements Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 1977151383272159438L;

    /**
     * Indicates whether this setting is locked by the master step.
     */
    @XmlAttribute(name = "locked")
    protected Boolean locked;


    /**
     * Default constructor.
     */
    public LockableSetting()
    {
    }

    /**
     * Gets whether this setting is locked by the master step.
     *
     * @return True if locked, false otherwise.
     */
    public Boolean isLocked()
    {
        return locked;
    }

    /**
     * Sets whether this setting is locked by the master step.
     *
     * @param value True to lock, false to unlock.
     */
    public void setLocked(Boolean value)
    {
        this.locked = value;
    }

}
