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

package com.genologics.ri.artifact;

import static com.genologics.ri.Namespaces.FILE_NAMESPACE;
import static com.genologics.ri.Namespaces.UDF_NAMESPACE;
import static org.apache.commons.lang3.StringUtils.SPACE;

import java.io.Serial;
import java.io.Serializable;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.ClarityEntity;
import com.genologics.ri.LimsEntity;
import com.genologics.ri.LimsEntityLink;
import com.genologics.ri.LimsEntityLinkable;
import com.genologics.ri.Linkable;
import com.genologics.ri.Location;
import com.genologics.ri.artifactgroup.ArtifactGroup;
import com.genologics.ri.controltype.ControlType;
import com.genologics.ri.file.ClarityFile;
import com.genologics.ri.process.ClarityProcess;
import com.genologics.ri.sample.Sample;
import com.genologics.ri.userdefined.UDF;
import com.genologics.ri.userdefined.UDFHolder;

/**
 *
 * <p>
 * The detailed representation of an Artifact.
 * </p>
 * <p>
 * An Artifact represents the inputs to or outputs from a process. An Artifact
 * is classified by its type (Analyte, ResultFile, etc).
 * </p>
 * <p>
 * Artifacts do not support HTTP POST requests.
 * </p>
 */
@ClarityEntity(uriSection = "artifacts", updateable = true, stateful = true)
@XmlRootElement(name = "artifact")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "artifact",
         propOrder = { "name", "type", "outputType", "parentProcess", "qcFlag", "location",
                       "workingFlag", "samples", "reagentLabels", "controlType", "fields", "file",
                       "artifactGroups", "workflowStages", "demux" })
