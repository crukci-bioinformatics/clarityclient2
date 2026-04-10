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

package com.genologics.ri.project;

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
 * The representation of a list of project links.
 * <p>
 * The system enforces a maximum number of elements when generating the list of
 * links. When the size of the request result set is larger than the system
 * maximum, the list represents a paged view of the overall results, and the
 * previous-page and next-page elements provide URIs linking to the previous or
 * next page of links in the overall results.
 * </p>
 */
@ClarityQueryResult(entityClass = Project.class)
@XmlRootElement(name = "projects")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "projects", propOrder = { "projects", "previousPage", "nextPage" })
public class Projects implements PaginatedBatch<ProjectLink>, Serializable
{
    /**
     * Class version for serialisation.
     */
    @java.io.Serial
    private static final long serialVersionUID = -507792514854460064L;

    /**
     * The list of project links.
     */
    @XmlElement(name = "project")
    protected List<ProjectLink> projects;

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
     * Constructor for Projects.
     */
    public Projects()
    {
    }

    /**
     * Get the list of project links.
     *
     * @return The list of project links.
     */
    public List<ProjectLink> getProjects()
    {
        if (projects == null)
        {
            projects = new ArrayList<>();
        }
        return projects;
    }

    /**
     * Get the list of project links.
     *
     * @return The list of project links.
     */
    @Override
    public List<ProjectLink> getList()
    {
        return getProjects();
    }

    /**
     * Get the number of project links.
     *
     * @return The size of the list.
     */
    @Override
    public int getSize()
    {
        return projects == null ? 0 : projects.size();
    }

    /**
     * Get the previous page of results.
     *
     * @return The previous page.
     */
    public Page getPreviousPage()
    {
        return previousPage;
    }

    /**
     * Set the previous page of results.
     *
     * @param previousPage The previous page.
     */
    public void setPreviousPage(Page previousPage)
    {
        this.previousPage = previousPage;
    }

    /**
     * Get the next page of results.
     *
     * @return The next page.
     */
    public Page getNextPage()
    {
        return nextPage;
    }

    /**
     * Set the next page of results.
     *
     * @param nextPage The next page.
     */
    public void setNextPage(Page nextPage)
    {
        this.nextPage = nextPage;
    }

}
