@XmlSchema(
        namespace = PROJECT_NAMESPACE,
        elementFormDefault = XmlNsForm.UNQUALIFIED,
        xmlns = @XmlNs(prefix = "prj", namespaceURI = PROJECT_NAMESPACE))
@XmlJavaTypeAdapter(type = java.net.URI.class, value = com.genologics.ri.jaxb.URIAdapter.class)
package com.genologics.ri.project;

import static com.genologics.ri.Namespaces.PROJECT_NAMESPACE;

import jakarta.xml.bind.annotation.XmlNs;
import jakarta.xml.bind.annotation.XmlNsForm;
import jakarta.xml.bind.annotation.XmlSchema;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
