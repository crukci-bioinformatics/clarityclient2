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


package com.genologics.ri.reagentkit;

import static com.genologics.ri.Namespaces.REAGENT_KIT_NAMESPACE;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the com.genologics.ri.reagentkit package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 *
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ReagentKits_QNAME = new QName(REAGENT_KIT_NAMESPACE, "reagent-kits");
    private final static QName _ReagentKit_QNAME = new QName(REAGENT_KIT_NAMESPACE, "reagent-kit");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.genologics.ri.reagentkit
     *
     */
    public ObjectFactory() {
    }

    /**
     * Creates a new ReagentKit instance.
     *
     * @return A new ReagentKit object.
     */
    public ReagentKit createReagentKit() {
        return new ReagentKit();
    }

    /**
     * Creates a new ReagentKits instance.
     *
     * @return A new ReagentKits object.
     */
    public ReagentKits createReagentKits() {
        return new ReagentKits();
    }

    /**
     * Creates a new ReagentKitLink instance.
     *
     * @return A new ReagentKitLink object.
     */
    public ReagentKitLink createReagentKitLink() {
        return new ReagentKitLink();
    }

    /**
     * Creates a JAXBElement for ReagentKits.
     *
     * @param value The ReagentKits value to wrap.
     *
     * @return A JAXBElement containing the ReagentKits.
     */
    @XmlElementDecl(namespace = REAGENT_KIT_NAMESPACE, name = "reagent-kits")
    public JAXBElement<ReagentKits> createReagentKits(ReagentKits value) {
        return new JAXBElement<ReagentKits>(_ReagentKits_QNAME, ReagentKits.class, null, value);
    }

    /**
     * Creates a JAXBElement for a ReagentKit.
     *
     * @param value The ReagentKit value to wrap.
     *
     * @return A JAXBElement containing the ReagentKit.
     */
    @XmlElementDecl(namespace = REAGENT_KIT_NAMESPACE, name = "reagent-kit")
    public JAXBElement<ReagentKit> createReagentKit(ReagentKit value) {
        return new JAXBElement<ReagentKit>(_ReagentKit_QNAME, ReagentKit.class, null, value);
    }
}
