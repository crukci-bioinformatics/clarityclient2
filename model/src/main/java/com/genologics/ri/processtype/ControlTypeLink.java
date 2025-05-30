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
 * @since 2.25
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "control-type-link")
public class ControlTypeLink implements LimsLink<ControlType>, Serializable
{
    private static final long serialVersionUID = 3029231159973544772L;

    @XmlAttribute(name = "name")
    protected String name;

    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;


    public ControlTypeLink()
    {
    }

    public ControlTypeLink(URI uri)
    {
        this.uri = uri;
    }

    public ControlTypeLink(URI uri, String name)
    {
        this.uri = uri;
        this.name = name;
    }

    public ControlTypeLink(Linkable<ControlType> link)
    {
        requireNonNull(link, "link cannot be null");
        this.uri = link.getUri();
    }

    public ControlTypeLink(ControlType controlType)
    {
        requireNonNull(controlType, "controlType cannot be null");
        this.uri = controlType.getUri();
        this.name = controlType.getName();
    }

    public URI getUri()
    {
        return uri;
    }

    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public Class<ControlType> getEntityClass()
    {
        return ControlType.class;
    }
}
