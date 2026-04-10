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
import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.Linkable;
import com.genologics.ri.artifact.Artifact;

/**
 *
 * Escalation details.
 *
 * @since 2.18
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "escalation", propOrder = { "request", "review", "escalatedArtifacts" })
public class Escalation implements Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = -7363821101050828859L;

    /**
     * The escalation request.
     */
    @XmlElement
    protected EscalationRequest request;

    /**
     * The escalation review.
     */
    @XmlElement
    protected EscalationReview review;

    /**
     * List of escalated artifacts.
     */
    @XmlElementWrapper(name = "escalated-artifacts")
    @XmlElement(name = "escalated-artifact")
    protected List<EscalatedArtifact> escalatedArtifacts;


    /**
     * Gets the escalation request.
     *
     * @return The escalation request.
     */
    public EscalationRequest getRequest()
    {
        return request;
    }

    /**
     * Sets the escalation request.
     *
     * @param request The escalation request.
     */
    public void setRequest(EscalationRequest request)
    {
        this.request = request;
    }

    /**
     * Gets the escalation review.
     *
     * @return The escalation review.
     */
    public EscalationReview getReview()
    {
        return review;
    }

    /**
     * Sets the escalation review.
     *
     * @param review The escalation review.
     */
    public void setReview(EscalationReview review)
    {
        this.review = review;
    }

    /**
     * Gets the list of escalated artifacts, creating it if it doesn't exist.
     *
     * @return The list of escalated artifacts.
     */
    public List<EscalatedArtifact> getEscalatedArtifacts()
    {
        if (escalatedArtifacts == null)
        {
            escalatedArtifacts = new ArrayList<EscalatedArtifact>();
        }
        return escalatedArtifacts;
    }

    /**
     * Adds an escalated artifact to the list.
     *
     * @param a The escalated artifact to add.
     * @return The added escalated artifact.
     */
    public EscalatedArtifact addEscalatedArtifact(EscalatedArtifact a)
    {
        getEscalatedArtifacts().add(a);
        return a;
    }

    /**
     * Adds an escalated artifact to the list from a linkable artifact.
     *
     * @param link The linkable artifact.
     * @return The added escalated artifact.
     */
    public EscalatedArtifact addEscalatedArtifact(Linkable<Artifact> link)
    {
        EscalatedArtifact a = new EscalatedArtifact(link);
        getEscalatedArtifacts().add(a);
        return a;
    }

}
