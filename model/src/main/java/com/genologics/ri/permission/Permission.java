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

import java.io.Serializable;
import java.net.URI;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.ClarityEntity;
import com.genologics.ri.LimsLink;
import com.genologics.ri.Linkable;

/**
 * The detailed representation of a permission.
 *
 * @since 2.19
 */
@ClarityEntity(uriSection = "permissions")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "permission", propOrder = { "name", "action", "description" })
@XmlRootElement(name = "permission")
public class Permission implements Linkable<Permission>, Serializable
{
    /**
     * Class version for serialisation.
     */
    @java.io.Serial
    private static final long serialVersionUID = 5000872708185118382L;

    /**
     * The permission name.
     */
    protected String name;

    /**
     * The permission action.
     */
    protected String action;

    /**
     * The permission description.
     */
    protected String description;

    /**
     * The URI of the permission.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * Default constructor.
     */
    public Permission()
    {
    }

    /**
     * Constructor with URI.
     *
     * @param uri The permission URI.
     */
    public Permission(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructor with URI and name.
     *
     * @param uri The permission URI.
     * @param name The permission name.
     */
    public Permission(URI uri, String name)
    {
        this.uri = uri;
        this.name = name;
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
     * Get the permission description.
     *
     * @return The permission description.
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Set the permission description.
     *
     * @param description The permission description.
     */
    public void setDescription(String description)
    {
        this.description = description;
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
    public LimsLink<Permission> getLink()
    {
        return new PermissionLink(this);
    }
}
