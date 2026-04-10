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

package com.genologics.ri.artifact;

import static com.genologics.ri.Namespaces.ARTIFACT_NAMESPACE;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * Factory class for creating instances of JAXB content classes defined in the
 * {@code com.genologics.ri.artifact} package.
 * <p>
 * This class is required by JAXB (Java Architecture for XML Binding) and provides
 * factory methods for instantiating JAXB-managed classes and elements within this
 * package. Each factory method constructs new instances of schema-derived classes
 * that represent XML content structures.
 * </p>
 * <p>
 * The {@code @XmlRegistry} annotation marks this class as a JAXB object factory,
 * allowing JAXB to discover and use these factory methods during marshalling and
 * unmarshalling operations.
 * </p>
 */
@XmlRegistry
public class ObjectFactory
{

    /**
     * The qualified name for artifacts element.
     */
    private final static QName _Artifacts_QNAME = new QName(ARTIFACT_NAMESPACE, "artifacts");

    /**
     * The qualified name for details element.
     */
    private final static QName _Details_QNAME = new QName(ARTIFACT_NAMESPACE, "details");

    /**
     * The qualified name for artifact element.
     */
    private final static QName _Artifact_QNAME = new QName(ARTIFACT_NAMESPACE, "artifact");

    /**
     * The qualified name for demux element.
     */
    private final static QName _Demux_QNAME = new QName(ARTIFACT_NAMESPACE, "demux");

    /**
     * The qualified name for demux-details element.
     */
    private final static QName _DemuxDetails_QNAME = new QName(ARTIFACT_NAMESPACE, "demux-details");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.genologics.ri.artifact
     *
     */
    public ObjectFactory() {
    }

    /**
     * Creates a new DemuxDetails instance.
     *
     * @return A new DemuxDetails object.
     */
    public DemuxDetails createDemuxDetails() {
        return new DemuxDetails();
    }

    /**
     * Creates a new PoolStep instance.
     *
     * @return A new PoolStep object.
     */
    public PoolStep createPoolStep() {
        return new PoolStep();
    }

    /**
     * Creates a new ArtifactGroupLink instance.
     *
     * @return A new ArtifactGroupLink object.
     */
    public ArtifactGroupLink createArtifactgroup() {
        return new ArtifactGroupLink();
    }

    /**
     * Creates a new SampleLink instance.
     *
     * @return A new SampleLink object.
     */
    public SampleLink createSample() {
        return new SampleLink();
    }

    /**
     * Creates a new Demux instance.
     *
     * @return A new Demux object.
     */
    public Demux createDemux() {
        return new Demux();
    }

    /**
     * Creates a new ReagentLabel instance.
     *
     * @return A new ReagentLabel object.
     */
    public ReagentLabel createReagentLabel() {
        return new ReagentLabel();
    }

    /**
     * Creates a new DemuxSourceArtifact instance.
     *
     * @return A new DemuxSourceArtifact object.
     */
    public DemuxSourceArtifact createDemuxSourceArtifact() {
        return new DemuxSourceArtifact();
    }

    /**
     * Creates a new DemuxLink instance.
     *
     * @return A new DemuxLink object.
     */
    public DemuxLink createDemuxLink() {
        return new DemuxLink();
    }

    /**
     * Creates a new DemuxArtifactSample instance.
     *
     * @return A new DemuxArtifactSample object.
     */
    public DemuxArtifactSample createDemuxArtifactSample() {
        return new DemuxArtifactSample();
    }

    /**
     * Creates a new DemuxArtifact instance.
     *
     * @return A new DemuxArtifact object.
     */
    public DemuxArtifact createDemuxArtifact() {
        return new DemuxArtifact();
    }

    /**
     * Creates a new ParentProcessLink instance.
     *
     * @return A new ParentProcessLink object.
     */
    public ParentProcessLink createParentProcess() {
        return new ParentProcessLink();
    }

    /**
     * Creates a new Artifact instance.
     *
     * @return A new Artifact object.
     */
    public Artifact createArtifact() {
        return new Artifact();
    }

    /**
     * Creates a new ArtifactLink instance.
     *
     * @return A new ArtifactLink object.
     */
    public ArtifactLink createArtifactLink() {
        return new ArtifactLink();
    }

    /**
     * Creates a new ControlTypeLink instance.
     *
     * @return A new ControlTypeLink object.
     */
    public ControlTypeLink createControlTypeLink() {
        return new ControlTypeLink();
    }

    /**
     * Creates a new ArtifactBatchFetchResult instance.
     *
     * @return A new ArtifactBatchFetchResult object.
     */
    public ArtifactBatchFetchResult createDetails() {
        return new ArtifactBatchFetchResult();
    }

    /**
     * Creates a new Artifacts instance.
     *
     * @return A new Artifacts object.
     */
    public Artifacts createArtifacts() {
        return new Artifacts();
    }

    /**
     * Creates a JAXBElement for Artifacts.
     *
     * @param value The Artifacts object to wrap.
     * @return A JAXBElement wrapping the Artifacts object.
     */
    @XmlElementDecl(namespace = ARTIFACT_NAMESPACE, name = "artifacts")
    public JAXBElement<Artifacts> createArtifacts(Artifacts value) {
        return new JAXBElement<Artifacts>(_Artifacts_QNAME, Artifacts.class, null, value);
    }

    /**
     * Creates a JAXBElement for ArtifactBatchFetchResult.
     *
     * @param value The ArtifactBatchFetchResult object to wrap.
     * @return A JAXBElement wrapping the ArtifactBatchFetchResult object.
     */
    @XmlElementDecl(namespace = ARTIFACT_NAMESPACE, name = "details")
    public JAXBElement<ArtifactBatchFetchResult> createDetails(ArtifactBatchFetchResult value) {
        return new JAXBElement<ArtifactBatchFetchResult>(_Details_QNAME, ArtifactBatchFetchResult.class, null, value);
    }

    /**
     * Creates a JAXBElement for Artifact.
     *
     * @param value The Artifact object to wrap.
     * @return A JAXBElement wrapping the Artifact object.
     */
    @XmlElementDecl(namespace = ARTIFACT_NAMESPACE, name = "artifact")
    public JAXBElement<Artifact> createArtifact(Artifact value) {
        return new JAXBElement<Artifact>(_Artifact_QNAME, Artifact.class, null, value);
    }

    /**
     * Creates a JAXBElement for DemuxDetails.
     *
     * @param value The DemuxDetails object to wrap.
     * @return A JAXBElement wrapping the DemuxDetails object.
     */
    @XmlElementDecl(namespace = ARTIFACT_NAMESPACE, name = "demux-details")
    public JAXBElement<DemuxDetails> createDemuxDetails(DemuxDetails value) {
        return new JAXBElement<DemuxDetails>(_DemuxDetails_QNAME, DemuxDetails.class, null, value);
    }

    /**
     * Creates a JAXBElement for Demux.
     *
     * @param value The Demux object to wrap.
     * @return A JAXBElement wrapping the Demux object.
     */
    @XmlElementDecl(namespace = "http://genologics.com/ri/artifact", name = "demux")
    public JAXBElement<Demux> createDemux(Demux value) {
        return new JAXBElement<Demux>(_Demux_QNAME, Demux.class, null, value);
    }
}
