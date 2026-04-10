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

import java.io.Serializable;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.ClarityEntity;
import com.genologics.ri.Page;
import com.genologics.ri.PaginatedBatch;

/**
 *
 * The representation of a queue.
 * <p>
 * It represents and is used to list all of the elements contained within a
 * queue. A queue is a representation of samples that are ready to run through a
 * Protocol Step.
 * </p>
 * <p>
 * Each artifact listed in the queue will contain elements to show when it was
 * queued and its container location.
 * </p>
 *
 * @since 2.19
 */
@ClarityEntity(uriSection = "queues", cacheable = false)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "queue", propOrder = { "artifacts", "previousPage", "nextPage" })
@XmlRootElement(name = "queue")
public class Queue implements PaginatedBatch<ArtifactLink>, Serializable
{
    /**
     * Class version for serialisation.
     */
    @java.io.Serial
    private static final long serialVersionUID = 4372664462524847744L;

    /**
     * The list of artifacts in the queue.
     */
    @XmlElementWrapper(name = "artifacts")
    @XmlElement(name = "artifact")
    protected List<ArtifactLink> artifacts;

    /**
     * The link to the previous page of results.
     */
    @XmlElement(name = "previous-page")
    protected Page previousPage;

    /**
     * The link to the next page of results.
     */
    @XmlElement(name = "next-page")
    protected Page nextPage;

    /**
     * The URI of the queue.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * The URI of the protocol step for this queue.
     */
    @XmlAttribute(name = "protocol-step-uri")
    @XmlSchemaType(name = "anyURI")
    protected URI protocolStepUri;

    /**
     * The name of the queue.
     */
    @XmlAttribute(name = "name")
    protected String name;

    /**
     * Default constructor.
     */
    public Queue()
    {
    }

    /**
     * Constructor with URI.
     *
     * @param uri The URI of the queue.
     */
    public Queue(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructor with URI and name.
     *
     * @param uri The URI of the queue.
     * @param name The name of the queue.
     */
    public Queue(URI uri, String name)
    {
        this.uri = uri;
        this.name = name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Page getPreviousPage()
    {
        return previousPage;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setPreviousPage(Page previousPage)
    {
        this.previousPage = previousPage;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Page getNextPage()
    {
        return nextPage;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setNextPage(Page nextPage)
    {
        this.nextPage = nextPage;
    }

    /**
     * Gets the URI of the queue.
     *
     * @return The queue URI.
     */
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI of the queue.
     *
     * @param uri The queue URI.
     */
    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Gets the protocol step URI.
     *
     * @return The protocol step URI.
     */
    public URI getProtocolStepUri()
    {
        return protocolStepUri;
    }

    /**
     * Sets the protocol step URI.
     *
     * @param protocolStepUri The protocol step URI.
     */
    public void setProtocolStepUri(URI protocolStepUri)
    {
        this.protocolStepUri = protocolStepUri;
    }

    /**
     * Gets the name of the queue.
     *
     * @return The queue name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of the queue.
     *
     * @param name The queue name.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Gets the list of artifacts in the queue.
     *
     * @return The list of artifact links.
     */
    public List<ArtifactLink> getArtifacts()
    {
        if (artifacts == null)
        {
            artifacts = new ArrayList<>();
        }
        return artifacts;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ArtifactLink> getList()
    {
        return getArtifacts();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getSize()
    {
        return artifacts == null ? 0 : artifacts.size();
    }
}
