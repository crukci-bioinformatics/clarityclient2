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

package com.genologics.ri.processtype;

import java.io.Serial;
import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


/**
 * The file element describes a shared result file output that will be displayed in the step-setup view.
 *
 * @since 2.25
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "file", propOrder = { "message" })
public class SharedResultFile implements Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = -4934343881979066853L;

    /**
     * The message associated with this shared result file.
     */
    protected String message;

    /**
     * The index of this shared result file.
     */
    @XmlAttribute(name = "shared-result-file-index")
    protected String sharedResultFileIndex;

    /**
     * Constructs a new shared result file.
     */
    public SharedResultFile()
    {
    }

    /**
     * Gets the message associated with this shared result file.
     *
     * @return the message.
     */
    public String getMessage()
    {
        return message;
    }

    /**
     * Sets the message associated with this shared result file.
     *
     * @param message the message.
     */
    public void setMessage(String message)
    {
        this.message = message;
    }

    /**
     * Gets the index of this shared result file.
     *
     * @return the shared result file index.
     */
    public String getSharedResultFileIndex()
    {
        return sharedResultFileIndex;
    }

    /**
     * Sets the index of this shared result file.
     *
     * @param sharedResultFileIndex the shared result file index.
     */
    public void setSharedResultFileIndex(String sharedResultFileIndex)
    {
        this.sharedResultFileIndex = sharedResultFileIndex;
    }
}
