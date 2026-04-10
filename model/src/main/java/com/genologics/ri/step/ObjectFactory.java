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

import static com.genologics.ri.Namespaces.STEP_NAMESPACE;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the com.genologics.ri.step package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 *
 */
@XmlRegistry
public class ObjectFactory
{
    /**
     * QName for the step element.
     */
    private final static QName _Step_QNAME = new QName(STEP_NAMESPACE, "step");

    /**
     * QName for the actions element.
     */
    private final static QName _Actions_QNAME = new QName(STEP_NAMESPACE, "actions");

    /**
     * QName for the reagents element.
     */
    private final static QName _Reagents_QNAME = new QName(STEP_NAMESPACE, "reagents");

    /**
     * QName for the step-creation element.
     */
    private final static QName _StepCreation_QNAME = new QName(STEP_NAMESPACE, "step-creation");

    /**
     * QName for the placements element.
     */
    private final static QName _Placements_QNAME = new QName(STEP_NAMESPACE, "placements");

    /**
     * QName for the setup element.
     */
    private final static QName _Setup_QNAME = new QName(STEP_NAMESPACE, "setup");

    /**
     * QName for the details element.
     */
    private final static QName _Details_QNAME = new QName(STEP_NAMESPACE, "details");

    /**
     * QName for the pools element.
     */
    private final static QName _Pools_QNAME = new QName(STEP_NAMESPACE, "pools");

    /**
     * QName for the lots element.
     */
    private final static QName _Lots_QNAME = new QName(STEP_NAMESPACE, "lots");

    /**
     * QName for the program-status element.
     */
    private final static QName _ProgramStatus_QNAME = new QName(STEP_NAMESPACE, "program-status");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.genologics.ri.step
     *
     */
    public ObjectFactory()
    {
    }

    /**
     * Create an instance of {@link StepConfiguration}.
     *
     * @return A new StepConfiguration instance.
     */
    public StepConfiguration createStepConfiguration()
    {
        return new StepConfiguration();
    }

    /**
     * Create an instance of {@link Placements}.
     *
     * @return A new Placements instance.
     */
    public Placements createPlacements()
    {
        return new Placements();
    }

    /**
     * Create an instance of {@link EscalationReview}.
     *
     * @return A new EscalationReview instance.
     */
    public EscalationReview createEscalationReview()
    {
        return new EscalationReview();
    }

    /**
     * Create an instance of {@link Escalation}.
     *
     * @return A new Escalation instance.
     */
    public Escalation createEscalation()
    {
        return new Escalation();
    }

    /**
     * Create an instance of {@link Actions}.
     *
     * @return A new Actions instance.
     */
    public Actions createActions()
    {
        return new Actions();
    }

    /**
     * Create an instance of {@link NextAction}.
     *
     * @return A new NextAction instance.
     */
    public NextAction createNextAction()
    {
        return new NextAction();
    }

    /**
     * Create an instance of {@link AutomaticNextStepLink}.
     *
     * @return A new AutomaticNextStepLink instance.
     */
    public AutomaticNextStepLink createAutomaticNextStepLink()
    {
        return new AutomaticNextStepLink();
    }

    /**
     * Create an instance of {@link Input}.
     *
     * @return A new Input instance.
     */
    public Input createInput()
    {
        return new Input();
    }

    /**
     * Create an instance of {@link ProgramStatus}.
     *
     * @return A new ProgramStatus instance.
     */
    public ProgramStatus createProgramStatus()
    {
        return new ProgramStatus();
    }

    /**
     * Create an instance of {@link StepDetails}.
     *
     * @return A new StepDetails instance.
     */
    public StepDetails createDetails()
    {
        return new StepDetails();
    }

    /**
     * Create an instance of {@link ReagentsLink}.
     *
     * @return A new ReagentsLink instance.
     */
    public ReagentsLink createReagentsLink()
    {
        return new ReagentsLink();
    }

    /**
     * Create an instance of {@link ActionsLink}.
     *
     * @return A new ActionsLink instance.
     */
    public ActionsLink createActionsLink()
    {
        return new ActionsLink();
    }

    /**
     * Create an instance of {@link OutputPlacement}.
     *
     * @return A new OutputPlacement instance.
     */
    public OutputPlacement createOutputPlacement()
    {
        return new OutputPlacement();
    }

    /**
     * Create an instance of {@link StepCreation}.
     *
     * @return A new StepCreation instance.
     */
    public StepCreation createStepCreation()
    {
        return new StepCreation();
    }

    /**
     * Create an instance of {@link ContainerLink}.
     *
     * @return A new ContainerLink instance.
     */
    public ContainerLink createContainer()
    {
        return new ContainerLink();
    }

