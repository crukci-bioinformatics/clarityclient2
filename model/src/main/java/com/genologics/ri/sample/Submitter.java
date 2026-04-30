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

package com.genologics.ri.sample;

import static java.util.Objects.requireNonNull;

import java.io.Serial;
import java.net.URI;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.genologics.ri.LimsLink;
import com.genologics.ri.LimsLinkBase;
import com.genologics.ri.Linkable;
import com.genologics.ri.researcher.Researcher;

/**
 * Submitter is a child element of Sample and provides a URI linking to the
 * detailed representation of the submitter for the Sample.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "submitter", propOrder = { "firstName", "lastName" })
public class Submitter extends LimsLinkBase<Researcher>
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 1302200229944706575L;

    /**
     * The first name of the submitter.
     */
    @XmlElement(name = "first-name")
    protected String firstName;

    /**
     * The last name of the submitter.
     */
    @XmlElement(name = "last-name")
    protected String lastName;

    /**
     * The URI of the submitter.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * Constructor for an empty submitter.
     */
    public Submitter()
    {
    }

    /**
     * Constructor for a submitter with a URI.
     *
     * @param uri The URI of the submitter.
     */
    public Submitter(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructor for a submitter from a linkable researcher.
     *
     * @param link The linkable researcher.
     */
    public Submitter(Linkable<Researcher> link)
    {
        requireNonNull(link, "link cannot be null");
        uri = link.getUri();
    }

    /**
     * Constructor for a submitter from a researcher entity.
     *
     * @param researcher The researcher entity.
     */
    public Submitter(Researcher researcher)
    {
        requireNonNull(researcher, "researcher cannot be null");
        uri = researcher.getUri();
        firstName = researcher.getFirstName();
        lastName = researcher.getLastName();
    }

    /**
     * Gets the entity class for this link.
     *
     * @return The Researcher class.
     */
    @Override
    public Class<Researcher> getEntityClass()
    {
        return Researcher.class;
    }

    /**
     * Gets the first name of the submitter.
     *
     * @return The first name.
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * Sets the first name of the submitter.
     *
     * @param firstName The first name.
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    /**
     * Gets the last name of the submitter.
     *
     * @return The last name.
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * Sets the last name of the submitter.
     *
     * @param lastName The last name.
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    /**
     * Convenience method for returning the full name of the submitter.
     *
     * @return The full name.
     *
     * @since 2.34.2
     */
    public String getFullName()
    {
        return Researcher.makeFullName(firstName, lastName);
    }

    /**
     * Gets the URI of the submitter.
     *
     * @return The submitter URI.
     */
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI of the submitter.
     *
     * @param uri The submitter URI.
     */
    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Returns a string representation of this submitter.
     *
     * @return The researcher URI and name.
     */
    @Override
    public String toString()
    {
        ToStringBuilder b = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
        b.append("researcher", LimsLink.toString(this));
        b.append("name", Researcher.makeFullName(firstName, lastName));
        return b.toString();
    }
}
