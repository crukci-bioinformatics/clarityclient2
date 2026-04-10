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
import java.util.Date;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.genologics.ri.ClarityEntity;
import com.genologics.ri.LimsEntity;
import com.genologics.ri.LimsEntityLink;
import com.genologics.ri.Linkable;
import com.genologics.ri.jaxb.LongTimestampAdapter;
import com.genologics.ri.researcher.Researcher;

/**
 *
 * The detailed representation of a step.
 * <p>
 * Since API version 2.27, the step can be deleted to cancel a process.
 * Requires the current status of step to be "in progress".
 * </p>
 */
@ClarityEntity(uriSection = "steps", removable = true)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "step",
         propOrder = { "dateStarted", "dateCompleted",
                       "configuration", "actions", "reagents", "pools", "placements", "reagentLots",
                       "programStatus", "setup", "arrangements", "details", "availablePrograms",
                       "automaticNextStep", "technician" })
@XmlRootElement(name = "step")
public class ProcessStep implements LimsEntity<ProcessStep>, Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial
    private static final long serialVersionUID = 8157777981636538216L;

    /**
     * The date and time the step was started.
     *
     * @since 2.22
     */
    @XmlElement(name = "date-started")
    @XmlSchemaType(name = "dateTime")
    @XmlJavaTypeAdapter(LongTimestampAdapter.class)
    protected Date dateStarted;

    /**
     * The date and time the step was completed.
     *
     * @since 2.22
     */
    @XmlElement(name = "date-completed")
    @XmlSchemaType(name = "dateTime")
    @XmlJavaTypeAdapter(LongTimestampAdapter.class)
    protected Date dateCompleted;

    /**
     * The configuration of the step.
     */
    @XmlElement(name = "configuration")
    protected StepConfiguration configuration;

    /**
     * Link to the actions associated with this step.
     */
    @XmlElement(name = "actions")
    protected ActionsLink actions;

    /**
     * Link to the reagents associated with this step.
     */
    @XmlElement(name = "reagents")
    protected ReagentsLink reagents;

    /**
     * Link to the pools associated with this step.
     */
    @XmlElement(name = "pools")
    protected PoolsLink pools;

    /**
     * Link to the placements associated with this step.
     */
    @XmlElement(name = "placements")
    protected PlacementsLink placements;

    /**
     * Link to the reagent lots associated with this step.
     *
     * @since 2.18
     */
    @XmlElement(name = "reagent-lots")
    protected ReagentLotsLink reagentLots;

    /**
     * Link to the program status associated with this step.
     */
    @XmlElement(name = "program-status")
    protected ProgramStatusLink programStatus;

    /**
     * Link to the setup associated with this step.
     *
     * @since 2.18
     */
    @XmlElement(name = "setup")
    protected StepSetupLink setup;

    /**
     * Link to the arrangements associated with this step.
     *
     * @since 2.34
     */
    @XmlElement(name = "arrangements")
    protected ArrangementsLink arrangements;

    /**
     * Link to the details associated with this step.
     *
     * @since 2.18
     */
    @XmlElement(name = "details")
    protected StepDetailsLink details;

    /**
     * The list of programs available for this step.
     *
     * @since 2.18
     */
    @XmlElementWrapper(name = "available-programs")
    @XmlElement(name = "available-program")
    protected List<AvailableProgram> availablePrograms;

    /**
     * Link to the next step that will be automatically triggered after this step.
     *
     * @since 2.22
     */
    @XmlElement(name = "automatic-next-step")
    protected AutomaticNextStepLink automaticNextStep;

    /**
     * The technician assigned to this step.
     *
     * @since 2.34
     */
    protected Technician technician;

    /**
     * The URI of the step.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * The LIMS id of the step.
     */
    @XmlAttribute(name = "limsid")
    protected String limsid;

    /**
     * The current state of the step.
     * Now an enumeration since release 2.31.3 of the client.
     *
     * @since 2.18
     */
    @XmlAttribute(name = "current-state")
    protected ProcessState currentState;


    /**
     * Constructs a new empty ProcessStep.
     */
    public ProcessStep()
    {
    }

    /**
     * Constructs a new ProcessStep with the given URI.
     *
     * @param uri the URI of the step.
     */
    public ProcessStep(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Constructs a new ProcessStep with the given URI and LIMS id.
     *
     * @param uri the URI of the step.
     * @param limsid the LIMS id of the step.
     */
    public ProcessStep(URI uri, String limsid)
    {
        this.uri = uri;
        this.limsid = limsid;
    }

    /**
     * Gets the date and time the step was started.
     *
     * @return the start date.
     */
    public Date getDateStarted()
    {
        return dateStarted;
    }

    /**
     * Sets the date and time the step was started.
     *
     * @param dateStarted the start date.
     */
    public void setDateStarted(Date dateStarted)
    {
        this.dateStarted = dateStarted;
    }

    /**
     * Gets the date and time the step was completed.
     *
     * @return the completion date.
     */
    public Date getDateCompleted()
    {
        return dateCompleted;
    }

    /**
     * Sets the date and time the step was completed.
     *
     * @param dateCompleted the completion date.
     */
    public void setDateCompleted(Date dateCompleted)
    {
        this.dateCompleted = dateCompleted;
    }

    /**
     * Gets the configuration of the step.
     *
     * @return the step configuration.
     */
    public StepConfiguration getConfiguration()
    {
        return configuration;
    }

    /**
     * Sets the configuration of the step.
     *
     * @param configuration the step configuration.
     */
    public void setConfiguration(StepConfiguration configuration)
    {
        this.configuration = configuration;
    }

    /**
     * Gets the link to the actions associated with this step.
     *
     * @return the actions link.
     */
    public ActionsLink getActions()
    {
        return actions;
    }

    /**
     * Sets the link to the actions associated with this step.
     *
     * @param actions the actions link.
     */
    public void setActions(ActionsLink actions)
    {
        this.actions = actions;
    }

    /**
     * Gets the link to the reagents associated with this step.
     *
     * @return the reagents link.
     */
    public ReagentsLink getReagents()
    {
        return reagents;
    }

    /**
     * Sets the link to the reagents associated with this step.
     *
     * @param reagents the linkable reagents.
     */
    public void setReagents(Linkable<Reagents> reagents)
    {
        this.reagents = new ReagentsLink(reagents);
    }

    /**
     * Gets the link to the pools associated with this step.
     *
     * @return the pools link.
     */
    public PoolsLink getPools()
    {
        return pools;
    }

    /**
     * Sets the link to the pools associated with this step.
     *
     * @param pools the linkable pools.
     */
    public void setPools(Linkable<Pools> pools)
    {
        this.pools = new PoolsLink(pools);
    }

    /**
     * Gets the link to the placements associated with this step.
     *
     * @return the placements link.
     */
    public PlacementsLink getPlacements()
    {
        return placements;
    }

    /**
     * Sets the link to the placements associated with this step.
     *
     * @param placements the linkable placements.
     */
    public void setPlacements(Linkable<Placements> placements)
    {
        this.placements = new PlacementsLink(placements);
    }

    /**
     * Gets the link to the program status associated with this step.
     *
     * @return the program status link.
     */
    public ProgramStatusLink getProgramStatus()
    {
        return programStatus;
    }

    /**
     * Sets the link to the program status associated with this step.
     *
     * @param programStatus the linkable program status.
     */
    public void setProgramStatus(Linkable<ProgramStatus> programStatus)
    {
        this.programStatus = new ProgramStatusLink(programStatus);
    }

    /**
     * Gets the URI of the step.
     *
     * @return the URI.
     */
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI of the step.
     *
     * @param uri the URI.
     */
    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Gets the LIMS id of the step.
     *
     * @return the LIMS id.
     */
    public String getLimsid()
    {
        return limsid;
    }

    /**
     * Sets the LIMS id of the step.
     *
     * @param limsid the LIMS id.
     */
    public void setLimsid(String limsid)
    {
        this.limsid = limsid;
    }

    /**
     * Gets the link to the reagent lots associated with this step.
     *
     * @return the reagent lots link.
     */
    public ReagentLotsLink getReagentLots()
    {
        return reagentLots;
    }

    /**
     * Sets the link to the reagent lots associated with this step.
     *
     * @param link the linkable reagent lots.
     */
    public void setReagentLots(Linkable<ReagentLots> link)
    {
        this.reagentLots = new ReagentLotsLink(link);
    }

    /**
     * Gets the link to the setup associated with this step.
     *
     * @return the setup link.
     */
    public StepSetupLink getSetup()
    {
        return setup;
    }

    /**
     * Sets the link to the setup associated with this step.
     *
     * @param link the linkable setup.
     */
    public void setSetup(Linkable<StepSetup> link)
    {
        this.setup = new StepSetupLink(link);
    }

    /**
     * Gets the link to the details associated with this step.
     *
     * @return the details link.
     */
    public StepDetailsLink getStepDetails()
    {
        return details;
    }

    /**
     * Sets the link to the details associated with this step.
     *
     * @param link the linkable details.
     */
    public void setDetails(Linkable<StepDetails> link)
    {
        this.details = new StepDetailsLink(uri);
    }

    /**
     * Gets the link to the arrangements associated with this step.
     *
     * @return the arrangements link.
     */
    public ArrangementsLink getArrangements()
    {
        return arrangements;
    }

    /**
     * Sets the link to the arrangements associated with this step.
     *
     * @param arrangements the linkable arrangements.
     */
    public void setArrangements(Linkable<Arrangements> arrangements)
    {
        this.arrangements = new ArrangementsLink(arrangements);
    }

    /**
     * Gets the list of programs available for this step.
     * The list will be created if it does not already exist.
     *
     * @return the list of available programs.
     */
    public List<AvailableProgram> getAvailablePrograms()
    {
        if (availablePrograms == null)
        {
            availablePrograms = new ArrayList<AvailableProgram>();
        }
        return availablePrograms;
    }

    /**
     * Adds an available program to the list of programs for this step.
     *
     * @param ap the available program to add.
     *
     * @return the added available program.
     */
    public AvailableProgram addAvailableProgram(AvailableProgram ap)
    {
        getAvailablePrograms().add(ap);
        return ap;
    }

    /**
     * Gets the current state of the step.
     *
     * @return the current state.
     */
    public ProcessState getCurrentState()
    {
        return currentState;
    }

    /**
     * Sets the current state of the step.
     *
     * @param currentState the current state.
     */
    public void setCurrentState(ProcessState currentState)
    {
        this.currentState = currentState;
    }

    /**
     * Gets the link to the next step that will be automatically triggered after this step.
     *
     * @return the automatic next step link.
     */
    public AutomaticNextStepLink getAutomaticNextStep()
    {
        return automaticNextStep;
    }

    /**
     * Sets the link to the next step that will be automatically triggered after this step.
     *
     * @param step the linkable next step.
     */
    public void setAutomaticNextStep(Linkable<ProcessStep> step)
    {
        this.automaticNextStep = new AutomaticNextStepLink(step);
    }

    /**
     * Gets the technician assigned to this step.
     *
     * @return the technician.
     */
    public Technician getTechnician()
    {
        return technician;
    }

    /**
     * Sets the technician assigned to this step from a linkable researcher.
     *
     * @param technician the linkable researcher.
     */
    public void setTechnician(Linkable<Researcher> technician)
    {
        this.technician = new Technician(technician);
    }

    /**
     * Sets the technician assigned to this step from a researcher.
     *
     * @param technician the researcher.
     */
    public void setTechnician(Researcher technician)
    {
        this.technician = new Technician(technician);
    }

    /**
     * Sets the technician assigned to this step.
     *
     * @param technician the technician.
     */
    public void setTechnician(Technician technician)
    {
        this.technician = technician;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LimsEntityLink<ProcessStep> getLink()
    {
        return new ProcessStepLink();
    }

    /**
     * There is no implementation of {@code LimsEntityLink} in the model for {@code ProcessStep}.
     * As such, this inner class will do the job of delegating to
     * the fields in this ProcessStep.
     */
    private class ProcessStepLink implements LimsEntityLink<ProcessStep>, Serializable
    {
        /**
         * Class version for serialisation.
         */
        @Serial
        private static final long serialVersionUID = -7807865307254531322L;

        /**
         * {@inheritDoc}
         */
        @Override
        public URI getUri()
        {
            return uri;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String getLimsid()
        {
            return limsid;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Class<ProcessStep> getEntityClass()
        {
            return ProcessStep.class;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void setLimsid(String id)
        {
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void setUri(URI uri)
        {
        }
    }
}
