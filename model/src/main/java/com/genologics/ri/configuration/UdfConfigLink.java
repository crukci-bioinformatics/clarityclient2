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
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.LimsLinkBase;

/**
 *
 * Udfconfig-link is a child element type of udfs and provides a URI linking to
 * the detailed representation of the configuration for a user defined field.
 */
@XmlRootElement(name = "udfconfig")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "udfconfig-link")
public class UdfConfigLink extends LimsLinkBase<Field>
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = -164190204904044681L;

    /**
     * The URI of the field configuration.
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
     * The name of the entity type this field is attached to.
     */
    @XmlAttribute(name = "attach-to-name")
    protected String attachToName;

    /**
     * The category this field is attached to.
     */
    @XmlAttribute(name = "attach-to-category")
    protected String attachToCategory;

    /**
     * Constructor for creating an empty UdfConfigLink object.
     */
    public UdfConfigLink()
    {
    }

    /**
     * Constructor for creating a UdfConfigLink with a URI.
     *
     * @param uri The URI of the field configuration.
     */
    public UdfConfigLink(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructor for creating a UdfConfigLink from a Field object.
     *
     * @param field The field to create the link from.
     */
    public UdfConfigLink(Field field)
    {
        requireNonNull(field, "field cannot be null");
        uri = field.getUri();
        name = field.getName();
        attachToName = field.getAttachToName();
        attachToCategory = field.getAttachToCategory();
    }

    /**
     * Gets the entity class for this link.
     *
     * @return The Field class.
     */
    @Override
    public Class<Field> getEntityClass()
    {
        return Field.class;
    }

    /**
     * Gets the URI of the field configuration.
     *
     * @return The URI.
     */
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI of the field configuration.
     *
     * @param uri The URI.
     */
    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Gets the name of the entity type this field is attached to.
     *
     * @return The entity type name.
     */
    public String getAttachToName()
    {
        return attachToName;
    }

    /**
     * Sets the name of the entity type this field is attached to.
     *
     * @param attachToName The entity type name.
     */
    public void setAttachToName(String attachToName)
    {
        this.attachToName = attachToName;
    }

    /**
     * Gets the name of the field.
     *
     * @return The field name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of the field.
     *
     * @param name The field name.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Gets the category this field is attached to.
     *
     * @return The category name.
     */
    public String getAttachToCategory()
    {
        return attachToCategory;
    }

    /**
     * Sets the category this field is attached to.
     *
     * @param attachToCategory The category name.
     */
    public void setAttachToCategory(String attachToCategory)
    {
        this.attachToCategory = attachToCategory;
    }

    /**
     * Returns the string representation of this link, which is the field name.
     *
     * @return The field name.
     */
    @Override
    public String toString()
    {
        return name;
    }
}
