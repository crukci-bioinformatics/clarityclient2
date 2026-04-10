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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.BatchUpdate;
import com.genologics.ri.ClarityBatchRetrieveResult;
import com.genologics.ri.Namespaces;

/**
 * The representation of a batch fetch result for artifacts.
 * <p>
 * This class is used for batch retrieval and batch update operations
 * on artifacts.
 * </p>
 */
@ClarityBatchRetrieveResult(entityClass = Artifact.class, batchUpdate = true)
@XmlRootElement(name = "details")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "details")
public class ArtifactBatchFetchResult implements BatchUpdate<Artifact>, Serializable
{
    /**
     * Class version for serialisation.
     */
    @java.io.Serial
    private static final long serialVersionUID = -1280235468943933621L;

    /**
     * The list of artifacts in this batch.
     */
    @XmlElement(name = "artifact", namespace = Namespaces.ARTIFACT_NAMESPACE)
    protected List<Artifact> artifacts;

    /**
     * Constructor.
     */
    public ArtifactBatchFetchResult()
    {
    }

    /**
     * Constructor taking a collection of artifacts.
     *
     * @param artifacts The collection of artifacts.
     */
    public ArtifactBatchFetchResult(Collection<Artifact> artifacts)
    {
        this.artifacts = new ArrayList<>(artifacts);
    }

    /**
     * Gets the list of artifacts in this batch.
     *
     * @return The list of artifacts.
     */
    public List<Artifact> getArtifacts()
    {
        if (artifacts == null)
        {
            artifacts = new ArrayList<>();
        }
        return artifacts;
    }

    /**
     * Gets the list of artifacts in this batch.
     *
     * @return The list of artifacts.
     */
    @Override
    public List<Artifact> getList()
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
     * Adds artifacts to be created.
     *
     * @param entities The collection of artifacts to add for creation.
     */
    @Override
    public void addForCreate(Collection<Artifact> entities)
    {
        getArtifacts().addAll(entities);
    }

    /**
     * Adds artifacts to be updated.
     *
     * @param entities The collection of artifacts to add for update.
     */
    @Override
    public void addForUpdate(Collection<Artifact> entities)
    {
        // Ignore the state part of the query and just let it pass.
        getArtifacts().addAll(entities);

        /*
        // Need to remove the "state=" part of the artifact URIs.
        getArtifacts();
        for (Artifact a : entities)
        {
            URI uri = URIAdapter.removeStateParameter(a.getUri());
            a.setUri(uri);
            artifacts.add(a);
        }
        */
    }
}
