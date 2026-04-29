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

package com.genologics.ri.sample;

import static com.genologics.ri.Namespaces.FILE_NAMESPACE;
import static com.genologics.ri.Namespaces.ROOT_NAMESPACE;
import static com.genologics.ri.Namespaces.UDF_NAMESPACE;
import static org.apache.commons.lang3.StringUtils.SPACE;
import static org.apache.commons.lang3.StringUtils.isBlank;

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
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.genologics.ri.ExternalId;
import com.genologics.ri.LimsEntityLinkable;
import com.genologics.ri.Linkable;
import com.genologics.ri.artifact.Artifact;
import com.genologics.ri.controltype.ControlType;
import com.genologics.ri.file.ClarityFile;
import com.genologics.ri.jaxb.ShortDateAdapter;
import com.genologics.ri.project.Project;
import com.genologics.ri.researcher.Researcher;
import com.genologics.ri.userdefined.UDF;
import com.genologics.ri.userdefined.UDFHolder;
import com.genologics.ri.userdefined.UDT;

/**
 * <p>
 * The base representation of a Sample, defining common elements for both Sample
 * and Sample creation.
 * </p>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "samplebase",
         propOrder = { "name", "dateReceived", "dateCompleted", "project", "controlType", "submitter",
                       "artifact", "bioSource", "type", "fields", "externalIds", "files" })
@XmlSeeAlso({ SampleCreation.class, Sample.class })
public class SampleBase implements UDFHolder, Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 7926341075019764297L;

    /**
     * The name of the sample.
     */
    protected String name;

    /**
     * The date the sample was received.
     */
    @XmlElement(name = "date-received")
    @XmlSchemaType(name = "date")
    @XmlJavaTypeAdapter(ShortDateAdapter.class)
    protected Date dateReceived;

    /**
     * The date the sample was completed.
     */
    @XmlElement(name = "date-completed")
    @XmlSchemaType(name = "date")
    @XmlJavaTypeAdapter(ShortDateAdapter.class)
    protected Date dateCompleted;

    /**
     * The project associated with this sample.
     */
    protected ProjectLink project;

    /**
     * The control type associated with this sample.
     */
    @XmlElement(name = "control-type")
    protected ControlTypeLink controlType;

    /**
     * The submitter of this sample.
     */
    protected Submitter submitter;

    /**
     * The artifact associated with this sample.
     */
    protected ArtifactLink artifact;

    /**
     * The biosource of this sample.
     *
     * @deprecated Biosource is not supported in Clarity.
     */
    @XmlElement(name = "biosource")
    @Deprecated
    protected BioSource bioSource;

    /**
     * The user-defined type of this sample.
     */
    @XmlElement(name = "type", namespace = UDF_NAMESPACE)
    protected UDT type;

    /**
     * The user-defined fields for this sample.
     */
    @XmlElement(name = "field", namespace = UDF_NAMESPACE)
    protected List<UDF> fields;

    /**
     * The external identifiers for this sample.
     */
    @XmlElement(name = "externalid", namespace = ROOT_NAMESPACE)
    protected List<ExternalId> externalIds;

    /**
     * The files associated with this sample.
     */
    @XmlElement(name = "file", namespace = FILE_NAMESPACE)
    protected List<ClarityFile> files;

    /**
     * The LIMS id of this sample.
     */
    @XmlAttribute(name = "limsid")
    protected String limsid;

    /**
     * The URI of this sample.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * Constructor for an empty sample base.
     */
    protected SampleBase()
    {
    }

    /**
     * Copy constructor for a sample base.
     *
     * @param other The sample base to copy from.
     */
    protected SampleBase(SampleBase other)
    {
        this.name = other.name;
        this.dateReceived = other.dateReceived;
        this.dateCompleted = other.dateCompleted;
        this.project = other.project;
        this.controlType = other.controlType;
        this.submitter = other.submitter;
        this.artifact = other.artifact;
        this.bioSource = other.bioSource;
        this.type = other.type;
        if (other.fields != null)
        {
            this.fields = new ArrayList<>(other.fields);
        }
        if (other.externalIds != null)
        {
            this.externalIds = new ArrayList<>(other.externalIds);
        }
        if (other.files != null)
        {
            this.files = new ArrayList<>(other.files);
        }
    }

    /**
     * Gets the name of the sample.
     *
     * @return The sample name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of the sample.
     *
     * @param value The sample name.
     */
    public void setName(String value)
    {
        this.name = value;
    }

    /**
     * Gets the date the sample was received.
     *
     * @return The date received.
     */
    public Date getDateReceived()
    {
        return dateReceived;
    }

    /**
     * Sets the date the sample was received.
     *
     * @param value The date received.
     */
    public void setDateReceived(Date value)
    {
        this.dateReceived = value;
    }

    /**
     * Gets the date the sample was completed.
     *
     * @return The date completed.
     */
    public Date getDateCompleted()
    {
        return dateCompleted;
    }

    /**
     * Sets the date the sample was completed.
     *
     * @param value The date completed.
     */
    public void setDateCompleted(Date value)
    {
        this.dateCompleted = value;
    }

    /**
     * Gets the project link for this sample.
     *
     * @return The project link.
     */
    public ProjectLink getProject()
    {
        return project;
    }

    /**
     * Sets the project for this sample.
     *
     * @param project The project linkable object.
     */
    public void setProject(LimsEntityLinkable<Project> project)
    {
        this.project = project == null ? null : new ProjectLink(project);
    }

    /**
     * Gets the control type link for this sample.
     *
     * @return The control type link.
     */
    public ControlTypeLink getControlType()
    {
        return controlType;
    }

    /**
     * Sets the control type for this sample.
     *
     * @param controlType The control type linkable object.
     */
    public void setControlType(Linkable<ControlType> controlType)
    {
        this.controlType = controlType == null ? null : new ControlTypeLink(controlType);
    }

    /**
     * Checks if this sample is a control sample.
     *
     * @return true if this sample has a control type, false otherwise.
     */
    public boolean isControlSample()
    {
        return controlType != null;
    }

    /**
     * Gets the submitter of this sample.
     *
     * @return The submitter.
     */
    public Submitter getSubmitter()
    {
        return submitter;
    }

    /**
     * Sets the submitter for this sample.
     *
     * @param link The researcher linkable object.
     * @return The created submitter.
     */
    public Submitter setSubmitter(Linkable<Researcher> link)
    {
        this.submitter = link == null ? null : new Submitter(link);
        return this.submitter;
    }

    /**
     * Gets the artifact link for this sample.
     *
     * @return The artifact link.
     */
    public ArtifactLink getArtifact()
    {
        return artifact;
    }

    /**
     * Sets the artifact for this sample.
     *
     * @param artifact The artifact linkable object.
     */
    public void setArtifact(LimsEntityLinkable<Artifact> artifact)
    {
        this.artifact = artifact == null ? null : new ArtifactLink(artifact);
    }

    /**
     * Gets the biosource of this sample.
     *
     * @deprecated Biosource is not supported in Clarity.
     * @return The biosource.
     */
    @Deprecated
    public BioSource getBioSource()
    {
        return bioSource;
    }

    /**
     * Sets the biosource for this sample.
     *
     * @deprecated Biosource is not supported in Clarity.
     * @param bioSource The biosource.
     */
    @Deprecated
    public void setBioSource(BioSource bioSource)
    {
        this.bioSource = bioSource;
    }

    /**
     * Gets the user-defined type of this sample.
     *
     * @return The user-defined type.
     */
    public UDT getUserDefinedType()
    {
        return type;
    }

    /**
     * Sets the user-defined type for this sample.
     *
     * @param value The user-defined type.
     * @return The set user-defined type.
     */
    public UDT setUserDefinedType(UDT value)
    {
        this.type = value;
        return this.type;
    }

    /**
     * Sets the user-defined type for this sample by type name.
     *
     * @param type The type name.
     * @return The created user-defined type.
     */
    public UDT setUserDefinedType(String type)
    {
        this.type = isBlank(type) ? null : new UDT(type);
        return this.type;
    }

    /**
     * Gets the list of user-defined fields for this sample.
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Any modification to the returned list will be
     * reflected in the object.
     * </p>
     *
     * @return The list of user-defined fields.
     */
    @Override
    public List<UDF> getUserDefinedFields()
    {
        if (fields == null)
        {
            fields = new ArrayList<>();
        }
        return fields;
    }

    /**
     * Gets the list of external identifiers for this sample.
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Any modification to the returned list will be
     * reflected in the object.
     * </p>
     *
     * @return The list of external identifiers.
     */
    public List<ExternalId> getExternalIds()
    {
        if (externalIds == null)
        {
            externalIds = new ArrayList<>();
        }
        return this.externalIds;
    }

    /**
     * Gets the list of files associated with this sample.
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Any modification to the returned list will be
     * reflected in the object.
     * </p>
     *
     * @return The list of files.
     */
    public List<ClarityFile> getFiles()
    {
        if (files == null)
        {
            files = new ArrayList<>();
        }
        return this.files;
    }

    /**
     * Adds a file to this sample.
     *
     * @param f The file to add.
     * @return The added file, or null if the file parameter was null.
     */
    public ClarityFile addFile(ClarityFile f)
    {
        if (f != null)
        {
            getFiles().add(f);
        }
        return f;
    }

    /**
     * Gets the LIMS id of this sample.
     *
     * @return The LIMS id.
     */
    public String getLimsid()
    {
        return limsid;
    }

    /**
     * Sets the LIMS id for this sample.
     *
     * @param value The LIMS id.
     */
    public void setLimsid(String value)
    {
        this.limsid = value;
    }

    /**
     * Gets the URI of this sample.
     *
     * @return The sample URI.
     */
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI for this sample.
     *
     * @param value The sample URI.
     */
    public void setUri(URI value)
    {
        this.uri = value;
    }

    /**
     * Returns a string representation of this sample.
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
}
