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

import static java.util.Objects.requireNonNull;

import java.io.Serializable;
import java.net.URI;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.XmlValue;

import com.genologics.ri.LimsLink;
import com.genologics.ri.Linkable;
import com.genologics.ri.stepconfiguration.ProtocolStep;


/**
 *
 *         Identifies the configuration information for the step run.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "step-configuration")
public class StepConfiguration implements LimsLink<ProtocolStep>, Serializable
{
    private static final long serialVersionUID = 7902167896883448736L;

    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI protocolStepUri;

    @XmlValue
    protected String stepName;

    public StepConfiguration()
    {
    }

    public StepConfiguration(URI protocolStepUri)
    {
        this.protocolStepUri = protocolStepUri;
    }

    public StepConfiguration(URI protocolStepUri, String stepName)
    {
        this.protocolStepUri = protocolStepUri;
        this.stepName = stepName;
    }

    public StepConfiguration(Linkable<ProtocolStep> step)
    {
        requireNonNull(step, "step cannot be null");
        protocolStepUri = step.getUri();
    }

    public StepConfiguration(ProtocolStep step)
    {
        requireNonNull(step, "step cannot be null");
        protocolStepUri = step.getUri();
        stepName = step.getName();
    }

    public URI getProtocolStepUri()
    {
        return protocolStepUri;
    }

    public void setProtocolStepUri(URI protocolStepUri)
    {
        this.protocolStepUri = protocolStepUri;
    }

    public void setProtocolStep(Linkable<ProtocolStep> protocolStep)
    {
        this.protocolStepUri = protocolStep.getUri();
    }

    public String getStepName()
    {
        return stepName;
    }

    public void setStepName(String stepName)
    {
        this.stepName = stepName;
    }

    @Override
    public URI getUri()
    {
        return protocolStepUri;
    }

    @Override
    public void setUri(URI uri)
    {
        this.protocolStepUri = uri;
    }

    @Override
    public Class<ProtocolStep> getEntityClass()
    {
        return ProtocolStep.class;
    }

}
