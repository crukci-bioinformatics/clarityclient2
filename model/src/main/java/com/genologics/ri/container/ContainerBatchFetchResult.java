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

package com.genologics.ri.container;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.BatchUpdate;
import com.genologics.ri.ClarityBatchRetrieveResult;
import com.genologics.ri.Namespaces;

/**
 * The representation of a list of resource details for batch operations on containers.
 */
@ClarityBatchRetrieveResult(entityClass = Container.class, batchCreate = true, batchUpdate = true)
@XmlRootElement(name = "details")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "details", propOrder = { "containers" })
public class ContainerBatchFetchResult implements BatchUpdate<Container>, Serializable
{
    /**
     * Class version for serialisation.
     */
    @java.io.Serial
    private static final long serialVersionUID = 3942410984112211790L;

    /**
     * The list of containers.
     */
    @XmlElement(name = "container", namespace = Namespaces.CONTAINER_NAMESPACE)
    protected List<Container> containers;

    /**
     * Default constructor.
     */
    public ContainerBatchFetchResult()
    {
    }

    /**
     * Constructor with a collection of containers.
     *
     * @param containers the collection of containers.
     */
    public ContainerBatchFetchResult(Collection<Container> containers)
    {
        this.containers = new ArrayList<>(containers);
    }

    /**
     * Gets the list of containers.
     *
     * @return the list of containers.
     */
    public List<Container> getContainers()
    {
        if (containers == null)
        {
            containers = new ArrayList<>();
        }
        return containers;
    }

    /**
     * Gets the list of containers.
     *
     * @return the list of containers.
     */
    @Override
    public List<Container> getList()
    {
        return getContainers();
    }

    /**
     * Gets the size of the container list.
     *
     * @return the size.
     */
    @Override
    public int getSize()
    {
        return containers == null ? 0 : containers.size();
    }

    /**
     * Adds containers for batch creation.
     *
     * @param entities the containers to add.
     */
    @Override
    public void addForCreate(Collection<Container> entities)
    {
        getContainers().addAll(entities);
    }

    /**
     * Adds containers for batch update.
     *
     * @param entities the containers to add.
     */
    @Override
    public void addForUpdate(Collection<Container> entities)
    {
        // Nothing to worry about with state parameters for containers.
        getContainers().addAll(entities);
    }

}
