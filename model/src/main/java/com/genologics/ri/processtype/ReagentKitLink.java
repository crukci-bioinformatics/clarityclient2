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
import com.genologics.ri.reagentkit.ReagentKit;


/**
 * Reagent-kit-link is a child element type of reagentKits and provides a URI linking to the detailed representation of a ReagentKit.
 *
 * @since 2.25
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reagent-kit-link")
public class ReagentKitLink extends LimsLinkBase<ReagentKit>
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 7746715136563752804L;

    /**
     * The name of the reagent kit.
     */
    @XmlAttribute(name = "name")
    protected String name;

    /**
     * The URI of the reagent kit.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * Constructs a new reagent kit link.
     */
    public ReagentKitLink()
    {
    }

    /**
     * Constructs a new reagent kit link with the specified name.
     *
     * @param name the name of the reagent kit.
     */
    public ReagentKitLink(String name)
    {
        this.name = name;
    }

    /**
     * Constructs a new reagent kit link from a linkable object.
     *
     * @param link the linkable object providing the URI.
     */
    public ReagentKitLink(Linkable<ReagentKit> link)
    {
        requireNonNull(link, "link cannot be null");
        uri = link.getUri();
    }

    /**
     * Constructs a new reagent kit link from a reagent kit entity.
     *
     * @param kit the reagent kit entity.
     */
    public ReagentKitLink(ReagentKit kit)
    {
        requireNonNull(kit, "kit cannot be null");
        uri = kit.getUri();
        name = kit.getName();
    }

    /**
     * Gets the name of the reagent kit.
     *
     * @return the reagent kit name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of the reagent kit.
     *
     * @param name the reagent kit name.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Gets the URI of the reagent kit.
     *
     * @return the reagent kit URI.
     */
    @Override
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI of the reagent kit.
     *
     * @param uri the reagent kit URI.
     */
    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Gets the entity class for this link.
     *
     * @return the ReagentKit class.
     */
    @Override
    public Class<ReagentKit> getEntityClass()
    {
        return ReagentKit.class;
    }

    /**
     * Returns a string representation of this reagent kit link.
     *
     * @return The reagent kit URI and name.
     */
    @Override
    public String toString()
    {
        ToStringBuilder b = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
        b.append("reagentKit", LimsLink.toString(this));
        b.append("name", name);
        return b.toString();
    }
}
