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

import static com.genologics.ri.Namespaces.ROOT_NAMESPACE;
import static com.genologics.ri.Namespaces.UDF_NAMESPACE;
import static org.apache.commons.lang3.StringUtils.isNoneEmpty;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;

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

import com.genologics.ri.ClarityEntity;
import com.genologics.ri.ExternalId;
import com.genologics.ri.LimsEntity;
import com.genologics.ri.LimsEntityLink;
import com.genologics.ri.Link;
import com.genologics.ri.Linkable;
import com.genologics.ri.lab.Lab;
import com.genologics.ri.userdefined.UDF;
import com.genologics.ri.userdefined.UDFHolder;
import com.genologics.ri.userdefined.UDT;

/**
 * The detailed representation of a researcher.
 */
@ClarityEntity(uriSection = "researchers", creatable = true, updateable = true, removable = true)
@XmlRootElement(name = "researcher")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "researcher",
         propOrder = { "firstName", "lastName", "phone", "fax", "email", "lab", "type", "fields",
                       "externalIds", "credentials", "initials" })
public class Researcher implements LimsEntity<Researcher>, UDFHolder, Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 2552745292977587999L;

    /**
     * The researcher's first name.
     */
    @XmlElement(name = "first-name")
    protected String firstName;

    /**
     * The researcher's last name.
     */
    @XmlElement(name = "last-name")
    protected String lastName;

    /**
     * The researcher's phone number.
     */
    protected String phone;

    /**
     * The researcher's fax number.
     */
    protected String fax;

    /**
     * The researcher's email address.
     */
    protected String email;

    /**
     * Link to the researcher's lab.
     */
    protected LabLink lab;

    /**
     * The user-defined type for the researcher.
     */
    @XmlElement(name = "type", namespace = UDF_NAMESPACE)
    protected UDT type;

    /**
     * The user-defined fields for the researcher.
     */
    @XmlElement(name = "field", namespace = UDF_NAMESPACE)
    protected List<UDF> fields;

    /**
     * The external identifiers for the researcher.
     */
    @XmlElement(name = "externalid", namespace = ROOT_NAMESPACE)
    protected List<ExternalId> externalIds;

    /**
     * The researcher's credentials.
     */
    protected Credentials credentials;

    /**
     * The researcher's initials.
     */
    protected String initials;

    /**
     * The URI to the researcher.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * Default constructor.
     */
    public Researcher()
    {
    }

    /**
     * Constructor with URI.
     *
     * @param uri The URI to the researcher.
     */
    public Researcher(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Gets the researcher's first name.
     *
     * @return The first name.
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * Sets the researcher's first name.
     *
     * @param value The first name.
     */
    public void setFirstName(String value)
    {
        this.firstName = value;
    }

    /**
     * Gets the researcher's last name.
     *
     * @return The last name.
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * Sets the researcher's last name.
     *
     * @param value The last name.
     */
    public void setLastName(String value)
    {
        this.lastName = value;
    }

    /**
     * Convenience method for returning the full name of the researcher.
     *
     * @return The full name.
     *
     * @since 2.31.2
     *
     * @see #makeFullName(String, String)
     */
    public String getFullName()
    {
        return makeFullName(firstName, lastName);
    }

    /**
     * Convenience method for making the full name of the researcher.
     * Present as a static to allow reuse by some of the researcher link classes.
     *
     * @param firstName The researcher first name.
     * @param lastName The researcher last name.
     *
     * @return First name &lt;space&gt; last name. If both names are null,
     * returns null.
     *
     * @since 2.31.2
     */
    public static String makeFullName(String firstName, String lastName)
    {
        if (firstName == null && lastName == null)
        {
            return null;
        }

        StringBuilder name = new StringBuilder(32);
        if (isNotEmpty(firstName))
        {
            name.append(firstName);
        }
        if (isNoneEmpty(firstName, lastName))
        {
            name.append(' ');
        }
        if (isNotEmpty(lastName))
        {
            name.append(lastName);
        }

        return name.toString();
    }

    /**
     * Gets the researcher's phone number.
     *
     * @return The phone number.
     */
    public String getPhone()
    {
        return phone;
    }

    /**
     * Sets the researcher's phone number.
     *
     * @param value The phone number.
     */
    public void setPhone(String value)
    {
        this.phone = value;
    }

    /**
     * Gets the researcher's fax number.
     *
     * @return The fax number.
     */
    public String getFax()
    {
        return fax;
    }

    /**
     * Sets the researcher's fax number.
     *
     * @param value The fax number.
     */
    public void setFax(String value)
    {
        this.fax = value;
    }

    /**
     * The researcher's e-mail address.
     *
     * @return The researcher's e-mail address.
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * Sets the researcher's email address.
     *
     * @param value The email address.
     */
    public void setEmail(String value)
    {
        this.email = value;
    }

    /**
     * Gets the link to the researcher's lab.
     *
     * @return The lab link.
     */
    public LabLink getLab()
    {
        return lab;
    }

    /**
     * Sets the link to the researcher's lab.
     *
     * @param link The linkable object containing the lab.
     */
    public void setLab(Linkable<Lab> link)
    {
        this.lab = new LabLink(link);
    }

    /**
     * Gets the user-defined type for the researcher.
     *
     * @return The user-defined type.
     */
    public UDT getUserDefinedType()
    {
        return type;
    }

    /**
     * Sets the user-defined type for the researcher.
     *
     * @param value The user-defined type.
     *
     * @return The user-defined type that was set.
     */
    public UDT setUserDefinedType(UDT value)
    {
        this.type = value;
        return this.type;
    }

    /**
     * Sets the user-defined type for the researcher.
     *
     * @param type The name of the user-defined type.
     *
     * @return The newly created user-defined type.
     */
    public UDT setUserDefinedType(String type)
    {
        this.type = new UDT(type);
        return this.type;
    }

    /**
     * Gets the list of user-defined fields for the researcher.
     *
     * @return The list of user-defined fields.
     */
    @Override
    public List<UDF> getUserDefinedFields()
    {
        if (fields == null)
        {
            fields = new ArrayList<UDF>();
        }
        return fields;
    }

    /**
     * Gets the list of external identifiers for the researcher.
     *
     * @return The list of external identifiers.
     */
    public List<ExternalId> getExternalIds()
    {
        if (externalIds == null)
        {
            externalIds = new ArrayList<ExternalId>();
        }
        return externalIds;
    }

    /**
     * Gets the researcher's credentials.
     *
     * @return The credentials.
     */
    public Credentials getCredentials()
    {
        return credentials;
    }

    /**
     * Sets the researcher's credentials.
     *
     * @param value The credentials.
     */
    public void setCredentials(Credentials value)
    {
        this.credentials = value;
    }

    /**
     * Gets the researcher's initials.
     *
     * @return The initials.
     */
    public String getInitials()
    {
        return initials;
    }

    /**
     * Sets the researcher's initials.
     *
     * @param value The initials.
     */
    public void setInitials(String value)
    {
        this.initials = value;
    }

    /**
     * Gets the URI to the researcher.
     *
     * @return The URI.
     */
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI to the researcher.
     *
     * @param value The URI.
     */
    public void setUri(URI value)
    {
        this.uri = value;
    }

    /**
     * Gets the LIMS id from the URI.
     *
     * @return The LIMS id.
     */
    @Override
    public String getLimsid()
    {
        return Link.limsIdFromUri(uri);
    }

    /**
     * Sets the LIMS id. This operation does nothing for this entity.
     *
     * @param id The LIMS id.
     */
    @Override
    public void setLimsid(String id)
    {
        // Does nothing.
    }

    /**
     * Gets a string representation of the researcher.
     *
     * @return A string containing the LIMS id, first name, and last name.
     */
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder(50);
        sb.append(getLimsid()).append(' ').append(firstName).append(' ').append(lastName);
        return sb.toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LimsEntityLink<Researcher> getLink()
    {
        return new ResearcherLink(this);
    }
}
