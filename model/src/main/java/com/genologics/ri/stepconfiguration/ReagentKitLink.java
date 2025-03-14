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

import static java.util.Objects.requireNonNull;

import java.net.URI;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.LimsLink;
import com.genologics.ri.Linkable;
import com.genologics.ri.reagentkit.ReagentKit;

/**
 *
 * Reagent-Kit-Link is an element providing a URI linking to the detailed
 * representation of a reagent kit.
 *
 * @since 2.18
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reagent-kit-link")
public class ReagentKitLink extends LockableSetting implements LimsLink<ReagentKit>
{
    private static final long serialVersionUID = -6108166879985602695L;

    @XmlAttribute(name = "name")
    protected String name;

    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    public ReagentKitLink()
    {
    }

    public ReagentKitLink(URI uri)
    {
        this.uri = uri;
    }

    public ReagentKitLink(URI uri, String name)
    {
        this.uri = uri;
        this.name = name;
    }

    public ReagentKitLink(Linkable<ReagentKit> link)
    {
        requireNonNull(link, "link cannot be null");
        uri = link.getUri();
    }

    public ReagentKitLink(ReagentKit kit)
    {
        requireNonNull(kit, "kit cannot be null");
        uri = kit.getUri();
        name = kit.getName();
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
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
    public Class<ReagentKit> getEntityClass()
    {
        return ReagentKit.class;
    }

    @Override
    public String toString()
    {
        return name;
    }
}
