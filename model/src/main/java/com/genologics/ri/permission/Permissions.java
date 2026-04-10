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

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.Batch;
import com.genologics.ri.ClarityQueryResult;

/**
 * The representation of a list of permission links.
 *
 * @since 2.19
 */
@ClarityQueryResult(entityClass = Permission.class)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "permissions")
@XmlRootElement(name = "permissions")
public class Permissions implements Batch<PermissionLink>, Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = -8403111885816697046L;

    /**
     * The list of permission links.
     */
    @XmlElement(name = "permission")
    protected List<PermissionLink> permissions;

    /**
     * The URI of the permissions collection.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected String uri;

    /**
     * Default constructor.
     */
    public Permissions()
    {
    }

    /**
     * Constructor with URI.
     *
     * @param uri The permissions collection URI.
     */
    public Permissions(String uri)
    {
        this.uri = uri;
    }

    /**
     * Get the list of permission links.
     *
     * @return The list of permission links.
     */
    public List<PermissionLink> getPermissions()
    {
        if (permissions == null)
        {
            permissions = new ArrayList<PermissionLink>();
        }
        return permissions;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<PermissionLink> getList()
    {
        return getPermissions();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getSize()
    {
        return permissions == null ? 0 : permissions.size();
    }

    /**
     * Get the URI.
     *
     * @return The URI.
     */
    public String getUri()
    {
        return uri;
    }

    /**
     * Set the URI.
     *
     * @param uri The URI.
     */
    public void setUri(String uri)
    {
        this.uri = uri;
    }

}
