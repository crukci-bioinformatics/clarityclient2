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
public class ObjectFactory
{
    /**
     * QName for the control-type XML element.
     */
    private final static QName _ControlType_QNAME = new QName(CONTROL_TYPE_NAMESPACE, "control-type");

    /**
     * QName for the control-types XML element.
     */
    private final static QName _ControlTypes_QNAME = new QName(CONTROL_TYPE_NAMESPACE, "control-types");

    /**
     * Creates a new ObjectFactory that can be used to create new instances of schema derived classes
     * for package: com.genologics.ri.controltype
     */
    public ObjectFactory()
    {
    }

    /**
     * Creates a new instance of {@link ControlType}.
     *
     * @return A new ControlType instance.
     */
    public ControlType createControlType()
    {
        return new ControlType();
    }

    /**
     * Creates a new instance of {@link ControlTypeLink}.
     *
     * @return A new ControlTypeLink instance.
     */
    public ControlTypeLink createControlTypeLink()
    {
        return new ControlTypeLink();
    }

    /**
     * Creates a new instance of {@link ControlTypes}.
     *
     * @return A new ControlTypes instance.
     */
    public ControlTypes createControlTypes()
    {
        return new ControlTypes();
    }

    /**
     * Creates a JAXBElement wrapping a ControlType instance.
     * <p>
     * This method is used by JAXB during marshalling to create an XML element
     * with the appropriate namespace and qualified name.
     * </p>
     *
     * @param value The ControlType value to wrap.
     * @return A JAXBElement containing the ControlType.
     */
    @XmlElementDecl(namespace = CONTROL_TYPE_NAMESPACE, name = "control-type")
    public JAXBElement<ControlType> createControlType(ControlType value)
    {
        return new JAXBElement<ControlType>(_ControlType_QNAME, ControlType.class, null, value);
    }

    /**
     * Creates a JAXBElement wrapping a ControlTypes instance.
     * <p>
     * This method is used by JAXB during marshalling to create an XML element
     * with the appropriate namespace and qualified name.
     * </p>
     *
     * @param value The ControlTypes value to wrap.
     * @return A JAXBElement containing the ControlTypes.
     */
    @XmlElementDecl(namespace = CONTROL_TYPE_NAMESPACE, name = "control-types")
    public JAXBElement<ControlTypes> createControlTypes(ControlTypes value)
    {
        return new JAXBElement<ControlTypes>(_ControlTypes_QNAME, ControlTypes.class, null, value);
    }
}
