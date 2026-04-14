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

import java.io.Serial;
import java.io.Serializable;
import java.net.URI;
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
 * The representation for a list of role links.
 *
 * @since 2.19
 */
@ClarityQueryResult(entityClass = Role.class)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "roles")
@XmlRootElement(name = "roles")
public class Roles implements Batch<RoleLink>, Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = -8997233724026640778L;

    /**
     * The list of role links.
     */
    @XmlElement(name = "role")
    protected List<RoleLink> roles;

    /**
     * The URI of the roles list.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * Default constructor.
     */
    public Roles()
    {
    }

    /**
     * Constructor with URI.
     *
     * @param uri The URI of the roles list.
     */
    public Roles(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Gets the list of role links.
     *
     * @return A list of role links.
     */
    public List<RoleLink> getRoles()
    {
        if (roles == null)
        {
            roles = new ArrayList<>();
        }
        return roles;
    }

    /**
     * Gets the URI of the roles list.
     *
     * @return The roles list URI.
     */
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI of the roles list.
     *
     * @param uri The roles list URI.
     */
    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Gets the list of role links for batch processing.
     *
     * @return A list of role links.
     */
    @Override
    public List<RoleLink> getList()
    {
        return getRoles();
    }

    /**
     * Gets the size of the roles list.
     *
     * @return The number of role links, or 0 if the list is null.
     */
    @Override
    public int getSize()
    {
        return roles == null ? 0 : roles.size();
    }

}
