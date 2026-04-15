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

package com.genologics.ri.userdefined;

import static com.genologics.ri.Namespaces.UDF_NAMESPACE;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * Factory class for creating instances of JAXB content classes defined in the
 * {@code com.genologics.ri.userdefined} package.
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
     * The qualified name for the "field" XML element in the UDF namespace.
     */
    private final static QName _Field_QNAME = new QName(UDF_NAMESPACE, "field");

    /**
     * The qualified name for the "type" XML element in the UDF namespace.
     */
    private final static QName _Type_QNAME = new QName(UDF_NAMESPACE, "type");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.genologics.ri.userdefined
     *
     */
    public ObjectFactory()
    {
    }

    /**
     * Create an instance of {@link UDT}
     *
     * @return A new UDT instance.
     */
    public UDT createType()
    {
        return new UDT();
    }

    /**
     * Create an instance of {@link UDF}
     *
     * @return A new UDF instance.
     */
    public UDF createField()
    {
        return new UDF();
    }

    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link UDF}{@code >}
     *
     * @param value Java instance representing xml element's value.
     * @return The new instance of {@link JAXBElement}{@code <}{@link UDF}{@code >}
     */
    @XmlElementDecl(namespace = UDF_NAMESPACE, name = "field")
    public JAXBElement<UDF> createField(UDF value)
    {
        return new JAXBElement<UDF>(_Field_QNAME, UDF.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link UDT}{@code >}
     *
     * @param value Java instance representing xml element's value.
     * @return The new instance of {@link JAXBElement}{@code <}{@link UDT}{@code >}
     */
    @XmlElementDecl(namespace = UDF_NAMESPACE, name = "type")
    public JAXBElement<UDT> createType(UDT value)
    {
        return new JAXBElement<UDT>(_Type_QNAME, UDT.class, null, value);
    }
}
