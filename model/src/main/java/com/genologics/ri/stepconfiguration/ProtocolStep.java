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

package com.genologics.ri.stepconfiguration;

import java.io.Serial;
import java.io.Serializable;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
import com.genologics.ri.containertype.ContainerType;
import com.genologics.ri.controltype.ControlType;
import com.genologics.ri.processtype.ProcessType;
import com.genologics.ri.protocolconfiguration.Protocol;
import com.genologics.ri.reagentkit.ReagentKit;
import com.genologics.ri.reagenttype.ReagentType;
import com.genologics.ri.stage.ProtocolStepLink;

// TODO - this one needs updating from the "Step" class generated.
// Will also need to do ObjectFactory, remember? Copy from generated and insert.

/**
 *
 * <p>
 * Detailed representation of a Step
 * </p>
 * <p>
 * Steps are the elements that compose protocols. They have various properties
 * regarding different UDFs contained on each view of the step as well as
 * configuration option and filters
 * </p>
 */
@ClarityEntity(uriSection = "steps", primaryEntity = Protocol.class)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "step",
         propOrder = { "protocolStepIndex", "processType", "permittedContainerTypes", "permittedReagentCategories",
                       "requiredReagentKits", "permittedControlTypes", "permittedInstrumentTypes", "transitions",
                       "defaultGrouping", "queueFields", "iceBucketFields", "stepFields", "sampleFields",
                       "stepProperties", "stepSetup", "eppTriggers" })
@XmlRootElement(name = "step")
public class ProtocolStep implements Linkable<ProtocolStep>, Serializable
{
    /**
     * Regular expression to extract protocol id and protocol step id from a
     * protocol step URI.
     *
     * @since 2.22
     */
    public static final Pattern ID_EXTRACTOR_PATTERN;

    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 496185986542798015L;

    /**
     * The index of this step within the protocol.
     */
    @XmlElement(name = "protocol-step-index")
    protected Integer protocolStepIndex;

    /**
     * The process type associated with this step.
     */
    @XmlElement(name = "process-type")
    protected ProcessTypeLink processType;

    /**
     * List of permitted container types for this step.
     */
    @XmlElementWrapper(name = "permitted-containers")
    @XmlElement(name = "container-type")
    protected List<GenericTypeLink> permittedContainerTypes;

    /**
     * List of permitted reagent categories for this step.
     */
    @XmlElementWrapper(name = "permitted-reagent-categories")
    @XmlElement(name = "reagent-category")
    protected List<GenericTypeLink> permittedReagentCategories;

    /**
     * List of required reagent kits for this step.
     *
     * @since 2.18
     */
    @XmlElementWrapper(name = "required-reagent-kits")
    @XmlElement(name = "reagent-kit")
    protected List<ReagentKitLink> requiredReagentKits;

    /**
     * List of permitted control types for this step.
     */
    @XmlElementWrapper(name = "permitted-control-types")
    @XmlElement(name = "control-type")
    protected List<ControlTypeLink> permittedControlTypes;

    /**
     * List of permitted instrument types for this step.
     *
     * @since 2.25
     */
    @XmlElementWrapper(name = "permitted-instrument-types")
    @XmlElement(name = "instrument-type")
    protected List<GenericTypeLink> permittedInstrumentTypes;

    /**
     * List of transitions to next steps in the protocol.
     */
    @XmlElementWrapper(name = "transitions")
    @XmlElement(name = "transition")
    protected List<NextStep> transitions;

    /**
     * Default field for grouping samples in the queue view.
     *
     * @since 2.18
     * @deprecated Please use "&lt;milestone&gt;DefaultGrouping" in a {@link StepProperty} field instead.
     */
    @Deprecated
    @XmlElement(name = "default-grouping")
    protected GenericTypeLink defaultGrouping;

    /**
     * List of fields to display in the queue view.
     */
    @XmlElementWrapper(name = "queue-fields")
    @XmlElement(name = "queue-field")
    protected List<QueueField> queueFields;

