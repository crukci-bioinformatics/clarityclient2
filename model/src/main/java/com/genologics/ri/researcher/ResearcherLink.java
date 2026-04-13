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

import static java.util.Objects.requireNonNull;

import java.io.Serial;
import java.net.URI;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.LimsEntityLinkBase;
import com.genologics.ri.Link;
import com.genologics.ri.Linkable;

/**
 * Researcher-link is a child element type of researchers and provides a URI
 * linking to the detailed representation of a researcher.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "researcher-link", propOrder = { "firstName", "lastName" })
public class ResearcherLink extends LimsEntityLinkBase<Researcher>
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 5396333049575412661L;

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
     * The URI to the researcher.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * Default constructor.
     */
    public ResearcherLink()
    {
    }

    /**
     * Constructor with URI.
     *
     * @param uri The URI to the researcher.
     */
    public ResearcherLink(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructor with URI and names.
     *
     * @param uri The URI to the researcher.
     * @param firstName The researcher's first name.
     * @param lastName The researcher's last name.
     */
    public ResearcherLink(URI uri, String firstName, String lastName)
    {
        this.uri = uri;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Constructor from a linkable object.
     *
     * @param link The linkable object containing the researcher URI.
     */
    public ResearcherLink(Linkable<Researcher> link)
    {
        requireNonNull(link, "link cannot be null");
        this.uri = link.getUri();
    }

    /**
     * Constructor from a researcher object.
     *
     * @param researcher The researcher to create the link from.
     */
    public ResearcherLink(Researcher researcher)
    {
        requireNonNull(researcher, "researcher cannot be null");
        uri = researcher.getUri();
        firstName = researcher.getFirstName();
        lastName = researcher.getLastName();
    }

    /**
     * Gets the entity class this link refers to.
     *
     * @return The Researcher class.
     */
    public Class<Researcher> getEntityClass()
    {
        return Researcher.class;
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
     * @param firstName The first name.
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
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
     * @param lastName The last name.
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    /**
     * Convenience method for returning the full name of the researcher.
     *
     * @return The full name.
     *
     * @since 2.31.2
     *
     * @see Researcher#makeFullName(String, String)
     */
    public String getFullName()
    {
        return Researcher.makeFullName(firstName, lastName);
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
     * @param uri The URI.
     */
    public void setUri(URI uri)
    {
        this.uri = uri;
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
     * Sets the LIMS id. This operation does nothing for this link type.
     *
     * @param id The LIMS id.
     */
    @Override
    public void setLimsid(String id)
    {
        // Does nothing.
    }

    /**
     * Gets a string representation of the researcher link.
     *
     * @return The researcher's full name.
     */
    @Override
    public String toString()
    {
        return firstName + " " + lastName;
    }
}
