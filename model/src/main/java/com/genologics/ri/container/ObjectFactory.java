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

package com.genologics.ri.container;

import static com.genologics.ri.Namespaces.CONTAINER_NAMESPACE;
import static com.genologics.ri.Namespaces.EMPTY_NAMESPACE;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * Factory class for creating instances of JAXB content classes defined in the
 * {@code com.genologics.ri.container} package.
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
     * The QName for the containers element.
     */
    private final static QName _Containers_QNAME = new QName(CONTAINER_NAMESPACE, "containers");

    /**
     * The QName for the container element.
     */
    private final static QName _Container_QNAME = new QName(CONTAINER_NAMESPACE, "container");

    /**
     * The QName for the details element.
     */
    private final static QName _Details_QNAME = new QName(CONTAINER_NAMESPACE, "details");

    /**
     * The QName for the placement element in Container scope.
     */
    private final static QName _ContainerPlacement_QNAME = new QName(EMPTY_NAMESPACE, "placement");

    /**
     * The QName for the occupied-wells element in Container scope.
     */
    private final static QName _ContainerOccupiedWells_QNAME = new QName(EMPTY_NAMESPACE, "occupied-wells");

    /**
     * The QName for the name element in Container scope.
     */
    private final static QName _ContainerName_QNAME = new QName(EMPTY_NAMESPACE, "name");

    /**
     * The QName for the state element in Container scope.
     */
    private final static QName _ContainerState_QNAME = new QName(EMPTY_NAMESPACE, "state");

    /**
     * The QName for the type element in Container scope.
     */
    private final static QName _ContainerType_QNAME = new QName(EMPTY_NAMESPACE, "type");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.genologics.ri.container.
     */
    public ObjectFactory()
    {
    }

    /**
     * Creates a new Container instance.
     *
     * @return A new Container instance.
     */
    public Container createContainer()
    {
        return new Container();
    }

    /**
     * Creates a new Placement instance.
     *
     * @return A new Placement instance.
     */
    public Placement createPlacement()
    {
        return new Placement();
    }

    /**
     * Creates a new ContainerTypeLink instance.
     *
     * @return A new ContainerTypeLink instance.
     */
    public ContainerTypeLink createContainerType()
    {
        return new ContainerTypeLink();
    }

    /**
     * Creates a new ContainerLink instance.
     *
     * @return A new ContainerLink instance.
     */
    public ContainerLink createContainerLink()
    {
        return new ContainerLink();
    }

    /**
     * Creates a new ContainerBatchFetchResult instance.
     *
     * @return A new ContainerBatchFetchResult instance.
     */
    public ContainerBatchFetchResult createDetails()
    {
        return new ContainerBatchFetchResult();
    }

    /**
     * Creates a new Containers instance.
     *
     * @return A new Containers instance.
     */
    public Containers createContainers()
    {
        return new Containers();
    }

    /**
     * Creates a JAXBElement for Containers.
     *
     * @param value The Containers value.
     * @return A JAXBElement wrapping the Containers.
     */
    @XmlElementDecl(namespace = CONTAINER_NAMESPACE, name = "containers")
    public JAXBElement<Containers> createContainers(Containers value)
    {
        return new JAXBElement<Containers>(_Containers_QNAME, Containers.class, null, value);
    }

    /**
     * Creates a JAXBElement for Container.
     *
     * @param value The Container value.
     * @return A JAXBElement wrapping the Container.
     */
    @XmlElementDecl(namespace = CONTAINER_NAMESPACE, name = "container")
    public JAXBElement<Container> createContainer(Container value)
    {
        return new JAXBElement<Container>(_Container_QNAME, Container.class, null, value);
    }

    /**
     * Creates a JAXBElement for ContainerBatchFetchResult.
     *
     * @param value The ContainerBatchFetchResult value.
     * @return A JAXBElement wrapping the ContainerBatchFetchResult.
     */
    @XmlElementDecl(namespace = CONTAINER_NAMESPACE, name = "details")
    public JAXBElement<ContainerBatchFetchResult> createDetails(ContainerBatchFetchResult value)
    {
        return new JAXBElement<ContainerBatchFetchResult>(_Details_QNAME, ContainerBatchFetchResult.class, null, value);
    }

    /**
     * Creates a JAXBElement for Placement in Container scope.
     *
     * @param value The Placement value.
     * @return A JAXBElement wrapping the Placement.
     */
    @XmlElementDecl(namespace = EMPTY_NAMESPACE, name = "placement", scope = Container.class)
    public JAXBElement<Placement> createContainerPlacement(Placement value)
    {
        return new JAXBElement<Placement>(_ContainerPlacement_QNAME, Placement.class, Container.class, value);
    }

    /**
     * Creates a JAXBElement for occupied-wells in Container scope.
     *
     * @param value The occupied-wells value.
     * @return A JAXBElement wrapping the Long value.
     */
    @XmlElementDecl(namespace = EMPTY_NAMESPACE, name = "occupied-wells", scope = Container.class)
    public JAXBElement<Long> createContainerOccupiedWells(Long value)
    {
        return new JAXBElement<Long>(_ContainerOccupiedWells_QNAME, Long.class, Container.class, value);
    }

    /**
     * Creates a JAXBElement for name in Container scope.
     *
     * @param value The name value.
     * @return A JAXBElement wrapping the String value.
     */
    @XmlElementDecl(namespace = EMPTY_NAMESPACE, name = "name", scope = Container.class)
    public JAXBElement<String> createContainerName(String value)
    {
        return new JAXBElement<String>(_ContainerName_QNAME, String.class, Container.class, value);
    }

    /**
     * Creates a JAXBElement for state in Container scope.
     *
     * @param value The state value.
     * @return A JAXBElement wrapping the String value.
     */
    @XmlElementDecl(namespace = EMPTY_NAMESPACE, name = "state", scope = Container.class)
    public JAXBElement<String> createContainerState(String value)
    {
        return new JAXBElement<String>(_ContainerState_QNAME, String.class, Container.class, value);
    }

    /**
     * Creates a JAXBElement for type in Container scope.
     *
     * @param value The ContainerTypeLink value.
     * @return A JAXBElement wrapping the ContainerTypeLink.
     */
    @XmlElementDecl(namespace = EMPTY_NAMESPACE, name = "type", scope = Container.class)
    public JAXBElement<ContainerTypeLink> createContainerType(ContainerTypeLink value)
    {
        return new JAXBElement<ContainerTypeLink>(_ContainerType_QNAME, ContainerTypeLink.class, Container.class, value);
    }
}
