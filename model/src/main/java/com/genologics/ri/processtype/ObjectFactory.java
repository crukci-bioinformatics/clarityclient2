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

import static com.genologics.ri.Namespaces.PROCESS_TYPE_NAMESPACE;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * Factory class for creating instances of JAXB content classes defined in the
 * {@code com.genologics.ri.processtype} package.
 * <p>
 * This class is required by JAXB (Java Architecture for XML Binding) and provides
 * factory methods for instantiating JAXB-managed classes and elements within this
 * package. Each factory method constructs new instances of schema-derived classes
 * that represent XML content structures.
 * </p>
 * <p>
 * The {@code @XmlRegistry} annotation marks this class as a JAXB object factory,
 * allowing JAXB to discover and use these factory methods during marshalling and
 * unmarshalling operations.
 * </p>
 */
@XmlRegistry
public class ObjectFactory
{

    /**
     * QName for the process-types root element.
     */
    private final static QName _ProcessTypes_QNAME = new QName(PROCESS_TYPE_NAMESPACE, "process-types");

    /**
     * QName for the process-type root element.
     */
    private final static QName _ProcessType_QNAME = new QName(PROCESS_TYPE_NAMESPACE, "process-type");

    /**
     * Creates a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.genologics.ri.processtype.
     */
    public ObjectFactory()
    {
    }

    /**
     * Creates a new SharedResultFile instance.
     *
     * @return a new SharedResultFile.
     */
    public SharedResultFile createSharedResultFile()
    {
        return new SharedResultFile();
    }

    /**
     * Creates a new StepProperty instance.
     *
     * @return a new StepProperty.
     */
    public StepProperty createStepProperty()
    {
        return new StepProperty();
    }

    /**
     * Creates a new Parameter instance.
     *
     * @return a new Parameter.
     */
    public Parameter createParameter()
    {
        return new Parameter();
    }

    /**
     * Creates a new ProcessType instance.
     *
     * @return a new ProcessType.
     */
    public ProcessType createProcessType()
    {
        return new ProcessType();
    }

    /**
     * Creates a new ControlTypeLink instance.
     *
     * @return a new ControlTypeLink.
     */
    public ControlTypeLink createControlTypeLink()
    {
        return new ControlTypeLink();
    }

    /**
     * Creates a new ContainerTypeLink instance.
     *
     * @return a new ContainerTypeLink.
     */
    public ContainerTypeLink createContainerTypeLink()
    {
        return new ContainerTypeLink();
    }

    /**
     * Creates a new IceBucketField instance.
     *
     * @return a new IceBucketField.
     */
    public IceBucketField createIceBucketField()
    {
        return new IceBucketField();
    }

    /**
     * Creates a new ProcessTypes instance.
     *
     * @return a new ProcessTypes.
     */
    public ProcessTypes createProcessTypes()
    {
        return new ProcessTypes();
    }

    /**
     * Creates a new EppTrigger instance.
     *
     * @return a new EppTrigger.
     */
    public EppTrigger createEppTrigger()
    {
        return new EppTrigger();
    }

    /**
     * Creates a new StepSetup instance.
     *
     * @return a new StepSetup.
     */
    public StepSetup createStepSetup()
    {
        return new StepSetup();
    }

    /**
     * Creates a new Field instance.
     *
     * @return a new Field.
     */
    public Field createField()
    {
        return new Field();
    }

    /**
     * Creates a new TypeDefinition instance.
     *
     * @return a new TypeDefinition.
     */
    public TypeDefinition createTypeDefinition()
    {
        return new TypeDefinition();
    }

    /**
     * Creates a new ProcessTypeLink instance.
     *
     * @return a new ProcessTypeLink.
     */
    public ProcessTypeLink createProcessTypeLink()
    {
        return new ProcessTypeLink();
    }

    /**
     * Creates a new QueueField instance.
     *
     * @return a new QueueField.
     */
    public QueueField createQueueField()
    {
        return new QueueField();
    }

    /**
     * Creates a new ProcessOutput instance.
     *
     * @return a new ProcessOutput.
     */
    public ProcessOutput createProcessOutput()
    {
        return new ProcessOutput();
    }

    /**
     * Creates a new ReagentKitLink instance.
     *
     * @return a new ReagentKitLink.
     */
    public ReagentKitLink createReagentKitLink()
    {
        return new ReagentKitLink();
    }

    /**
     * Creates a new ProcessInput instance.
     *
     * @return a new ProcessInput.
     */
    public ProcessInput createProcessInput()
    {
        return new ProcessInput();
    }

    /**
     * Creates a new ProcessTypeAttribute instance.
     *
     * @return a new ProcessTypeAttribute.
     */
    public ProcessTypeAttribute createProcessTypeAttribute()
    {
        return new ProcessTypeAttribute();
    }

    /**
     * Creates a JAXB element wrapping ProcessTypes.
     *
     * @param value the ProcessTypes instance to wrap.
     * @return a JAXBElement wrapping the ProcessTypes.
     */
    @XmlElementDecl(namespace = PROCESS_TYPE_NAMESPACE, name = "process-types")
    public JAXBElement<ProcessTypes> createProcessTypes(ProcessTypes value)
    {
        return new JAXBElement<ProcessTypes>(_ProcessTypes_QNAME, ProcessTypes.class, null, value);
    }

    /**
     * Creates a JAXB element wrapping ProcessType.
     *
     * @param value the ProcessType instance to wrap.
     * @return a JAXBElement wrapping the ProcessType.
     */
    @XmlElementDecl(namespace = PROCESS_TYPE_NAMESPACE, name = "process-type")
    public JAXBElement<ProcessType> createProcessType(ProcessType value)
    {
        return new JAXBElement<ProcessType>(_ProcessType_QNAME, ProcessType.class, null, value);
    }
}
