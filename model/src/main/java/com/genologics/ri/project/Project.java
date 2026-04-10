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

package com.genologics.ri.project;

import static com.genologics.ri.Namespaces.FILE_NAMESPACE;
import static com.genologics.ri.Namespaces.ROOT_NAMESPACE;
import static com.genologics.ri.Namespaces.UDF_NAMESPACE;

import java.io.Serial;
import java.io.Serializable;
import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.genologics.ri.ClarityEntity;
import com.genologics.ri.ExternalId;
import com.genologics.ri.LimsEntity;
import com.genologics.ri.LimsEntityLink;
import com.genologics.ri.Linkable;
import com.genologics.ri.file.ClarityFile;
import com.genologics.ri.jaxb.ShortDateAdapter;
import com.genologics.ri.researcher.Researcher;
import com.genologics.ri.userdefined.UDF;
import com.genologics.ri.userdefined.UDFHolder;
import com.genologics.ri.userdefined.UDT;

/**
 * The detailed representation of a Project.
 */
@ClarityEntity(uriSection = "projects", creatable = true, updateable = true)
@XmlRootElement(name = "project")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "project",
         propOrder = { "name", "openDate", "closeDate", "invoiceDate", "researcher", "type",
                       "fields", "externalIds", "files", "priority" })
public class Project implements LimsEntity<Project>, UDFHolder, Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = -7543006762891280018L;

    /**
     * The name of the project.
     */
    @XmlElement(name = "name")
    protected String name;

    /**
     * The date the project was opened.
     */
    @XmlElement(name = "open-date")
    @XmlSchemaType(name = "date")
    @XmlJavaTypeAdapter(ShortDateAdapter.class)
    protected Date openDate;

    /**
     * The date the project was closed.
     */
    @XmlElement(name = "close-date")
    @XmlSchemaType(name = "date")
    @XmlJavaTypeAdapter(ShortDateAdapter.class)
    protected Date closeDate;

    /**
     * The date the project was invoiced.
     */
    @XmlElement(name = "invoice-date")
    @XmlSchemaType(name = "date")
    @XmlJavaTypeAdapter(ShortDateAdapter.class)
    protected Date invoiceDate;

    /**
     * The researcher associated with the project.
     */
    @XmlElement
    protected ResearcherLink researcher;

    /**
     * The user-defined type of the project.
     */
    @XmlElement(name = "type", namespace = UDF_NAMESPACE)
    protected UDT type;

    /**
     * The user-defined fields for the project.
     */
    @XmlElement(name = "field", namespace = UDF_NAMESPACE)
    protected List<UDF> fields;

    /**
     * The external identifiers for the project.
     */
    @XmlElement(name = "externalid", namespace = ROOT_NAMESPACE)
    protected List<ExternalId> externalIds;

    /**
     * The files attached to the project.
     */
    @XmlElement(name = "file", namespace = FILE_NAMESPACE)
    protected List<ClarityFile> files;

    /**
     * The priority of the project.
     *
     * @since 2.34
     */
    @XmlElement
    protected String priority;

    /**
     * The LIMS id of the project.
     */
    @XmlAttribute(name = "limsid")
    protected String limsid;

    /**
     * The URI of the project.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;



    /**
     * Constructor for Project.
     */
    public Project()
    {
    }

    /**
     * Constructor for Project with a URI.
     *
     * @param uri The URI of the project.
     */
    public Project(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructor for Project with a URI and LIMS id.
     *
     * @param uri The URI of the project.
     * @param limsid The LIMS id of the project.
     */
    public Project(URI uri, String limsid)
    {
        this.uri = uri;
        this.limsid = limsid;
    }

    /**
     * Get the name of the project.
     *
     * @return The project name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Set the name of the project.
     *
     * @param value The new project name.
     */
    public void setName(String value)
    {
        this.name = value;
    }

    /**
     * Get the open date of the project.
     *
     * @return The open date.
     */
    public Date getOpenDate()
    {
        return openDate;
    }

    /**
     * Set the open date of the project.
     *
     * @param openDate The new open date.
     */
    public void setOpenDate(Date openDate)
    {
        this.openDate = openDate;
    }

    /**
     * Get the close date of the project.
     *
     * @return The close date.
     */
    public Date getCloseDate()
    {
        return closeDate;
    }

    /**
     * Set the close date of the project.
     *
     * @param closeDate The new close date.
     */
    public void setCloseDate(Date closeDate)
    {
        this.closeDate = closeDate;
    }

    /**
     * Get the invoice date of the project.
     *
     * @return The invoice date.
     */
    public Date getInvoiceDate()
    {
        return invoiceDate;
    }

    /**
     * Set the invoice date of the project.
     *
     * @param invoiceDate The new invoice date.
     */
    public void setInvoiceDate(Date invoiceDate)
    {
        this.invoiceDate = invoiceDate;
    }

    /**
     * Get the researcher associated with the project.
     *
     * @return The researcher link.
     */
    public ResearcherLink getResearcher()
    {
        return researcher;
    }

    /**
     * Set the researcher associated with the project.
     *
     * @param link The linkable researcher.
     */
    public void setResearcher(Linkable<Researcher> link)
    {
        this.researcher = new ResearcherLink(link);
    }

    /**
     * Get the user-defined type of the project.
     *
     * @return The user-defined type.
     */
    public UDT getUserDefinedType()
    {
        return type;
    }

    /**
     * Set the user-defined type of the project.
     *
     * @param value The new user-defined type.
     *
     * @return The user-defined type that was set.
     */
    public UDT setUserDefinedType(UDT value)
    {
        this.type = value;
        return this.type;
    }

    /**
     * Set the user-defined type of the project by name.
     *
     * @param type The name of the user-defined type.
     *
     * @return The user-defined type that was created and set.
     */
    public UDT setUserDefinedType(String type)
    {
        this.type = new UDT(type);
        return this.type;
    }

    /**
     * Get the user-defined fields for the project.
     *
     * @return The list of user-defined fields.
     */
    @Override
    public List<UDF> getUserDefinedFields()
    {
        if (fields == null)
        {
            fields = new ArrayList<UDF>();
        }
        return this.fields;
    }

    /**
     * Get the external identifiers for the project.
     *
     * @return The list of external identifiers.
     */
    public List<ExternalId> getExternalIds()
    {
        if (externalIds == null)
        {
            externalIds = new ArrayList<ExternalId>();
        }
        return this.externalIds;
    }

    /**
     * Get the files attached to the project.
     *
     * @return The list of files.
     */
    public List<ClarityFile> getFiles()
    {
        if (files == null)
        {
            files = new ArrayList<ClarityFile>();
        }
        return this.files;
    }

    /**
     * Add a file to the project.
     *
     * @param f The file to add.
     *
     * @return The file that was added.
     */
    public ClarityFile addFile(ClarityFile f)
    {
        getFiles().add(f);
        return f;
    }

    /**
     * Get the priority of the project.
     *
     * @return The priority.
     */
    public String getPriority()
    {
        return priority;
    }

    /**
     * Set the priority of the project.
     *
     * @param priority The new priority.
     */
    public void setPriority(String priority)
    {
        this.priority = priority;
    }

    /**
     * Get the LIMS id of the project.
     *
     * @return The LIMS id.
     */
    public String getLimsid()
    {
        return limsid;
    }

    /**
     * Set the LIMS id of the project.
     *
     * @param value The new LIMS id.
     */
    public void setLimsid(String value)
    {
        this.limsid = value;
    }

    /**
     * Get the URI of the project.
     *
     * @return The URI.
     */
    public URI getUri()
    {
        return uri;
    }

    /**
     * Set the URI of the project.
     *
     * @param value The new URI.
     */
    public void setUri(URI value)
    {
        this.uri = value;
    }

    /**
     * Return a string representation of the project.
     *
     * @return The LIMS id and name of the project.
     */
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder(30);
        sb.append(limsid).append(' ').append(name);
        return sb.toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LimsEntityLink<Project> getLink()
    {
        return new ProjectLink(this);
    }
}
