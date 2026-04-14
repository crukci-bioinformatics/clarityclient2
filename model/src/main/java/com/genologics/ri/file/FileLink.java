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

package com.genologics.ri.file;

import static java.util.Objects.requireNonNull;

import java.io.Serial;
import java.net.URI;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.LimsEntityLinkable;
import com.genologics.ri.LimsLinkBase;

/**
 * The file-link type provides a URI that links to information about a file in
 * the system.
 * <p>
 * Elements of this type are used for lists of files, or by resources that have
 * attached files to identify and link to further information about the file.
 * </p>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "file-link")
public class FileLink extends LimsLinkBase<ClarityFile>
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = -2151598768590902010L;

    /**
     * The URI of the file resource.
     */
    @XmlAttribute(name = "uri")
    protected URI uri;

    /**
     * The LIMS id of the file.
     */
    @XmlAttribute(name = "limsid")
    protected String limsid;

    /**
     * Creates a new, empty FileLink.
     */
    public FileLink()
    {
    }

    /**
     * Creates a new FileLink with the specified URI.
     *
     * @param uri The URI of the file resource.
     */
    public FileLink(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Creates a new FileLink with the specified URI and LIMS id.
     *
     * @param uri The URI of the file resource.
     * @param limsid The LIMS id of the file.
     */
    public FileLink(URI uri, String limsid)
    {
        this.uri = uri;
        this.limsid = limsid;
    }

    /**
     * Creates a new FileLink from a linkable entity that references a ClarityFile,
     * copying its URI and LIMS id.
     *
     * @param link The linkable entity to create a link from.
     *
     * @throws NullPointerException if link is null.
     */
    public FileLink(LimsEntityLinkable<ClarityFile> link)
    {
        requireNonNull(link, "link cannot be null");
        this.uri = link.getUri();
        this.limsid = link.getLimsid();
    }

    /**
     * Gets the entity class that this link references.
     *
     * @return The ClarityFile class.
     */
    @Override
    public Class<ClarityFile> getEntityClass()
    {
        return ClarityFile.class;
    }

    /**
     * Gets the URI of the file resource.
     *
     * @return The URI.
     */
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI of the file resource.
     *
     * @param uri The URI to set.
     */
    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Gets the LIMS id of the file.
     *
     * @return The LIMS id.
     */
    public String getLimsid()
    {
        return limsid;
    }

    /**
     * Sets the LIMS id of the file.
     *
     * @param limsid The LIMS id to set.
     */
    public void setLimsid(String limsid)
    {
        this.limsid = limsid;
    }
}