public class Artifact implements LimsEntity<Artifact>, UDFHolder, Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 4667019853212119178L;

    /**
     * The name of the artifact.
     */
    protected String name;

    /**
     * The type of the artifact.
     */
    protected String type;

    /**
     * The output type of the artifact.
     */
    @XmlElement(name = "output-type")
    protected OutputType outputType;

    /**
     * The parent process that produced this artifact.
     */
    @XmlElement(name = "parent-process")
    protected ParentProcessLink parentProcess;

    /**
     * The quality control flag for this artifact.
     */
    @XmlElement(name = "qc-flag")
    protected QCFlag qcFlag;

    /**
     * The location of the artifact.
     */
    @XmlElement(name = "location")
    protected Location location;

    /**
     * Flag indicating if this artifact is in a working state.
     */
    @XmlElement(name = "working-flag")
    protected Boolean workingFlag;

    /**
     * The list of samples associated with this artifact.
     */
    @XmlElement(name = "sample")
    protected List<SampleLink> samples;

    /**
     * The list of reagent labels applied to this artifact.
     */
    @XmlElement(name = "reagent-label")
    protected List<ReagentLabel> reagentLabels;

    /**
     * The control type if this artifact is a control sample.
     */
    @XmlElement(name = "control-type")
    protected ControlTypeLink controlType;

    /**
     * The list of user-defined fields for this artifact.
     */
    @XmlElement(name = "field", namespace = UDF_NAMESPACE)
    protected List<UDF> fields;

    /**
     * The file associated with this artifact, if any.
     */
    @XmlElement(name = "file", namespace = FILE_NAMESPACE)
    protected ClarityFile file;

    /**
     * The list of artifact groups this artifact belongs to.
     */
    @XmlElement(name = "artifact-group")
    protected List<ArtifactGroupLink> artifactGroups;

    /**
     * The workflow stages this artifact is associated with.
     *
     * @since 2.20
     */
    @XmlElementWrapper(name = "workflow-stages")
    @XmlElement(name = "workflow-stage")
    protected List<WorkflowStage> workflowStages;

    /**
     * The demultiplexing information for this artifact if it is a pool.
     *
     * @since 2.26
     */
    @XmlElement(name = "demux")
    protected DemuxLink demux;

    /**
     * The LIMS id of the artifact.
     */
    @XmlAttribute(name = "limsid")
    protected String limsid;

    /**
     * The URI of the artifact.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * Default constructor.
     */
    public Artifact()
    {
    }

    /**
     * Constructor with a URI.
     *
     * @param uri The artifact URI.
    */
    public Artifact(URI uri)
    {
    }

    /**
     * Constructor with URI and id.
     *
     * @param uri The artifact URI.
     * @param name The artifact LIMS id.
     */
    public Artifact(URI uri, String limsid)
    {
        setUri(uri);
        setLimsId(limsid);
    }

    /**
     * Gets the name of the artifact.
     *
     * @return The artifact name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of the artifact.
     *
     * @param value The artifact name.
     */
    public void setName(String value)
    {
        this.name = value;
    }

    /**
     * Gets the type of the artifact.
     *
     * @return The artifact type.
     */
    public String getType()
    {
        return type;
    }

    /**
     * Sets the type of the artifact.
     *
     * @param value The artifact type.
     */
    public void setType(String value)
    {
        this.type = value;
    }

    /**
     * Gets the output type of the artifact.
     *
     * @return The output type.
     */
    public OutputType getOutputType()
    {
        return outputType;
    }

    /**
     * Sets the output type of the artifact.
     *
     * @param value The output type.
     */
    public void setOutputType(OutputType value)
    {
        this.outputType = value;
    }

    /**
     * Gets the parent process that produced this artifact.
     *
     * @return The parent process link.
     */
    public ParentProcessLink getParentProcess()
    {
        return parentProcess;
    }

    /**
     * Sets the parent process that produced this artifact.
     *
     * @param link The parent process link.
     * @return The created parent process link.
     */
    public ParentProcessLink setParentProcess(LimsEntityLinkable<ClarityProcess> link)
    {
        parentProcess = new ParentProcessLink(link);
        return parentProcess;
    }

    /**
     * Gets the quality control flag for this artifact.
     *
     * @return The QC flag.
     */
    public QCFlag getQCFlag()
    {
        return qcFlag;
    }

    /**
     * Sets the quality control flag for this artifact.
     *
     * @param value The QC flag.
     */
    public void setQCFlag(QCFlag value)
    {
        this.qcFlag = value;
    }

    /**
     * Gets the location of the artifact.
     *
     * @return The location.
     */
    public Location getLocation()
    {
        return location;
    }

    /**
     * Sets the location of the artifact.
     *
     * @param value The location.
     */
    public void setLocation(Location value)
    {
        this.location = value;
    }

    /**
     * Checks if this artifact is in a working state.
     *
     * @return The working flag.
     */
    public Boolean isWorkingFlag()
    {
        return workingFlag;
    }

    /**
     * Sets the working flag for this artifact.
     *
     * @param value The working flag.
     */
    public void setWorkingFlag(Boolean value)
    {
        this.workingFlag = value;
    }

    /**
     * Gets the list of samples associated with this artifact.
     *
     * @return The list of sample links.
     */
    public List<SampleLink> getSamples()
    {
        if (samples == null)
        {
            samples = new ArrayList<>();
        }
        return samples;
    }

    /**
     * Sets the list of samples associated with this artifact.
     *
     * @param links The collection of sample links.
     */
    public void setSamples(Collection<? extends LimsEntityLinkable<Sample>> links)
    {
        getSamples().clear();
        for (LimsEntityLinkable<Sample> link : links)
        {
            samples.add(new SampleLink(link));
        }
    }

    /**
     * Adds a sample to this artifact.
     *
     * @param linkable The linkable sample to add.
     * @return The created sample link.
     */
    public SampleLink addSample(Linkable<Sample> linkable)
    {
        SampleLink link = null;
        if (linkable != null)
        {
            link = new SampleLink(linkable);
            getSamples().add(link);
        }
        return link;
    }

    /**
     * Adds a sample to this artifact.
     *
     * @param linkable The LIMS entity linkable sample to add.
     * @return The created sample link.
     */
    public SampleLink addSample(LimsEntityLinkable<Sample> linkable)
    {
        SampleLink link = null;
        if (linkable != null)
        {
            link = new SampleLink(linkable);
            getSamples().add(link);
        }
        return link;
    }

    /**
     * Gets the list of reagent labels applied to this artifact.
     *
     * @return The list of reagent labels.
     */
    public List<ReagentLabel> getReagentLabels()
    {
        if (reagentLabels == null)
        {
            reagentLabels = new ArrayList<>();
        }
        return reagentLabels;
    }

    /**
     * Adds a reagent label to this artifact.
     *
     * @param label The reagent label to add.
     * @return The added reagent label.
     */
    public ReagentLabel addReagentLabel(ReagentLabel label)
    {
        getReagentLabels().add(label);
        return label;
    }

    /**
     * Adds a reagent label to this artifact.
     *
     * @param labelName The name of the reagent label to add.
     * @return The created reagent label.
     */
    public ReagentLabel addReagentLabel(String labelName)
    {
        return addReagentLabel(new ReagentLabel(labelName));
    }

    /**
     * Gets the control type if this artifact is a control sample.
     *
     * @return The control type link.
     */
    public ControlTypeLink getControlType()
    {
        return controlType;
    }

    /**
     * Sets the control type for this artifact.
     *
     * @param link The control type link.
     */
    public void setControlType(Linkable<ControlType> link)
    {
        this.controlType = link == null ? null : new ControlTypeLink(link);
    }

    @Override
    public List<UDF> getUserDefinedFields()
    {
        if (fields == null)
        {
            fields = new ArrayList<>();
        }
        return this.fields;
    }

    /**
     * File provides a URI linking to the detailed representation of the File
     * associated with the Artifact.
     *
     * @return The file link, if present.
     */
    public ClarityFile getFile()
    {
        return file;
    }

    /**
     * Sets the file associated with this artifact.
     *
     * @param value The file.
     */
    public void setFile(ClarityFile value)
    {
        this.file = value == null ? null : new ClarityFile(value);
    }

    /**
     * Gets the list of artifact groups this artifact belongs to.
     *
     * @return The list of artifact group links.
     */
    public List<ArtifactGroupLink> getArtifactGroups()
    {
        if (artifactGroups == null)
        {
            artifactGroups = new ArrayList<ArtifactGroupLink>();
        }
        return artifactGroups;
    }

    /**
     * Sets the artifact groups this artifact belongs to.
     *
     * @param links The collection of artifact group links.
     */
    public void setArtifactGroups(Collection<? extends Linkable<ArtifactGroup>> links)
    {
        getArtifactGroups().clear();
        for (Linkable<ArtifactGroup> link : links)
        {
            artifactGroups.add(new ArtifactGroupLink(link));
        }
    }

    /**
     * Adds an artifact group to this artifact.
     *
     * @param link The artifact group link to add.
     * @return The created artifact group link.
     */
    public ArtifactGroupLink addArtifactGroup(Linkable<ArtifactGroup> link)
    {
        ArtifactGroupLink l = new ArtifactGroupLink(link);
        getArtifactGroups().add(l);
        return l;
    }

    /**
     * Gets the workflow stages this artifact is associated with.
     *
     * @return The list of workflow stages.
     */
    public List<WorkflowStage> getWorkflowStages()
    {
        if (workflowStages == null)
        {
            workflowStages = new ArrayList<WorkflowStage>();
        }
        return workflowStages;
    }

    /**
     * Sets the workflow stages this artifact is associated with.
     *
     * @param workflowStages The collection of workflow stages.
     */
    public void setWorkflowStages(Collection<WorkflowStage> workflowStages)
    {
        getWorkflowStages().clear();
        getWorkflowStages().addAll(workflowStages);
    }

    /**
     * Adds a workflow stage to this artifact.
     *
     * @param stage The workflow stage to add.
     * @return The added workflow stage.
     */
    public WorkflowStage addWorkflowStage(WorkflowStage stage)
    {
        if (stage != null)
        {
            getWorkflowStages().add(stage);
        }
        return stage;
    }

    /**
     * Gets the demultiplexing information for this artifact.
     *
     * @return The demux link.
     */
    public DemuxLink getDemux()
    {
        return demux;
    }

    /**
     * Sets the demultiplexing information for this artifact.
     *
     * @param demux The demux link.
     */
    public void setDemux(Linkable<Demux> demux)
    {
        this.demux = demux == null ? null : new DemuxLink(demux.getUri());
    }

    /**
     * Gets the LIMS id of this artifact.
     *
     * @return The LIMS id.
     */
    @Override
    public String getLimsid()
    {
        return limsid;
    }

    /**
     * Sets the LIMS id of this artifact.
     *
     * @param value The LIMS id.
     */
    @Override
    public void setLimsid(String value)
    {
        this.limsid = value;
    }

    /**
     * Gets the URI of this artifact.
     *
     * @return The artifact URI.
     */
    @Override
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI of this artifact.
     *
     * @param value The artifact URI.
     */
    @Override
    public void setUri(URI value)
    {
        this.uri = value;
    }

    /**
     * Returns a string representation of this artifact.
     *
     * @return A string containing the LIMS id and type.
     */
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(limsid).append(SPACE).append(type);
        return sb.toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LimsEntityLink<Artifact> getLink()
    {
        return new ArtifactLink(this);
    }
}
