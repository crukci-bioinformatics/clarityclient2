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

package com.genologics.ri.controltype;

import static java.util.Objects.requireNonNull;

import java.io.Serial;
import java.io.Serializable;
import java.net.URI;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.LimsLink;
import com.genologics.ri.Linkable;

/**
 * Control-type-link is a child element type of controlTypes and provides a URI
 * linking to the detailed representation of a ControlType.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "control-type-link")
public class ControlTypeLink implements LimsLink<ControlType>, Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 7850681628082855516L;

    /**
     * The name of the control type.
     */
    @XmlAttribute(name = "name")
    protected String name;

    /**
     * The URI of the control type.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;


    /**
     * Default constructor.
     */
    public ControlTypeLink()
    {
    }

    /**
     * Constructs a control type link with the specified URI.
     *
     * @param uri The URI.
     */
    public ControlTypeLink(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructs a control type link with the specified URI and name.
     *
     * @param uri The URI.
     * @param name The name.
     */
    public ControlTypeLink(URI uri, String name)
    {
        this.uri = uri;
        this.name = name;
    }

    /**
     * Constructs a control type link from a linkable object.
     *
     * @param link The linkable object.
     */
    public ControlTypeLink(Linkable<ControlType> link)
    {
        requireNonNull(link, "link cannot be null");
        this.uri = link.getUri();
    }

    /**
     * Constructs a control type link from a control type object.
     *
     * @param controlType The control type.
     */
    public ControlTypeLink(ControlType controlType)
    {
        requireNonNull(controlType, "controlType cannot be null");
        this.uri = controlType.getUri();
        this.name = controlType.getName();
    }

    /**
     * Gets the name of the control type.
     *
     * @return The name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of the control type.
     *
     * @param name The name.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public URI getUri()
    {
        return uri;
    }

    @Override
    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    @Override
    public Class<ControlType> getEntityClass()
    {
        return ControlType.class;
    }

    @Override
    public String toString()
    {
        return name;
    }
}
