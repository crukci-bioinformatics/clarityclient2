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

import static com.genologics.ri.Namespaces.EMPTY_NAMESPACE;
import static com.genologics.ri.Namespaces.PROCESS_TEMPLATE_NAMESPACE;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * Factory class for creating instances of JAXB content classes defined in the
 * {@code com.genologics.ri.processtemplate} package.
 * <p>
 * This class is required by JAXB (Java Architecture for XML Binding) and provides
 * factory methods for instantiating JAXB-managed classes and elements within this
 * package. Each factory method constructs new instances of schema-derived classes
 * that represent XML content structures.
 * </p>
 */
@XmlRegistry
public class ObjectFactory
{
    /**
     * The QName for the processes element.
     */
    private final static QName _ProcessTemplates_QNAME = new QName(PROCESS_TEMPLATE_NAMESPACE, "process-templates");

    /**
     * The QName for the process element.
     */
    private final static QName _ProcessTemplate_QNAME = new QName(PROCESS_TEMPLATE_NAMESPACE, "process-template");

    /**
     * The QName for the technician element.
     */
    private final static QName _ProcessTemplateTechnician_QNAME = new QName(EMPTY_NAMESPACE, "technician");

    /**
     * The QName for the name element.
     */
    private final static QName _ProcessTemplateName_QNAME = new QName(EMPTY_NAMESPACE, "name");

    /**
     * The QName for the is-default element.
     */
    private final static QName _ProcessTemplateIsDefault_QNAME = new QName(EMPTY_NAMESPACE, "is-default");

    /**
     * The QName for the instrument element.
     */
    private final static QName _ProcessTemplateInstrument_QNAME = new QName(EMPTY_NAMESPACE, "instrument");

    /**
     * The QName for the type element.
     */
    private final static QName _ProcessTemplateType_QNAME = new QName(EMPTY_NAMESPACE, "type");

    /**
     * The QName for the process-parameter element.
     */
    private final static QName _ProcessTemplateProcessParameter_QNAME = new QName(EMPTY_NAMESPACE, "process-parameter");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.genologics.ri.processtemplate
     *
     */
    public ObjectFactory()
    {
    }

    /**
     * Creates a new ProcessTemplateLink instance.
     *
     * @return A new ProcessTemplateLink instance.
     */
    public ProcessTemplateLink createProcessTemplateLink()
    {
        return new ProcessTemplateLink();
    }

    /**
     * Creates a new Parameter instance.
     *
     * @return A new Parameter instance.
     */
    public Parameter createParameter()
    {
        return new Parameter();
    }

    /**
     * Creates a new ProcessTemplate instance.
     *
     * @return A new ProcessTemplate instance.
     */
    public ProcessTemplate createProcessTemplate()
    {
        return new ProcessTemplate();
    }

    /**
     * Creates a new ProcessTypeLink instance.
     *
     * @return A new ProcessTypeLink instance.
     */
    public ProcessTypeLink createProcessType()
    {
        return new ProcessTypeLink();
    }

    /**
     * Creates a new ProcessTemplates instance.
     *
     * @return A new ProcessTemplates instance.
     */
    public ProcessTemplates createProcessTemplates()
    {
        return new ProcessTemplates();
    }

    /**
     * Creates a new InstrumentLink instance.
     *
     * @return A new InstrumentLink instance.
     */
    public InstrumentLink createInstrument()
    {
        return new InstrumentLink();
    }

    /**
     * Creates a new Technician instance.
     *
     * @return A new Technician instance.
     */
    public Technician createTechnician()
    {
        return new Technician();
    }

    /**
     * Creates a JAXBElement for ProcessTemplates.
     *
     * @param value The ProcessTemplates instance.
     * @return A JAXBElement wrapping the ProcessTemplates instance.
     */
    @XmlElementDecl(namespace = PROCESS_TEMPLATE_NAMESPACE, name = "process-templates")
    public JAXBElement<ProcessTemplates> createProcessTemplates(ProcessTemplates value)
    {
        return new JAXBElement<ProcessTemplates>(_ProcessTemplates_QNAME, ProcessTemplates.class, null, value);
    }