    /**
     * Create an instance of {@link StepSetup}.
     *
     * @return A new StepSetup instance.
     */
    public StepSetup createSetup()
    {
        return new StepSetup();
    }

    /**
     * Create an instance of {@link ReagentLots}.
     *
     * @return A new ReagentLots instance.
     */
    public ReagentLots createReagentsLots()
    {
        return new ReagentLots();
    }

    /**
     * Create an instance of {@link InstrumentLink}.
     *
     * @return A new InstrumentLink instance.
     */
    public InstrumentLink createInstrument()
    {
        return new InstrumentLink();
    }

    /**
     * Create an instance of {@link PlacementsLink}.
     *
     * @return A new PlacementsLink instance.
     */
    public PlacementsLink createPlacementsLink()
    {
        return new PlacementsLink();
    }

    /**
     * Create an instance of {@link ArtifactLink}.
     *
     * @return A new ArtifactLink instance.
     */
    public ArtifactLink createArtifact()
    {
        return new ArtifactLink();
    }

    /**
     * Create an instance of {@link ReagentLotsLink}.
     *
     * @return A new ReagentLotsLink instance.
     */
    public ReagentLotsLink createReagentLotsLink()
    {
        return new ReagentLotsLink();
    }

    /**
     * Create an instance of {@link UserLink}.
     *
     * @return A new UserLink instance.
     */
    public UserLink createUser()
    {
        return new UserLink();
    }

    /**
     * Create an instance of {@link Output}.
     *
     * @return A new Output instance.
     */
    public Output createOutput()
    {
        return new Output();
    }

    /**
     * Create an instance of {@link InputOutputMap}.
     *
     * @return A new InputOutputMap instance.
     */
    public InputOutputMap createInputOutputMap()
    {
        return new InputOutputMap();
    }

    /**
     * Create an instance of {@link EscalatedArtifact}.
     *
     * @return A new EscalatedArtifact instance.
     */
    public EscalatedArtifact createEscalatedArtifact()
    {
        return new EscalatedArtifact();
    }

    /**
     * Create an instance of {@link ReagentLotLink}.
     *
     * @return A new ReagentLotLink instance.
     */
    public ReagentLotLink createReagentLotLink()
    {
        return new ReagentLotLink();
    }

    /**
     * Create an instance of {@link ReagentLabel}.
     *
     * @return A new ReagentLabel instance.
     */
    public ReagentLabel createReagentLabel()
    {
        return new ReagentLabel();
    }

    /**
     * Create an instance of {@link AvailableProgram}.
     *
     * @return A new AvailableProgram instance.
     */
    public AvailableProgram createAvailableProgram()
    {
        return new AvailableProgram();
    }

    /**
     * Create an instance of {@link PooledInputs}.
     *
     * @return A new PooledInputs instance.
     */
    public com.genologics.ri.step.PooledInputs createPooledInputs()
    {
        return new com.genologics.ri.step.PooledInputs();
    }

    /**
     * Create an instance of {@link StepSetupLink}.
     *
     * @return A new StepSetupLink instance.
     */
    public StepSetupLink createSetupLink()
    {
        return new StepSetupLink();
    }

    /**
     * Create an instance of {@link ProcessStep}.
     *
     * @return A new ProcessStep instance.
     */
    public ProcessStep createStep()
    {
        return new ProcessStep();
    }

    /**
     * Create an instance of {@link Reagents}.
     *
     * @return A new Reagents instance.
     */
    public Reagents createReagents()
    {
        return new Reagents();
    }

    /**
     * Create an instance of {@link Pools}.
     *
     * @return A new Pools instance.
     */
    public Pools createPools()
    {
        return new Pools();
    }

    /**
     * Create an instance of {@link CreationInput}.
     *
     * @return A new CreationInput instance.
     */
    public CreationInput createCreationInput()
    {
        return new CreationInput();
    }

    /**
     * Create an instance of {@link ProgramStatusLink}.
     *
     * @return A new ProgramStatusLink instance.
     */
    public ProgramStatusLink createProgramStatusLink()
    {
        return new ProgramStatusLink();
    }

    /**
     * Create an instance of {@link StepDetailsLink}.
     *
     * @return A new StepDetailsLink instance.
     */
    public StepDetailsLink createDetailsLink()
    {
        return new StepDetailsLink();
    }

    /**
     * Create an instance of {@link PoolsLink}.
     *
     * @return A new PoolsLink instance.
     */
    public PoolsLink createPoolsLink()
    {
        return new PoolsLink();
    }

