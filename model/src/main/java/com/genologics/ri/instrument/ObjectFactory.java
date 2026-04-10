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

package com.genologics.ri.instrument;

import static com.genologics.ri.Namespaces.INSTRUMENT_NAMESPACE;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * Factory class for creating instances of JAXB content classes defined in the
 * {@code com.genologics.ri.instrument} package.
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

    private final static QName _Instrument_QNAME = new QName(INSTRUMENT_NAMESPACE, "instrument");
    private final static QName _Instruments_QNAME = new QName(INSTRUMENT_NAMESPACE, "instruments");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.genologics.ri.instrument
     *
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of Instrument.
     *
     * @return A new Instrument instance.
     */
    public Instrument createInstrument() {
        return new Instrument();
    }

    /**
     * Create an instance of InstrumentLink.
     *
     * @return A new InstrumentLink instance.
     */
    public InstrumentLink createInstrumentLink() {
        return new InstrumentLink();
    }

    /**
     * Create an instance of Instruments.
     *
     * @return A new Instruments instance.
     */
    public Instruments createInstruments() {
        return new Instruments();
    }

    /**
     * Create a JAXBElement for Instrument.
     *
     * @param value The Instrument instance.
     * @return A new JAXBElement wrapping the Instrument instance.
     */
    @XmlElementDecl(namespace = INSTRUMENT_NAMESPACE, name = "instrument")
    public JAXBElement<Instrument> createInstrument(Instrument value) {
        return new JAXBElement<Instrument>(_Instrument_QNAME, Instrument.class, null, value);
    }

    /**
     * Create a JAXBElement for Instruments.
     *
     * @param value The Instruments instance.
     * @return A new JAXBElement wrapping the Instruments instance.
     */
    @XmlElementDecl(namespace = INSTRUMENT_NAMESPACE, name = "instruments")
    public JAXBElement<Instruments> createInstruments(Instruments value) {
        return new JAXBElement<Instruments>(_Instruments_QNAME, Instruments.class, null, value);
    }
}
