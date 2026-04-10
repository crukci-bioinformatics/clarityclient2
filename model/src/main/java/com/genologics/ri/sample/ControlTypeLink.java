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

package com.genologics.ri.sample;

import static java.util.Objects.requireNonNull;

import java.io.Serializable;
import java.net.URI;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.LimsLink;
import com.genologics.ri.Linkable;
import com.genologics.ri.controltype.ControlType;

/**
 *
 * Control Type provides a name and a URI linking to the detailed representation
 * of the Control Type associated with the Sample. If a Control Type is
 * associated, the Sample will not have an associated Project.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "controlType")
public class ControlTypeLink implements LimsLink<ControlType>, Serializable
{
    /**
     * Class version for serialisation.
     */
    @java.io.Serial
    private static final long serialVersionUID = 4125221399101385098L;

    /**
     * The URI of the control type.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * The name of the control type.
     */
    @XmlAttribute(name = "name")
    protected String name;

    /**
     * Constructor for an empty control type link.
     */
    public ControlTypeLink()
    {
    }

    /**
     * Constructor for a control type link with a URI.
     *
     * @param uri The URI of the control type.
     */
    public ControlTypeLink(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructor for a control type link with a URI and name.
     *
     * @param uri The URI of the control type.
     * @param name The name of the control type.
     */
    public ControlTypeLink(URI uri, String name)
    {
        this.uri = uri;
        this.name = name;
    }

    /**
     * Constructor for a control type link from a linkable control type.
     *
     * @param link The linkable control type.
     */
    public ControlTypeLink(Linkable<ControlType> link)
    {
        requireNonNull(link, "link cannot be null");
        this.uri = link.getUri();
    }

    /**
     * Constructor for a control type link from a control type entity.
     *
     * @param controlType The control type entity.
     */
    public ControlTypeLink(ControlType controlType)
    {
        requireNonNull(controlType, "controlType cannot be null");
        this.uri = controlType.getUri();
        this.name = controlType.getName();
    }

    /**
     * Gets the URI of the control type.
     *
     * @return The control type URI.
     */
    @Override
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI of the control type.
     *
     * @param value The control type URI.
     */
    @Override
    public void setUri(URI value)
    {
        this.uri = value;
    }

    /**
     * Gets the entity class for this link.
     *
     * @return The ControlType class.
     */
    @Override
    public Class<ControlType> getEntityClass()
    {
        return ControlType.class;
    }

    /**
     * Gets the name of the control type.
     *
     * @return The control type name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of the control type.
     *
     * @param name The control type name.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Returns a string representation of this control type link.
     *
     * @return The control type name.
     */
    @Override
    public String toString()
    {
        return name;
    }
}
