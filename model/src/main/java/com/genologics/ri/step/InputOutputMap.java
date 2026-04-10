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

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.LimsEntityLinkable;
import com.genologics.ri.Linkable;
import com.genologics.ri.artifact.Artifact;

/**
 *
 * Input-output-map is a child element of Step and relates one of the Step
 * inputs to one of the outputs that was produced for that input.
 * <p>
 * There will be a distinct input-output-map for each pairing of Step input to
 * Step output.
 * </p>
 * <p>
 * If an input is not mapped to any outputs, the input will be listed with no
 * outputs.
 * </p>
 *
 * @since 2.18
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "input-output-map", propOrder = { "input", "output" })
public class InputOutputMap implements Serializable
{
    /**
     * Class version for serialisation.
     */
    @java.io.Serial
    private static final long serialVersionUID = -6553131277891392216L;

    /**
     * The input artifact link.
     */
    protected ArtifactLink input;

    /**
     * The output artifact link.
     */
    protected ArtifactLink output;


    /**
     * Default constructor.
     */
    public InputOutputMap()
    {
    }

    /**
     * Constructor with input and output artifact links.
     *
     * @param input The input artifact link.
     * @param output The output artifact link.
     */
    public InputOutputMap(ArtifactLink input, ArtifactLink output)
    {
        setInput(input);
        setOutput(output);
    }

    /**
     * Constructor with linkable input and output artifacts.
     *
     * @param input The linkable input artifact.
     * @param output The linkable output artifact.
     */
    public InputOutputMap(Linkable<Artifact> input, Linkable<Artifact> output)
    {
        setInput(input);
        setOutput(output);
    }

    /**
     * Constructor with LIMS entity linkable input and output artifacts.
     *
     * @param input The LIMS entity linkable input artifact.
     * @param output The LIMS entity linkable output artifact.
     */
    public InputOutputMap(LimsEntityLinkable<Artifact> input, LimsEntityLinkable<Artifact> output)
    {
        setInput(input);
        setOutput(output);
    }

    /**
     * Gets the input artifact link.
     *
     * @return The input artifact link.
     */
    public ArtifactLink getInput()
    {
        return input;
    }

    /**
     * Sets the input artifact link.
     *
     * @param value The input artifact link.
     */
    public void setInput(ArtifactLink value)
    {
        this.input = value;
    }

    /**
     * Sets the input from a linkable artifact.
     *
     * @param link The linkable artifact.
     */
    public void setInput(Linkable<Artifact> link)
    {
        this.input = link == null ? null : new ArtifactLink(link);
    }

    /**
     * Sets the input from a LIMS entity linkable artifact.
     *
     * @param link The LIMS entity linkable artifact.
     */
    public void setInput(LimsEntityLinkable<Artifact> link)
    {
        this.input = link == null ? null : new ArtifactLink(link);
    }

    /**
     * Gets the output artifact link.
     *
     * @return The output artifact link.
     */
    public ArtifactLink getOutput()
    {
        return output;
    }

    /**
     * Sets the output artifact link.
     *
     * @param value The output artifact link.
     */
    public void setOutput(ArtifactLink value)
    {
        this.output = value;
    }

    /**
     * Sets the output from a linkable artifact.
     *
     * @param link The linkable artifact.
     */
    public void setOutput(Linkable<Artifact> link)
    {
        this.output = link == null ? null : new ArtifactLink(link);
    }

    /**
     * Sets the output from a LIMS entity linkable artifact.
     *
     * @param link The LIMS entity linkable artifact.
     */
    public void setOutput(LimsEntityLinkable<Artifact> link)
    {
        this.output = link == null ? null : new ArtifactLink(link);
    }
}
