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

package com.genologics.ri.processtype;

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
import com.genologics.ri.configuration.Field;

/**
 *
 * Type-definition is a child element of process type providing a URI linking to
 * the configuration of a user-defined type for the process type.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "type-definition")
public class TypeDefinition extends LimsLinkBase<Field>
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 2990437613974395091L;

    /**
     * The URI of the field.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * The name of the field.
     */
    @XmlAttribute(name = "name")
    protected String name;

    /**
     * Constructs a new type definition.
     */
    public TypeDefinition()
    {
    }

    /**
     * Constructs a new type definition with the specified URI.
     *
     * @param uri the URI of the field.
     */
    public TypeDefinition(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructs a new type definition with the specified URI and name.
     *
     * @param uri the URI of the field.
     * @param name the name of the field.
     */
    public TypeDefinition(URI uri, String name)
    {
        this.uri = uri;
        this.name = name;
    }

    /**
     * Constructs a new type definition from a linkable field.
     *
     * @param field the linkable field.
     */
    public TypeDefinition(Linkable<Field> field)
    {
        requireNonNull(field, "field cannot be null");
        uri = field.getUri();
        try
        {
            name = (String)PropertyUtils.getProperty(field, "name");
        }
        catch (Exception e)
        {
        }
    }

    /**
     * Constructs a new type definition from a field entity.
     *
     * @param field the field entity.
     */
    public TypeDefinition(Field field)
    {
        requireNonNull(field, "field cannot be null");
        uri = field.getUri();
        name = field.getName();
    }

    /**
     * Gets the entity class for this link.
     *
     * @return the Field class.
     */
    @Override
    public Class<Field> getEntityClass()
    {
        return Field.class;
    }

    /**
     * Gets the name of the field.
     *
     * @return the field name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of the field.
     *
     * @param name the field name.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Gets the URI of the field.
     *
     * @return the field URI.
     */
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI of the field.
     *
     * @param uri the field URI.
     */
    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Returns a string representation of this type definition.
     *
     * @return the field name.
     */
    @Override
    public String toString()
    {
        return name;
    }
}
