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

package com.genologics.ri.exception;

import static com.genologics.ri.Namespaces.EXCEPTION_NAMESPACE;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * Factory class for creating instances of JAXB content classes defined in the
 * {@code com.genologics.ri.exception} package.
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
     * The qualified name for the exception XML element.
     */
    private final static QName _Exception_QNAME = new QName(EXCEPTION_NAMESPACE, "exception");

    /**
     * Creates a new ObjectFactory that can be used to create new instances of
     * schema-derived classes for package: com.genologics.ri.exception.
     */
    public ObjectFactory()
    {
    }

    /**
     * Creates an instance of {@link Exception}.
     *
     * @return A new Exception instance.
     */
    public Exception createException()
    {
        return new Exception();
    }

    /**
     * Creates an instance of {@link JAXBElement}{@code <}{@link Exception}{@code >}
     * for use in marshalling the exception element.
     *
     * @param value The Exception value to wrap.
     *
     * @return A JAXBElement containing the Exception.
     */
    @XmlElementDecl(namespace = EXCEPTION_NAMESPACE, name = "exception")
    public JAXBElement<Exception> createException(Exception value)
    {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }
}
