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

import static java.util.Objects.requireNonNull;

import java.io.Serial;
import java.net.URI;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import org.apache.commons.beanutils.PropertyUtils;

import com.genologics.ri.LimsLinkBase;
import com.genologics.ri.Linkable;

/**
 * Type-definition provides a URI linking to the user defined type associated
 * with the user-defined field, if applicable.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "type-definition")
public class TypeDefinition extends LimsLinkBase<Type>
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 7368802583367288257L;

    /**
     * The name of the type.
     */
    @XmlAttribute(name = "name")
    protected String name;

    /**
     * The URI of the type definition.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * Constructor for creating an empty TypeDefinition object.
     */
    public TypeDefinition()
    {
    }

    /**
     * Constructor for creating a TypeDefinition with a URI.
     *
     * @param uri The URI of the type.
     */
    public TypeDefinition(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructor for creating a TypeDefinition with a URI and name.
     *
     * @param uri The URI of the type.
     * @param name The name of the type.
     */
    public TypeDefinition(URI uri, String name)
    {
        this.name = name;
        this.uri = uri;
    }

    /**
     * Constructor for creating a TypeDefinition from a Linkable object.
     * Attempts to extract the name property using reflection.
     *
     * @param type The linkable type object.
     */
    public TypeDefinition(Linkable<Type> type)
    {
        requireNonNull(type, "type cannot be null");
        uri = type.getUri();
        try
        {
            name = (String)PropertyUtils.getProperty(type, "name");
        }
        catch (Exception e)
        {
            // Ignore.
        }
    }

    /**
     * Constructor for creating a TypeDefinition from a Type object.
     *
     * @param type The type object.
     */
    public TypeDefinition(Type type)
    {
        requireNonNull(type, "type cannot be null");
        uri = type.getUri();
        name = type.getName();
    }

    /**
     * Gets the entity class for this type definition.
     *
     * @return The Type class.
     */
    @Override
    public Class<Type> getEntityClass()
    {
        return Type.class;
    }

    /**
     * Gets the name of the type.
     *
     * @return The type name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of the type.
     *
     * @param name The type name.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Gets the URI of the type definition.
     *
     * @return The URI.
     */
    @Override
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI of the type definition.
     *
     * @param uri The URI.
     */
    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Returns the string representation of this type definition, which is the type name.
     *
     * @return The type name.
     */
    @Override
    public String toString()
    {
        return name;
    }
}
