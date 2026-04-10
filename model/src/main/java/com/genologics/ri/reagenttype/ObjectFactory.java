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

package com.genologics.ri.reagenttype;

import static com.genologics.ri.Namespaces.REAGENT_TYPE_NAMESPACE;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * Factory class for creating instances of JAXB content classes defined in the
 * {@code com.genologics.ri.reagenttype} package.
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
     * The qualified name for reagent-type elements.
     */
    private final static QName _ReagentType_QNAME = new QName(REAGENT_TYPE_NAMESPACE, "reagent-type");

    /**
     * The qualified name for reagent-types elements.
     */
    private final static QName _ReagentTypes_QNAME = new QName(REAGENT_TYPE_NAMESPACE, "reagent-types");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.genologics.ri.reagenttype
     */
    public ObjectFactory()
    {
    }

    /**
     * Create an instance of {@link ReagentTypes}.
     *
     * @return A new ReagentTypes instance.
     */
    public ReagentTypes createReagentTypes()
    {
        return new ReagentTypes();
    }

    /**
     * Create an instance of {@link SpecialType}.
     *
     * @return A new SpecialType instance.
     */
    public SpecialType createSpecialType()
    {
        return new SpecialType();
    }

    /**
     * Create an instance of {@link Attribute}.
     *
     * @return A new Attribute instance.
     */
    public Attribute createAttribute()
    {
        return new Attribute();
    }

    /**
     * Create an instance of {@link ReagentTypeLink}.
     *
     * @return A new ReagentTypeLink instance.
     */
    public ReagentTypeLink createReagentTypeLink()
    {
        return new ReagentTypeLink();
    }

    /**
     * Create an instance of {@link ReagentType}.
     *
     * @return A new ReagentType instance.
     */
    public ReagentType createReagentType()
    {
        return new ReagentType();
    }

    /**
     * Create an instance of {@link JAXBElement}&lt;{@link ReagentType}&gt;.
     *
     * @param value The ReagentType value.
     * @return A JAXBElement wrapping the ReagentType.
     */
    @XmlElementDecl(namespace = REAGENT_TYPE_NAMESPACE, name = "reagent-type")
    public JAXBElement<ReagentType> createReagentType(ReagentType value)
    {
        return new JAXBElement<ReagentType>(_ReagentType_QNAME, ReagentType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement}&lt;{@link ReagentTypes}&gt;.
     *
     * @param value The ReagentTypes value.
     * @return A JAXBElement wrapping the ReagentTypes.
     */
    @XmlElementDecl(namespace = REAGENT_TYPE_NAMESPACE, name = "reagent-types")
    public JAXBElement<ReagentTypes> createReagentTypes(ReagentTypes value)
    {
        return new JAXBElement<ReagentTypes>(_ReagentTypes_QNAME, ReagentTypes.class, null, value);
    }
}
