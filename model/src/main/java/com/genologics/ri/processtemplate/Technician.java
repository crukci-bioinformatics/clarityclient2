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

package com.genologics.ri.processtemplate;

import static java.util.Objects.requireNonNull;
import static org.apache.commons.lang3.StringUtils.SPACE;

import java.io.Serial;
import java.net.URI;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.LimsLinkBase;
import com.genologics.ri.Linkable;
import com.genologics.ri.researcher.Researcher;

/**
 *
 * Technician is a child element of process-template and provides a URI linking
 * to the detailed representation of the technician that is configured to run a
 * Process created using this Process Template.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "technician", propOrder = { "firstName", "lastName" })
public class Technician extends LimsLinkBase<Researcher>
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = -8798198413338733052L;

    /**
     * The first name of the technician.
     */
    @XmlElement(name = "first-name")
    protected String firstName;

    /**
     * The last name of the technician.
     */
    @XmlElement(name = "last-name")
    protected String lastName;

    /**
     * The URI linking to the detailed representation of this technician in the system.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * Constructs a new Technician with default values.
     */
    public Technician()
    {
    }

    /**
     * Constructs a new Technician with the specified URI.
     *
     * @param uri the URI of the technician resource
     */
    public Technician(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructs a new Technician from a linkable researcher object.
     *
     * @param link the linkable object containing the researcher URI
     * @throws NullPointerException if link is null
     */
    public Technician(Linkable<Researcher> link)
    {
        requireNonNull(link, "link cannot be null");
        uri = link.getUri();
    }

    /**
     * Constructs a new Technician from a Researcher object, copying the URI, 
     * first name, and last name.
     *
     * @param researcher the researcher to copy details from
     * @throws NullPointerException if researcher is null
     */
    public Technician(Researcher researcher)
    {
        requireNonNull(researcher, "researcher cannot be null");
        uri = researcher.getUri();
        firstName = researcher.getFirstName();
        lastName = researcher.getLastName();
    }

    /**
     * Gets the entity class that this link references.
     *
     * @return the Researcher class
     */
    @Override
    public Class<Researcher> getEntityClass()
    {
        return Researcher.class;
    }

    /**
     * Gets the first name of the technician.
     *
     * @return the first name
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * Sets the first name of the technician.
     *
     * @param firstName the first name to set
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    /**
     * Gets the last name of the technician.
     *
     * @return the last name
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * Sets the last name of the technician.
     *
     * @param lastName the last name to set
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    /**
     * Gets the URI of this technician resource.
     *
     * @return the URI
     */
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI of this technician resource.
     *
     * @param uri the URI to set
     */
    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Returns a string representation of the technician in the format "firstName lastName".
     *
     * @return the full name of the technician
     */
    @Override
    public String toString()
    {
        return firstName + SPACE + lastName;
    }
}
