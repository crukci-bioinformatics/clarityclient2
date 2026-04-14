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

package com.genologics.ri.containertype;

import static com.genologics.ri.Namespaces.CONTAINER_TYPE_NAMESPACE;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * Factory class for creating instances of JAXB content classes defined in the
 * {@code com.genologics.ri.containertype} package.
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
     * Qualified name for the container-type XML element.
     */
    private final static QName _ContainerType_QNAME = new QName(CONTAINER_TYPE_NAMESPACE, "container-type");

    /**
     * Qualified name for the container-types XML element.
     */
    private final static QName _ContainerTypes_QNAME = new QName(CONTAINER_TYPE_NAMESPACE, "container-types");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.genologics.ri.containertype
     *
     */
    public ObjectFactory()
    {
    }

    /**
     * Creates a new instance of {@link CalibrantWell}.
     *
     * @return A new calibrant well object.
     *
     * @deprecated This method is no longer supported as CalibrantWell is deprecated.
     */
    @Deprecated
    public CalibrantWell createCalibrantWell()
    {
        return new CalibrantWell();
    }

    /**
     * Creates a new instance of {@link ContainerType}.
     *
     * @return A new container type object.
     */
    public ContainerType createContainerType()
    {
        return new ContainerType();
    }

    /**
     * Creates a new instance of {@link ContainerTypes}.
     *
     * @return A new container types object.
     */
    public ContainerTypes createContainerTypes()
    {
        return new ContainerTypes();
    }

    /**
     * Creates a new instance of {@link ContainerTypeLink}.
     *
     * @return A new container type link object.
     */
    public ContainerTypeLink createContainerTypeLink()
    {
        return new ContainerTypeLink();
    }

    /**
     * Creates a new instance of {@link Dimension}.
     *
     * @return A new dimension object.
     */
    public Dimension createDimension()
    {
        return new Dimension();
    }

    /**
     * Creates a JAXBElement for marshalling a {@link ContainerType} object.
     *
     * @param value The container type to wrap.
     *
     * @return A JAXBElement wrapping the container type.
     */
    @XmlElementDecl(namespace = CONTAINER_TYPE_NAMESPACE, name = "container-type")
    public JAXBElement<ContainerType> createContainerType(ContainerType value)
    {
        return new JAXBElement<ContainerType>(_ContainerType_QNAME, ContainerType.class, null, value);
    }

    /**
     * Creates a JAXBElement for marshalling a {@link ContainerTypes} object.
     *
     * @param value The container types list to wrap.
     *
     * @return A JAXBElement wrapping the container types list.
     */
    @XmlElementDecl(namespace = CONTAINER_TYPE_NAMESPACE, name = "container-types")
    public JAXBElement<ContainerTypes> createContainerTypes(ContainerTypes value)
    {
        return new JAXBElement<ContainerTypes>(_ContainerTypes_QNAME, ContainerTypes.class, null, value);
    }
}
