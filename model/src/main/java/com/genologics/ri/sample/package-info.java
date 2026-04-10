/**
 * Provides classes for sample entities in the Clarity LIMS API.
 * <p>
 * This package contains representations and helper classes for working with
 * samples, including sample links, sample creation, and batch operations.
 * </p>
 */
@XmlSchema(
        namespace = SAMPLE_NAMESPACE,
        elementFormDefault = XmlNsForm.UNQUALIFIED,
        xmlns = @XmlNs(prefix = "smp", namespaceURI = SAMPLE_NAMESPACE))
@XmlJavaTypeAdapter(type = java.net.URI.class, value = com.genologics.ri.jaxb.URIAdapter.class)
package com.genologics.ri.sample;

import static com.genologics.ri.Namespaces.SAMPLE_NAMESPACE;

import jakarta.xml.bind.annotation.XmlNs;
import jakarta.xml.bind.annotation.XmlNsForm;
import jakarta.xml.bind.annotation.XmlSchema;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
