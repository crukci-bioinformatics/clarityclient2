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


package com.genologics.ri.protocolconfiguration;

import static com.genologics.ri.Namespaces.PROTOCOL_CONFIGURATION_NAMESPACE;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * Factory class for creating instances of JAXB content classes defined in the
 * {@code com.genologics.ri.protocolconfiguration} package.
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

    private final static QName _Protocol_QNAME = new QName(PROTOCOL_CONFIGURATION_NAMESPACE, "protocol");
    private final static QName _Protocols_QNAME = new QName(PROTOCOL_CONFIGURATION_NAMESPACE, "protocols");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.genologics.ri.protocolconfiguration
     *
     */
    public ObjectFactory()
    {
    }

    /**
     * Creates a new Protocols instance.
     *
     * @return A new Protocols object.
     */
    public Protocols createProtocols()
    {
        return new Protocols();
    }

    /**
     * Creates a new ProtocolProperty instance.
     *
     * @return A new ProtocolProperty object.
     */
    public ProtocolProperty createProtocolProperty()
    {
        return new ProtocolProperty();
    }

    /**
     * Creates a new ProtocolLink instance.
     *
     * @return A new ProtocolLink object.
     */
    public ProtocolLink createProtocolLink()
    {
        return new ProtocolLink();
    }

    /**
     * Creates a new Protocol instance.
     *
     * @return A new Protocol object.
     */
    public Protocol createProtocol()
    {
        return new Protocol();
    }

    /**
     * Creates a JAXBElement for a Protocol.
     *
     * @param value The Protocol value to wrap.
     *
     * @return A JAXBElement containing the Protocol.
     */
    @XmlElementDecl(namespace = PROTOCOL_CONFIGURATION_NAMESPACE, name = "protocol")
    public JAXBElement<Protocol> createProtocol(Protocol value)
    {
        return new JAXBElement<Protocol>(_Protocol_QNAME, Protocol.class, null, value);
    }

    /**
     * Creates a JAXBElement for Protocols.
     *
     * @param value The Protocols value to wrap.
     *
     * @return A JAXBElement containing the Protocols.
     */
    @XmlElementDecl(namespace = PROTOCOL_CONFIGURATION_NAMESPACE, name = "protocols")
    public JAXBElement<Protocols> createProtocols(Protocols value)
    {
        return new JAXBElement<Protocols>(_Protocols_QNAME, Protocols.class, null, value);
    }
}
