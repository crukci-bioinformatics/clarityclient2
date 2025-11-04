@XmlSchema(
    namespace = GLOBAL_TOKEN_NAMESPACE,
    elementFormDefault = XmlNsForm.UNQUALIFIED,
    xmlns = @XmlNs(prefix = "ns1", namespaceURI = GLOBAL_TOKEN_NAMESPACE))
@XmlJavaTypeAdapter(type = java.net.URI.class, value = com.genologics.ri.jaxb.URIAdapter.class)
package com.genologics.ri.globaltoken;

import static com.genologics.ri.Namespaces.GLOBAL_TOKEN_NAMESPACE;

import jakarta.xml.bind.annotation.XmlNs;
import jakarta.xml.bind.annotation.XmlNsForm;
import jakarta.xml.bind.annotation.XmlSchema;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
