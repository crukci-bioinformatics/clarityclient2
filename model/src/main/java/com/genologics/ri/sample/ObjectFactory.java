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

package com.genologics.ri.sample;

import static com.genologics.ri.Namespaces.SAMPLE_NAMESPACE;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the com.genologics.ri.sample package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 * </p>
 */
@XmlRegistry
public class ObjectFactory
{
    /**
     * The qualified name for the sample element.
     */
    private final static QName _Sample_QNAME = new QName(SAMPLE_NAMESPACE, "sample");

    /**
     * The qualified name for the samplecreation element.
     */
    private final static QName _Samplecreation_QNAME = new QName(SAMPLE_NAMESPACE, "samplecreation");

    /**
     * The qualified name for the samples element.
     */
    private final static QName _Samples_QNAME = new QName(SAMPLE_NAMESPACE, "samples");

    /**
     * The qualified name for the details element.
     */
    private final static QName _Details_QNAME = new QName(SAMPLE_NAMESPACE, "details");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.genologics.ri.sample
     */
    public ObjectFactory()
    {
    }

    /**
     * Create an instance of {@link SampleCreation}.
     *
     * @return The new SampleCreation instance.
     */
    public SampleCreation createSamplecreation()
    {
        return new SampleCreation();
    }

    /**
     * Create an instance of {@link Sample}.
     *
     * @return The new Sample instance.
     */
    public Sample createSample()
    {
        return new Sample();
    }

    /**
     * Create an instance of {@link SampleBatchFetchResult}.
     *
     * @return The new SampleBatchFetchResult instance.
     */
    public SampleBatchFetchResult createDetails()
    {
        return new SampleBatchFetchResult();
    }

    /**
     * Create an instance of {@link ArtifactLink}.
     *
     * @return The new ArtifactLink instance.
     */
    public ArtifactLink createArtifact()
    {
        return new ArtifactLink();
    }

    /**
     * Create an instance of {@link Samples}.
     *
     * @return The new Samples instance.
     */
    public Samples createSamples()
    {
        return new Samples();
    }

    /**
     * Create an instance of {@link SampleBase}.
     *
     * @return The new SampleBase instance.
     */
    public SampleBase createSamplebase()
    {
        return new SampleBase();
    }

    /**
     * Create an instance of {@link BioSource}.
     *
     * @deprecated Biosource is not supported in Clarity.
     * @return The new BioSource instance.
     */
    @Deprecated
    public BioSource createBiosource()
    {
        return new BioSource();
    }

    /**
     * Create an instance of {@link Submitter}.
     *
     * @return The new Submitter instance.
     */
    public Submitter createSubmitter()
    {
        return new Submitter();
    }

    /**
     * Create an instance of {@link SampleLink}.
     *
     * @return The new SampleLink instance.
     */
    public SampleLink createSampleLink()
    {
        return new SampleLink();
    }

    /**
     * Create an instance of {@link ProjectLink}.
     *
     * @return The new ProjectLink instance.
     */
    public ProjectLink createProject()
    {
        return new ProjectLink();
    }

    /**
     * Create an instance of {@link ControlTypeLink}.
     *
     * @return The new ControlTypeLink instance.
     */
    public ControlTypeLink createControlTypeLink()
    {
        return new ControlTypeLink();
    }

    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link Sample}{@code >}.
     *
     * @param value The Sample instance value.
     * @return The JAXBElement wrapper for the Sample.
     */
    @XmlElementDecl(namespace = SAMPLE_NAMESPACE, name = "sample")
    public JAXBElement<Sample> createSample(Sample value)
    {
        return new JAXBElement<Sample>(_Sample_QNAME, Sample.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link SampleCreation}{@code >}.
     *
     * @param value The SampleCreation instance value.
     * @return The JAXBElement wrapper for the SampleCreation.
     */
    @XmlElementDecl(namespace = SAMPLE_NAMESPACE, name = "samplecreation")
    public JAXBElement<SampleCreation> createSamplecreation(SampleCreation value)
    {
        return new JAXBElement<SampleCreation>(_Samplecreation_QNAME, SampleCreation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link Samples}{@code >}.
     *
     * @param value The Samples instance value.
     * @return The JAXBElement wrapper for the Samples.
     */
    @XmlElementDecl(namespace = SAMPLE_NAMESPACE, name = "samples")
    public JAXBElement<Samples> createSamples(Samples value)
    {
        return new JAXBElement<Samples>(_Samples_QNAME, Samples.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link SampleBatchFetchResult}{@code >}.
     *
     * @param value The SampleBatchFetchResult instance value.
     * @return The JAXBElement wrapper for the SampleBatchFetchResult.
     */
    @XmlElementDecl(namespace = SAMPLE_NAMESPACE, name = "details")
    public JAXBElement<SampleBatchFetchResult> createDetails(SampleBatchFetchResult value)
    {
        return new JAXBElement<SampleBatchFetchResult>(_Details_QNAME, SampleBatchFetchResult.class, null, value);
    }
}
