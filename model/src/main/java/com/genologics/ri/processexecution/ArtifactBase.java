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

package com.genologics.ri.processexecution;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;

import org.apache.commons.beanutils.PropertyUtils;

import com.genologics.ri.Linkable;
import com.genologics.ri.artifact.Artifact;

/**
 *
 * The base representation of an Artifact in the context of Process execution,
 * defining common elements for both input and output Artifacts.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "artifactbase", propOrder = { "qcFlag" })
@XmlSeeAlso({ Input.class, Output.class })
public abstract class ArtifactBase implements Serializable
{
    /**
     * Class version for serialisation.
     */
    @java.io.Serial
    private static final long serialVersionUID = -946571040944446567L;

    /**
     * The quality control flag for this artifact.
     */
    @XmlElement(name = "qc-flag")
    protected QCFlag qcFlag;

    /**
     * Gets the quality control flag for this artifact.
     *
     * @return The QC flag.
     */
    public QCFlag getQCFlag()
    {
        return qcFlag;
    }

    /**
     * Sets the quality control flag for this artifact.
     *
     * @param value The QC flag to set.
     */
    public void setQCFlag(QCFlag value)
    {
        this.qcFlag = value;
    }

    /**
     * Updates the QC flag from a linkable artifact.
     *
     * @param link The linkable artifact to get the QC flag from.
     */
    protected void updateQCFlag(Linkable<Artifact> link)
    {
        qcFlag = null;
        try
        {
            String objectQCFlagString = PropertyUtils.getProperty(link, "qcFlag").toString();
            if (objectQCFlagString != null)
            {
                qcFlag = QCFlag.valueOf(objectQCFlagString);
            }
        }
        catch (Exception e)
        {
            // Ignore.
        }
    }
}
