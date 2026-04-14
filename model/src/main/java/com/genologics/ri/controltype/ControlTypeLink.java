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
import java.net.URI;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.LimsLinkBase;
import com.genologics.ri.Linkable;

/**
 * Control-type-link is a child element type of controlTypes and provides a URI
 * linking to the detailed representation of a ControlType.
 * <p>
 * This class serves as a lightweight reference to a full ControlType entity,
 * containing only the essential information (URI and name) needed for linking
 * purposes in API responses.
 * </p>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "control-type-link")
public class ControlTypeLink extends LimsLinkBase<ControlType>
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

    /**
     * Gets the URI of the control type.
     *
     * @return The URI of the control type resource.
     */
    @Override
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI of the control type.
     *
     * @param uri The URI of the control type resource.
     */
    @Override
    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Gets the entity class that this link refers to.
     *
     * @return The ControlType class.
     */
    @Override
    public Class<ControlType> getEntityClass()
    {
        return ControlType.class;
    }

    /**
     * Returns a string representation of this control type link.
     *
     * @return The name of the control type.
     */
    @Override
    public String toString()
    {
        return name;
    }
}
