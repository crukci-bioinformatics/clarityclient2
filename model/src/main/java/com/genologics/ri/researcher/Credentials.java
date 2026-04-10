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

package com.genologics.ri.researcher;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * The credentials element contains information about a researcher's access to
 * the client software interface. It is used only when a researcher is given
 * access to the system. It is not used when a researcher's information is being
 * stored for contact purposes only.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "credentials", propOrder = { "username", "password", "accountLocked", "roles" })
public class Credentials implements Serializable
{
    /**
     * Class version for serialisation.
     */
    @java.io.Serial
    private static final long serialVersionUID = -2712902822454057343L;

    /**
     * The researcher's username.
     */
    protected String username;

    /**
     * The researcher's password.
     */
    protected String password;

    /**
     * Whether the researcher's account is locked.
     */
    @XmlElement(name = "account-locked")
    protected Boolean accountLocked;

    /**
     * The roles assigned to the researcher.
     */
    @XmlElement(name = "role")
    protected List<Role> roles;

    /**
     * Gets the username.
     *
     * @return The username.
     */
    public String getUsername()
    {
        return username;
    }

    /**
     * Sets the username.
     *
     * @param value The username.
     */
    public void setUsername(String value)
    {
        this.username = value;
    }

    /**
     * Gets the password.
     *
     * @return The password.
     */
    public String getPassword()
    {
        return password;
    }

    /**
     * Sets the password.
     *
     * @param value The password.
     */
    public void setPassword(String value)
    {
        this.password = value;
    }

    /**
     * Checks whether the account is locked.
     *
     * @return True if the account is locked, false otherwise.
     */
    public Boolean isAccountLocked()
    {
        return accountLocked;
    }

    /**
     * Sets whether the account is locked.
     *
     * @param value True to lock the account, false otherwise.
     */
    public void setAccountLocked(Boolean value)
    {
        this.accountLocked = value;
    }

    /**
     * Gets the list of roles assigned to the researcher.
     *
     * @return The list of roles.
     */
    public List<Role> getRoles()
    {
        if (roles == null)
        {
            roles = new ArrayList<Role>();
        }
        return this.roles;
    }

    /**
     * Adds a role to the researcher's credentials.
     *
     * @param role The role to add.
     *
     * @return The added role.
     */
    public Role addRole(Role role)
    {
        getRoles().add(role);
        return role;
    }

    /**
     * Adds a role to the researcher's credentials.
     *
     * @param name The name of the role to add.
     *
     * @return The newly created role.
     */
    public Role addRole(String name)
    {
        Role role = new Role(null, name);
        getRoles().add(role);
        return role;
    }
}
