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

import java.io.Serializable;
import java.net.URI;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import org.apache.commons.beanutils.PropertyUtils;

import com.genologics.ri.LimsLink;
import com.genologics.ri.Linkable;
import com.genologics.ri.configuration.Field;

/**
 *
 * Type-definition is a child element of process type providing a URI linking to
 * the configuration of a user-defined type for the process type.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "type-definition")
public class TypeDefinition implements LimsLink<Field>, Serializable
{
    private static final long serialVersionUID = 2990437613974395091L;

    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    @XmlAttribute(name = "name")
    protected String name;

    public TypeDefinition()
    {
    }

    public TypeDefinition(URI uri)
    {
        this.uri = uri;
    }

    public TypeDefinition(URI uri, String name)
    {
        this.uri = uri;
        this.name = name;
    }

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
            // Ignore.
        }
    }

    public TypeDefinition(Field field)
    {
        requireNonNull(field, "field cannot be null");
        uri = field.getUri();
        name = field.getName();
    }

    @Override
    public Class<Field> getEntityClass()
    {
        return Field.class;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public URI getUri()
    {
        return uri;
    }

    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    @Override
    public String toString()
    {
        return name;
    }
}
