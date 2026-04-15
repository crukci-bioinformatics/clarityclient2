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

import static com.genologics.ri.Namespaces.EMPTY_NAMESPACE;
import static com.genologics.ri.Namespaces.PROCESS_NAMESPACE;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * Factory class for creating instances of JAXB content classes defined in the
 * {@code com.genologics.ri.process} package.
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
    private final static QName _Processes_QNAME = new QName(PROCESS_NAMESPACE, "processes");

    /**
     * The QName for the process element.
     */
    private final static QName _Process_QNAME = new QName(PROCESS_NAMESPACE, "process");

    /**
     * The QName for the protocol-name element.
     */
    private final static QName _ProcessProtocolName_QNAME = new QName(EMPTY_NAMESPACE, "protocol-name");

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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.genologics.ri.process
     */
    public ObjectFactory()
    {
    }

    /**
     * Creates a new ClarityProcess instance.
     *
     * @return A new ClarityProcess instance.
     */
    public ClarityProcess createProcess()
    {
        return new ClarityProcess();
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
     * Creates a new ProcessTypeLink instance.
     *
     * @return A new ProcessTypeLink instance.
     */
    public ProcessTypeLink createProcessType()
    {
        return new ProcessTypeLink();
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
     * Creates a new ClarityProcesses instance.
     *
     * @return A new ClarityProcesses instance.
     */
    public ClarityProcesses createProcesses()
    {
        return new ClarityProcesses();
    }

    /**
     * Creates a new ArtifactLink instance.
     *
     * @return A new ArtifactLink instance.
     */
    public ArtifactLink createArtifact()
    {
        return new ArtifactLink();
    }

    /**
     * Creates a new ProcessLink instance.
     *
     * @return A new ProcessLink instance.
     */
    public ProcessLink createProcessLink()
    {
        return new ProcessLink();
    }

    /**
     * Creates a new InputOutputMap instance.
     *
     * @return A new InputOutputMap instance.
     */
    public InputOutputMap createInputOutputMap()
    {
        return new InputOutputMap();
    }

    /**
     * Creates a new ParentProcessLink instance.
     *
     * @return A new ParentProcessLink instance.
     */
    public ParentProcessLink createParentProcess()
    {
        return new ParentProcessLink();
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
     * Creates a JAXBElement for ClarityProcesses.
     *
     * @param value The ClarityProcesses instance.
     *
     * @return A JAXBElement wrapping the ClarityProcesses instance.
     */
    @XmlElementDecl(namespace = PROCESS_NAMESPACE, name = "processes")
    public JAXBElement<ClarityProcesses> createProcesses(ClarityProcesses value)
    {
        return new JAXBElement<ClarityProcesses>(_Processes_QNAME, ClarityProcesses.class, null, value);
    }

    /**
     * Creates a JAXBElement for ClarityProcess.
     *
     * @param value The ClarityProcess instance.
     *
     * @return A JAXBElement wrapping the ClarityProcess instance.
     */
    @XmlElementDecl(namespace = PROCESS_NAMESPACE, name = "process")
    public JAXBElement<ClarityProcess> createProcess(ClarityProcess value)
    {
        return new JAXBElement<ClarityProcess>(_Process_QNAME, ClarityProcess.class, null, value);
    }

    /**
     * Creates a JAXBElement for the process protocol name.
     *
     * @param value The protocol name.
     *
     * @return A JAXBElement wrapping the protocol name.
     */
    @XmlElementDecl(namespace = EMPTY_NAMESPACE, name = "protocol-name", scope = ClarityProcess.class)
    public JAXBElement<String> createProcessProtocolName(String value)
    {
        return new JAXBElement<String>(_ProcessProtocolName_QNAME, String.class, ClarityProcess.class, value);
    }

    /**
     * Creates a JAXBElement for the process technician.
     *
     * @param value The Technician instance.
     *
     * @return A JAXBElement wrapping the Technician instance.
     */
    @XmlElementDecl(namespace = EMPTY_NAMESPACE, name = "technician", scope = ClarityProcess.class)
    public JAXBElement<Technician> createProcessTechnician(Technician value)
    {
        return new JAXBElement<Technician>(_ProcessTechnician_QNAME, Technician.class, ClarityProcess.class, value);
    }

    /**
     * Creates a JAXBElement for the process instrument.
     *
     * @param value The InstrumentLink instance.
     *
     * @return A JAXBElement wrapping the InstrumentLink instance.
     */
    @XmlElementDecl(namespace = EMPTY_NAMESPACE, name = "instrument", scope = ClarityProcess.class)
    public JAXBElement<InstrumentLink> createProcessInstrument(InstrumentLink value)
    {
        return new JAXBElement<InstrumentLink>(_ProcessInstrument_QNAME, InstrumentLink.class, ClarityProcess.class, value);
    }

    /**
     * Creates a JAXBElement for the process type.
     *
     * @param value The ProcessTypeLink instance.
     *
     * @return A JAXBElement wrapping the ProcessTypeLink instance.
     */
    @XmlElementDecl(namespace = EMPTY_NAMESPACE, name = "type", scope = ClarityProcess.class)
    public JAXBElement<ProcessTypeLink> createProcessType(ProcessTypeLink value)
    {
        return new JAXBElement<ProcessTypeLink>(_ProcessType_QNAME, ProcessTypeLink.class, ClarityProcess.class, value);
    }

    /**
     * Creates a JAXBElement for the process input-output map.
     *
     * @param value The InputOutputMap instance.
     *
     * @return A JAXBElement wrapping the InputOutputMap instance.
     */
    @XmlElementDecl(namespace = EMPTY_NAMESPACE, name = "input-output-map", scope = ClarityProcess.class)
    public JAXBElement<InputOutputMap> createProcessInputOutputMap(InputOutputMap value)
    {
        return new JAXBElement<InputOutputMap>(_ProcessInputOutputMap_QNAME, InputOutputMap.class, ClarityProcess.class, value);
    }

    /**
     * Creates a JAXBElement for the process parameter.
     *
     * @param value The Parameter instance.
     *
     * @return A JAXBElement wrapping the Parameter instance.
     */
    @XmlElementDecl(namespace = EMPTY_NAMESPACE, name = "process-parameter", scope = ClarityProcess.class)
    public JAXBElement<Parameter> createProcessProcessParameter(Parameter value)
    {
        return new JAXBElement<Parameter>(_ProcessProcessParameter_QNAME, Parameter.class, ClarityProcess.class, value);
    }

    /**
     * Creates a JAXBElement for the process date run.
     *
     * @param value The date run string.
     *
     * @return A JAXBElement wrapping the date run string.
     */
    @XmlElementDecl(namespace = EMPTY_NAMESPACE, name = "date-run", scope = ClarityProcess.class)
    public JAXBElement<String> createProcessDateRun(String value)
    {
        return new JAXBElement<String>(_ProcessDateRun_QNAME, String.class, ClarityProcess.class, value);
    }
}
