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

import static java.util.Objects.requireNonNull;
import static org.apache.commons.lang3.StringUtils.SPACE;

import java.io.Serial;
import java.net.URI;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.genologics.ri.LimsLink;
import com.genologics.ri.LimsLinkBase;
import com.genologics.ri.Linkable;
import com.genologics.ri.controltype.ControlType;


/**
 * Link to a control type within a process type configuration.
 * Provides a URI linking to the detailed representation of a control type,
 * along with its name.
 *
 * @since 2.25
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "control-type-link")
public class ControlTypeLink extends LimsLinkBase<ControlType>
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 3029231159973544772L;

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
     * Constructs a new control type link.
     */
    public ControlTypeLink()
    {
    }

    /**
     * Constructs a new control type link with the specified URI.
     *
     * @param uri the URI of the control type.
     */
    public ControlTypeLink(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructs a new control type link with the specified URI and name.
     *
     * @param uri the URI of the control type.
     * @param name the name of the control type.
     */
    public ControlTypeLink(URI uri, String name)
    {
        this.uri = uri;
        this.name = name;
    }

    /**
     * Constructs a new control type link from a linkable object.
     *
     * @param link the linkable object providing the URI.
     */
    public ControlTypeLink(Linkable<ControlType> link)
    {
        requireNonNull(link, "link cannot be null");
        this.uri = link.getUri();
    }

    /**
     * Constructs a new control type link from a control type entity.
     *
     * @param controlType the control type entity.
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
     * @return the control type URI.
     */
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI of the control type.
     *
     * @param uri the control type URI.
     */
    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Gets the name of the control type.
     *
     * @return the control type name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of the control type.
     *
     * @param name the control type name.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Gets the entity class for this link.
     *
     * @return the ControlType class.
     */
    @Override
    public Class<ControlType> getEntityClass()
    {
        return ControlType.class;
    }

    /**
     * Returns a string representation of this link.
     *
     * @return The control type LIMS id and the name.
     */
    @Override
    public String toString()
    {
        ToStringBuilder b = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
        b.append("controlType", LimsLink.toString(this));
        b.append("name", name);
        return b.toString();
    }
}
