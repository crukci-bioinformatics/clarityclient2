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

package com.genologics.ri;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;

/**
 * Address contains the related fields of a mailing address.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "address",
         propOrder = { "street", "city", "state", "country", "postalCode", "institution", "department" })
public class Address implements Serializable
{
    /**
     * Class version for serialisation.
     */
    @java.io.Serial
    private static final long serialVersionUID = 5343736859063068514L;

    /**
     * The street address.
     */
    protected String street;

    /**
     * The city.
     */
    protected String city;

    /**
     * The state or province.
     */
    protected String state;

    /**
     * The country.
     */
    protected String country;

    /**
     * The postal or zip code.
     */
    protected String postalCode;

    /**
     * The institution.
     */
    protected String institution;

    /**
     * The department.
     */
    protected String department;

    /**
     * Gets the street address.
     *
     * @return The street address.
     */
    public String getStreet()
    {
        return street;
    }

    /**
     * Sets the street address.
     *
     * @param street The street address.
     */
    public void setStreet(String street)
    {
        this.street = street;
    }

    /**
     * Gets the city.
     *
     * @return The city.
     */
    public String getCity()
    {
        return city;
    }

    /**
     * Sets the city.
     *
     * @param city The city.
     */
    public void setCity(String city)
    {
        this.city = city;
    }

    /**
     * Gets the state or province.
     *
     * @return The state or province.
     */
    public String getState()
    {
        return state;
    }

    /**
     * Sets the state or province.
     *
     * @param state The state or province.
     */
    public void setState(String state)
    {
        this.state = state;
    }

    /**
     * Gets the country.
     *
     * @return The country.
     */
    public String getCountry()
    {
        return country;
    }

    /**
     * Sets the country.
     *
     * @param country The country.
     */
    public void setCountry(String country)
    {
        this.country = country;
    }

    /**
     * Gets the postal or zip code.
     *
     * @return The postal or zip code.
     */
    public String getPostalCode()
    {
        return postalCode;
    }

    /**
     * Sets the postal or zip code.
     *
     * @param postalCode The postal or zip code.
     */
    public void setPostalCode(String postalCode)
    {
        this.postalCode = postalCode;
    }

    /**
     * Gets the institution.
     *
     * @return The institution.
     */
    public String getInstitution()
    {
        return institution;
    }

    /**
     * Sets the institution.
     *
     * @param institution The institution.
     */
    public void setInstitution(String institution)
    {
        this.institution = institution;
    }

    /**
     * Gets the department.
     *
     * @return The department.
     */
    public String getDepartment()
    {
        return department;
    }

    /**
     * Sets the department.
     *
     * @param department The department.
     */
    public void setDepartment(String department)
    {
        this.department = department;
    }
}
