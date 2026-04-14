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

import java.io.Serial;
import java.net.URI;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import org.apache.commons.beanutils.PropertyUtils;

import com.genologics.ri.LimsLinkBase;
import com.genologics.ri.Linkable;
import com.genologics.ri.processtype.ProcessType;

/**
 * Provides links to process types the automation is enabled on.
 *
 * @since 2.26
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "process-type")
public class ProcessTypeLink extends LimsLinkBase<ProcessType>
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 1189833674343873526L;

    /**
     * The URI of the process type.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * The name of the process type.
     */
    @XmlAttribute(name = "name")
    protected String name;

    /**
     * Default constructor.
     */
    public ProcessTypeLink()
    {
    }

    /**
     * Constructor with URI.
     *
     * @param uri The process type URI.
     */
    public ProcessTypeLink(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructor with URI and name.
     *
     * @param uri The process type URI.
     * @param name The process type name.
     */
    public ProcessTypeLink(URI uri, String name)
    {
        this.uri = uri;
        this.name = name;
    }

    /**
     * Constructor from a Linkable.
     *
     * @param link The linkable process type.
     */
    public ProcessTypeLink(Linkable<ProcessType> link)
    {
        requireNonNull(link, "link cannot be null");
        this.uri = link.getUri();
    }

    /**
     * Constructor from a ProcessType entity.
     *
     * @param processType The process type entity.
     */
    public ProcessTypeLink(ProcessType processType)
    {
        requireNonNull(processType, "processType cannot be null");
        uri = processType.getUri();
        name = processType.getName();
    }

    /**
     * Gets the URI of the process type.
     *
     * @return The process type URI.
     */
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI of the process type.
     *
     * @param value The process type URI.
     */
    public void setUri(URI value)
    {
        this.uri = value;
    }

    /**
     * Sets the process type from a linkable.
     *
     * @param processType The linkable process type.
     */
    public void setProcessType(Linkable<ProcessType> processType)
    {
        uri = processType == null ? null : processType.getUri();
        name = null;
        try
        {
            name = (String)PropertyUtils.getProperty(processType, "name");
        }
        catch (Exception e)
        {
            // Ignore everything - it's only an attempt.
        }
    }

    /**
     * Gets the name of the process type.
     *
     * @return The process type name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of the process type.
     *
     * @param value The process type name.
     */
    public void setName(String value)
    {
        this.name = value;
    }

    /**
     * Gets the entity class for this link.
     *
     * @return The ProcessType class.
     */
    @Override
    public Class<ProcessType> getEntityClass()
    {
        return ProcessType.class;
    }

    /**
     * Returns a string representation of this link.
     *
     * @return The process type name, or "null" if the name is null.
     */
    @Override
    public String toString()
    {
        return name == null ? "null" : name;
    }
}
