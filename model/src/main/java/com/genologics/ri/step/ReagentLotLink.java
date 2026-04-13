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

package com.genologics.ri.step;

import static java.util.Objects.requireNonNull;

import java.io.Serial;
import java.net.URI;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.LimsEntityLinkBase;
import com.genologics.ri.LimsEntityLinkable;
import com.genologics.ri.Linkable;
import com.genologics.ri.reagentlot.ReagentLot;

/**
 *
 * Provides a URI linking to the reagent lot details.
 *
 * @since 2.18
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reagent-lot-link")
public class ReagentLotLink extends LimsEntityLinkBase<ReagentLot>
{
    /**
     * Class version for serialisation.
     */
    @Serial
    private static final long serialVersionUID = -5183820950832194933L;

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
     * Constructs a new empty ReagentLotLink.
     */
    public ReagentLotLink()
    {
    }

    /**
     * Constructs a new ReagentLotLink with the given URI.
     *
     * @param uri the URI of the reagent lot.
     */
    public ReagentLotLink(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructs a new ReagentLotLink with the given URI and LIMS id.
     *
     * @param uri the URI of the reagent lot.
     * @param limsid the LIMS id of the reagent lot.
     */
    public ReagentLotLink(URI uri, String limsid)
    {
        this.uri = uri;
        this.limsid = limsid;
    }

    /**
     * Constructs a new ReagentLotLink from a linkable reagent lot.
     *
     * @param link the linkable reagent lot.
     *
     * @throws NullPointerException if link is null.
     */
    public ReagentLotLink(Linkable<ReagentLot> link)
    {
        requireNonNull(link, "link cannot be null");
        uri = link.getUri();
    }

    /**
     * Constructs a new ReagentLotLink from a LIMS entity linkable reagent lot.
     *
     * @param link the LIMS entity linkable reagent lot.
     *
     * @throws NullPointerException if link is null.
     */
    public ReagentLotLink(LimsEntityLinkable<ReagentLot> link)
    {
        requireNonNull(link, "link cannot be null");
        uri = link.getUri();
        limsid = link.getLimsid();
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
     * Sets the LIMS id of the reagent lot.
     *
     * @param limsid the LIMS id.
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

    /**
     * Returns a string representation of the reagent lot link.
     *
     * @return the LIMS id.
     */
    @Override
    public String toString()
    {
        return limsid;
    }
}
