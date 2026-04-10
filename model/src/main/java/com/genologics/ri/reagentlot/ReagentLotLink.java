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

package com.genologics.ri.reagentlot;

import static java.util.Objects.requireNonNull;

import java.io.Serializable;
import java.net.URI;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.LimsEntityLink;
import com.genologics.ri.LimsEntityLinkable;
import com.genologics.ri.Linkable;

/**
 *
 * Reagent-lot-link is a child element type of Reagent Lots and provides a URI
 * linking to the detailed representation of a Reagent Lot.
 *
 * @since 2.18
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reagent-lot-link", propOrder = { "name" })
public class ReagentLotLink implements LimsEntityLink<ReagentLot>, Serializable
{
    /**
     * Class version for serialisation.
     */
    @java.io.Serial
    private static final long serialVersionUID = -5668438563329514777L;

    /**
     * The name of the Reagent Lot.
     * @since 2.31
     */
    @XmlElement
    protected String name;

    /**
     * The LIMS id of the reagent lot.
     */
    @XmlAttribute(name = "limsid")
    protected String limsid;

    /**
     * The URI of the reagent lot.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * Default constructor.
     */
    public ReagentLotLink()
    {
    }

    /**
     * Constructor with URI.
     *
     * @param uri The reagent lot URI.
     */
    public ReagentLotLink(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructor with URI and LIMS id.
     *
     * @param uri The reagent lot URI.
     * @param limsid The LIMS id.
     */
    public ReagentLotLink(URI uri, String limsid)
    {
        this.uri = uri;
        this.limsid = limsid;
    }

    /**
     * Constructor with URI, LIMS id, and name.
     *
     * @param uri The reagent lot URI.
     * @param limsid The LIMS id.
     * @param name The reagent lot name.
     */
    public ReagentLotLink(URI uri, String limsid, String name)
    {
        this.uri = uri;
        this.limsid = limsid;
        this.name = name;
    }

    /**
     * Constructor from a linkable reagent lot.
     *
     * @param link The linkable reagent lot.
     */
    public ReagentLotLink(Linkable<ReagentLot> link)
    {
        requireNonNull(link, "link cannot be null");
        uri = link.getUri();
    }

    /**
     * Constructor from a LIMS entity linkable reagent lot.
     *
     * @param link The LIMS entity linkable reagent lot.
     */
    public ReagentLotLink(LimsEntityLinkable<ReagentLot> link)
    {
        requireNonNull(link, "link cannot be null");
        uri = link.getUri();
        limsid = link.getLimsid();
    }

    /**
     * Constructor from a reagent lot entity.
     *
     * @param lot The reagent lot entity.
     */
    public ReagentLotLink(ReagentLot lot)
    {
        requireNonNull(lot, "lot cannot be null");
        uri = lot.getUri();
        limsid = lot.getLimsid();
        name = lot.getName();
    }

    /**
     * Gets the name of the reagent lot.
     *
     * @return The reagent lot name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of the reagent lot.
     *
     * @param name The reagent lot name.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getLimsid()
    {
        return limsid;
    }

    /**
     * Sets the LIMS id.
     *
     * @param limsid The LIMS id.
     */
    public void setLimsid(String limsid)
    {
        this.limsid = limsid;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public URI getUri()
    {
        return uri;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Class<ReagentLot> getEntityClass()
    {
        return ReagentLot.class;
    }

    @Override
    public String toString()
    {
        return limsid;
    }
}
