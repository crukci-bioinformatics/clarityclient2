/**
 * Provides classes for representing and managing laboratory entities in the Clarity LIMS system.
 * <p>
 * This package contains the representation of labs, including detailed lab information,
 * lab links for navigation, and paginated collections of labs. The classes support
 * JAXB XML serialization and deserialization for communication with the Clarity REST API.
 * </p>
 */
@XmlSchema(
        namespace = LAB_NAMESPACE,
        elementFormDefault = XmlNsForm.UNQUALIFIED,
        xmlns = @XmlNs(prefix = "lab", namespaceURI = LAB_NAMESPACE))
@XmlJavaTypeAdapter(type = java.net.URI.class, value = com.genologics.ri.jaxb.URIAdapter.class)
package com.genologics.ri.lab;

import static com.genologics.ri.Namespaces.LAB_NAMESPACE;

import jakarta.xml.bind.annotation.XmlNs;
import jakarta.xml.bind.annotation.XmlNsForm;
import jakarta.xml.bind.annotation.XmlSchema;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
