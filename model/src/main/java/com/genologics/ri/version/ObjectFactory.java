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

package com.genologics.ri.version;

import static com.genologics.ri.Namespaces.VERSION_NAMESPACE;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * Factory class for creating instances of JAXB content classes defined in the
 * {@code com.genologics.ri.version} package.
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

    private final static QName _Version_QNAME = new QName(VERSION_NAMESPACE, "version");
    private final static QName _Versions_QNAME = new QName(VERSION_NAMESPACE, "versions");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.genologics.ri.version
     *
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Version}
     *
     * @return A new Version instance.
     */
    public Version createVersion() {
        return new Version();
    }

    /**
     * Create an instance of {@link Versions}
     *
     * @return A new Versions instance.
     */
    public Versions createVersions() {
        return new Versions();
    }

    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link Version}{@code >}
     *
     * @param value Java instance representing xml element's value.
     * @return The new instance of {@link JAXBElement}{@code <}{@link Version}{@code >}
     */
    @XmlElementDecl(namespace = VERSION_NAMESPACE, name = "version")
    public JAXBElement<Version> createVersion(Version value) {
        return new JAXBElement<Version>(_Version_QNAME, Version.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link Versions}{@code >}
     *
     * @param value Java instance representing xml element's value.
     * @return The new instance of {@link JAXBElement}{@code <}{@link Versions}{@code >}
     */
    @XmlElementDecl(namespace = VERSION_NAMESPACE, name = "versions")
    public JAXBElement<Versions> createVersions(Versions value) {
        return new JAXBElement<Versions>(_Versions_QNAME, Versions.class, null, value);
    }
}
