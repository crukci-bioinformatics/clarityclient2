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

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.genologics.ri.LimsLinkBase;
import com.genologics.ri.permission.Permission;

/**
 *
 * Permission-link is a child element type of permissions and provides a URI
 * linking to the detailed representation of a Permission.
 *
 * @since 2.19
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "permission-link")
public class PermissionLink extends LimsLinkBase<Permission>
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 6570314965797232412L;

    /**
     * The action associated with the permission.
     */
    @XmlAttribute(name = "action")
    protected String action;

    /**
     * The name of the permission.
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
     * @param uri The URI of the permission.
     */
    public PermissionLink(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructor with URI and name.
     *
     * @param uri The URI of the permission.
     * @param name The name of the permission.
     */
    public PermissionLink(URI uri, String name)
    {
        this.uri = uri;
        this.name = name;
    }

    /**
     * Constructor with URI, name, and action.
     *
     * @param uri The URI of the permission.
     * @param name The name of the permission.
     * @param action The action associated with the permission.
     */
    public PermissionLink(URI uri, String name, String action)
    {
        this.uri = uri;
        this.name = name;
        this.action = action;
    }

    /**
     * Constructor from a Permission entity.
     *
     * @param permission The permission entity.
     */
    public PermissionLink(Permission permission)
    {
        requireNonNull(permission, "permission cannot be null");
        this.uri = permission.getUri();
        this.name = permission.getName();
        this.action = permission.getAction();
    }

    /**
     * Gets the action associated with the permission.
     *
     * @return The permission action.
     */
    public String getAction()
    {
        return action;
    }

    /**
     * Sets the action associated with the permission.
     *
     * @param action The permission action.
     */
    public void setAction(String action)
    {
        this.action = action;
    }

    /**
     * Gets the name of the permission.
     *
     * @return The permission name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of the permission.
     *
     * @param name The permission name.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Gets the URI of the permission.
     *
     * @return The permission URI.
     */
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI of the permission.
     *
     * @param uri The permission URI.
     */
    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Gets the entity class for this link.
     *
     * @return The Permission class.
     */
    @Override
    public Class<Permission> getEntityClass()
    {
        return Permission.class;
    }

    /**
     * Returns a string representation of this permission link.
     *
     * @return The permission URI, name and action.
     */
    @Override
    public String toString()
    {
        ToStringBuilder b = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
        b.append("permission", uri);
        b.append("name", name);
        b.append("action", action);
        return b.toString();
    }
}
