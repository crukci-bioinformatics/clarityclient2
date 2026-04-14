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

import static com.genologics.ri.Namespaces.EMPTY_NAMESPACE;
import static com.genologics.ri.Namespaces.PROCESS_EXECUTION_NAMESPACE;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * Factory class for creating instances of JAXB content classes defined in the
 * {@code com.genologics.ri.processexecution} package.
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
     * The QName for the process element.
     */
    private final static QName _Process_QNAME = new QName(PROCESS_EXECUTION_NAMESPACE, "process");

    /**
     * The QName for the technician element.
     */
    private final static QName _ProcessTechnician_QNAME = new QName(EMPTY_NAMESPACE, "technician");

    /**
     * The QName for the instrument element.
     */
    private final static QName _ProcessInstrument_QNAME = new QName(EMPTY_NAMESPACE, "instrument");

    /**
     * The QName for the type element.
     */
    private final static QName _ProcessType_QNAME = new QName(EMPTY_NAMESPACE, "type");

    /**
     * The QName for the input-output-map element.
     */
    private final static QName _ProcessInputOutputMap_QNAME = new QName(EMPTY_NAMESPACE, "input-output-map");

    /**
     * The QName for the process-parameter element.
     */
    private final static QName _ProcessProcessParameter_QNAME = new QName(EMPTY_NAMESPACE, "process-parameter");

    /**
     * The QName for the date-run element.
     */
    private final static QName _ProcessDateRun_QNAME = new QName(EMPTY_NAMESPACE, "date-run");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.genologics.ri.processexecution
     */
    public ObjectFactory()
    {
    }

    /**
     * Create an instance of ExecutableProcess.
     *
     * @return A new ExecutableProcess instance.
     */
    public ExecutableProcess createProcess()
    {
        return new ExecutableProcess();
    }

    /**
     * Create an instance of Output.
     *
     * @return A new Output instance.
     */
    public Output createOutput()
    {
        return new Output();
    }

    /**
     * Create an instance of Input.
     *
     * @return A new Input instance.
     */
    public Input createInput()
    {
        return new Input();
    }

    /**
     * Create an instance of Technician.
     *
     * @return A new Technician instance.
     */
    public Technician createTechnician()
    {
        return new Technician();
    }

    /**
     * Create an instance of Parameter.
     *
     * @return A new Parameter instance.
     */
    public Parameter createParameter()
    {
        return new Parameter();
    }

    /**
     * Create an instance of ExecutableInputOutputMap.
     *
     * @return A new ExecutableInputOutputMap instance.
     */
    public ExecutableInputOutputMap createInputOutputMap()
    {
        return new ExecutableInputOutputMap();
    }

    /**
     * Create an instance of InstrumentLink.
     *
     * @return A new InstrumentLink instance.
     */
    public InstrumentLink createInstrument()
    {
        return new InstrumentLink();
    }

    /**
     * Create an instance of JAXBElement&lt;ExecutableProcess&gt;.
     *
     * @param value The ExecutableProcess value.
     * @return A new JAXBElement&lt;ExecutableProcess&gt; instance.
     */
    @XmlElementDecl(namespace = PROCESS_EXECUTION_NAMESPACE, name = "process")
    public JAXBElement<ExecutableProcess> createProcess(ExecutableProcess value)
    {
        return new JAXBElement<ExecutableProcess>(_Process_QNAME, ExecutableProcess.class, null, value);
    }

    /**
     * Create an instance of JAXBElement&lt;Technician&gt;.
     *
     * @param value The Technician value.
     * @return A new JAXBElement&lt;Technician&gt; instance.
     */
    @XmlElementDecl(namespace = EMPTY_NAMESPACE, name = "technician", scope = ExecutableProcess.class)
    public JAXBElement<Technician> createProcessTechnician(Technician value)
    {
        return new JAXBElement<Technician>(_ProcessTechnician_QNAME, Technician.class, ExecutableProcess.class, value);
    }

    /**
     * Create an instance of JAXBElement&lt;InstrumentLink&gt;.
     *
     * @param value The InstrumentLink value.
     * @return A new JAXBElement&lt;InstrumentLink&gt; instance.
     */
    @XmlElementDecl(namespace = EMPTY_NAMESPACE, name = "instrument", scope = ExecutableProcess.class)
    public JAXBElement<InstrumentLink> createProcessInstrument(InstrumentLink value)
    {
        return new JAXBElement<InstrumentLink>(_ProcessInstrument_QNAME, InstrumentLink.class, ExecutableProcess.class, value);
    }

    /**
     * Create an instance of JAXBElement&lt;String&gt; for process type.
     *
     * @param value The process type name.
     * @return A new JAXBElement&lt;String&gt; instance.
     */
    @XmlElementDecl(namespace = EMPTY_NAMESPACE, name = "type", scope = ExecutableProcess.class)
    public JAXBElement<String> createProcessType(String value)
    {
        return new JAXBElement<String>(_ProcessType_QNAME, String.class, ExecutableProcess.class, value);
    }

    /**
     * Create an instance of JAXBElement&lt;ExecutableInputOutputMap&gt;.
     *
     * @param value The ExecutableInputOutputMap value.
     * @return A new JAXBElement&lt;ExecutableInputOutputMap&gt; instance.
     */
    @XmlElementDecl(namespace = EMPTY_NAMESPACE, name = "input-output-map", scope = ExecutableProcess.class)
    public JAXBElement<ExecutableInputOutputMap> createProcessInputOutputMap(ExecutableInputOutputMap value)
    {
        return new JAXBElement<ExecutableInputOutputMap>(_ProcessInputOutputMap_QNAME, ExecutableInputOutputMap.class, ExecutableProcess.class, value);
    }

    /**
     * Create an instance of JAXBElement&lt;Parameter&gt;.
     *
     * @param value The Parameter value.
     * @return A new JAXBElement&lt;Parameter&gt; instance.
     */
    @XmlElementDecl(namespace = EMPTY_NAMESPACE, name = "process-parameter", scope = ExecutableProcess.class)
    public JAXBElement<Parameter> createProcessProcessParameter(Parameter value)
    {
        return new JAXBElement<Parameter>(_ProcessProcessParameter_QNAME, Parameter.class, ExecutableProcess.class, value);
    }

    /**
     * Create an instance of JAXBElement&lt;String&gt; for date run.
     *
     * @param value The date run as a string.
     * @return A new JAXBElement&lt;String&gt; instance.
     */
    @XmlElementDecl(namespace = EMPTY_NAMESPACE, name = "date-run", scope = ExecutableProcess.class)
    public JAXBElement<String> createProcessDateRun(String value)
    {
        return new JAXBElement<String>(_ProcessDateRun_QNAME, String.class, ExecutableProcess.class, value);
    }
}
