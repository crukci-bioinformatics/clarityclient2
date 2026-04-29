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

package com.genologics.ri.process;

import static com.genologics.ri.Namespaces.FILE_NAMESPACE;
import static com.genologics.ri.Namespaces.UDF_NAMESPACE;
import static org.apache.commons.lang3.StringUtils.SPACE;

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
import com.genologics.ri.LimsEntity;
import com.genologics.ri.LimsEntityLink;
import com.genologics.ri.Linkable;
import com.genologics.ri.file.ClarityFile;
import com.genologics.ri.instrument.Instrument;
import com.genologics.ri.jaxb.ShortDateAdapter;
import com.genologics.ri.processtype.ProcessType;
import com.genologics.ri.researcher.Researcher;
import com.genologics.ri.userdefined.UDF;
import com.genologics.ri.userdefined.UDFHolder;
import com.genologics.ri.userdefined.UDT;

/**
 * The detailed representation of a process.
 */
@ClarityEntity(uriSection = "processes", cacheable = true, creatable = true, updateable = true)
@XmlRootElement(name = "process")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "process",
         propOrder = { "processType", "dateRun", "technician", "inputOutputMaps", "type", "fields",
                       "files", "protocolName", "instrument", "parameter" })
public class ClarityProcess implements LimsEntity<ClarityProcess>, UDFHolder, Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 6767285324829996005L;

    /**
     * The type of the process.
     */
    @XmlElement(name = "type")
    protected ProcessTypeLink processType;

    /**
     * The date the process was run.
     */
    @XmlElement(name = "date-run")
    @XmlSchemaType(name = "date")
    @XmlJavaTypeAdapter(ShortDateAdapter.class)
    protected Date dateRun;

    /**
     * The technician who ran the process.
     */
    @XmlElement(name = "technician")
    protected Technician technician;

    /**
     * The input-output mappings for the process.
     */
    @XmlElement(name = "input-output-map")
    protected List<InputOutputMap> inputOutputMaps;

    /**
     * The user defined type.
     */
    @XmlElement(name = "type", namespace = UDF_NAMESPACE)
    protected UDT type;

    /**
     * The user defined fields.
     */
    @XmlElement(name = "field", namespace = UDF_NAMESPACE)
    protected List<UDF> fields;

    /**
     * The files associated with the process.
     */
    @XmlElement(name = "file", namespace = FILE_NAMESPACE)
    protected List<ClarityFile> files;

    /**
     * The protocol name.
     */
    @XmlElement(name = "protocol-name")
    protected String protocolName;

    /**
     * The instrument used to run the process.
     */
    @XmlElement(name = "instrument")
    protected InstrumentLink instrument;

    /**
     * The process parameter for external program integration.
     */
    @XmlElement(name = "process-parameter")
    protected Parameter parameter;

    /**
     * The LIMS id of the process.
     */
    @XmlAttribute(name = "limsid")
    protected String limsid;

    /**
     * The URI of the process.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * Default constructor.
     */
    public ClarityProcess()
    {
    }

    /**
     * Constructor with URI.
     *
     * @param uri the URI of the process.
     */
    public ClarityProcess(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructor with URI and LIMS id.
     *
     * @param uri the URI of the process.
     * @param limsid the LIMS id of the process.
     */
    public ClarityProcess(URI uri, String limsid)
    {
        this.limsid = limsid;
        this.uri = uri;
    }

    /**
     * Gets the LIMS id.
     *
     * @return the LIMS id.
     */
    public String getLimsid()
    {
        return limsid;
    }

    /**
     * Sets the LIMS id.
     *
     * @param value the LIMS id to set.
     */
    public void setLimsid(String value)
    {
        this.limsid = value;
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
     * @param value the URI to set.
     */
    public void setUri(URI value)
    {
        this.uri = value;
    }

    /**
     * Gets the process type link.
     *
     * @return the process type link.
     */
    public ProcessTypeLink getProcessType()
    {
        return processType;
    }

    /**
     * Sets the process type from a linkable object.
     *
     * @param link the linkable process type.
     */
    public void setProcessType(Linkable<ProcessType> link)
    {
        this.processType = new ProcessTypeLink(link);
    }

    /**
     * Sets the process type.
     *
     * @param processType the process type to set.
     */
    public void setProcessType(ProcessType processType)
    {
        this.processType = new ProcessTypeLink(processType);
    }

    /**
     * Gets the date the process was run.
     *
     * @return the date the process was run.
     */
    public Date getDateRun()
    {
        return dateRun;
    }

    /**
     * Sets the date the process was run.
     *
     * @param dateRun the date to set.
     */
    public void setDateRun(Date dateRun)
    {
        this.dateRun = dateRun;
    }

    /**
     * Gets the technician.
     *
     * @return the technician.
     */
    public Technician getTechnician()
    {
        return technician;
    }

    /**
     * Sets the technician from a linkable researcher.
     *
     * @param link the linkable researcher.
     */
    public void setTechnician(Linkable<Researcher> link)
    {
        this.technician = new Technician(link);
    }

    /**
     * Gets the input-output mappings.
     *
     * @return the list of input-output mappings.
     */
    public List<InputOutputMap> getInputOutputMaps()
    {
        if (inputOutputMaps == null)
        {
            inputOutputMaps = new ArrayList<InputOutputMap>();
        }
        return inputOutputMaps;
    }

    /**
     * Adds an input-output mapping.
     *
     * @param ioMap the input-output mapping to add.
     * @return the added input-output mapping.
     */
    public InputOutputMap addInputOutputMap(InputOutputMap ioMap)
    {
        getInputOutputMaps().add(ioMap);
        return ioMap;
    }

    /**
     * Gets the user defined type.
     *
     * @return the user defined type.
     */
    public UDT getUserDefinedType()
    {
        return type;
    }

    /**
     * Sets the user defined type.
     *
     * @param type the user defined type to set.
     * @return the user defined type that was set.
     */
    public UDT setUserDefinedType(UDT type)
    {
        this.type = type;
        return this.type;
    }

    /**
     * Sets the user defined type by name.
     *
     * @param type the name of the user defined type.
     * @return the created user defined type.
     */
    public UDT setUserDefinedType(String type)
    {
        this.type = new UDT(type);
        return this.type;
    }

    /**
     * Gets the user defined fields.
     *
     * @return the list of user defined fields.
     */
    @Override
    public List<UDF> getUserDefinedFields()
    {
        if (fields == null)
        {
            fields = new ArrayList<UDF>();
        }
        return fields;
    }

    /**
     * Gets the files associated with the process.
     *
     * @return the list of files.
     */
    public List<ClarityFile> getFiles()
    {
        if (files == null)
        {
            files = new ArrayList<ClarityFile>();
        }
        return files;
    }

    /**
     * Adds a file to the process.
     *
     * @param f the file to add.
     * @return the added file.
     */
    public ClarityFile addFile(ClarityFile f)
    {
        getFiles().add(f);
        return f;
    }

    /**
     * Gets the protocol name.
     *
     * @return the protocol name.
     */
    public String getProtocolName()
    {
        return protocolName;
    }

    /**
     * Sets the protocol name.
     *
     * @param protocolName the protocol name to set.
     */
    public void setProtocolName(String protocolName)
    {
        this.protocolName = protocolName;
    }

    /**
     * Gets the instrument link.
     *
     * @return the instrument link.
     */
    public InstrumentLink getInstrument()
    {
        return instrument;
    }

    /**
     * Sets the instrument from a linkable object.
     *
     * @param link the linkable instrument.
     */
    public void setInstrument(Linkable<Instrument> link)
    {
        this.instrument = new InstrumentLink(link);
    }

    /**
     * Gets the parameter.
     *
     * @return the parameter.
     */
    public Parameter getParameter()
    {
        return parameter;
    }

    /**
     * Sets the parameter.
     *
     * @param parameter the parameter to set.
     */
    public void setParameter(Parameter parameter)
    {
        this.parameter = parameter;
    }

    /**
     * Returns a string representation of this process.
     *
     * @return a string containing the LIMS id and process type name.
     */
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(limsid);
        if (processType != null)
        {
            sb.append(SPACE).append(processType.getName());
        }
        return sb.toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LimsEntityLink<ClarityProcess> getLink()
    {
        return new ProcessLink(this);
    }
}
