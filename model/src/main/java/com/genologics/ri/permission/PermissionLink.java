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

package com.genologics.ri.permission;

import static java.util.Objects.requireNonNull;

import java.io.Serializable;
import java.net.URI;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.LimsLink;


/**
 * Permission-link provides a URI linking to the detailed representation of a permission.
 *
 * @since 2.19
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "permission-link")
public class PermissionLink implements LimsLink<Permission>, Serializable
{
    /**
     * Class version for serialisation.
     */
    @java.io.Serial
    private static final long serialVersionUID = -1000854973822260389L;

    /**
     * The permission action.
     */
    @XmlAttribute(name = "action")
    protected String action;

    /**
     * The permission name.
     */
    @XmlAttribute(name = "name")
    protected String name;

    /**
     * The URI of the permission.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * Default constructor.
     */
    public PermissionLink()
    {
    }

    /**
     * Constructor with URI.
     *
     * @param uri The permission URI.
     */
    public PermissionLink(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructor with URI, name and action.
     *
     * @param uri The permission URI.
     * @param name The permission name.
     * @param action The permission action.
     */
    public PermissionLink(URI uri, String name, String action)
    {
        this.uri = uri;
        this.name = name;
        this.action = action;
    }

    /**
     * Constructor from a permission.
     *
     * @param permission The permission.
     */
    public PermissionLink(Permission permission)
    {
        requireNonNull(permission, "permission cannot be null");
        this.uri = permission.getUri();
        this.name = permission.getName();
        this.action = permission.getAction();
    }

    /**
     * Get the permission action.
     *
     * @return The permission action.
     */
    public String getAction()
    {
        return action;
    }

    /**
     * Set the permission action.
     *
     * @param action The permission action.
     */
    public void setAction(String action)
    {
        this.action = action;
    }

    /**
     * Get the permission name.
     *
     * @return The permission name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Set the permission name.
     *
     * @param name The permission name.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public URI getUri()
    {
        return uri;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Class<Permission> getEntityClass()
    {
        return Permission.class;
    }
}
