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

package com.genologics.ri.role;

import static java.util.Objects.requireNonNull;

import java.io.Serial;
import java.net.URI;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.LimsLinkBase;

/**
 *
 * Role-link is a child element type of roles and provides a URI linking to the
 * detailed representation of a Role.
 *
 * @since 2.19
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "role-link")
public class RoleLink extends LimsLinkBase<Role>
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = -6515590246139208584L;

    /**
     * The name of the role.
     */
    @XmlAttribute(name = "name")
    protected String name;

    /**
     * The URI of the role.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * Default constructor.
     */
    public RoleLink()
    {
    }

    /**
     * Constructor with URI.
     *
     * @param uri The URI of the role.
     */
    public RoleLink(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructor with URI and name.
     *
     * @param uri The URI of the role.
     * @param name The name of the role.
     */
    public RoleLink(URI uri, String name)
    {
        this.uri = uri;
        this.name = name;
    }

    /**
     * Constructor from a Role entity.
     *
     * @param role The role entity.
     */
    public RoleLink(Role role)
    {
        requireNonNull(role, "role cannot be null");
        uri = role.getUri();
        name = role.getName();
    }

    /**
     * Gets the name of the role.
     *
     * @return The role name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of the role.
     *
     * @param name The role name.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Gets the URI of the role.
     *
     * @return The role URI.
     */
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI of the role.
     *
     * @param uri The role URI.
     */
    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Gets the entity class for this link.
     *
     * @return The Role class.
     */
    @Override
    public Class<Role> getEntityClass()
    {
        return Role.class;
    }

    /**
     * Returns a string representation of this link.
     *
     * @return The name of the role.
     */
    @Override
    public String toString()
    {
        return name;
    }
}