    /**
     * List of fields to display in the ice bucket view.
     *
     * @since 2.25
     */
    @XmlElementWrapper(name = "ice-bucket-fields")
    @XmlElement(name = "ice-bucket-field")
    protected List<IceBucketField> iceBucketFields;

    /**
     * List of fields to display on the step.
     */
    @XmlElementWrapper(name = "step-fields")
    @XmlElement(name = "step-field")
    protected List<Field> stepFields;

    /**
     * List of fields to display for samples.
     */
    @XmlElementWrapper(name = "sample-fields")
    @XmlElement(name = "sample-field")
    protected List<Field> sampleFields;

    /**
     * List of step properties.
     */
    @XmlElementWrapper(name = "step-properties")
    @XmlElement(name = "step-property")
    protected List<StepProperty> stepProperties;

    /**
     * Configuration for the step setup view.
     */
    @XmlElement(name = "step-setup")
    protected StepSetup stepSetup;

    /**
     * List of EPP triggers for this step.
     */
    @XmlElementWrapper(name = "epp-triggers")
    @XmlElement(name = "epp-trigger")
    protected List<EppTrigger> eppTriggers;

    /**
     * The name of the protocol step.
     */
    @XmlAttribute(name = "name")
    protected String name;

    /**
     * The URI of the protocol step.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * The URI of the protocol this step belongs to.
     */
    @XmlAttribute(name = "protocol-uri")
    @XmlSchemaType(name = "anyURI")
    protected URI protocolUri;


    static
    {
        ClarityEntity innerAnno = ProtocolStep.class.getAnnotation(ClarityEntity.class);
        ClarityEntity outerAnno = innerAnno.primaryEntity().getAnnotation(ClarityEntity.class);

        StringBuilder b = new StringBuilder();
        b.append("^.*/").append(outerAnno.uriSection()).append("/(\\d+)/");
        b.append(innerAnno.uriSection()).append("/(\\d+)$");

        ID_EXTRACTOR_PATTERN = Pattern.compile(b.toString());
    }

    /**
     * Default constructor.
     */
    public ProtocolStep()
    {
    }

