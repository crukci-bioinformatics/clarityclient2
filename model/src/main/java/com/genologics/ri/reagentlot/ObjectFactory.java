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

package com.genologics.ri.reagentlot;

import static com.genologics.ri.Namespaces.REAGENT_LOT_NAMESPACE;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * Factory class for creating instances of JAXB content classes defined in the
 * {@code com.genologics.ri.reagentlot} package.
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

    private final static QName _ReagentLots_QNAME = new QName(REAGENT_LOT_NAMESPACE, "reagent-lots");
    private final static QName _ReagentLot_QNAME = new QName(REAGENT_LOT_NAMESPACE, "reagent-lot");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.genologics.ri.reagentlot
     *
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ReagentLotLink}.
     *
     * @return A new ReagentLotLink instance.
     */
    public ReagentLotLink createReagentLotLink() {
        return new ReagentLotLink();
    }

    /**
     * Create an instance of {@link ReagentLot}.
     *
     * @return A new ReagentLot instance.
     */
    public ReagentLot createReagentLot() {
        return new ReagentLot();
    }

    /**
     * Create an instance of {@link ResearcherLink}.
     *
     * @return A new ResearcherLink instance.
     */
    public ResearcherLink createResearcher() {
        return new ResearcherLink();
    }

    /**
     * Create an instance of {@link ReagentLots}.
     *
     * @return A new ReagentLots instance.
     */
    public ReagentLots createReagentLots() {
        return new ReagentLots();
    }

    /**
     * Create an instance of {@link ReagentKitLink}.
     *
     * @return A new ReagentKitLink instance.
     */
    public ReagentKitLink createReagentKitLink() {
        return new ReagentKitLink();
    }

    /**
     * Create an instance of {@link JAXBElement}&lt;{@link ReagentLots}&gt;.
     *
     * @param value The ReagentLots value.
     * @return A JAXBElement wrapping the ReagentLots.
     */
    @XmlElementDecl(namespace = REAGENT_LOT_NAMESPACE, name = "reagent-lots")
    public JAXBElement<ReagentLots> createReagentLots(ReagentLots value) {
        return new JAXBElement<ReagentLots>(_ReagentLots_QNAME, ReagentLots.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement}&lt;{@link ReagentLot}&gt;.
     *
     * @param value The ReagentLot value.
     * @return A JAXBElement wrapping the ReagentLot.
     */
    @XmlElementDecl(namespace = REAGENT_LOT_NAMESPACE, name = "reagent-lot")
    public JAXBElement<ReagentLot> createReagentLot(ReagentLot value) {
        return new JAXBElement<ReagentLot>(_ReagentLot_QNAME, ReagentLot.class, null, value);
    }
}
