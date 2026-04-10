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

package com.genologics.ri.processexecution;

import static com.genologics.ri.Namespaces.UDF_NAMESPACE;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.genologics.ri.Linkable;
import com.genologics.ri.instrument.Instrument;
import com.genologics.ri.jaxb.ShortDateAdapter;
import com.genologics.ri.processtype.ProcessType;
import com.genologics.ri.researcher.Researcher;
import com.genologics.ri.userdefined.UDF;
import com.genologics.ri.userdefined.UDFHolder;
import com.genologics.ri.userdefined.UDT;

/**
 *
 * The process element defines the XML needed to run a process.
 */
@XmlRootElement(name = "process")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "process",
         propOrder = { "processType", "dateRun", "technician", "inputOutputMaps",
                       "type", "fields", "instrument", "parameter" })
public class ExecutableProcess implements UDFHolder, Serializable
{
    /**
     * Class version for serialisation.
     */
    @java.io.Serial
    private static final long serialVersionUID = -4582482597481524823L;

    /**
     * The process type name.
     */
    @XmlElement(name = "type")
    protected String processType;

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
    protected List<ExecutableInputOutputMap> inputOutputMaps;

    /**
     * The user-defined type.
     */
    @XmlElement(name = "type", namespace = UDF_NAMESPACE)
    protected UDT type;

    /**
     * The user-defined fields.
     */
    @XmlElement(name = "field", namespace = UDF_NAMESPACE)
    protected List<UDF> fields;

    /**
     * The instrument used for the process.
     */
    @XmlElement(name = "instrument")
    protected InstrumentLink instrument;

    /**
     * The process parameter for external program integration.
     */
    @XmlElement(name = "process-parameter")
    protected Parameter parameter;

    /**
     * Default constructor.
     */
    public ExecutableProcess()
    {
    }

    /**
     * Constructor with process type.
     *
     * @param processType The process type name.
     */
    public ExecutableProcess(String processType)
    {
        this.processType = processType;
    }

    /**
     * Constructor with process type and technician.
     *
     * @param processType The process type name.
     * @param technician The technician link.
     */
    public ExecutableProcess(String processType, Linkable<Researcher> technician)
    {
        this.processType = processType;
        setTechnician(technician);
    }

    /**
     * Gets the process type name.
     *
     * @return The process type name.
     */
    public String getProcessType()
    {
        return processType;
    }

    /**
     * Sets the process type name.
     *
     * @param processType The process type name to set.
     */
    public void setProcessType(String processType)
    {
        this.processType = processType;
    }

    /**
     * Sets the process type from a ProcessType object.
     *
     * @param processType The process type object.
     */
    public void setProcessType(ProcessType processType)
    {
        this.processType = processType.getName();
    }

    /**
     * Gets the date the process was run.
     *
     * @return The run date.
     */
    public Date getDateRun()
    {
        return dateRun;
    }

    /**
     * Sets the date the process was run.
     *
     * @param dateRun The run date to set.
     */
    public void setDateRun(Date dateRun)
    {
        this.dateRun = dateRun;
    }

    /**
     * Gets the technician who ran the process.
     *
     * @return The technician.
     */
    public Technician getTechnician()
    {
        return technician;
    }

    /**
     * Sets the technician from a researcher link.
     *
     * @param link The researcher link.
     */
    public void setTechnician(Linkable<Researcher> link)
    {
        this.technician = new Technician(link);
    }

    /**
     * Gets the input-output mappings.
     *
     * @return The input-output mappings (never null).
     */
    public List<ExecutableInputOutputMap> getInputOutputMaps()
    {
        if (inputOutputMaps == null)
        {
            inputOutputMaps = new ArrayList<ExecutableInputOutputMap>();
        }
        return inputOutputMaps;
    }

    /**
     * Adds an input-output map to the list.
     *
     * @param ioMap The input-output map to add.
     * @return The added input-output map.
     */
    public ExecutableInputOutputMap addInputOutputMap(ExecutableInputOutputMap ioMap)
    {
        getInputOutputMaps().add(ioMap);
        return ioMap;
    }

    /**
     * Creates and adds a new input-output map.
     *
     * @return The newly created input-output map.
     */
    public ExecutableInputOutputMap newInputOutputMap()
    {
        return addInputOutputMap(new ExecutableInputOutputMap());
    }

    /**
     * Gets the user-defined type.
     *
     * @return The user-defined type.
     */
    public UDT getUserDefinedType()
    {
        return type;
    }

    /**
     * Sets the user-defined type.
     *
     * @param type The user-defined type to set.
     * @return The user-defined type that was set.
     */
    public UDT setUserDefinedType(UDT type)
    {
        this.type = type;
        return this.type;
    }

    /**
     * Sets the user-defined type by name.
     *
     * @param type The type name.
     * @return The created user-defined type.
     */
    public UDT setUserDefinedType(String type)
    {
        this.type = new UDT(type);
        return this.type;
    }

    /**
     * Gets the user-defined fields.
     *
     * @return The user-defined fields (never null).
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
     * Gets the instrument used for the process.
     *
     * @return The instrument link.
     */
    public InstrumentLink getInstrument()
    {
        return instrument;
    }

    /**
     * Sets the instrument from an instrument link.
     *
     * @param link The instrument link.
     */
    public void setInstrument(Linkable<Instrument> link)
    {
        this.instrument = new InstrumentLink(link);
    }

    /**
     * Gets the process parameter.
     *
     * @return The parameter.
     */
    public Parameter getParameter()
    {
        return parameter;
    }

    /**
     * Sets the process parameter.
     *
     * @param parameter The parameter to set.
     */
    public void setParameter(Parameter parameter)
    {
        this.parameter = parameter;
    }

}
