/**
 * Entities for control types in the Clarity LIMS system.
 * <p>
 * This package contains classes representing control types and their associated
 * data structures. Control types define reference materials or standards used
 * for quality control and validation in laboratory workflows.
 * </p>
 * <p>
 * The main classes in this package are:
 * </p>
 * <ul>
 * <li>{@link com.genologics.ri.controltype.ControlType} - The full representation of a control type</li>
 * <li>{@link com.genologics.ri.controltype.ControlTypeLink} - A lightweight link to a control type</li>
 * <li>{@link com.genologics.ri.controltype.ControlTypes} - A collection of control type links</li>
 * </ul>
 */
@XmlSchema(
    namespace = CONTROL_TYPE_NAMESPACE,
    elementFormDefault = XmlNsForm.UNQUALIFIED,
    xmlns = @XmlNs(prefix = "ctrltp", namespaceURI = CONTROL_TYPE_NAMESPACE))
@XmlJavaTypeAdapter(type = java.net.URI.class, value = com.genologics.ri.jaxb.URIAdapter.class)
package com.genologics.ri.controltype;

import static com.genologics.ri.Namespaces.CONTROL_TYPE_NAMESPACE;

import jakarta.xml.bind.annotation.XmlNs;
import jakarta.xml.bind.annotation.XmlNsForm;
import jakarta.xml.bind.annotation.XmlSchema;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