    /**
     * Creates a JAXBElement for ProcessTemplate.
     *
     * @param value The ProcessTemplate instance.
     * @return A JAXBElement wrapping the ProcessTemplate instance.
     */
    @XmlElementDecl(namespace = PROCESS_TEMPLATE_NAMESPACE, name = "process-template")
    public JAXBElement<ProcessTemplate> createProcessTemplate(ProcessTemplate value)
    {
        return new JAXBElement<ProcessTemplate>(_ProcessTemplate_QNAME, ProcessTemplate.class, null, value);
    }

    /**
     * Creates a JAXBElement for process template technician.
     *
     * @param value The Technician instance.
     * @return A JAXBElement wrapping the Technician instance.
     */
    @XmlElementDecl(namespace = EMPTY_NAMESPACE, name = "technician", scope = ProcessTemplate.class)
    public JAXBElement<Technician> createProcessTemplateTechnician(Technician value)
    {
        return new JAXBElement<Technician>(_ProcessTemplateTechnician_QNAME, Technician.class, ProcessTemplate.class, value);
    }

    /**
     * Creates a JAXBElement for process template name.
     *
     * @param value The name string.
     * @return A JAXBElement wrapping the name string.
     */
    @XmlElementDecl(namespace = EMPTY_NAMESPACE, name = "name", scope = ProcessTemplate.class)
    public JAXBElement<String> createProcessTemplateName(String value)
    {
        return new JAXBElement<String>(_ProcessTemplateName_QNAME, String.class, ProcessTemplate.class, value);
    }

    /**
     * Creates a JAXBElement for process template default flag.
     *
     * @param value The default flag.
     * @return A JAXBElement wrapping the default flag.
     */
    @XmlElementDecl(namespace = EMPTY_NAMESPACE, name = "is-default", scope = ProcessTemplate.class)
    public JAXBElement<Boolean> createProcessTemplateIsDefault(Boolean value)
    {
        return new JAXBElement<Boolean>(_ProcessTemplateIsDefault_QNAME, Boolean.class, ProcessTemplate.class, value);
    }

    /**
     * Creates a JAXBElement for process template instrument.
     *
     * @param value The InstrumentLink instance.
     * @return A JAXBElement wrapping the InstrumentLink instance.
     */
    @XmlElementDecl(namespace = EMPTY_NAMESPACE, name = "instrument", scope = ProcessTemplate.class)
    public JAXBElement<InstrumentLink> createProcessTemplateInstrument(InstrumentLink value)
    {
        return new JAXBElement<InstrumentLink>(_ProcessTemplateInstrument_QNAME, InstrumentLink.class, ProcessTemplate.class, value);
    }

    /**
     * Creates a JAXBElement for process template type.
     *
     * @param value The ProcessTypeLink instance.
     * @return A JAXBElement wrapping the ProcessTypeLink instance.
     */
    @XmlElementDecl(namespace = EMPTY_NAMESPACE, name = "type", scope = ProcessTemplate.class)
    public JAXBElement<ProcessTypeLink> createProcessTemplateType(ProcessTypeLink value)
    {
        return new JAXBElement<ProcessTypeLink>(_ProcessTemplateType_QNAME, ProcessTypeLink.class, ProcessTemplate.class, value);
    }

    /**
     * Creates a JAXBElement for process template parameter.
     *
     * @param value The Parameter instance.
     * @return A JAXBElement wrapping the Parameter instance.
     */
    @XmlElementDecl(namespace = EMPTY_NAMESPACE, name = "process-parameter", scope = ProcessTemplate.class)
    public JAXBElement<Parameter> createProcessTemplateProcessParameter(Parameter value)
    {
        return new JAXBElement<Parameter>(_ProcessTemplateProcessParameter_QNAME, Parameter.class, ProcessTemplate.class, value);
    }
}
