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
import static org.apache.commons.lang3.StringUtils.SPACE;

import java.io.Serial;
import java.net.URI;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.genologics.ri.LimsLink;
import com.genologics.ri.LimsLinkBase;
import com.genologics.ri.Linkable;

/**
 *
 * Field definition represents a user-defined field configured in the parent
 * entity. It includes the name and a URI linking to the detailed representation
 * of the configuration of a user defined field.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "field-link")
public class FieldLink extends LimsLinkBase<Field>
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 5031274064780081067L;

    /**
     * The name of the field.
     */
    @XmlAttribute(name = "name")
    protected String name;

    /**
     * The URI of the field configuration.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * Constructor for creating an empty FieldLink object.
     */
    public FieldLink()
    {
    }

    /**
     * Constructor for creating a FieldLink with a URI.
     *
     * @param uri The URI of the field.
     */
    public FieldLink(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructor for creating a FieldLink with a URI and name.
     *
     * @param uri The URI of the field.
     * @param name The name of the field.
     */
    public FieldLink(URI uri, String name)
    {
        this.name = name;
        this.uri = uri;
    }

    /**
     * Constructor for creating a FieldLink from a Linkable object.
     * Attempts to extract the name property using reflection.
     *
     * @param link The linkable object to create the link from.
     */
    public FieldLink(Linkable<Field> link)
    {
        requireNonNull(link, "link cannot be null");
        uri = link.getUri();
        try
        {
            name = (String)PropertyUtils.getProperty(link, "name");
        }
        catch (Exception e)
        {
            // Ignore.
        }
    }

    /**
     * Constructor for creating a FieldLink from a Field object.
     *
     * @param field The field to create the link from.
     */
    public FieldLink(Field field)
    {
        requireNonNull(field, "field cannot be null");
        uri = field.getUri();
        name = field.getName();
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
     * Returns a string representation of this link.
     *
     * @return The field LIMS id and the name.
     */
    @Override
    public String toString()
    {
        ToStringBuilder b = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
        b.append("field", LimsLink.toString(this));
        b.append("name", name);
        return b.toString();
    }
}
