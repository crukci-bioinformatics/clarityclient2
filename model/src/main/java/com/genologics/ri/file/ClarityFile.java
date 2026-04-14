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
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.ClarityEntity;
import com.genologics.ri.LimsEntity;
import com.genologics.ri.LimsEntityLinkBase;
import com.genologics.ri.Linkable;

/**
 * The file element contains information about a file in the system.
 * <p>
 * These are rather strange as the link to a file is just a file object with
 * only the URI set. So they are both entities and links.
 * </p>
 */
@ClarityEntity(uriSection = "files", creatable = true, updateable = true, removable = true)
@XmlRootElement(name = "file")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "file", propOrder = { "attachedTo", "contentLocation", "originalLocation", "originalName", "published" })
public class ClarityFile extends LimsEntityLinkBase<ClarityFile> implements LimsEntity<ClarityFile>
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = -6683975101172687186L;

    /**
     * The URI of the resource that this file is attached to (e.g., a project, sample, process, or artifact).
     */
    @XmlElement(name = "attached-to")
    @XmlSchemaType(name = "anyURI")
    protected URI attachedTo;

    /**
     * The network location URI where the file content can be retrieved.
     */
    @XmlElement(name = "content-location")
    @XmlSchemaType(name = "anyURI")
    protected URI contentLocation;

    /**
     * The original name and location of the file before it was imported into the system.
     */
    @XmlElement(name = "original-location")
    protected String originalLocation;

    /**
     * The original name of the file before it was imported into the system.
     *
     * @since 2.26
     */
    @XmlElement(name = "original-name")
    protected String originalName;

    /**
     * Indicates whether the file is displayed in LabLink.
     */
    @XmlElement(name = "is-published")
    protected Boolean published;

    /**
     * The LIMS id of the file.
     */
    @XmlAttribute(name = "limsid")
    protected String limsid;

    /**
     * The URI of the file resource.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * Creates a new, empty ClarityFile.
     */
    public ClarityFile()
    {
    }

    /**
     * Creates a new ClarityFile with the specified URI.
     *
     * @param uri The URI of the file resource.
     */
    public ClarityFile(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Creates a new ClarityFile with the specified URI and LIMS id.
     *
     * @param uri The URI of the file resource.
     * @param limsid The LIMS id of the file.
     */
    public ClarityFile(URI uri, String limsid)
    {
        this.uri = uri;
        this.limsid = limsid;
    }

    /**
     * Creates a new ClarityFile as a copy of another ClarityFile,
     * copying its URI and LIMS id.
     *
     * @param file The file to copy from.
     *
     * @throws NullPointerException if file is null.
     */
    public ClarityFile(ClarityFile file)
    {
        requireNonNull(file, "file cannot be null");
        this.uri = file.getUri();
        this.limsid = file.getLimsid();
    }

    /**
     * This element contains a URI that identifies and links to further information about the resource that
     * the file is attached to, such as a project, sample, process, or file-based artifact.
     *
     * @return The URI of the entity the file is attached to.
     */
    public URI getAttachedTo()
    {
        return attachedTo;
    }

    /**
     * Sets the resource that this file is attached to.
     *
     * @param link The linkable entity to attach this file to, or null to clear the attachment.
     */
    public void setAttachedTo(Linkable<?> link)
    {
        this.attachedTo = link == null ? null : link.getUri();
    }

    /**
     * This element contains a URI that identifies and links to the network location of the file,
     * which can be used to retrieve the file and process its contents.
     *
     * @return The file's location.
     */
    public URI getContentLocation()
    {
        return contentLocation;
    }

    /**
     * Sets the network location URI where the file content can be retrieved.
     *
     * @param contentLocation The URI of the file content location.
     */
    public void setContentLocation(URI contentLocation)
    {
        this.contentLocation = contentLocation;
    }

    /**
     * This element provides the original name and location of the file before it was imported into the system.
     * Note: If the file was uploaded from the Clarity web interface, the original-location element will not contain
     * the full file path due to browser security limitations. Only the original file name will be available.
     *
     * @return The original file location.
     */
    public String getOriginalLocation()
    {
        return originalLocation;
    }

    /**
     * Sets the original name and location of the file before it was imported into the system.
     *
     * @param originalLocation The original file location string.
     */
    public void setOriginalLocation(String originalLocation)
    {
        this.originalLocation = originalLocation;
    }

    /**
     * This element provides the original name of the file before it was imported into the system.
     * This is calculated from the original-location.
     *
     * @return The original file name.
     *
     * @since 2.26
     */
    public String getOriginalName()
    {
        return originalName;
    }

    /**
     * Sets the original name of the file before it was imported into the system.
     *
     * @param originalName The original file name.
     *
     * @since 2.26
     */
    public void setOriginalName(String originalName)
    {
        this.originalName = originalName;
    }

    /**
     * This element specifies whether the file is displayed in LabLink.
     *
     * @return true to be visible in Lablink, false to be invisible.
     */
    public boolean isPublished()
    {
        return published == null ? false : published.booleanValue();
    }

    /**
     * Sets whether the file should be displayed in LabLink.
     *
     * @param published true to make the file visible in Lablink, false to make it invisible.
     */
    public void setPublished(Boolean published)
    {
        this.published = published;
    }

    /**
     * Gets the LIMS id of this file.
     *
     * @return The LIMS id.
     */
    public String getLimsid()
    {
        return limsid;
    }

    /**
     * Sets the LIMS id of this file.
     *
     * @param limsid The LIMS id to set.
     */
    public void setLimsid(String limsid)
    {
        this.limsid = limsid;
    }

    /**
     * Gets the URI of this file resource.
     *
     * @return The URI.
     */
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI of this file resource.
     *
     * @param uri The URI to set.
     */
    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Helper method to clear the detail fields (attachedTo, contentLocation, originalLocation
     * and published). This may be necessary if a new file is created with these values set and
     * that object then set on, say, an artifact that needs to be updated. Internally, the link
     * will have been set on the server.
     */
    public void clearDetailFields()
    {
        attachedTo = null;
        contentLocation = null;
        originalLocation = null;
        published = null;
    }

    /**
     * Gets the entity class for this file.
     *
     * @return The ClarityFile class.
     */
    @Override
    public Class<ClarityFile> getEntityClass()
    {
        return ClarityFile.class;
    }

    /**
     * Returns a string representation of this file, which is its LIMS id.
     *
     * @return The LIMS id as a string.
     */
    @Override
    public String toString()
    {
        return limsid;
    }
}
