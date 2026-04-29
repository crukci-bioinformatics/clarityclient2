/*
 * CRUK-CI Clarity REST API Java Client.
 * Copyright (C) 2018 Cancer Research UK Cambridge Institute.
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

package com.genologics.ri.automation;

import static java.util.Objects.requireNonNull;
import static org.apache.commons.lang3.StringUtils.SPACE;

import java.io.Serial;
import java.net.URI;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.genologics.ri.LimsLink;
import com.genologics.ri.LimsLinkBase;
import com.genologics.ri.Linkable;

/**
 * A link to an Automation entity.
 *
 * @since 2.26
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "automation-link")
public class AutomationLink extends LimsLinkBase<Automation>
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 3268594731404978793L;

    /**
     * The URI of the automation.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * The name of the automation.
     */
    @XmlAttribute(name = "name")
    protected String name;

    /**
     * Default constructor.
     */
    public AutomationLink()
    {
    }

    /**
     * Constructor with URI.
     *
     * @param uri The automation URI.
     */
    public AutomationLink(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructor with URI and name.
     *
     * @param uri The automation URI.
     * @param name The automation name.
     */
    public AutomationLink(URI uri, String name)
    {
        this.uri = uri;
        this.name = name;
    }

    /**
     * Constructor from a Linkable.
     *
     * @param link The linkable automation.
     */
    public AutomationLink(Linkable<Automation> link)
    {
        requireNonNull(link, "link cannot be null");
        uri = link.getUri();
    }

    /**
     * Constructor from an Automation entity.
     *
     * @param automation The automation entity.
     */
    public AutomationLink(Automation automation)
    {
        requireNonNull(automation, "automation cannot be null");
        uri = automation.getUri();
        name = automation.getName();
    }

    /**
     * Gets the URI of the automation.
     *
     * @return The automation URI.
     */
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI of the automation.
     *
     * @param uri The automation URI.
     */
    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Gets the name of the automation.
     *
     * @return The automation name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of the automation.
     *
     * @param name The automation name.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Gets the entity class for this link.
     *
     * @return The Automation class.
     */
    @Override
    public Class<Automation> getEntityClass()
    {
        return Automation.class;
    }

    /**
     * Returns a string representation of this link.
     *
     * @return The automation LIMS id and the automation name.
     */
    @Override
    public String toString()
    {
        ToStringBuilder b = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
        b.append("automation", LimsLink.toString(this));
        b.append("name", name);
        return b.toString();
    }
}
