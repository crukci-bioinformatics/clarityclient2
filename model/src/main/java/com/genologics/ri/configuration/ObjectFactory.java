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

package com.genologics.ri.configuration;

import static com.genologics.ri.Namespaces.CONFIGURATION_NAMESPACE;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * Factory class for creating instances of JAXB content classes defined in the
 * {@code com.genologics.ri.configuration} package.
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
     * The QName for the type element.
     */
    private final static QName _Type_QNAME = new QName(CONFIGURATION_NAMESPACE, "type");

    /**
     * The QName for the udtconfig-link element.
     */
    private final static QName _UdtconfigLink_QNAME = new QName(CONFIGURATION_NAMESPACE, "udtconfig-link");

    /**
     * The QName for the udfs element.
     */
    private final static QName _Udfs_QNAME = new QName(CONFIGURATION_NAMESPACE, "udfs");

    /**
     * The QName for the udfconfig-link element.
     */
    private final static QName _UdfconfigLink_QNAME = new QName(CONFIGURATION_NAMESPACE, "udfconfig-link");

    /**
     * The QName for the udts element.
     */
    private final static QName _Udts_QNAME = new QName(CONFIGURATION_NAMESPACE, "udts");

    /**
     * The QName for the field element.
     */
    private final static QName _Field_QNAME = new QName(CONFIGURATION_NAMESPACE, "field");

    /**
     * The QName for the field-dynamic-preset element.
     */
    private final static QName _FieldDynamicPreset_QNAME = new QName(CONFIGURATION_NAMESPACE, "field-dynamic-preset");

    /**
     * The QName for the field-dynamic-preset-details element.
     */
    private final static QName _FieldDynamicPresetDetails_QNAME = new QName(CONFIGURATION_NAMESPACE, "field-dynamic-preset-details");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.genologics.ri.configuration.
     */
    public ObjectFactory()
    {
    }

    /**
     * Creates a new Udts instance.
     *
     * @return A new Udts instance.
     */
    public Udts createUdts()
    {
        return new Udts();
    }

    /**
     * Creates a new FieldLink instance.
     *
     * @return A new FieldLink instance.
     */
    public FieldLink createFieldLink()
    {
        return new FieldLink();
    }

    /**
     * Creates a new Udfs instance.
     *
     * @return A new Udfs instance.
     */
    public Udfs createUdfs()
    {
        return new Udfs();
    }

    /**
     * Creates a new UdfConfigLink instance.
     *
     * @return A new UdfConfigLink instance.
     */
    public UdfConfigLink createUdfconfigLink()
    {
        return new UdfConfigLink();
    }

    /**
     * Creates a new TypeDefinition instance.
     *
     * @return A new TypeDefinition instance.
     */
    public TypeDefinition createTypeDefinition()
    {
        return new TypeDefinition();
    }

    /**
     * Creates a new Field instance.
     *
     * @return A new Field instance.
     */
    public Field createField()
    {
        return new Field();
    }

    /**
     * Creates a new UdtConfigLink instance.
     *
     * @return A new UdtConfigLink instance.
     */
    public UdtConfigLink createUdtconfigLink()
    {
        return new UdtConfigLink();
    }

    /**
     * Creates a new Type instance.
     *
     * @return A new Type instance.
     */
    public Type createType()
    {
        return new Type();
    }

    /**
     * Creates a new FieldDynamicPreset instance.
     *
     * @return A new FieldDynamicPreset instance.
     */
    public FieldDynamicPreset createFieldDynamicPreset()
    {
        return new FieldDynamicPreset();
    }

    /**
     * Creates a new FieldDynamicPresetDetails instance.
     *
     * @return A new FieldDynamicPresetDetails instance.
     */
    public FieldDynamicPresetDetails createFieldDynamicPresetDetails()
    {
        return new FieldDynamicPresetDetails();
    }

    /**
     * Creates a JAXBElement for a Type.
     *
     * @param value The Type value.
     * @return A JAXBElement wrapping the Type.
     */
    @XmlElementDecl(namespace = CONFIGURATION_NAMESPACE, name = "type")
    public JAXBElement<Type> createType(Type value)
    {
        return new JAXBElement<Type>(_Type_QNAME, Type.class, null, value);
    }

    /**
     * Creates a JAXBElement for a UdtConfigLink.
     *
     * @param value The UdtConfigLink value.
     * @return A JAXBElement wrapping the UdtConfigLink.
     */
    @XmlElementDecl(namespace = CONFIGURATION_NAMESPACE, name = "udtconfig-link")
    public JAXBElement<UdtConfigLink> createUdtconfigLink(UdtConfigLink value)
    {
        return new JAXBElement<UdtConfigLink>(_UdtconfigLink_QNAME, UdtConfigLink.class, null, value);
    }

    /**
     * Creates a JAXBElement for Udfs.
     *
     * @param value The Udfs value.
     * @return A JAXBElement wrapping the Udfs.
     */
    @XmlElementDecl(namespace = CONFIGURATION_NAMESPACE, name = "udfs")
    public JAXBElement<Udfs> createUdfs(Udfs value)
    {
        return new JAXBElement<Udfs>(_Udfs_QNAME, Udfs.class, null, value);
    }

    /**
     * Creates a JAXBElement for a UdfConfigLink.
     *
     * @param value The UdfConfigLink value.
     * @return A JAXBElement wrapping the UdfConfigLink.
     */
    @XmlElementDecl(namespace = CONFIGURATION_NAMESPACE, name = "udfconfig-link")
    public JAXBElement<UdfConfigLink> createUdfconfigLink(UdfConfigLink value)
    {
        return new JAXBElement<UdfConfigLink>(_UdfconfigLink_QNAME, UdfConfigLink.class, null, value);
    }

    /**
     * Creates a JAXBElement for Udts.
     *
     * @param value The Udts value.
     * @return A JAXBElement wrapping the Udts.
     */
    @XmlElementDecl(namespace = CONFIGURATION_NAMESPACE, name = "udts")
    public JAXBElement<Udts> createUdts(Udts value)
    {
        return new JAXBElement<Udts>(_Udts_QNAME, Udts.class, null, value);
    }

    /**
     * Creates a JAXBElement for a Field.
     *
     * @param value The Field value.
     * @return A JAXBElement wrapping the Field.
     */
    @XmlElementDecl(namespace = CONFIGURATION_NAMESPACE, name = "field")
    public JAXBElement<Field> createField(Field value)
    {
        return new JAXBElement<Field>(_Field_QNAME, Field.class, null, value);
    }

    /**
     * Creates a JAXBElement for a FieldDynamicPreset.
     *
     * @param value The FieldDynamicPreset value.
     * @return A JAXBElement wrapping the FieldDynamicPreset.
     */
    @XmlElementDecl(namespace = CONFIGURATION_NAMESPACE, name = "field-dynamic-preset")
    public JAXBElement<FieldDynamicPreset> createFieldDynamicPreset(FieldDynamicPreset value)
    {
        return new JAXBElement<FieldDynamicPreset>(_FieldDynamicPreset_QNAME, FieldDynamicPreset.class, null, value);
    }

    /**
     * Creates a JAXBElement for FieldDynamicPresetDetails.
     *
     * @param value The FieldDynamicPresetDetails value.
     * @return A JAXBElement wrapping the FieldDynamicPresetDetails.
     */
    @XmlElementDecl(namespace = CONFIGURATION_NAMESPACE, name = "field-dynamic-preset-details")
    public JAXBElement<FieldDynamicPresetDetails> createFieldDynamicPresetDetails(FieldDynamicPresetDetails value)
    {
        return new JAXBElement<FieldDynamicPresetDetails>(_FieldDynamicPresetDetails_QNAME, FieldDynamicPresetDetails.class, null, value);
    }
}
