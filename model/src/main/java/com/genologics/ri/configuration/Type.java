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

package com.genologics.ri.configuration;

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
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.Batch;
import com.genologics.ri.ClarityEntity;
import com.genologics.ri.LimsLink;
import com.genologics.ri.Linkable;

/**
 * The detailed representation of the configuration of a user defined type.
 */
@ClarityEntity(uriSection = "configuration/udts")
@XmlRootElement(name = "type")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "type", propOrder = { "fieldDefinitions", "attachToName", "attachToCategory" })
public class Type implements Linkable<Type>, Batch<FieldLink>, Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 6975337629090720371L;

    /**
     * The list of field definitions for this type.
     */
    @XmlElement(name = "field-definition")
    protected List<FieldLink> fieldDefinitions;

    /**
     * The name of the entity type this user defined type is attached to.
     */
    @XmlElement(name = "attach-to-name")
    protected String attachToName;

    /**
     * The category this user defined type is attached to.
     */
    @XmlElement(name = "attach-to-category")
    protected String attachToCategory;

    /**
     * The name of this type.
     */
    @XmlAttribute(name = "name")
    protected String name;

    /**
     * The URI of this type configuration.
     */
    @XmlAttribute(name = "uri")
    protected URI uri;

    /**
     * Constructor for creating an empty Type object.
     */
    public Type()
    {
    }

    /**
     * Constructor for creating a Type with a name.
     *
     * @param name The name of the type.
     */
    public Type(String name)
    {
        this.name = name;
    }

    /**
     * Constructor for creating a Type with a name and URI.
     *
     * @param name The name of the type.
     * @param uri The URI of the type.
     */
    public Type(String name, URI uri)
    {
        this.name = name;
        this.uri = uri;
    }

    /**
     * Gets the list of field definitions for this type.
     * Creates a new list if one doesn't exist.
     *
     * @return The list of field definitions.
     */
    public List<FieldLink> getFieldDefinitions()
    {
        if (fieldDefinitions == null)
        {
            fieldDefinitions = new ArrayList<>();
        }
        return fieldDefinitions;
    }

    /**
     * Gets the list of field definitions as required by the Batch interface.
     *
     * @return The list of field definitions.
     */
    @Override
    public List<FieldLink> getList()
    {
        return getFieldDefinitions();
    }

    /**
     * Gets the number of field definitions.
     *
     * @return The number of field definitions, or 0 if the list is null.
     */
    @Override
    public int getSize()
    {
        return fieldDefinitions == null ? 0 : fieldDefinitions.size();
    }

    /**
     * Gets the name of the entity type this user defined type is attached to.
     *
     * @return The entity type name.
     */
    public String getAttachToName()
    {
        return attachToName;
    }

    /**
     * Sets the name of the entity type this user defined type is attached to.
     *
     * @param value The entity type name.
     */
    public void setAttachToName(String value)
    {
        this.attachToName = value;
    }

    /**
     * Gets the category this user defined type is attached to.
     *
     * @return The category name.
     */
    public String getAttachToCategory()
    {
        return attachToCategory;
    }

    /**
     * Sets the category this user defined type is attached to.
     *
     * @param value The category name.
     */
    public void setAttachToCategory(String value)
    {
        this.attachToCategory = value;
    }

    /**
     * Gets the name of this type.
     *
     * @return The type name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of this type.
     *
     * @param value The type name.
     */
    public void setName(String value)
    {
        this.name = value;
    }

    /**
     * Gets the URI of this type configuration.
     *
     * @return The URI.
     */
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI of this type configuration.
     *
     * @param value The URI.
     */
    public void setUri(URI value)
    {
        this.uri = value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LimsLink<Type> getLink()
    {
        return new UdtConfigLink(this);
    }
}
