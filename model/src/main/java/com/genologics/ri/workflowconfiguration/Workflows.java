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

package com.genologics.ri.workflowconfiguration;

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
 * The representation of a list of Workflow links.
 */
@ClarityQueryResult(entityClass = Workflow.class)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "workflows")
@XmlRootElement(name = "workflows")
public class Workflows implements Batch<WorkflowLink>, Serializable
{
    /**
     * Class version for serialisation.
     */
    @java.io.Serial
    private static final long serialVersionUID = -7678105241108473919L;

    /**
     * The list of workflow links.
     */
    @XmlElement(name = "workflow")
    protected List<WorkflowLink> workflows;

    /**
     * Default constructor.
     */
    public Workflows() {}

    /**
     * Gets the list of workflows.
     *
     * @return The list of workflow links.
     */
    public List<WorkflowLink> getWorkflows()
    {
        if (workflows == null)
        {
            workflows = new ArrayList<>();
        }
        return workflows;
    }

    /**
     * Gets the list of workflows.
     *
     * @return The list of workflow links.
     */
    @Override
    public List<WorkflowLink> getList()
    {
        return getWorkflows();
    }

    /**
     * Gets the number of workflows in the list.
     *
     * @return The size of the workflow list.
     */
    @Override
    public int getSize()
    {
        return workflows == null ? 0 : workflows.size();
    }
}
