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

import static com.genologics.ri.Namespaces.UDF_NAMESPACE;

import java.io.Serial;
import java.io.Serializable;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.ClarityEntity;
import com.genologics.ri.LimsLink;
import com.genologics.ri.Linkable;
import com.genologics.ri.instrument.Instrument;
import com.genologics.ri.processtype.ProcessType;
import com.genologics.ri.researcher.Researcher;
import com.genologics.ri.userdefined.UDF;
import com.genologics.ri.userdefined.UDFHolder;
import com.genologics.ri.userdefined.UDT;

/**
 * The detailed representation of a Process Template.
 */
@ClarityEntity(uriSection = "processtemplates")
@XmlRootElement(name = "process-template")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "process-template",
         propOrder = { "name", "processType", "technician", "instrument", "parameter",
                       "type", "fields", "defaultTemplate" })
public class ProcessTemplate implements Linkable<ProcessTemplate>, UDFHolder, Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 3219761173873030207L;

    /**
     * The name of this process template.
     */
    @XmlElement(name = "name")
    protected String name;

    /**
     * The process type this template is associated with.
     */
    @XmlElement(name = "type")
    protected ProcessTypeLink processType;

    /**
     * The technician configured to run processes created from this template.
     */
    @XmlElement(name = "technician")
    protected Technician technician;

    /**
     * The instrument configured to run processes created from this template.
     */
    @XmlElement(name = "instrument")
    protected InstrumentLink instrument;

    /**
     * The process parameter for external program integration.
     */
    @XmlElement(name = "process-parameter")
    protected Parameter parameter;

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
     * Indicates whether this is the default template for the associated process type.
     */
    @XmlElement(name = "is-default")
    protected Boolean defaultTemplate;

    /**
     * The URI of this process template.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;


    /**
     * Default constructor.
     */
    public ProcessTemplate()
    {
    }

    /**
     * Constructor with URI.
     *
     * @param uri the URI of the process template.
     */
    public ProcessTemplate(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructor with URI and name.
     *
     * @param uri the URI of the process template.
     * @param name the name of the process template.
     */
    public ProcessTemplate(URI uri, String name)
    {
        this.uri = uri;
        this.name = name;
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
     * Gets the name.
     *
     * @return the name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name the name to set.
     */
    public void setName(String name)
    {
        this.name = name;
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
     * Sets the process type.
     *
     * @param processType the process type link to set.
     */
    public void setProcessType(ProcessTypeLink processType)
    {
        this.processType = processType;
    }

    /**
     * Sets the process type from a ProcessType object.
     *
     * @param processType the process type to set.
     */
    public void setProcessType(ProcessType processType)
    {
        setProcessType(new ProcessTypeLink(processType));
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
     * Sets the technician.
     *
     * @param technician the technician to set.
     */
    public void setTechnician(Technician technician)
    {
        this.technician = technician;
    }

    /**
     * Sets the technician from a Researcher object.
     *
     * @param researcher the researcher to set as technician.
     */
    public void setTechnician(Researcher researcher)
    {
        setTechnician(new Technician(researcher));
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
     * Sets the instrument.
     *
     * @param instrument the instrument link to set.
     */
    public void setInstrument(InstrumentLink instrument)
    {
        this.instrument = instrument;
    }

    /**
     * Sets the instrument from an Instrument object.
     *
     * @param instrument the instrument to set.
     */
    public void setInstrument(Instrument instrument)
    {
        setInstrument(new InstrumentLink(instrument));
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
     * Gets the user-defined type.
     *
     * @return the user-defined type.
     */
    public UDT getUserDefinedType()
    {
        return type;
    }

    /**
     * Sets the user-defined type.
     *
     * @param value the user-defined type to set.
     * @return the user-defined type that was set.
     */
    public UDT setUserDefinedType(UDT value)
    {
        this.type = value;
        return this.type;
    }

    /**
     * Sets the user-defined type by name.
     *
     * @param type the name of the user-defined type.
     * @return the created user-defined type.
     */
    public UDT setUserDefinedType(String type)
    {
        this.type = new UDT(type);
        return this.type;
    }

    /**
     * Gets the user-defined fields.
     *
     * @return the list of user-defined fields (never null).
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
     * Checks if this is the default template.
     *
     * @return true if this is the default template, false otherwise.
     */
    public Boolean isDefault()
    {
        return defaultTemplate;
    }

    /**
     * Sets whether this is the default template.
     *
     * @param defaultTemplate true to make this the default template.
     */
    public void setDefault(Boolean defaultTemplate)
    {
        this.defaultTemplate = defaultTemplate;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LimsLink<ProcessTemplate> getLink()
    {
        return new ProcessTemplateLink(this);
    }
}
