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
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.ClarityEntity;
import com.genologics.ri.LimsLink;
import com.genologics.ri.Linkable;

/**
 *
 * The detailed representation of a Role
 *
 * @since 2.19
 */
@ClarityEntity(uriSection = "roles", updateable = true)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "role", propOrder = { "name", "researchers", "permissions" })
@XmlRootElement(name = "role")
public class Role implements Linkable<Role>, Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 5417064490465819346L;

    /**
     * The name of the role.
     */
    @XmlElement
    protected String name;

    /**
     * The list of researchers assigned to this role.
     */
    @XmlElementWrapper(name = "researchers")
    @XmlElement(name = "researcher")
    protected List<ResearcherLink> researchers;

    /**
     * The list of permissions assigned to this role.
     */
    @XmlElementWrapper(name = "permissions")
    @XmlElement(name = "permission")
    protected List<PermissionLink> permissions;

    /**
     * Whether this is a built-in system role.
     */
    @XmlAttribute(name = "built-in")
    protected Boolean builtIn;

    /**
     * The URI of the role.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * Default constructor.
     */
    public Role()
    {
    }

    /**
     * Constructor with URI.
     *
     * @param uri The URI of the role.
     */
    public Role(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructor with URI and name.
     *
     * @param uri The URI of the role.
     * @param name The name of the role.
     */
    public Role(URI uri, String name)
    {
        this.uri = uri;
        this.name = name;
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
     * Gets the list of researchers assigned to this role.
     *
     * @return A list of researcher links.
     */
    public List<ResearcherLink> getResearchers()
    {
        if (researchers == null)
        {
            researchers = new ArrayList<ResearcherLink>();
        }
        return researchers;
    }

    /**
     * Gets the list of permissions assigned to this role.
     *
     * @return A list of permission links.
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
     * Gets whether this is a built-in system role.
     *
     * @return True if this is a built-in role, false otherwise.
     */
    public Boolean getBuiltIn()
    {
        return builtIn;
    }

    /**
     * Sets whether this is a built-in system role.
     *
     * @param builtIn True if this is a built-in role, false otherwise.
     */
    public void setBuiltIn(Boolean builtIn)
    {
        this.builtIn = builtIn;
    }

    /**
     * Gets the URI of the role.
     *
     * @return The role URI.
     */
    @Override
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI of the role.
     *
     * @param uri The role URI.
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
    public LimsLink<Role> getLink()
    {
        return new RoleLink(this);
    }
}
