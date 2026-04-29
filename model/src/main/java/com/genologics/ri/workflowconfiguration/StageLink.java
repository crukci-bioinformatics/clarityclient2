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

package com.genologics.ri.workflowconfiguration;

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

import com.genologics.ri.LimsLink;
import com.genologics.ri.LimsLinkBase;
import com.genologics.ri.Linkable;
import com.genologics.ri.stage.Stage;

/**
 *
 * The detailed representation of a Stage (the portion of a workflow to which
 * samples can be associated in order to be queued)
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "stage-link")
public class StageLink extends LimsLinkBase<Stage>
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = -2216914758853864373L;

    /**
     * The URI of the stage.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * The name of the stage.
     */
    @XmlAttribute(name = "name")
    protected String name;

    /**
     * Default constructor.
     */
    public StageLink()
    {
    }

    /**
     * Constructor accepting a URI.
     *
     * @param uri The stage URI.
     */
    public StageLink(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructor accepting a URI and name.
     *
     * @param uri The stage URI.
     * @param name The stage name.
     */
    public StageLink(URI uri, String name)
    {
        this.uri = uri;
        this.name = name;
    }

    /**
     * Constructor accepting a Linkable object.
     *
     * @param link The linkable stage object.
     */
    public StageLink(Linkable<Stage> link)
    {
        requireNonNull(link, "link cannot be null");
        uri = link.getUri();
    }

    /**
     * Constructor accepting a Stage object.
     *
     * @param stage The stage to link to.
     */
    public StageLink(Stage stage)
    {
        requireNonNull(stage, "stage cannot be null");
        uri = stage.getUri();
        name = stage.getName();
    }

    /**
     * Gets the entity class for this link.
     *
     * @return The Stage class.
     */
    @Override
    public Class<Stage> getEntityClass()
    {
        return Stage.class;
    }

    /**
     * Gets the URI of the stage.
     *
     * @return The stage URI.
     */
    @Override
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI of the stage.
     *
     * @param uri The stage URI.
     */
    @Override
    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Gets the name of the stage.
     *
     * @return The stage name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of the stage.
     *
     * @param name The stage name.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Returns a string representation of this stage link.
     *
     * @return The stage URI and name.
     */
    @Override
    public String toString()
    {
        ToStringBuilder b = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
        b.append("stage", LimsLink.toString(this));
        b.append("name", name);
        return b.toString();
    }
}
