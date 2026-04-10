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

package com.genologics.ri.controltype;

import static com.genologics.ri.Namespaces.CONTROL_TYPE_NAMESPACE;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * Factory class for creating instances of JAXB content classes defined in the
 * {@code com.genologics.ri.controltype} package.
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
public class ObjectFactory {

    private final static QName _ControlType_QNAME = new QName(CONTROL_TYPE_NAMESPACE, "control-type");
    private final static QName _ControlTypes_QNAME = new QName(CONTROL_TYPE_NAMESPACE, "control-types");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.genologics.ri.controltype
     *
     */
    public ObjectFactory() {
    }

    public ControlType createControlType() {
        return new ControlType();
    }

    public ControlTypeLink createControlTypeLink() {
        return new ControlTypeLink();
    }

    public ControlTypes createControlTypes() {
        return new ControlTypes();
    }

    @XmlElementDecl(namespace = CONTROL_TYPE_NAMESPACE, name = "control-type")
    public JAXBElement<ControlType> createControlType(ControlType value) {
        return new JAXBElement<ControlType>(_ControlType_QNAME, ControlType.class, null, value);
    }

    @XmlElementDecl(namespace = CONTROL_TYPE_NAMESPACE, name = "control-types")
    public JAXBElement<ControlTypes> createControlTypes(ControlTypes value) {
        return new JAXBElement<ControlTypes>(_ControlTypes_QNAME, ControlTypes.class, null, value);
    }
}
