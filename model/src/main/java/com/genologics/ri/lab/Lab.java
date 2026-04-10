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

package com.genologics.ri.lab;

import static com.genologics.ri.Namespaces.ROOT_NAMESPACE;
import static com.genologics.ri.Namespaces.UDF_NAMESPACE;

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

import com.genologics.ri.Address;
import com.genologics.ri.ClarityEntity;
import com.genologics.ri.ExternalId;
import com.genologics.ri.LimsEntity;
import com.genologics.ri.LimsEntityLink;
import com.genologics.ri.Link;
import com.genologics.ri.userdefined.UDF;
import com.genologics.ri.userdefined.UDFHolder;
import com.genologics.ri.userdefined.UDT;

/**
 * The detailed representation of a lab.
 */
@ClarityEntity(uriSection = "labs", creatable = true, updateable = true)
@XmlRootElement(name = "lab")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "lab",
         propOrder = { "name", "billingAddress", "shippingAddress", "type", "fields", "externalIds", "website" })
public class Lab implements LimsEntity<Lab>, UDFHolder, Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 8559819171292932068L;

    /**
     * The name of the lab.
     */
    @XmlElement(name = "name")
    protected String name;

    /**
     * The billing address for the lab.
     */
    @XmlElement(name = "billing-address")
    protected Address billingAddress;

    /**
     * The shipping address for the lab.
     */
    @XmlElement(name = "shipping-address")
    protected Address shippingAddress;

    /**
     * The user-defined type for the lab.
     */
    @XmlElement(name = "type", namespace = UDF_NAMESPACE)
    protected UDT type;

    /**
     * The list of user-defined fields for the lab.
     */
    @XmlElement(name = "field", namespace = UDF_NAMESPACE)
    protected List<UDF> fields;

    /**
     * The list of external identifiers for the lab.
     */
    @XmlElement(name = "externalid", namespace = ROOT_NAMESPACE)
    protected List<ExternalId> externalIds;

    /**
     * The website URL of the lab.
     */
    protected String website;

    /**
     * The URI of the lab resource.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;


    /**
     * Constructs a new Lab instance.
     */
    public Lab()
    {
    }

    /**
     * Constructs a new Lab instance with the specified URI.
     *
     * @param uri the URI of the lab resource.
     */
    public Lab(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructs a new Lab instance with the specified URI and name.
     *
     * @param uri the URI of the lab resource.
     * @param name the name of the lab.
     */
    public Lab(URI uri, String name)
    {
        this.uri = uri;
        this.name = name;
    }

    /**
     * Gets the name of the lab.
     *
     * @return the name of the lab.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of the lab.
     *
     * @param value the name to set.
     */
    public void setName(String value)
    {
        this.name = value;
    }

    /**
     * Gets the billing address of the lab.
     *
     * @return the billing address.
     */
    public Address getBillingAddress()
    {
        return billingAddress;
    }

    /**
     * Sets the billing address of the lab.
     *
     * @param value the billing address to set.
     */
    public void setBillingAddress(Address value)
    {
        this.billingAddress = value;
    }

    /**
     * Gets the shipping address of the lab.
     *
     * @return the shipping address.
     */
    public Address getShippingAddress()
    {
        return shippingAddress;
    }

    /**
     * Sets the shipping address of the lab.
     *
     * @param value the shipping address to set.
     */
    public void setShippingAddress(Address value)
    {
        this.shippingAddress = value;
    }

    /**
     * Gets the user-defined type of the lab.
     *
     * @return the user-defined type.
     */
    public UDT getUserDefinedType()
    {
        return type;
    }

    /**
     * Sets the user-defined type of the lab.
     *
     * @param value the user-defined type to set.
     * @return the user-defined type that was set.
     */
    public UDT setUserDefinedType(UDT value)
    {
        this.type = value;
        return this.type;
    }

    /**
     * Sets the user-defined type of the lab using a type name.
     *
     * @param type the name of the user-defined type.
     * @return the newly created user-defined type.
     */
    public UDT setUserDefinedType(String type)
    {
        this.type = new UDT(type);
        return this.type;
    }

    @Override
    public List<UDF> getUserDefinedFields()
    {
        if (fields == null)
        {
            fields = new ArrayList<UDF>();
        }
        return this.fields;
    }

    /**
     * Gets the list of external identifiers for the lab.
     *
     * @return the list of external identifiers.
     */
    public List<ExternalId> getExternalid()
    {
        if (externalIds == null)
        {
            externalIds = new ArrayList<ExternalId>();
        }
        return this.externalIds;
    }

    /**
     * Gets the website URL of the lab.
     *
     * @return the website URL.
     */
    public String getWebsite()
    {
        return website;
    }

    /**
     * Sets the website URL of the lab.
     *
     * @param value the website URL to set.
     */
    public void setWebsite(String value)
    {
        this.website = value;
    }

    /**
     * Gets the URI of the lab resource.
     *
     * @return the URI of the lab.
     */
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI of the lab resource.
     *
     * @param value the URI to set.
     */
    public void setUri(URI value)
    {
        this.uri = value;
    }

    /**
     * Gets the LIMS id extracted from the URI.
     *
     * @return the LIMS id.
     */
    @Override
    public String getLimsid()
    {
        return Link.limsIdFromUri(uri);
    }

    /**
     * Sets the LIMS id. This operation does nothing as the id is derived from the URI.
     *
     * @param id the LIMS id (ignored).
     */
    @Override
    public void setLimsid(String id)
    {
        // Does nothing.
    }

    /**
     * Returns a string representation of the lab.
     *
     * @return a string containing the LIMS id and name.
     */
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder(50);
        sb.append(getLimsid()).append(' ').append(name);
        return sb.toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LimsEntityLink<Lab> getLink()
    {
        return new LabLink(this);
    }
}
