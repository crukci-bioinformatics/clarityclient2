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

import java.io.Serial;
import java.net.URI;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.genologics.ri.LimsLinkBase;
import com.genologics.ri.Linkable;

/**
 * process-template-link is a child element type of Process Templates and
 * provides a URI linking to the detailed representation of a Process Template.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "process-template-link", propOrder = { "name" })
public class ProcessTemplateLink extends LimsLinkBase<ProcessTemplate>
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = -4745812706787102584L;

    /**
     * The URI of the process template.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * The name of the process template.
     */
    protected String name;

    /**
     * Default constructor.
     */
    public ProcessTemplateLink()
    {
    }

    /**
     * Constructor with URI.
     *
     * @param uri the URI of the process template.
     */
    public ProcessTemplateLink(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructor with URI and name.
     *
     * @param uri the URI of the process template.
     * @param name the name of the process template.
     */
    public ProcessTemplateLink(URI uri, String name)
    {
        this.uri = uri;
        this.name = name;
    }

    /**
     * Constructor from a linkable process template.
     *
     * @param link the linkable process template.
     */
    public ProcessTemplateLink(Linkable<ProcessTemplate> link)
    {
        requireNonNull(link, "link cannot be null");
        this.uri = link.getUri();
    }

    /**
     * Constructor from a ProcessTemplate object.
     *
     * @param template the process template.
     */
    public ProcessTemplateLink(ProcessTemplate template)
    {
        requireNonNull(template, "template cannot be null");
        uri = template.getUri();
        name = template.getName();
    }

    /**
     * Gets the entity class.
     *
     * @return the ProcessTemplate class.
     */
    @Override
    public Class<ProcessTemplate> getEntityClass()
    {
        return ProcessTemplate.class;
    }

    /**
     * Gets the name.
     *
     * @return the name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name the name to set.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Gets the URI.
     *
     * @return the URI.
     */
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI.
     *
     * @param uri the URI to set.
     */
    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Returns a string representation of this process template link.
     *
     * @return The process template URI and name.
     */
    @Override
    public String toString()
    {
        ToStringBuilder b = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
        b.append("processTemplate", uri);
        b.append("name", name);
        return b.toString();
    }
}
