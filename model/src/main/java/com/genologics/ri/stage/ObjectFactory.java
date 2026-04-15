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

package com.genologics.ri.stage;

import static com.genologics.ri.Namespaces.STAGE_NAMESPACE;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * Factory class for creating instances of JAXB content classes defined in the
 * {@code com.genologics.ri.stage} package.
 * <p>
 * This class is required by JAXB (Java Architecture for XML Binding) and provides
 * factory methods for instantiating JAXB-managed classes and elements within this
 * package. Each factory method constructs new instances of schema-derived classes
 * that represent XML content structures.
 * </p>
 */
@XmlRegistry
public class ObjectFactory
{
    /**
     * The qualified name for the stage element in the JAXB context.
     */
    private final static QName _Stage_QNAME = new QName(STAGE_NAMESPACE, "stage");

    /**
     * Creates a new ObjectFactory that can be used to create new instances of
     * schema derived classes for package: com.genologics.ri.stage.
     */
    public ObjectFactory()
    {
    }

    /**
     * Creates an instance of {@link ProtocolStepLink}.
     *
     * @return A new ProtocolStepLink instance.
     */
    public ProtocolStepLink createProtocolStepLink()
    {
        return new ProtocolStepLink();
    }

    /**
     * Creates an instance of {@link WorkflowLink}.
     *
     * @return A new WorkflowLink instance.
     */
    public WorkflowLink createWorkflowLink()
    {
        return new WorkflowLink();
    }

    /**
     * Creates an instance of {@link Stage}.
     *
     * @return A new Stage instance.
     */
    public Stage createStage()
    {
        return new Stage();
    }

    /**
     * Creates an instance of {@link ProtocolLink}.
     *
     * @return A new ProtocolLink instance.
     */
    public ProtocolLink createProtocolLink()
    {
        return new ProtocolLink();
    }

    /**
     * Creates an instance of {@link JAXBElement}{@code <}{@link Stage}{@code >}.
     *
     * @param value The Java instance representing the XML element's value.
     *
     * @return The new instance of {@link JAXBElement}{@code <}{@link Stage}{@code >}.
     */
    @XmlElementDecl(namespace = STAGE_NAMESPACE, name = "stage")
    public JAXBElement<Stage> createStage(Stage value)
    {
        return new JAXBElement<Stage>(_Stage_QNAME, Stage.class, null, value);
    }
}
