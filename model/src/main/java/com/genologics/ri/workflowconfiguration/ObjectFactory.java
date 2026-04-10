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

package com.genologics.ri.workflowconfiguration;

import static com.genologics.ri.Namespaces.WORKFLOW_CONFIGURATION_NAMESPACE;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * Factory class for creating instances of JAXB content classes defined in the
 * {@code com.genologics.ri.workflowconfiguration} package.
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

    private final static QName _Workflows_QNAME = new QName(WORKFLOW_CONFIGURATION_NAMESPACE, "workflows");
    private final static QName _Workflow_QNAME = new QName(WORKFLOW_CONFIGURATION_NAMESPACE, "workflow");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.genologics.ri.workflowconfiguration
     *
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Workflow}.
     *
     * @return A new Workflow instance.
     */
    public Workflow createWorkflow() {
        return new Workflow();
    }

    /**
     * Create an instance of {@link ProtocolLink}.
     *
     * @return A new ProtocolLink instance.
     */
    public ProtocolLink createProtocolLink() {
        return new ProtocolLink();
    }

    /**
     * Create an instance of {@link WorkflowLink}.
     *
     * @return A new WorkflowLink instance.
     */
    public WorkflowLink createWorkflowLink() {
        return new WorkflowLink();
    }

    /**
     * Create an instance of {@link StageLink}.
     *
     * @return A new StageLink instance.
     */
    public StageLink createStageLink() {
        return new StageLink();
    }

    /**
     * Create an instance of {@link Workflows}.
     *
     * @return A new Workflows instance.
     */
    public Workflows createWorkflows() {
        return new Workflows();
    }

    /**
     * Create a JAXBElement for {@link Workflows}.
     *
     * @param value The Workflows value to wrap.
     * @return A JAXBElement wrapping the Workflows instance.
     */
    @XmlElementDecl(namespace = WORKFLOW_CONFIGURATION_NAMESPACE, name = "workflows")
    public JAXBElement<Workflows> createWorkflows(Workflows value) {
        return new JAXBElement<Workflows>(_Workflows_QNAME, Workflows.class, null, value);
    }

    /**
     * Create a JAXBElement for {@link Workflow}.
     *
     * @param value The Workflow value to wrap.
     * @return A JAXBElement wrapping the Workflow instance.
     */
    @XmlElementDecl(namespace = WORKFLOW_CONFIGURATION_NAMESPACE, name = "workflow")
    public JAXBElement<Workflow> createWorkflow(Workflow value) {
        return new JAXBElement<Workflow>(_Workflow_QNAME, Workflow.class, null, value);
    }
}
