/**
 * Entities for container type definitions in the Clarity system.
 * <p>
 * This package contains classes that represent container types, which describe the physical
 * characteristics of containers used in the laboratory. Container types define the dimensions,
 * well layouts, and coordinate systems for containers such as plates, tubes, and other sample
 * storage vessels.
 * </p>
 * <p>
 * Key classes include:
 * </p>
 * <ul>
 * <li>{@link com.genologics.ri.containertype.ContainerType} - The main representation of a container type</li>
 * <li>{@link com.genologics.ri.containertype.Dimension} - Defines the size and identification method for container dimensions</li>
 * <li>{@link com.genologics.ri.containertype.ContainerTypeLink} - A link to a container type resource</li>
 * <li>{@link com.genologics.ri.containertype.ContainerTypes} - A paginated list of container type links</li>
 * </ul>
 */
@XmlSchema(
    namespace = CONTAINER_TYPE_NAMESPACE,
    elementFormDefault = XmlNsForm.UNQUALIFIED,
    xmlns = @XmlNs(prefix = "ctp", namespaceURI = CONTAINER_TYPE_NAMESPACE))
@XmlJavaTypeAdapter(type = java.net.URI.class, value = com.genologics.ri.jaxb.URIAdapter.class)
package com.genologics.ri.containertype;

import static com.genologics.ri.Namespaces.CONTAINER_TYPE_NAMESPACE;

import jakarta.xml.bind.annotation.XmlNs;
import jakarta.xml.bind.annotation.XmlNsForm;
import jakarta.xml.bind.annotation.XmlSchema;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
