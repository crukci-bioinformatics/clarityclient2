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

import static java.util.Objects.requireNonNull;

import java.io.Serial;
import java.net.URI;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.genologics.ri.LimsEntityLinkBase;
import com.genologics.ri.LimsLink;
import com.genologics.ri.Link;
import com.genologics.ri.Linkable;
import com.genologics.ri.researcher.Researcher;

/**
 *
 * Researcher-link is a child element type of researchers and provides a URI
 * linking to the detailed representation of a researcher.
 *
 * @since 2.19
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "researcher-link")
public class ResearcherLink extends LimsEntityLinkBase<Researcher>
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = -8690537907678526381L;

    /**
     * The last name of the researcher.
     */
    @XmlAttribute(name = "last-name")
    protected String lastName;

    /**
     * The first name of the researcher.
     */
    @XmlAttribute(name = "first-name")
    protected String firstName;

    /**
     * The URI of the researcher.
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
     * @param uri The URI of the researcher.
     */
    public ResearcherLink(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructor from a Linkable.
     *
     * @param link The linkable researcher.
     */
    public ResearcherLink(Linkable<Researcher> link)
    {
        requireNonNull(link, "link cannot be null");
        this.uri = link.getUri();
    }

    /**
     * Constructor from a Researcher entity.
     *
     * @param researcher The researcher entity.
     */
    public ResearcherLink(Researcher researcher)
    {
        requireNonNull(researcher, "researcher cannot be null");
        uri = researcher.getUri();
        firstName = researcher.getFirstName();
        lastName = researcher.getLastName();
    }

    /**
     * Gets the last name of the researcher.
     *
     * @return The researcher's last name.
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * Sets the last name of the researcher.
     *
     * @param lastName The researcher's last name.
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    /**
     * Gets the first name of the researcher.
     *
     * @return The researcher's first name.
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * Sets the first name of the researcher.
     *
     * @param firstName The researcher's first name.
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
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
     * Gets the URI of the researcher.
     *
     * @return The researcher URI.
     */
    @Override
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI of the researcher.
     *
     * @param uri The researcher URI.
     */
    @Override
    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Gets the LIMS id from the URI.
     *
     * @return The LIMS id extracted from the URI.
     */
    @Override
    public String getLimsid()
    {
        return Link.limsIdFromUri(uri);
    }

    /**
     * Sets the LIMS id. This method does nothing as the id is extracted from the URI.
     *
     * @param id The LIMS id (ignored).
     */
    @Override
    public void setLimsid(String id)
    {
        // Does nothing.
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
     * Returns a string representation of this link.
     *
     * @return The researcher LIMS id and full name of the researcher.
     */
    @Override
    public String toString()
    {
        ToStringBuilder b = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
        b.append("reagentKit", LimsLink.toString(this));
        b.append("name", getFullName());
        return b.toString();
    }
}
