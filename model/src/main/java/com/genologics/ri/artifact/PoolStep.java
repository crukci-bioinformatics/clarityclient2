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

package com.genologics.ri.artifact;

import static java.util.Objects.requireNonNull;

import java.io.Serializable;
import java.net.URI;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.LimsLink;
import com.genologics.ri.Linkable;
import com.genologics.ri.step.ProcessStep;

/**
 * The details of the pooling step that created the pooled sample(s).
 *
 * @since 2.26
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pool-step")
public class PoolStep implements LimsLink<ProcessStep>, Serializable
{
    private static final long serialVersionUID = 2462830072429085619L;

    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    @XmlAttribute(name = "name")
    protected String name;

    public PoolStep()
    {
    }

    public PoolStep(URI uri)
    {
        this.uri = uri;
    }

    public PoolStep(URI uri, String name)
    {
        this.uri = uri;
        this.name = name;
    }

    public PoolStep(Linkable<ProcessStep> step)
    {
        requireNonNull(step, "step cannot be null");
        this.uri = step.getUri();
    }

    public URI getUri()
    {
        return uri;
    }

    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public Class<ProcessStep> getEntityClass()
    {
        return ProcessStep.class;
    }

    @Override
    public String toString()
    {
        return name == null ? "null" : name;
    }
}
