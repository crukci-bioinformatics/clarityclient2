@XmlSchema(
    namespace = SAVED_QUERY_NAMESPACE,
    elementFormDefault = XmlNsForm.UNQUALIFIED,
    xmlns = @XmlNs(prefix = "sqr", namespaceURI = SAVED_QUERY_NAMESPACE))
@XmlJavaTypeAdapter(type = java.net.URI.class, value = com.genologics.ri.jaxb.URIAdapter.class)
package com.genologics.ri.savedquery;

import static com.genologics.ri.Namespaces.SAVED_QUERY_NAMESPACE;

import jakarta.xml.bind.annotation.XmlNs;
import jakarta.xml.bind.annotation.XmlNsForm;
import jakarta.xml.bind.annotation.XmlSchema;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
