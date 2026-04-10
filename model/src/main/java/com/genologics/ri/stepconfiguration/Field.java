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

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;

/**
 * A field has a name and an attach to value, these fields are used to keep track of all
 * the User Defined and Built In values for samples in queue and work view as well as
 * those on the actual step.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "field")
@XmlSeeAlso({ QueueField.class, IceBucketField.class })
public class Field extends LockableSetting
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 2627702301901466857L;

    /**
     * The name of the field.
     */
    @XmlAttribute(name = "name")
    protected String name;

    /**
     * Defines what entity this field is attached to.
     */
    @XmlAttribute(name = "attach-to")
    protected String attachTo;

    /**
     * The style of the field (user-defined or built-in).
     *
     * @since 2.23
     */
    @XmlAttribute(name = "style")
    protected Style style;

    /**
     * Default constructor.
     */
    public Field()
    {
    }

    /**
     * Constructor with field name.
     *
     * @param name The field name.
     */
    public Field(String name)
    {
        this.name = name;
    }

    /**
     * Constructor with field name and attach-to value.
     *
     * @param name The field name.
     * @param attachTo What entity this field is attached to.
     */
    public Field(String name, String attachTo)
    {
        this.name = name;
        this.attachTo = attachTo;
    }

    /**
     * Gets the name of the field.
     *
     * @return The field name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of the field.
     *
     * @param name The field name.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Gets the attach-to value indicating what entity this field is attached to.
     *
     * @return The attach-to value.
     */
    public String getAttachTo()
    {
        return attachTo;
    }

    /**
     * Sets the attach-to value indicating what entity this field is attached to.
     *
     * @param attachTo The attach-to value.
     */
    public void setAttachTo(String attachTo)
    {
        this.attachTo = attachTo;
    }

    /**
     * Gets the style of the field.
     *
     * @return The field style.
     */
    public Style getStyle()
    {
        return style;
    }

    /**
     * Sets the style of the field.
     *
     * @param style The field style.
     */
    public void setStyle(Style style)
    {
        this.style = style;
    }
}
