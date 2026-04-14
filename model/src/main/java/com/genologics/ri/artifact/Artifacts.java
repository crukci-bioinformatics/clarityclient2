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

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.ClarityQueryResult;
import com.genologics.ri.Page;
import com.genologics.ri.PaginatedBatch;

/**
 *
 * The representation of a list of artifact links.
 * <p>
 * The system enforces a maximum number of elements when generating the list of
 * links. When the size of the request result set is larger than the system
 * maximum, the list represents a paged view of the overall results, and the
 * previous-page and next-page elements provide URIs linking to the previous or
 * next page of links in the overall results.
 * </p>
 */
@ClarityQueryResult(entityClass = Artifact.class)
@XmlRootElement(name = "artifacts")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "artifacts", propOrder = { "artifacts", "previousPage", "nextPage" })
public class Artifacts implements PaginatedBatch<ArtifactLink>, Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 2523274106664095426L;

    /**
     * The list of artifact links.
     */
    @XmlElement(name = "artifact")
    protected List<ArtifactLink> artifacts;

    /**
     * The previous page of results.
     */
    @XmlElement(name = "previous-page")
    protected Page previousPage;

    /**
     * The next page of results.
     */
    @XmlElement(name = "next-page")
    protected Page nextPage;

    /**
     * Constructor.
     */
    public Artifacts()
    {
    }

    /**
     * Gets the list of artifact links.
     *
     * @return The list of artifact links.
     */
    public List<ArtifactLink> getArtifacts()
    {
        if (artifacts == null)
        {
            artifacts = new ArrayList<ArtifactLink>();
        }
        return this.artifacts;
    }

    /**
     * Gets the list of artifact links.
     *
     * @return The list of artifact links.
     */
    @Override
    public List<ArtifactLink> getList()
    {
        return getArtifacts();
    }

    /**
     * Gets the size of the artifact list.
     *
     * @return The number of artifacts.
     */
    @Override
    public int getSize()
    {
        return artifacts == null ? 0 : artifacts.size();
    }

    /**
     * Gets the previous page of results.
     *
     * @return The previous page.
     */
    @Override
    public Page getPreviousPage()
    {
        return previousPage;
    }

    /**
     * Sets the previous page of results.
     *
     * @param value The previous page.
     */
    @Override
    public void setPreviousPage(Page value)
    {
        this.previousPage = value;
    }

    /**
     * Gets the next page of results.
     *
     * @return The next page.
     */
    @Override
    public Page getNextPage()
    {
        return nextPage;
    }

    /**
     * Sets the next page of results.
     *
     * @param value The next page.
     */
    @Override
    public void setNextPage(Page value)
    {
        this.nextPage = value;
    }

}
