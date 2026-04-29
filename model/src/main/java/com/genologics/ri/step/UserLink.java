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

package com.genologics.ri.step;

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
 *
 * Describes a user as required in the context of step escalations.
 *
 * @since 2.18
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "user", propOrder = { "firstName", "lastName" })
public class UserLink extends LimsLinkBase<Researcher>
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = -682022057659965784L;

    /**
     * The first name of the user.
     */
    @XmlElement(name = "first-name")
    protected String firstName;

    /**
     * The last name of the user.
     */
    @XmlElement(name = "last-name")
    protected String lastName;

    /**
     * The URI of the researcher resource representing the user.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * Default constructor.
     */
    public UserLink()
    {
    }

    /**
     * Constructor taking a URI.
     *
     * @param uri The URI of the user.
     */
    public UserLink(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructor taking a linkable researcher.
     *
     * @param link The linkable researcher representing the user.
     *
     * @throws NullPointerException if {@code link} is null.
     */
    public UserLink(Linkable<Researcher> link)
    {
        requireNonNull(link, "link cannot be null");
        uri = link.getUri();
    }

    /**
     * Constructor taking a researcher.
     *
     * @param researcher The researcher representing the user.
     *
     * @throws NullPointerException if {@code researcher} is null.
     */
    public UserLink(Researcher researcher)
    {
        requireNonNull(researcher, "researcher cannot be null");
        uri = researcher.getUri();
        firstName = researcher.getFirstName();
        lastName = researcher.getLastName();
    }

    /**
     * Gets the first name of the user.
     *
     * @return The first name.
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * Sets the first name of the user.
     *
     * @param firstName The first name.
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    /**
     * Gets the last name of the user.
     *
     * @return The last name.
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * Sets the last name of the user.
     *
     * @param lastName The last name.
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    /**
     * Gets the URI of the researcher resource.
     *
     * @return The URI.
     */
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI of the researcher resource.
     *
     * @param uri The URI.
     */
    public void setUri(URI uri)
    {
        this.uri = uri;
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
     * Returns a string representation of this user link.
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
