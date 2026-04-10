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

package com.genologics.ri.version;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.Batch;
import com.genologics.ri.ClarityQueryResult;

/**
 *
 * Index is the base entry point to the API, providing a list of supported
 * versions in the system.
 */
@ClarityQueryResult(entityClass = Version.class)
@XmlRootElement(name = "versions")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "versions")
public class Versions implements Batch<Version>, Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = -1555363240810423322L;

    /**
     * The list of versions.
     */
    @XmlElement(name = "version")
    protected List<Version> versions;

    /**
     * Default constructor.
     */
    public Versions() {}

    /**
     * Gets the list of versions.
     *
     * @return The list of versions.
     */
    public List<Version> getVersions()
    {
        if (versions == null)
        {
            versions = new ArrayList<>();
        }
        return versions;
    }

    /**
     * Gets the list of versions.
     *
     * @return The list of versions.
     */
    @Override
    public List<Version> getList()
    {
        return getVersions();
    }

    /**
     * Gets the size of the versions list.
     *
     * @return The number of versions in the list.
     */
    @Override
    public int getSize()
    {
        return versions == null ? 0 : versions.size();
    }

}
