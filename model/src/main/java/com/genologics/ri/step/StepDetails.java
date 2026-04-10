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
import com.genologics.ri.Namespaces;
import com.genologics.ri.artifact.Artifact;
import com.genologics.ri.instrument.Instrument;
import com.genologics.ri.userdefined.UDF;
import com.genologics.ri.userdefined.UDFHolder;

/**
 * Represents the detailed view of a step, including configuration, input/output mappings,
 * user-defined fields, and associated resources.
 *
 * @since 2.18
 */
@ClarityEntity(uriSection = "steps", uriSubsection = "details", updateable = true)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "details", propOrder = { "step", "configuration", "inputOutputMaps", "fields", "preset", "instrument" })
@XmlRootElement(name = "details")
public class StepDetails implements Linkable<StepDetails>, UDFHolder, Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 5865493881321340964L;

    /**
     * Link to the step this details object describes.
     */
    @XmlElement
    protected Link step;

    /**
     * The configuration of the step.
     */
    @XmlElement
    protected StepConfiguration configuration;

    /**
     * The list of input to output artifact mappings for the step.
     */
    @XmlElementWrapper(name = "input-output-maps")
    @XmlElement(name = "input-output-map")
    protected List<InputOutputMap> inputOutputMaps;

    /**
     * The user-defined fields for the step.
     */
    @XmlElementWrapper(name = "fields")
    @XmlElement(name = "field", namespace = Namespaces.UDF_NAMESPACE)
    protected List<UDF> fields;

    /**
     * The name of the preset configuration used for the step.
     */
    @XmlElement
    protected String preset;

    /**
     * Link to the instrument used for the step.
     */
    @XmlElement
    protected InstrumentLink instrument;

    /**
     * The URI of this step details resource.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;


    /**
     * Default constructor.
     */
    public StepDetails()
    {
    }

    /**
     * Constructor taking the URI of the step details.
     *
     * @param uri The URI of the step details.
     */
    public StepDetails(URI uri)
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
     * Gets the list of input to output artifact mappings.
     *
     * @return The list of input/output mappings.
     */
    public List<InputOutputMap> getInputOutputMaps()
    {
        if (inputOutputMaps == null)
        {
            inputOutputMaps = new ArrayList<InputOutputMap>();
        }
        return inputOutputMaps;
    }

    /**
     * Adds an input/output mapping to the step.
     *
     * @param iomap The input/output mapping to add.
     *
     * @return The added mapping.
     */
    public InputOutputMap addInputOutputMap(InputOutputMap iomap)
    {
        getInputOutputMaps().add(iomap);
        return iomap;
    }

    /**
     * Creates and adds an input/output mapping to the step.
     *
     * @param input The input artifact.
     * @param output The output artifact.
     *
     * @return The created and added mapping.
     */
    public InputOutputMap addInputOutputMap(LimsEntityLinkable<Artifact> input, LimsEntityLinkable<Artifact> output)
    {
        InputOutputMap iomap = new InputOutputMap(input, output);
        getInputOutputMaps().add(iomap);
        return iomap;
    }

    /**
     * Gets the list of user-defined fields for the step.
     *
     * @return The list of user-defined fields.
     */
    @Override
    public List<UDF> getUserDefinedFields()
    {
        if (fields == null)
        {
            fields = new ArrayList<UDF>();
        }
        return fields;
    }

    /**
     * Gets the preset name.
     *
     * @return The preset name.
     */
    public String getPreset()
    {
        return preset;
    }

    /**
     * Sets the preset name.
     *
     * @param preset The preset name.
     */
    public void setPreset(String preset)
    {
        this.preset = preset;
    }

    /**
     * Gets the link to the instrument.
     *
     * @return The instrument link.
     */
    public InstrumentLink getInstrument()
    {
        return instrument;
    }

    /**
     * Sets the instrument from a link.
     *
     * @param link The instrument link.
     */
    public void setInstrument(Linkable<Instrument> link)
    {
        this.instrument = new InstrumentLink(link);
    }

    /**
     * Sets the instrument from an instrument object.
     *
     * @param instrument The instrument.
     */
    public void setInstrument(Instrument instrument)
    {
        this.instrument = new InstrumentLink(instrument);
    }

    /**
     * Gets the URI of this step details resource.
     *
     * @return The URI.
     */
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI of this step details resource.
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
    public LimsLink<StepDetails> getLink()
    {
        return new StepDetailsLink(this);
    }
}
