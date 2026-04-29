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
import static org.apache.commons.lang3.StringUtils.SPACE;

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
 * Technician is a child element of Step and provides a URI linking to the
 * detailed representation of the technician that ran the Step.
 *
 * @since 2.34
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "technician", propOrder = { "firstName", "lastName" })
public class Technician extends LimsLinkBase<Researcher>
{
    /**
     * Class version for serialisation.
     */
    @Serial
    private static final long serialVersionUID = -3531986232419228456L;

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
     * The URI of the researcher resource representing the technician.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * Default constructor.
     */
    public Technician()
    {
    }

    /**
     * Constructor taking a URI.
     *
     * @param uri The URI of the technician.
     */
    public Technician(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructor taking a linkable researcher.
     *
     * @param technician The linkable researcher representing the technician.
     *
     * @throws NullPointerException if {@code technician} is null.
     */
    public Technician(Linkable<Researcher> technician)
    {
        requireNonNull(technician, "technician cannot be null");
        this.uri = technician.getUri();
    }

    /**
     * Constructor taking a researcher.
     *
     * @param technician The researcher representing the technician.
     *
     * @throws NullPointerException if {@code technician} is null.
     */
    public Technician(Researcher technician)
    {
        requireNonNull(technician, "technician cannot be null");
        this.uri = technician.getUri();
        this.firstName = technician.getFirstName();
        this.lastName = technician.getLastName();
    }

    /**
     * Gets the first name of the technician.
     *
     * @return The first name.
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * Sets the first name of the technician.
     *
     * @param firstName The first name.
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    /**
     * Gets the last name of the technician.
     *
     * @return The last name.
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * Sets the last name of the technician.
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
     * Returns a string representation of this technician.
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
