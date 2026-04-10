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
 *
 * A field has a name and an attach to value, these fields are used to keep
 * track of all the UDF values for samples in queue and work view as well as
 * those on the actual step
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "queuefield")
public class QueueField extends Field
{
    /**
     * Class version for serialisation.
     */
    @java.io.Serial
    private static final long serialVersionUID = -3020055581011697956L;

    /**
     * Indicates whether this queue field should be shown in detail view.
     */
    @XmlAttribute(name = "detail")
    protected Boolean detail;


    /**
     * Default constructor.
     */
    public QueueField()
    {
    }

    /**
     * Constructor with field name.
     *
     * @param name The field name.
     */
    public QueueField(String name)
    {
        super(name);
    }

    /**
     * Constructor with field name and attach-to value.
     *
     * @param name The field name.
     * @param attachTo What entity this field is attached to.
     */
    public QueueField(String name, String attachTo)
    {
        super(name, attachTo);
    }

    /**
     * Constructor with field name, attach-to value, and detail flag.
     *
     * @param name The field name.
     * @param attachTo What entity this field is attached to.
     * @param detail Whether to show in detail view.
     */
    public QueueField(String name, String attachTo, Boolean detail)
    {
        super(name, attachTo);
        this.detail = detail;
    }

    /**
     * Gets whether this field should be shown in detail view.
     *
     * @return True if shown in detail view, false otherwise.
     */
    public Boolean getDetail()
    {
        return detail;
    }

    /**
     * Sets whether this field should be shown in detail view.
     *
     * @param detail True to show in detail view, false otherwise.
     */
    public void setDetail(Boolean detail)
    {
        this.detail = detail;
    }


}
