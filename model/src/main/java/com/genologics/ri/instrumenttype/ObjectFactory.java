/*
 * CRUK-CI Clarity REST API Java Client.
 * Copyright (C) 2016 Cancer Research UK Cambridge Institute.
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

package com.genologics.ri.instrumenttype;

import static com.genologics.ri.Namespaces.INSTRUMENT_TYPE_NAMESPACE;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * Factory class for creating instances of JAXB content classes defined in the
 * {@code com.genologics.ri.instrumenttype} package.
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
     * The qualified name for the instrument-types element.
     */
    private final static QName _InstrumentTypes_QNAME = new QName(INSTRUMENT_TYPE_NAMESPACE, "instrument-types");

    /**
     * The qualified name for the instrument-type element.
     */
    private final static QName _InstrumentType_QNAME = new QName(INSTRUMENT_TYPE_NAMESPACE, "instrument-type");

    /**
     * Create a new ObjectFactory that can be used to create new instances of
     * schema derived classes for package: com.genologics.ri.instrumenttype
     *
     */
    public ObjectFactory()
    {
    }

    /**
     * Create an instance of InstrumentTypeLink.
     *
     * @return A new InstrumentTypeLink instance.
     */
    public InstrumentTypeLink createInstrumentTypeLink()
    {
        return new InstrumentTypeLink();
    }

    /**
     * Create an instance of InstrumentTypes.
     *
     * @return A new InstrumentTypes instance.
     */
    public InstrumentTypes createInstrumentTypes()
    {
        return new InstrumentTypes();
    }

    /**
     * Create an instance of InstrumentTypeProcessType.
     *
     * @return A new InstrumentTypeProcessType instance.
     */
    public InstrumentTypeProcessType createInstrumentTypeProcessType()
    {
        return new InstrumentTypeProcessType();
    }

    /**
     * Create an instance of InstrumentType.
     *
     * @return A new InstrumentType instance.
     */
    public InstrumentType createInstrumentType()
    {
        return new InstrumentType();
    }

    /**
     * Create a JAXBElement for InstrumentTypes.
     *
     * @param value The InstrumentTypes instance.
     * @return A new JAXBElement wrapping the InstrumentTypes instance.
     */
    @XmlElementDecl(namespace = INSTRUMENT_TYPE_NAMESPACE, name = "instrument-types")
    public JAXBElement<InstrumentTypes> createInstrumentTypes(InstrumentTypes value)
    {
        return new JAXBElement<InstrumentTypes>(_InstrumentTypes_QNAME, InstrumentTypes.class, null, value);
    }

    /**
     * Create a JAXBElement for InstrumentType.
     *
     * @param value The InstrumentType instance.
     * @return A new JAXBElement wrapping the InstrumentType instance.
     */
    @XmlElementDecl(namespace = INSTRUMENT_TYPE_NAMESPACE, name = "instrument-type")
    public JAXBElement<InstrumentType> createInstrumentType(InstrumentType value)
    {
        return new JAXBElement<InstrumentType>(_InstrumentType_QNAME, InstrumentType.class, null, value);
    }
}
