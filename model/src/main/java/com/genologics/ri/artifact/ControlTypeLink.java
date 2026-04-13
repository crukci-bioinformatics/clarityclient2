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

package com.genologics.ri.artifact;

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
import com.genologics.ri.controltype.ControlType;

/**
 *
 * Provide a URI linking to the control type if this artifact is a control
 * sample.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "control-type")
public class ControlTypeLink extends LimsLinkBase<ControlType>
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = -4203696627970925073L;

    /**
     * The URI of this control type.
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
     * Constructor taking a URI.
     *
     * @param uri The control type URI.
     */
    public ControlTypeLink(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructor from a Linkable.
     *
     * @param link The linkable object to copy.
     */
    public ControlTypeLink(Linkable<ControlType> link)
    {
        requireNonNull(link, "link cannot be null");
        this.uri = link.getUri();
    }

    /**
     * Gets the entity class.
     *
     * @return The ControlType class.
     */
    @Override
    public Class<ControlType> getEntityClass()
    {
        return ControlType.class;
    }

    /**
     * Gets the URI.
     *
     * @return The control type URI.
     */
    @Override
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI.
     *
     * @param value The control type URI.
     */
    @Override
    public void setUri(URI value)
    {
        this.uri = value;
    }

}
