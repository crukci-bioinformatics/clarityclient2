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
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;

import org.apache.commons.lang3.ClassUtils;


/**
 * A field has a name and an attach to value,
 * these fields are used to keep track of all
 * the User Defined and Built In values for
 * samples in queue and work view as well as
 * those on the actual step
 *
 * @since 2.25
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "field")
@XmlSeeAlso({ QueueField.class, IceBucketField.class })
public class Field implements Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 7870381376405702078L;

    /**
     * The name of the field.
     */
    @XmlAttribute(name = "name")
    protected String name;

    /**
     * The entity to which this field is attached.
     */
    @XmlAttribute(name = "attach-to")
    protected String attachTo;

    /**
     * The style of the field (user-defined or built-in).
     */
    @XmlAttribute(name = "style")
    protected Style style;

    /**
     * Constructs a new field.
     */
    public Field()
    {
    }

    /**
     * Constructs a new field with the specified name.
     *
     * @param name the name of the field.
     */
    public Field(String name)
    {
        this.name = name;
    }

    /**
     * Gets the name of the field.
     *
     * @return the field name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of the field.
     *
     * @param name the field name.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Gets the entity to which this field is attached.
     *
     * @return the attach-to value.
     */
    public String getAttachTo()
    {
        return attachTo;
    }

    /**
     * Sets the entity to which this field is attached.
     *
     * @param attachTo the attach-to value.
     */
    public void setAttachTo(String attachTo)
    {
        this.attachTo = attachTo;
    }

    /**
     * Gets the style of the field.
     *
     * @return the field style.
     */
    public Style getStyle()
    {
        return style;
    }

    /**
     * Sets the style of the field.
     *
     * @param style the field style.
     */
    public void setStyle(Style style)
    {
        this.style = style;
    }

    /**
     * Returns a string representation of this field.
     *
     * @return a string containing the class name and field name.
     */
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder(32);
        sb.append(ClassUtils.getShortClassName(getClass()));
        if (name != null)
        {
            sb.append(':').append(name);
        }
        return sb.toString();
    }
}
