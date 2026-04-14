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

package com.genologics.ri;

import static com.genologics.ri.Namespaces.ROOT_NAMESPACE;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * Factory class for creating instances of JAXB content classes defined in the
 * {@code com.genologics.ri} package.
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
     * QName for the links element.
     */
    private final static QName _Links_QNAME = new QName(ROOT_NAMESPACE, "links");

    /**
     * QName for the index element.
     */
    private final static QName _Index_QNAME = new QName(ROOT_NAMESPACE, "index");

    /**
     * QName for the externalid element.
     */
    private final static QName _Externalid_QNAME = new QName(ROOT_NAMESPACE, "externalid");

    /**
     * Constructor. Creates a new ObjectFactory that can be used to create new
     * instances of schema derived classes for package: com.genologics.ri
     */
    public ObjectFactory()
    {
    }

    /**
     * Creates a new ExternalId instance.
     *
     * @return A new ExternalId object.
     */
    public ExternalId createExternalid()
    {
        return new ExternalId();
    }

    /**
     * Creates a new ContainerLink instance.
     *
     * @return A new ContainerLink object.
     */
    public ContainerLink createContainer()
    {
        return new ContainerLink();
    }

    /**
     * Creates a new Link instance.
     *
     * @return A new Link object.
     */
    public Link createLink()
    {
        return new Link();
    }

    /**
     * Creates a new Index instance.
     *
     * @return A new Index object.
     */
    public Index createIndex()
    {
        return new Index();
    }

    /**
     * Creates a new Location instance.
     *
     * @return A new Location object.
     */
    public Location createLocation()
    {
        return new Location();
    }

    /**
     * Creates a new Address instance.
     *
     * @return A new Address object.
     */
    public Address createAddress()
    {
        return new Address();
    }

    /**
     * Creates a new Links instance.
     *
     * @return A new Links object.
     */
    public Links createLinks()
    {
        return new Links();
    }

    /**
     * Creates a new Page instance.
     *
     * @return A new Page object.
     */
    public Page createPage()
    {
        return new Page();
    }

    /**
     * Creates a JAXBElement for Links.
     *
     * @param value The Links value to wrap.
     * @return A JAXBElement containing the Links value.
     */
    @XmlElementDecl(namespace = ROOT_NAMESPACE, name = "links")
    public JAXBElement<Links> createLinks(Links value)
    {
        return new JAXBElement<Links>(_Links_QNAME, Links.class, null, value);
    }

    /**
     * Creates a JAXBElement for Index.
     *
     * @param value The Index value to wrap.
     * @return A JAXBElement containing the Index value.
     */
    @XmlElementDecl(namespace = ROOT_NAMESPACE, name = "index")
    public JAXBElement<Index> createIndex(Index value)
    {
        return new JAXBElement<Index>(_Index_QNAME, Index.class, null, value);
    }

    /**
     * Creates a JAXBElement for ExternalId.
     *
     * @param value The ExternalId value to wrap.
     * @return A JAXBElement containing the ExternalId value.
     */
    @XmlElementDecl(namespace = ROOT_NAMESPACE, name = "externalid")
    public JAXBElement<ExternalId> createExternalid(ExternalId value)
    {
        return new JAXBElement<ExternalId>(_Externalid_QNAME, ExternalId.class, null, value);
    }
}
