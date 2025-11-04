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

package com.genologics.ri.globaltoken;

import java.io.Serializable;
import java.net.URI;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.genologics.ri.LimsLink;
import com.genologics.ri.Linkable;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "global-token", propOrder = { "name", "value", "description", "isCustom" })
public class GlobalToken implements Linkable<GlobalToken>, Serializable
{
    private static final long serialVersionUID = 8999326250541104054L;

    @XmlElement
    protected String name;

    @XmlElement
    protected String value;

    @XmlElement
    protected String description;

    @XmlElement(name = "is-custom")
    protected Boolean isCustom;

    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;


    public GlobalToken()
    {
    }

    public GlobalToken(URI uri)
    {
        this.uri = uri;
    }

    public GlobalToken(URI uri, String name)
    {
        this.uri = uri;
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public boolean isCustom()
    {
        return isCustom == null ? false : isCustom.booleanValue();
    }

    public void setCustom(Boolean isCustom)
    {
        this.isCustom = isCustom;
    }

    public URI getUri()
    {
        return uri;
    }

    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    @Override
    public String toString()
    {
        ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
        sb.append("name", name);
        sb.append("value", value);
        return sb.toString();
    }

    @Override
    public LimsLink<GlobalToken> getLink()
    {
        return new GlobalTokenLink(uri, name);
    }
}
