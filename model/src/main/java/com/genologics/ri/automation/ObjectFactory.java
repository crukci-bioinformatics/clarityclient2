/*
 * CRUK-CI Clarity REST API Java Client.
 * Copyright (C) 2018 Cancer Research UK Cambridge Institute.
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

package com.genologics.ri.automation;

import static com.genologics.ri.Namespaces.AUTOMATION_NAMESPACE;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * Factory class for creating instances of JAXB content classes defined in the
 * {@code com.genologics.ri.automation} package.
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
     * QName for automation element.
     */
    private final static QName _Automation_QNAME = new QName(AUTOMATION_NAMESPACE, "automation");

    /**
     * QName for automations element.
     */
    private final static QName _Automations_QNAME = new QName(AUTOMATION_NAMESPACE, "automations");

    /**
     * Default constructor.
     */
    public ObjectFactory()
    {
    }

    /**
     * Creates a new ProcessTypeLink instance.
     *
     * @return A new ProcessTypeLink object.
     */
    public ProcessTypeLink createProcessTypeLink()
    {
        return new ProcessTypeLink();
    }

    /**
     * Creates a new AutomationLink instance.
     *
     * @return A new AutomationLink object.
     */
    public AutomationLink createAutomationLink()
    {
        return new AutomationLink();
    }

    /**
     * Creates a new Automations instance.
     *
     * @return A new Automations object.
     */
    public Automations createAutomations()
    {
        return new Automations();
    }

    /**
     * Creates a new Automation instance.
     *
     * @return A new Automation object.
     */
    public Automation createAutomation()
    {
        return new Automation();
    }

    /**
     * Creates a JAXBElement for Automation.
     *
     * @param value The Automation value to wrap.
     * @return A JAXBElement containing the Automation value.
     */
    @XmlElementDecl(namespace = AUTOMATION_NAMESPACE, name = "automation")
    public JAXBElement<Automation> createAutomation(Automation value)
    {
        return new JAXBElement<Automation>(_Automation_QNAME, Automation.class, null, value);
    }

    /**
     * Creates a JAXBElement for Automations.
     *
     * @param value The Automations value to wrap.
     * @return A JAXBElement containing the Automations value.
     */
    @XmlElementDecl(namespace = AUTOMATION_NAMESPACE, name = "automations")
    public JAXBElement<Automations> createAutomations(Automations value)
    {
        return new JAXBElement<Automations>(_Automations_QNAME, Automations.class, null, value);
    }
}
