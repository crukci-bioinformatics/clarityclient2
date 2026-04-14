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

package com.genologics.ri.processtemplate;

import static java.util.Objects.requireNonNull;

import java.io.Serial;
import java.net.URI;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.LimsEntityLinkBase;
import com.genologics.ri.Link;
import com.genologics.ri.Linkable;
import com.genologics.ri.instrument.Instrument;

/**
 *
 * The instrument is a child element of process-template that provides a URI to
 * the instrument that is responsible for running a Process created using this
 * Process Template.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "instrument")
public class InstrumentLink extends LimsEntityLinkBase<Instrument>
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = -2255676271595073801L;

    /**
     * The URI of the instrument.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * Default constructor.
     */
    public InstrumentLink()
    {
    }

    /**
     * Constructor with URI.
     *
     * @param uri the URI of the instrument.
     */
    public InstrumentLink(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructor from a linkable instrument.
     *
     * @param link the linkable instrument.
     */
    public InstrumentLink(Linkable<Instrument> link)
    {
        requireNonNull(link, "link cannot be null");
        uri = link.getUri();
    }

    /**
     * Gets the entity class.
     *
     * @return the Instrument class.
     */
    @Override
    public Class<Instrument> getEntityClass()
    {
        return Instrument.class;
    }

    /**
     * Gets the URI.
     *
     * @return the URI.
     */
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI.
     *
     * @param uri the URI to set.
     */
    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Gets the LIMS id extracted from the URI.
     *
     * @return the LIMS id.
     */
    @Override
    public String getLimsid()
    {
        return Link.limsIdFromUri(uri);
    }

    /**
     * Sets the LIMS id. This method does nothing as the LIMS id is extracted from the URI.
     *
     * @param id the LIMS id (ignored).
     */
    @Override
    public void setLimsid(String id)
    {
        // Does nothing.
    }
}