    /**
     * Create an instance of {@link EscalationRequest}.
     *
     * @return A new EscalationRequest instance.
     */
    public EscalationRequest createEscalationRequest()
    {
        return new EscalationRequest();
    }

    /**
     * Create an instance of {@link SharedResultFile}.
     *
     * @return A new SharedResultFile instance.
     */
    public SharedResultFile createFile()
    {
        return new SharedResultFile();
    }

    /**
     * Create an instance of {@link JAXBElement}&lt;{@link ProcessStep}&gt;.
     *
     * @param value The ProcessStep value.
     * @return A JAXBElement wrapping the ProcessStep.
     */
    @XmlElementDecl(namespace = STEP_NAMESPACE, name = "step")
    public JAXBElement<ProcessStep> createStep(ProcessStep value)
    {
        return new JAXBElement<ProcessStep>(_Step_QNAME, ProcessStep.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement}&lt;{@link Actions}&gt;.
     *
     * @param value The Actions value.
     * @return A JAXBElement wrapping the Actions.
     */
    @XmlElementDecl(namespace = STEP_NAMESPACE, name = "actions")
    public JAXBElement<Actions> createActions(Actions value)
    {
        return new JAXBElement<Actions>(_Actions_QNAME, Actions.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement}&lt;{@link Reagents}&gt;.
     *
     * @param value The Reagents value.
     * @return A JAXBElement wrapping the Reagents.
     */
    @XmlElementDecl(namespace = STEP_NAMESPACE, name = "reagents")
    public JAXBElement<Reagents> createReagents(Reagents value)
    {
        return new JAXBElement<Reagents>(_Reagents_QNAME, Reagents.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement}&lt;{@link StepCreation}&gt;.
     *
     * @param value The StepCreation value.
     * @return A JAXBElement wrapping the StepCreation.
     */
    @XmlElementDecl(namespace = STEP_NAMESPACE, name = "step-creation")
    public JAXBElement<StepCreation> createStepCreation(StepCreation value)
    {
        return new JAXBElement<StepCreation>(_StepCreation_QNAME, StepCreation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement}&lt;{@link Placements}&gt;.
     *
     * @param value The Placements value.
     * @return A JAXBElement wrapping the Placements.
     */
    @XmlElementDecl(namespace = STEP_NAMESPACE, name = "placements")
    public JAXBElement<Placements> createPlacements(Placements value)
    {
        return new JAXBElement<Placements>(_Placements_QNAME, Placements.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement}&lt;{@link StepSetup}&gt;.
     *
     * @param value The StepSetup value.
     * @return A JAXBElement wrapping the StepSetup.
     */
    @XmlElementDecl(namespace = STEP_NAMESPACE, name = "setup")
    public JAXBElement<StepSetup> createSetup(StepSetup value)
    {
        return new JAXBElement<StepSetup>(_Setup_QNAME, StepSetup.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement}&lt;{@link StepDetails}&gt;.
     *
     * @param value The StepDetails value.
     * @return A JAXBElement wrapping the StepDetails.
     */
    @XmlElementDecl(namespace = STEP_NAMESPACE, name = "details")
    public JAXBElement<StepDetails> createDetails(StepDetails value)
    {
        return new JAXBElement<StepDetails>(_Details_QNAME, StepDetails.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement}&lt;{@link Pools}&gt;.
     *
     * @param value The Pools value.
     * @return A JAXBElement wrapping the Pools.
     */
    @XmlElementDecl(namespace = STEP_NAMESPACE, name = "pools")
    public JAXBElement<Pools> createPools(Pools value)
    {
        return new JAXBElement<Pools>(_Pools_QNAME, Pools.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement}&lt;{@link ReagentLots}&gt;.
     *
     * @param value The ReagentLots value.
     * @return A JAXBElement wrapping the ReagentLots.
     */
    @XmlElementDecl(namespace = STEP_NAMESPACE, name = "lots")
    public JAXBElement<ReagentLots> createLots(ReagentLots value)
    {
        return new JAXBElement<ReagentLots>(_Lots_QNAME, ReagentLots.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement}&lt;{@link ProgramStatus}&gt;.
     *
     * @param value The ProgramStatus value.
     * @return A JAXBElement wrapping the ProgramStatus.
     */
    @XmlElementDecl(namespace = STEP_NAMESPACE, name = "program-status")
    public JAXBElement<ProgramStatus> createProgramStatus(ProgramStatus value)
    {
        return new JAXBElement<ProgramStatus>(_ProgramStatus_QNAME, ProgramStatus.class, null, value);
    }
}
