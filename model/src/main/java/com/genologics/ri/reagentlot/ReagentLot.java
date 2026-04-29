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

import static org.apache.commons.lang3.StringUtils.SPACE;

import java.io.Serial;
import java.io.Serializable;
import java.net.URI;
import java.util.Date;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.genologics.ri.ClarityEntity;
import com.genologics.ri.LimsEntity;
import com.genologics.ri.LimsEntityLink;
import com.genologics.ri.LimsEntityLinkable;
import com.genologics.ri.Linkable;
import com.genologics.ri.jaxb.ShortDateAdapter;
import com.genologics.ri.reagentkit.ReagentKit;
import com.genologics.ri.researcher.Researcher;

/**
 * Represents a reagent lot in the Clarity LIMS system.
 * <p>
 * A reagent lot is a specific batch of a reagent kit that is tracked
 * separately with its own lot number, expiry date, and usage information.
 * This class provides detailed information about the lot including its
 * status, storage location, and audit trail (creation and modification
 * timestamps and responsible researchers).
 * </p>
 *
 * @since 2.18
 */
@ClarityEntity(uriSection = "reagentlots", creatable = true, updateable = true)
@XmlRootElement(name = "reagent-lot")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reagent-lot",
         propOrder = { "reagentKit", "name", "lotNumber", "createdDate", "lastModifiedDate",
                       "expiryDate", "createdBy", "lastModifiedBy", "storageLocation", "notes",
                       "status", "usageCount" })
