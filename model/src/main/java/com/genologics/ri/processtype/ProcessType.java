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

package com.genologics.ri.processtype;

import java.io.Serial;
import java.io.Serializable;
import java.net.URI;
import java.util.ArrayList;
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
import com.genologics.ri.LimsLink;
import com.genologics.ri.Linkable;
import com.genologics.ri.configuration.FieldLink;

/**
 * The process-type element contains the XML representation of a type of process
 * configured in the system.
 */
@ClarityEntity(uriSection = "processtypes")
@XmlRootElement(name = "process-type")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "process-type",
         propOrder = { "fieldDefinitions", "parameters", "typeDefinitions", "processInputs",
                       "processOutputs", "processTypeAttributes",
                       "permittedContainers", "permittedReagentCategories", "requiredReagentKits",
                       "permittedControlTypes", "permittedInstrumentTypes",
                       "queueFields", "iceBucketFields", "stepFields", "sampleFields",
                       "stepProperties", "stepSetup", "eppTriggers" })
public class ProcessType implements Linkable<ProcessType>, Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 3103866326222677563L;

    /**
     * Field definitions for user-defined fields.
     */
    @XmlElement(name = "field-definition")
    protected List<FieldLink> fieldDefinitions;

    /**
     * EPP parameters for this process type.
     */
    @XmlElement(name = "parameter")
    protected List<Parameter> parameters;

    /**
     * Type definitions for user-defined types.
     */
    @XmlElement(name = "type-definition")
    protected List<TypeDefinition> typeDefinitions;

    /**
     * Process input configurations.
     */
    @XmlElement(name = "process-input")
    protected List<ProcessInput> processInputs;

    /**
     * Process output configurations.
     */
    @XmlElement(name = "process-output")
    protected List<ProcessOutput> processOutputs;

    /**
     * Internal process type attributes.
     */
    @XmlElement(name = "process-type-attribute")
    protected List<ProcessTypeAttribute> processTypeAttributes;

    /**
     * Permitted container types for this process.
     *
     * @since 2.25
     */
    @XmlElementWrapper(name = "permitted-containers")
    @XmlElement(name = "container-type")
    protected List<ContainerTypeLink> permittedContainers;

    /**
     * Permitted reagent categories for this process.
     *
     * @since 2.25
     */
    @XmlElementWrapper(name = "permitted-reagent-categories")
    @XmlElement(name = "reagent-category")
    protected List<String> permittedReagentCategories;

    /**
     * Required reagent kits for this process.
     *
     * @since 2.25
     */
    @XmlElementWrapper(name = "required-reagent-kits")
    @XmlElement(name = "reagent-kit")
    protected List<ReagentKitLink> requiredReagentKits;

    /**
     * Permitted control types for this process.
     *
     * @since 2.25
     */
    @XmlElementWrapper(name = "permitted-control-types")
    @XmlElement(name = "control-type")
    protected List<ControlTypeLink> permittedControlTypes;

    /**
     * Permitted instrument types for this process.
     *
     * @since 2.25
     */
    @XmlElementWrapper(name = "permitted-instrument-types")
    @XmlElement(name = "instrument-type")
    protected List<String> permittedInstrumentTypes;

    /**
     * Fields displayed in the queue view.
     *
     * @since 2.25
     */
    @XmlElementWrapper(name = "queue-fields")
    @XmlElement(name = "queue-field")
    protected List<QueueField> queueFields;

    /**
     * Fields displayed in the ice bucket view.
     *
     * @since 2.25
     */
    @XmlElementWrapper(name = "ice-bucket-fields")
    @XmlElement(name = "ice-bucket-field")
    protected List<IceBucketField> iceBucketFields;

    /**
     * Fields displayed in the step view.
     *
     * @since 2.25
     */
    @XmlElementWrapper(name = "step-fields")
    @XmlElement(name = "step-field")
    protected List<Field> stepFields;

    /**
     * Fields displayed for samples in the step view.
     *
     * @since 2.25
     */
    @XmlElementWrapper(name = "sample-fields")
    @XmlElement(name = "sample-field")
    protected List<Field> sampleFields;

    /**
     * Properties for the step configuration.
     *
     * @since 2.25
     */
    @XmlElementWrapper(name = "step-properties")
    @XmlElement(name = "step-property")
    protected List<StepProperty> stepProperties;

    /**
     * Step setup configuration.
     *
     * @since 2.25
     */
    @XmlElement(name = "step-setup")
    protected StepSetup stepSetup;

    /**
     * EPP triggers for this process type.
     *
     * @since 2.25
     */
    @XmlElementWrapper(name = "epp-triggers")
    @XmlElement(name = "epp-trigger")
    protected List<EppTrigger> eppTriggers;

    /**
     * The name of the process type.
     */
    @XmlAttribute(name = "name")
    protected String name;

    /**
     * The URI of the process type.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * Constructs a new process type.
     */
    public ProcessType()
    {
    }

    /**
     * Constructs a new process type with the specified URI.
     *
     * @param uri the URI of the process type.
     */
    public ProcessType(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructs a new process type with the specified URI and name.
     *
     * @param uri the URI of the process type.
     * @param name the name of the process type.
     */
    public ProcessType(URI uri, String name)
    {
        this.uri = uri;
        this.name = name;
    }

    /**
     * Gets the name of the process type.
     *
     * @return the process type name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of the process type.
     *
     * @param name the process type name.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Gets the URI of the process type.
     *
     * @return the process type URI.
     */
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI of the process type.
     *
     * @param uri the process type URI.
     */
    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Each field definition provides a URI linking to the configuration of a user-defined field for the output type.
     *
     * @return A list of links to fields.
     */
    public List<FieldLink> getFieldDefinitions()
    {
        if (fieldDefinitions == null)
        {
            fieldDefinitions = new ArrayList<FieldLink>();
        }
        return fieldDefinitions;
    }

    /**
     * Gets the EPP parameters for this process type.
     *
     * @return a list of parameters.
     */
    public List<Parameter> getParameters()
    {
        if (parameters == null)
        {
            parameters = new ArrayList<Parameter>();
        }
        return parameters;
    }

    /**
     * Gets the type definitions for this process type.
     *
     * @return a list of type definitions.
     */
    public List<TypeDefinition> getTypeDefinitions()
    {
        if (typeDefinitions == null)
        {
            typeDefinitions = new ArrayList<TypeDefinition>();
        }
        return typeDefinitions;
    }

    /**
     * Adds a type definition for the specified field.
     *
     * @param link the field link.
     * @return the created type definition.
     */
    public TypeDefinition addTypeDefinition(Linkable<com.genologics.ri.configuration.Field> link)
    {
        TypeDefinition td = new TypeDefinition(link);
        getTypeDefinitions().add(td);
        return td;
    }

    /**
     * Gets the process input configurations.
     *
     * @return a list of process inputs.
     */
    public List<ProcessInput> getProcessInputs()
    {
        if (processInputs == null)
        {
            processInputs = new ArrayList<ProcessInput>();
        }
        return processInputs;
    }

    /**
     * Gets the process output configurations.
     *
     * @return a list of process outputs.
     */
    public List<ProcessOutput> getProcessOutputs()
    {
        if (processOutputs == null)
        {
            processOutputs = new ArrayList<ProcessOutput>();
        }
        return processOutputs;
    }

    /**
     * Gets the process type attributes.
     *
     * @return a list of process type attributes.
     */
    public List<ProcessTypeAttribute> getProcessTypeAttributes()
    {
        if (processTypeAttributes == null)
        {
            processTypeAttributes = new ArrayList<ProcessTypeAttribute>();
        }
        return processTypeAttributes;
    }

    /**
     * Gets the permitted container types for this process.
     *
     * @return a list of container type links.
     */
    public List<ContainerTypeLink> getPermittedContainers()
    {
        if (permittedContainers == null)
        {
            permittedContainers = new ArrayList<ContainerTypeLink>();
        }
        return permittedContainers;
    }

    /**
     * Gets the permitted reagent categories for this process.
     *
     * @return a list of reagent category names.
     */
    public List<String> getPermittedReagentCategories()
    {
        if (permittedReagentCategories == null)
        {
            permittedReagentCategories = new ArrayList<String>();
        }
        return permittedReagentCategories;
    }

    /**
     * Gets the required reagent kits for this process.
     *
     * @return a list of reagent kit links.
     */
    public List<ReagentKitLink> getRequiredReagentKits()
    {
        if (requiredReagentKits == null)
        {
            requiredReagentKits = new ArrayList<ReagentKitLink>();
        }
        return requiredReagentKits;
    }

    /**
     * Gets the permitted control types for this process.
     *
     * @return a list of control type links.
     */
    public List<ControlTypeLink> getPermittedControlTypes()
    {
        if (permittedControlTypes == null)
        {
            permittedControlTypes = new ArrayList<ControlTypeLink>();
        }
        return permittedControlTypes;
    }

    /**
     * Gets the permitted instrument types for this process.
     *
     * @return a list of instrument type names.
     */
    public List<String> getPermittedInstrumentTypes()
    {
        if (permittedInstrumentTypes == null)
        {
            permittedInstrumentTypes = new ArrayList<String>();
        }
        return permittedInstrumentTypes;
    }

    /**
     * Gets the fields displayed in the queue view.
     *
     * @return a list of queue fields.
     */
    public List<QueueField> getQueueFields()
    {
        if (queueFields == null)
        {
            queueFields = new ArrayList<QueueField>();
        }
        return queueFields;
    }

    /**
     * Gets the fields displayed in the ice bucket view.
     *
     * @return a list of ice bucket fields.
     */
    public List<IceBucketField> getIceBucketFields()
    {
        if (iceBucketFields == null)
        {
            iceBucketFields = new ArrayList<IceBucketField>();
        }
        return iceBucketFields;
    }

    /**
     * Gets the fields displayed in the step view.
     *
     * @return a list of step fields.
     */
    public List<Field> getStepFields()
    {
        if (stepFields == null)
        {
            stepFields = new ArrayList<Field>();
        }
        return stepFields;
    }

    /**
     * Gets the fields displayed for samples in the step view.
     *
     * @return a list of sample fields.
     */
    public List<Field> getSampleFields()
    {
        if (sampleFields == null)
        {
            sampleFields = new ArrayList<Field>();
        }
        return sampleFields;
    }

    /**
     * Gets the step properties for this process type.
     *
     * @return a list of step properties.
     */
    public List<StepProperty> getStepProperties()
    {
        if (stepProperties == null)
        {
            stepProperties = new ArrayList<StepProperty>();
        }
        return stepProperties;
    }

    /**
     * Gets the step setup configuration.
     *
     * @return the step setup.
     */
    public StepSetup getStepSetup()
    {
        return stepSetup;
    }

    /**
     * Sets the step setup configuration.
     *
     * @param stepSetup the step setup.
     */
    public void setStepSetup(StepSetup stepSetup)
    {
        this.stepSetup = stepSetup;
    }

    /**
     * Gets the EPP triggers for this process type.
     *
     * @return a list of EPP triggers.
     */
    public List<EppTrigger> getEppTriggers()
    {
        if (eppTriggers == null)
        {
            eppTriggers = new ArrayList<EppTrigger>();
        }
        return eppTriggers;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LimsLink<ProcessType> getLink()
    {
        return new ProcessTypeLink(this);
    }
}
