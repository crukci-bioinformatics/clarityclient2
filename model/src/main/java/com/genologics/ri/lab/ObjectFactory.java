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

package com.genologics.ri.lab;

import static com.genologics.ri.Namespaces.LAB_NAMESPACE;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * Factory class for creating instances of JAXB content classes defined in the
 * {@code com.genologics.ri.lab} package.
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
     * The qualified name for the labs element.
     */
    private final static QName _Labs_QNAME = new QName(LAB_NAMESPACE, "labs");

    /**
     * The qualified name for the lab element.
     */
    private final static QName _Lab_QNAME = new QName(LAB_NAMESPACE, "lab");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.genologics.ri.lab
     *
     */
    public ObjectFactory()
    {
    }

    /**
     * Creates a new Lab instance.
     *
     * @return a new Lab object.
     */
    public Lab createLab()
    {
        return new Lab();
    }

    /**
     * Creates a new Labs instance.
     *
     * @return a new Labs object.
     */
    public Labs createLabs()
    {
        return new Labs();
    }

    /**
     * Creates a new LabLink instance.
     *
     * @return a new LabLink object.
     */
    public LabLink createLabLink()
    {
        return new LabLink();
    }

    /**
     * Creates a JAXBElement for the labs element.
     *
     * @param value the Labs value to wrap.
     * @return a JAXBElement containing the Labs value.
     */
    @XmlElementDecl(namespace = LAB_NAMESPACE, name = "labs")
    public JAXBElement<Labs> createLabs(Labs value)
    {
        return new JAXBElement<Labs>(_Labs_QNAME, Labs.class, null, value);
    }

    /**
     * Creates a JAXBElement for the lab element.
     *
     * @param value the Lab value to wrap.
     * @return a JAXBElement containing the Lab value.
     */
    @XmlElementDecl(namespace = LAB_NAMESPACE, name = "lab")
    public JAXBElement<Lab> createLab(Lab value)
    {
        return new JAXBElement<Lab>(_Lab_QNAME, Lab.class, null, value);
    }
}