public class ReagentLot implements LimsEntity<ReagentLot>, Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 8414977581247533239L;

    /**
     * Link to the reagent kit that this lot belongs to.
     */
    @XmlElement(name = "reagent-kit")
    protected ReagentKitLink reagentKit;

    /**
     * The name of this reagent lot.
     */
    @XmlElement
    protected String name;

    /**
     * The lot number identifier for this reagent lot.
     */
    @XmlElement(name = "lot-number")
    protected String lotNumber;

    /**
     * The date when this reagent lot was created in the system.
     */
    @XmlElement(name = "created-date")
    @XmlSchemaType(name = "date")
    @XmlJavaTypeAdapter(ShortDateAdapter.class)
    protected Date createdDate;

    /**
     * The date when this reagent lot was last modified.
     */
    @XmlElement(name = "last-modified-date")
    @XmlSchemaType(name = "date")
    @XmlJavaTypeAdapter(ShortDateAdapter.class)
    protected Date lastModifiedDate;

    /**
     * The expiry date of this reagent lot.
     */
    @XmlElement(name = "expiry-date")
    @XmlSchemaType(name = "date")
    @XmlJavaTypeAdapter(ShortDateAdapter.class)
    protected Date expiryDate;

    /**
     * Link to the researcher who created this reagent lot.
     */
    @XmlElement(name = "created-by")
    protected ResearcherLink createdBy;

    /**
     * Link to the researcher who last modified this reagent lot.
     */
    @XmlElement(name = "last-modified-by")
    protected ResearcherLink lastModifiedBy;

    /**
     * The physical storage location of this reagent lot.
     */
    @XmlElement(name = "storage-location")
    protected String storageLocation;

    /**
     * Additional notes about this reagent lot.
     */
    @XmlElement
    protected String notes;

    /**
     * The current status of this reagent lot (e.g., ACTIVE, ARCHIVED).
     */
    @XmlElement
    protected Status status;

    /**
     * The number of times this reagent lot has been used.
     *
     * @since 2.20
     */
    @XmlElement(name = "usage-count")
    protected Long usageCount;

    /**
     * The URI of this reagent lot resource.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * The LIMS id of this reagent lot.
     */
    @XmlAttribute(name = "limsid")
    protected String limsid;

    /**
     * Default constructor.
     */
    public ReagentLot()
    {
    }

    /**
     * Constructor with URI.
     *
     * @param uri The URI of the reagent lot.
     */
    public ReagentLot(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructor with URI and LIMS id.
     *
     * @param uri The URI of the reagent lot.
     * @param limsid The LIMS id of the reagent lot.
     */
    public ReagentLot(URI uri, String limsid)
    {
        this.uri = uri;
        this.limsid = limsid;
    }

    /**
     * Constructor from a linkable reagent lot.
     *
     * @param link The linkable reagent lot to copy URI and LIMS id from.
     */
    public ReagentLot(LimsEntityLinkable<ReagentLot> link)
    {
        uri = link.getUri();
        limsid = link.getLimsid();
    }

    /**
     * Gets the link to the reagent kit.
     *
     * @return The reagent kit link.
     */
    public ReagentKitLink getReagentKit()
    {
        return reagentKit;
    }

    /**
     * Sets the reagent kit for this lot.
     *
     * @param reagentKit A linkable reference to the reagent kit.
     */
    public void setReagentKit(Linkable<ReagentKit> reagentKit)
    {
        this.reagentKit = new ReagentKitLink(reagentKit);
    }

    /**
     * Gets the name of the reagent lot.
     *
     * @return The name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of the reagent lot.
     *
     * @param name The name to set.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Gets the lot number.
     *
     * @return The lot number.
     */
    public String getLotNumber()
    {
        return lotNumber;
    }

    /**
     * Sets the lot number.
     *
     * @param lotNumber The lot number to set.
     */
    public void setLotNumber(String lotNumber)
    {
        this.lotNumber = lotNumber;
    }

    /**
     * Gets the creation date.
     *
     * @return The creation date.
     */
    public Date getCreatedDate()
    {
        return createdDate;
    }

    /**
     * Sets the creation date.
     *
     * @param createdDate The creation date to set.
     */
    public void setCreatedDate(Date createdDate)
    {
        this.createdDate = createdDate;
    }

    /**
     * Gets the last modification date.
     *
     * @return The last modification date.
     */
    public Date getLastModifiedDate()
    {
        return lastModifiedDate;
    }

    /**
     * Sets the last modification date.
     *
     * @param lastModifiedDate The last modification date to set.
     */
    public void setLastModifiedDate(Date lastModifiedDate)
    {
        this.lastModifiedDate = lastModifiedDate;
    }

    /**
     * Gets the expiry date.
     *
     * @return The expiry date.
     */
    public Date getExpiryDate()
    {
        return expiryDate;
    }

    /**
     * Sets the expiry date.
     *
     * @param expiryDate The expiry date to set.
     */
    public void setExpiryDate(Date expiryDate)
    {
        this.expiryDate = expiryDate;
    }

    /**
     * Gets the link to the researcher who created this lot.
     *
     * @return The creator researcher link.
     */
    public ResearcherLink getCreatedBy()
    {
        return createdBy;
    }

    /**
     * Sets the researcher who created this lot.
     *
     * @param createdBy A linkable reference to the creator researcher.
     */
    public void setCreatedBy(Linkable<Researcher> createdBy)
    {
        this.createdBy = new ResearcherLink(createdBy);
    }

    /**
     * Gets the link to the researcher who last modified this lot.
     *
     * @return The last modifier researcher link.
     */
    public ResearcherLink getLastModifiedBy()
    {
        return lastModifiedBy;
    }

    /**
     * Sets the researcher who last modified this lot.
     *
     * @param lastModifiedBy A linkable reference to the last modifier researcher.
     */
    public void setLastModifiedBy(Linkable<Researcher> lastModifiedBy)
    {
        this.lastModifiedBy = new ResearcherLink(lastModifiedBy);
    }

    /**
     * Gets the storage location.
     *
     * @return The storage location.
     */
    public String getStorageLocation()
    {
        return storageLocation;
    }

    /**
     * Sets the storage location.
     *
     * @param storageLocation The storage location to set.
     */
    public void setStorageLocation(String storageLocation)
    {
        this.storageLocation = storageLocation;
    }

    /**
     * Gets the notes.
     *
     * @return The notes.
     */
    public String getNotes()
    {
        return notes;
    }

    /**
     * Sets the notes.
     *
     * @param notes The notes to set.
     */
    public void setNotes(String notes)
    {
        this.notes = notes;
    }

    /**
     * Gets the status of the reagent lot.
     *
     * @return The status.
     */
    public Status getStatus()
    {
        return status;
    }

    /**
     * Sets the status of the reagent lot.
     *
     * @param status The status to set.
     */
    public void setStatus(Status status)
    {
        this.status = status;
    }

    /**
     * Gets the usage count.
     *
     * @return The usage count.
     */
    public Long getUsageCount()
    {
        return usageCount;
    }

    /**
     * Sets the usage count.
     *
     * @param usageCount The usage count to set.
     */
    public void setUsageCount(Long usageCount)
    {
        this.usageCount = usageCount;
    }

    @Override
    public URI getUri()
    {
        return uri;
    }

    @Override
    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    @Override
    public String getLimsid()
    {
        return limsid;
    }

    @Override
    public void setLimsid(String limsid)
    {
        this.limsid = limsid;
    }

    /**
     * Returns a string representation of this reagent lot.
     *
     * @return A string containing the LIMS id and name.
     */
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(limsid).append(SPACE).append(name);
        return sb.toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LimsEntityLink<ReagentLot> getLink()
    {
        return new ReagentLotLink(this);
    }
}
