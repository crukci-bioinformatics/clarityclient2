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

package com.genologics.ri.process;

import java.io.Serial;
import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.LimsEntityLinkable;
import com.genologics.ri.Linkable;
import com.genologics.ri.artifact.Artifact;

/**
 * Input-output-map is a child element of Process and relates one of the Process
 * inputs to one of the outputs that was produced for that input.
 * <p>
 * There will be a distinct input-output-map for each pairing of Process input
 * to Process output.
 * </p>
 * <p>
 * If an input is not mapped to any outputs, the input will be listed with no
 * outputs.
 * </p>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "input-output-map", propOrder = { "input", "output" })
public class InputOutputMap implements Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 1174916419431443420L;

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
     * @param input the input artifact link.
     * @param output the output artifact link.
     */
    public InputOutputMap(ArtifactLink input, ArtifactLink output)
    {
        setInput(input);
        setOutput(output);
    }

    /**
     * Constructor with input and output linkable artifacts.
     *
     * @param input the input linkable artifact.
     * @param output the output linkable artifact.
     */
    public InputOutputMap(Linkable<Artifact> input, Linkable<Artifact> output)
    {
        setInput(input);
        setOutput(output);
    }

    /**
     * Constructor with input and output LIMS entity linkable artifacts.
     *
     * @param input the input LIMS entity linkable artifact.
     * @param output the output LIMS entity linkable artifact.
     */
    public InputOutputMap(LimsEntityLinkable<Artifact> input, LimsEntityLinkable<Artifact> output)
    {
        setInput(input);
        setOutput(output);
    }

    /**
     * Gets the input artifact link.
     *
     * @return the input artifact link.
     */
    public ArtifactLink getInput()
    {
        return input;
    }

    /**
     * Sets the input artifact link.
     *
     * @param value the input artifact link to set.
     */
    public void setInput(ArtifactLink value)
    {
        this.input = value;
    }

    /**
     * Sets the input from a linkable artifact.
     *
     * @param link the linkable artifact.
     */
    public void setInput(Linkable<Artifact> link)
    {
        this.input = link == null ? null : new ArtifactLink(link);
    }

    /**
     * Sets the input from a LIMS entity linkable artifact.
     *
     * @param link the LIMS entity linkable artifact.
     */
    public void setInput(LimsEntityLinkable<Artifact> link)
    {
        this.input = link == null ? null : new ArtifactLink(link);
    }

    /**
     * Gets the output artifact link.
     *
     * @return the output artifact link.
     */
    public ArtifactLink getOutput()
    {
        return output;
    }

    /**
     * Sets the output artifact link.
     *
     * @param value the output artifact link to set.
     */
    public void setOutput(ArtifactLink value)
    {
        this.output = value;
    }

    /**
     * Sets the output from a linkable artifact.
     *
     * @param link the linkable artifact.
     */
    public void setOutput(Linkable<Artifact> link)
    {
        this.output = link == null ? null : new ArtifactLink(link);
    }

    /**
     * Sets the output from a LIMS entity linkable artifact.
     *
     * @param link the LIMS entity linkable artifact.
     */
    public void setOutput(LimsEntityLinkable<Artifact> link)
    {
        this.output = link == null ? null : new ArtifactLink(link);
    }
}
