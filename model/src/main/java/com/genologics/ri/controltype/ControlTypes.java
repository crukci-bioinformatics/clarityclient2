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

package com.genologics.ri.controltype;

import java.io.Serial;
import java.io.Serializable;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.Batch;
import com.genologics.ri.ClarityQueryResult;

/**
 * The representation of a list of control types in the Clarity LIMS system.
 * <p>
 * This class provides a container for multiple {@link ControlTypeLink} objects,
 * typically returned from queries that retrieve multiple control types. It implements
 * the {@link Batch} interface to provide standard list operations and sizing information.
 * </p>
 */
@ClarityQueryResult(entityClass = ControlType.class)
@XmlRootElement(name = "control-types")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "control-types")
public class ControlTypes implements Batch<ControlTypeLink>, Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 5668622843069816173L;

    /**
     * The list of control type links.
     */
    @XmlElement(name = "control-type")
    protected List<ControlTypeLink> controlTypes;

    /**
     * The URI of the control types collection.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * Default constructor.
     */
    public ControlTypes()
    {
    }

    /**
     * Gets the list of control types.
     * <p>
     * This method returns the internal list of control type links. If the list
     * has not been initialized, it creates a new empty ArrayList.
     * </p>
     *
     * @return The list of control type links. Never returns null.
     */
    public List<ControlTypeLink> getControlTypes()
    {
        if (controlTypes == null)
        {
            controlTypes = new ArrayList<ControlTypeLink>();
        }
        return controlTypes;
    }

    /**
     * Gets the list of control type links.
     * <p>
     * This method satisfies the {@link Batch} interface contract.
     * </p>
     *
     * @return The list of control type links.
     */
    @Override
    public List<ControlTypeLink> getList()
    {
        return getControlTypes();
    }

    /**
     * Gets the size of the control types list.
     *
     * @return The number of control type links in the collection, or 0 if the list is null.
     */
    @Override
    public int getSize()
    {
        return controlTypes == null ? 0 : controlTypes.size();
    }

    /**
     * Gets the URI of the control types collection.
     *
     * @return The URI.
     */
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI of the control types collection.
     *
     * @param uri The URI.
     */
    public void setUri(URI uri)
    {
        this.uri = uri;
    }

}
