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

package com.genologics.ri.queue;

import static com.genologics.ri.Namespaces.QUEUE_NAMESPACE;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * Factory class for creating instances of JAXB content classes defined in the
 * {@code com.genologics.ri.queue} package.
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
     * The QName for the queue element in the QUEUE_NAMESPACE.
     */
    private final static QName _Queue_QNAME = new QName(QUEUE_NAMESPACE, "queue");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.genologics.ri.queue
     *
     */
    public ObjectFactory()
    {
    }

    /**
     * Creates a new Queue instance.
     *
     * @return A new Queue object.
     */
    public Queue createQueue()
    {
        return new Queue();
    }

    /**
     * Creates a new ArtifactLink instance.
     *
     * @return A new ArtifactLink object.
     */
    public ArtifactLink createArtifactLink()
    {
        return new ArtifactLink();
    }

    /**
     * Creates a JAXBElement for a Queue.
     *
     * @param value The Queue value to wrap.
     *
     * @return A JAXBElement containing the Queue.
     */
    @XmlElementDecl(namespace = QUEUE_NAMESPACE, name = "queue")
    public JAXBElement<Queue> createQueue(Queue value)
    {
        return new JAXBElement<Queue>(_Queue_QNAME, Queue.class, null, value);
    }
}
