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

import static com.genologics.ri.Namespaces.STEP_CONFIGURATION_NAMESPACE;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the com.genologics.ri.stepconfiguration package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 *
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Step_QNAME = new QName(STEP_CONFIGURATION_NAMESPACE, "step");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.genologics.ri.stepconfiguration
     *
     */
    public ObjectFactory() {
    }

    /**
     * Creates a new ControlTypeLink instance.
     *
     * @return A new ControlTypeLink.
     */
    public ControlTypeLink createControlTypeLink() {
        return new ControlTypeLink();
    }

    /**
     * Creates a new StepProperty instance.
     *
     * @return A new StepProperty.
     */
    public StepProperty createStepProperty() {
        return new StepProperty();
    }

    /**
     * Creates a new EppTrigger instance.
     *
     * @return A new EppTrigger.
     */
    public EppTrigger createEppTrigger() {
        return new EppTrigger();
    }

    /**
     * Creates a new LockableSetting instance.
     *
     * @return A new LockableSetting.
     */
    public LockableSetting createLockableSetting() {
        return new LockableSetting();
    }

    /**
     * Creates a new ProtocolStep instance.
     *
     * @return A new ProtocolStep.
     */
    public ProtocolStep createProtocolStep() {
        return new ProtocolStep();
    }

    /**
     * Creates a new ProcessTypeLink instance.
     *
     * @return A new ProcessTypeLink.
     */
    public ProcessTypeLink createProcessTypeLink() {
        return new ProcessTypeLink();
    }

    /**
     * Creates a new ReagentKitLink instance.
     *
     * @return A new ReagentKitLink.
     */
    public ReagentKitLink createReagentKitLink() {
        return new ReagentKitLink();
    }

    /**
     * Creates a new IceBucketField instance.
     *
     * @return A new IceBucketField.
     */
    public IceBucketField createIceBucketField() {
        return new IceBucketField();
    }

    /**
     * Creates a new SharedResultFile instance.
     *
     * @return A new SharedResultFile.
     */
    public SharedResultFile createSharedResultFile() {
        return new SharedResultFile();
    }

    /**
     * Creates a new StepSetup instance.
     *
     * @return A new StepSetup.
     */
    public StepSetup createStepSetup() {
        return new StepSetup();
    }

    /**
     * Creates a new NextStep instance.
     *
     * @return A new NextStep.
     */
    public NextStep createNextStep() {
        return new NextStep();
    }

    /**
     * Creates a new GenericTypeLink instance.
     *
     * @return A new GenericTypeLink.
     */
    public GenericTypeLink createGenericTypeLink() {
        return new GenericTypeLink();
    }

    /**
     * Creates a new Field instance.
     *
     * @return A new Field.
     */
    public Field createField() {
        return new Field();
    }

    /**
     * Creates a new QueueField instance.
     *
     * @return A new QueueField.
     */
    public QueueField createQueueField() {
        return new QueueField();
    }

    /**
     * Creates a JAXBElement wrapping a ProtocolStep.
     *
     * @param value The ProtocolStep to wrap.
     * @return A JAXBElement containing the ProtocolStep.
     */
    @XmlElementDecl(namespace = STEP_CONFIGURATION_NAMESPACE, name = "step")
    public JAXBElement<ProtocolStep> createStep(ProtocolStep value) {
        return new JAXBElement<ProtocolStep>(_Step_QNAME, ProtocolStep.class, null, value);
    }
}
