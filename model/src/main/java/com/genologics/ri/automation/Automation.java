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
import com.genologics.ri.Linkable;
import com.genologics.ri.Namespaces;
import com.genologics.ri.file.ClarityFile;

/**
 * The automation element integrates the process with the Automation Worker
 * (previously called External Program Plugin or EPP). When a user runs the
 * process, the system automatically issue a command, or submits files and
 * scripts to third-party programs for further processing.
 *
 * @since 2.26
 */
@ClarityEntity(uriSection = "configuration/automations")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "automation",
         propOrder = { "context", "script", "runProgramPerEvent", "channel", "files", "processTypes" })
@XmlRootElement(name = "automation")
public class Automation implements Linkable<Automation>, Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 8888968017373728807L;

    /**
     * The context in which this automation runs.
     */
    @XmlElement
    protected Context context;

    /**
     * The script content for this automation.
     */
    @XmlElement(name = "string")
    protected String script;

    /**
     * Flag indicating whether the program should run per event.
     */
    @XmlElement(name = "run-program-per-event")
    protected Boolean runProgramPerEvent;

    /**
     * The channel for this automation.
     */
    @XmlElement
    protected String channel;

    /**
     * The files associated with this automation.
     */
    @XmlElement(namespace = Namespaces.FILE_NAMESPACE, name = "file")
    protected List<ClarityFile> files;

    /**
     * The process types associated with this automation.
     */
    @XmlElementWrapper(name = "process-types")
    @XmlElement(name = "process-type")
    protected List<ProcessTypeLink> processTypes;

    /**
     * The URI of this automation.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * The name of this automation.
     */
    @XmlAttribute(name = "name")
    protected String name;

    /**
     * Default constructor.
     */
    public Automation()
    {
    }

    /**
     * Gets the context in which this automation runs.
     *
     * @return The automation context.
     */
    public Context getContext()
    {
        return context;
    }

    /**
     * Sets the context in which this automation runs.
     *
     * @param value The automation context.
     */
    public void setContext(Context value)
    {
        this.context = value;
    }

    /**
     * Gets the script content for this automation.
     *
     * @return The script content.
     */
    public String getScript()
    {
        return script;
    }

    /**
     * Sets the script content for this automation.
     *
     * @param script The script content.
     */
    public void setScript(String script)
    {
        this.script = script;
    }

    /**
     * Checks if the program should run per event.
     *
     * @return {@code true} if the program runs per event, {@code false} otherwise.
     */
    public Boolean isRunProgramPerEvent()
    {
        return runProgramPerEvent;
    }

    /**
     * Sets whether the program should run per event.
     *
     * @param value {@code true} if the program should run per event, {@code false} otherwise.
     */
    public void setRunProgramPerEvent(Boolean value)
    {
        this.runProgramPerEvent = value;
    }

    /**
     * Gets the channel for this automation.
     *
     * @return The channel.
     */
    public String getChannel()
    {
        return channel;
    }

    /**
     * Sets the channel for this automation.
     *
     * @param value The channel.
     */
    public void setChannel(String value)
    {
        this.channel = value;
    }

    /**
     * Gets the list of files associated with this automation.
     *
     * @return The list of files.
     */
    public List<ClarityFile> getFiles()
    {
        if (files == null)
        {
            files = new ArrayList<>();
        }
        return files;
    }

    /**
     * Gets the list of process types associated with this automation.
     *
     * @return The list of process type links.
     */
    public List<ProcessTypeLink> getProcessTypes()
    {
        if (processTypes == null)
        {
            processTypes = new ArrayList<>();
        }
        return processTypes;
    }

    /**
     * Gets the URI of this automation.
     *
     * @return The URI.
     */
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI of this automation.
     *
     * @param value The URI.
     */
    public void setUri(URI value)
    {
        this.uri = value;
    }

    /**
     * Gets the name of this automation.
     *
     * @return The automation name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of this automation.
     *
     * @param value The automation name.
     */
    public void setName(String value)
    {
        this.name = value;
    }

    /**
     * Gets a link to this automation.
     *
     * @return A link to this automation.
     */
    @Override
    public LimsLink<Automation> getLink()
    {
        return new AutomationLink(this);
    }
}