    /**
     * Constructor with URI.
     *
     * @param uri The URI of the protocol step.
     */
    public ProtocolStep(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructor with URI and name.
     *
     * @param uri The URI of the protocol step.
     * @param name The name of the protocol step.
     */
    public ProtocolStep(URI uri, String name)
    {
        this.uri = uri;
        this.name = name;
    }

    /**
     * Get the numeric identifier for this protocol step from its URI.
     *
     * @return The protocol step id, or null if either the URI is not set
     * or it doesn't match the form expected for a protocol step URI.
     *
     * @since 2.22
     */
    public Integer getId()
    {
        Integer id = null;
        if (uri != null)
        {
            Matcher m = ID_EXTRACTOR_PATTERN.matcher(uri.toString());
            if (m.matches())
            {
                id = Integer.valueOf(m.group(2));
            }
        }
        return id;
    }

    /**
     * Get the numeric identifier for this step's protocol from its URI.
     *
     * @return The protocol id, or null if either the URI is not set
     * or it doesn't match the form expected for a protocol step URI.
     *
     * @since 2.22
     */
    public Integer getProtocolId()
    {
        Integer id = null;
        if (uri != null)
        {
            Matcher m = ID_EXTRACTOR_PATTERN.matcher(uri.toString());
            if (m.matches())
            {
                id = Integer.valueOf(m.group(1));
            }
        }
        return id;
    }

    /**
     * Gets the protocol step index.
     *
     * @return The protocol step index.
     */
    public Integer getProtocolStepIndex()
    {
        return protocolStepIndex;
    }

    /**
     * Sets the protocol step index.
     *
     * @param protocolStepIndex The protocol step index.
     */
    public void setProtocolStepIndex(Integer protocolStepIndex)
    {
        this.protocolStepIndex = protocolStepIndex;
    }

    /**
     * Gets the process type for this step.
     *
     * @return The process type link.
     */
    public ProcessTypeLink getProcessType()
    {
        return processType;
    }

    /**
     * Sets the process type for this step.
     *
     * @param processType The linkable process type.
     */
    public void setProcessType(Linkable<ProcessType> processType)
    {
        this.processType = new ProcessTypeLink(processType);
    }

    /**
     * Gets the list of permitted container types for this step.
     *
     * @return The list of permitted container types.
     */
    public List<GenericTypeLink> getPermittedContainerTypes()
    {
        if (permittedContainerTypes == null)
        {
            permittedContainerTypes = new ArrayList<GenericTypeLink>();
        }
        return permittedContainerTypes;
    }

    /**
     * Adds a permitted container type by name.
     *
     * @param containerType The container type name.
     * @return The container type name.
     */
    public String addPermittedContainer(String containerType)
    {
        getPermittedContainerTypes().add(new GenericTypeLink(containerType));
        return containerType;
    }

    /**
     * Adds a permitted container type from a ContainerType entity.
     *
     * @param type The container type entity.
     * @return The container type name.
     */
    public String addPermittedContainer(ContainerType type)
    {
        getPermittedContainerTypes().add(new GenericTypeLink(type.getName()));
        return type.getName();
    }

    /**
     * Gets the list of permitted reagent categories for this step.
     *
     * @return The list of permitted reagent categories.
     */
    public List<GenericTypeLink> getPermittedReagentCategories()
    {
        if (permittedContainerTypes == null)
        {
            permittedContainerTypes = new ArrayList<GenericTypeLink>();
        }
        return permittedContainerTypes;
    }

    /**
     * Adds a permitted reagent category by name.
     *
     * @param category The reagent category name.
     * @return The reagent category name.
     */
    public String addPermittedReagentCategory(String category)
    {
        getPermittedReagentCategories().add(new GenericTypeLink(category));
        return category;
    }

    /**
     * Adds a permitted reagent category from a ReagentType entity.
     *
     * @param reagentType The reagent type entity.
     * @return The reagent category name, or null if not available.
     */
    public String addPermittedReagentCategory(ReagentType reagentType)
    {
        String category = null;
        if (reagentType != null && reagentType.getReagentCategory() != null)
        {
            category = reagentType.getReagentCategory();
            getPermittedReagentCategories().add(new GenericTypeLink(category));
        }
        return category;
    }

    /**
     * Gets the list of required reagent kits for this step.
     *
     * @return The list of required reagent kits.
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
     * Adds a required reagent kit.
     *
     * @param kit The linkable reagent kit.
     * @return The reagent kit link.
     */
    public ReagentKitLink addRequiredReagentKit(Linkable<ReagentKit> kit)
    {
        ReagentKitLink link = new ReagentKitLink(kit);
        getRequiredReagentKits().add(link);
        return link;
    }

    /**
     * Gets the list of permitted control types for this step.
     *
     * @return The list of permitted control types.
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
     * Adds a permitted control type.
     *
     * @param controlType The linkable control type.
     * @return The control type link.
     */
    public ControlTypeLink addPermittedControlType(Linkable<ControlType> controlType)
    {
        ControlTypeLink link = new ControlTypeLink(controlType);
        getPermittedControlTypes().add(link);
        return link;
    }

    /**
     * Gets the list of permitted instrument types for this step.
     *
     * @return The list of permitted instrument types.
     */
    public List<GenericTypeLink> getPermittedInstrumentTypes()
    {
        if (permittedInstrumentTypes == null)
        {
            permittedInstrumentTypes = new ArrayList<GenericTypeLink>();
        }
        return permittedInstrumentTypes;
    }

    /**
     * Gets the list of transitions to next steps.
     *
     * @return The list of transitions.
     */
    public List<NextStep> getTransitions()
    {
        if (transitions == null)
        {
            transitions = new ArrayList<NextStep>();
        }
        return transitions;
    }

    /**
     * Adds a transition to a next step.
     *
     * @param transition The next step transition.
     * @return The next step transition.
     */
    public NextStep addTransition(NextStep transition)
    {
        getTransitions().add(transition);
        return transition;
    }

    /**
     * Field by which the queue view samples will be grouped by default.
     *
     * @return Grouping field.
     *
     * @deprecated Please use "&lt;milestone&gt;DefaultGrouping"
     * (for example, "queueDefaultGrouping") in a {@link StepProperty} field instead.
     */
    @Deprecated
    public GenericTypeLink getDefaultGrouping()
    {
        return defaultGrouping;
    }

    @Deprecated
    public void setDefaultGrouping(GenericTypeLink defaultGrouping)
    {
        this.defaultGrouping = defaultGrouping;
    }

    /**
     * Gets the list of queue fields for this step.
     *
     * @return The list of queue fields.
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
     * Adds a queue field.
     *
     * @param field The queue field.
     * @return The queue field.
     */
    public QueueField addQueueField(QueueField field)
    {
        getQueueFields().add(field);
        return field;
    }

    /**
     * Gets the list of ice bucket fields for this step.
     *
     * @return The list of ice bucket fields.
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
     * Adds an ice bucket field.
     *
     * @param field The ice bucket field.
     * @return The ice bucket field.
     */
    public IceBucketField addIceBucketField(IceBucketField field)
    {
        getIceBucketFields().add(field);
        return field;
    }

    /**
     * Gets the list of step fields.
     *
     * @return The list of step fields.
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
     * Adds a step field.
     *
     * @param field The step field.
     * @return The step field.
     */
    public Field addStepField(Field field)
    {
        getStepFields().add(field);
        return field;
    }

    /**
     * Gets the list of sample fields.
     *
     * @return The list of sample fields.
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
     * Adds a sample field.
     *
     * @param field The sample field.
     * @return The sample field.
     */
    public Field setSampleFields(Field field)
    {
        getSampleFields().add(field);
        return field;
    }

    /**
     * Gets the list of step properties.
     *
     * @return The list of step properties.
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
     * Adds a step property.
     *
     * @param property The step property.
     * @return The step property.
     */
    public StepProperty addStepProperty(StepProperty property)
    {
        getStepProperties().add(property);
        return property;
    }

    /**
     * Adds a step property with name and value.
     *
     * @param name The property name.
     * @param value The property value.
     * @return The step property.
     */
    public StepProperty addStepProperty(String name, String value)
    {
        return addStepProperty(new StepProperty(name, value));
    }

    /**
     * Gets the step setup configuration.
     *
     * @return The step setup.
     */
    public StepSetup getStepSetup()
    {
        return stepSetup;
    }

    /**
     * Sets the step setup configuration.
     *
     * @param stepSetup The step setup.
     */
    public void setStepSetup(StepSetup stepSetup)
    {
        this.stepSetup = stepSetup;
    }

    /**
     * Gets the list of EPP triggers for this step.
     *
     * @return The list of EPP triggers.
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
     * Adds an EPP trigger.
     *
     * @param trigger The EPP trigger.
     * @return The EPP trigger.
     */
    public EppTrigger addEppTriggers(EppTrigger trigger)
    {
        getEppTriggers().add(trigger);
        return trigger;
    }

    /**
     * Gets the name of the protocol step.
     *
     * @return The step name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of the protocol step.
     *
     * @param name The step name.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Gets the URI of the protocol step.
     *
     * @return The step URI.
     */
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI of the protocol step.
     *
     * @param uri The step URI.
     */
    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Gets the URI of the protocol this step belongs to.
     *
     * @return The protocol URI.
     */
    public URI getProtocolUri()
    {
        return protocolUri;
    }

    /**
     * Sets the URI of the protocol this step belongs to.
     *
     * @param protocolUri The protocol URI.
     */
    public void setProtocolUri(URI protocolUri)
    {
        this.protocolUri = protocolUri;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LimsLink<ProtocolStep> getLink()
    {
        return new ProtocolStepLink(this);
    }
}
