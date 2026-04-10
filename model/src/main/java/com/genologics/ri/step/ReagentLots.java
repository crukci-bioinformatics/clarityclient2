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
import com.genologics.ri.LimsEntityLinkable;
import com.genologics.ri.LimsLink;
import com.genologics.ri.Link;
import com.genologics.ri.Linkable;
import com.genologics.ri.reagentlot.ReagentLot;

/**
 * The list representation of a step's reagent lots.
 *
 * @since 2.18
 */
@ClarityEntity(uriSection = "steps", uriSubsection = "reagentlots", updateable = true)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reagents-lots", propOrder = { "step", "configuration", "reagentLots" })
@XmlRootElement(name = "lots")
public class ReagentLots implements Linkable<ReagentLots>, Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 27145430586603574L;

    /**
     * Provides a URI linking to the step resource.
     */
    @XmlElement
    protected Link step;

    /**
     * Provides a URI linking to the configuration resource that identifies the
     * protocol step.
     */
    @XmlElement
    protected StepConfiguration configuration;

    /**
     * The list of reagent lots associated with the step.
     */
    @XmlElementWrapper(name = "reagent-lots")
    @XmlElement(name = "reagent-lot")
    protected List<ReagentLotLink> reagentLots;

    /**
     * The URI of the reagent lots resource.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;


    /**
     * Gets the step link.
     *
     * @return The step link.
     */
    public Link getStep()
    {
        return step;
    }

    /**
     * Sets the step link.
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
     * Gets the list of reagent lot links.
     *
     * @return The list of reagent lot links, never null.
     */
    public List<ReagentLotLink> getReagentLots()
    {
        if (reagentLots == null)
        {
            reagentLots = new ArrayList<ReagentLotLink>();
        }
        return reagentLots;
    }

    /**
     * Adds a reagent lot link to the list.
     *
     * @param link The reagent lot link to add.
     *
     * @return The reagent lot link that was added.
     */
    public ReagentLotLink addReagentLot(ReagentLotLink link)
    {
        getReagentLots().add(link);
        return link;
    }

    /**
     * Adds a reagent lot to the list by creating a link from the linkable object.
     *
     * @param lot The reagent lot linkable object.
     *
     * @return The reagent lot link that was created and added.
     */
    public ReagentLotLink addReagentLot(LimsEntityLinkable<ReagentLot> lot)
    {
        ReagentLotLink link = new ReagentLotLink(lot);
        getReagentLots().add(link);
        return link;
    }

    /**
     * Gets the URI of this reagent lots resource.
     *
     * @return The URI.
     */
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI of this reagent lots resource.
     *
     * @param uri The URI.
     */
    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LimsLink<ReagentLots> getLink()
    {
        return new ReagentLotsLink(this);
    }
}
