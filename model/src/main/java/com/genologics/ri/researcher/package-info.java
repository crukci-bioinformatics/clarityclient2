@XmlSchema(
        namespace = RESEARCHER_NAMESPACE,
        elementFormDefault = XmlNsForm.UNQUALIFIED,
        xmlns = @XmlNs(prefix = "res", namespaceURI = RESEARCHER_NAMESPACE))
@XmlJavaTypeAdapter(type = java.net.URI.class, value = com.genologics.ri.jaxb.URIAdapter.class)
package com.genologics.ri.researcher;

import static com.genologics.ri.Namespaces.RESEARCHER_NAMESPACE;

import jakarta.xml.bind.annotation.XmlNs;
import jakarta.xml.bind.annotation.XmlNsForm;
import jakarta.xml.bind.annotation.XmlSchema;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
