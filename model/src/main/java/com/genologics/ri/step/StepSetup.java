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

import java.io.Serial;
import java.io.Serializable;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.ClarityEntity;
import com.genologics.ri.LimsLink;
import com.genologics.ri.Link;
import com.genologics.ri.Linkable;

/**
 * Represents the setup configuration for a step, including files and configuration settings.
 *
 * @since 2.18
 */
@ClarityEntity(uriSection = "steps", uriSubsection = "setup")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "setup", propOrder = { "step", "configuration", "files" })
@XmlRootElement(name = "setup")
public class StepSetup implements Linkable<StepSetup>, Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 1161115098255552451L;

    /**
     * Link to the step this setup is for.
     */
    @XmlElement
    protected Link step;

    /**
     * The configuration of the step.
     */
    @XmlElement
    protected StepConfiguration configuration;

    /**
     * The list of shared result files for the step.
     */
    @XmlElementWrapper(name = "files")
    @XmlElement(name = "file")
    protected List<SharedResultFile> files;

    /**
     * The URI of this step setup resource.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;


    /**
     * Default constructor.
     */
    public StepSetup()
    {
    }

    /**
     * Constructor taking the URI of the step setup.
     *
     * @param uri The URI of the step setup.
     */
    public StepSetup(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Gets the link to the step.
     *
     * @return The step link.
     */
    public Link getStep()
    {
        return step;
    }

    /**
     * Sets the link to the step.
     *
     * @param step The step link.
     */
    public void setStep(Link step)
    {
        this.step = step;
    }

    /**
     * Gets the step configuration.
     *
     * @return The step configuration.
     */
    public StepConfiguration getConfiguration()
    {
        return configuration;
    }

    /**
     * Sets the step configuration.
     *
     * @param configuration The step configuration.
     */
    public void setConfiguration(StepConfiguration configuration)
    {
        this.configuration = configuration;
    }

    /**
     * Gets the list of shared result files.
     *
     * @return The list of files.
     */
    public List<SharedResultFile> getFiles()
    {
        if (files == null)
        {
            files = new ArrayList<SharedResultFile>();
        }
        return files;
    }

    /**
     * Adds a shared result file to the step.
     *
     * @param file The file to add.
     *
     * @return The added file.
     */
    public SharedResultFile addFile(SharedResultFile file)
    {
        getFiles().add(file);
        return file;
    }

    /**
     * Gets the URI of this step setup resource.
     *
     * @return The URI.
     */
    @Override
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI of this step setup resource.
     *
     * @param uri The URI.
     */
    @Override
    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LimsLink<StepSetup> getLink()
    {
        return new StepSetupLink(this);
    }
}
