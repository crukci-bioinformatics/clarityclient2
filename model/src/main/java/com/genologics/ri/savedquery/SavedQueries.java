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

package com.genologics.ri.savedquery;

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
 * Represents a paginated list of saved queries.
 *
 * @since 2.34
 */
@ClarityQueryResult(entityClass = SavedQuery.class)
@XmlRootElement(name = "saved-queries")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "saved-queries", propOrder = { "savedQueries", "previousPage", "nextPage" })
public class SavedQueries implements PaginatedBatch<SavedQueryLink>, Serializable
{
    /**
     * Class version for serialisation.
     */
    @java.io.Serial
    private static final long serialVersionUID = -1608597563242261675L;

    /**
     * The list of saved query links.
     */
    @XmlElement(name = "saved-query")
    protected List<SavedQueryLink> savedQueries;

    /**
     * The link to the previous page of results.
     */
    @XmlElement(name = "previous-page")
    protected Page previousPage;

    /**
     * The link to the next page of results.
     */
    @XmlElement(name = "next-page")
    protected Page nextPage;

    /**
     * Default constructor.
     */
    public SavedQueries() {}

    /**
     * Gets the list of saved query links.
     *
     * @return The list of saved query links.
     */
    public List<SavedQueryLink> getSavedQueries()
    {
        if (savedQueries == null)
        {
            savedQueries = new ArrayList<>();
        }
        return savedQueries;
    }

    /**
     * Gets the list of saved query links.
     *
     * @return The list of saved query links.
     */
    @Override
    public List<SavedQueryLink> getList()
    {
        return getSavedQueries();
    }

    /**
     * Gets the size of the saved query list.
     *
     * @return The number of saved queries in the list.
     */
    @Override
    public int getSize()
    {
        return savedQueries == null ? 0 : savedQueries.size();
    }

    /**
     * Gets the previous page of results.
     *
     * @return The previous page.
     */
    public Page getPreviousPage()
    {
        return previousPage;
    }

    /**
     * Sets the previous page of results.
     *
     * @param previousPage The previous page.
     */
    public void setPreviousPage(Page previousPage)
    {
        this.previousPage = previousPage;
    }

    /**
     * Gets the next page of results.
     *
     * @return The next page.
     */
    public Page getNextPage()
    {
        return nextPage;
    }

    /**
     * Sets the next page of results.
     *
     * @param nextPage The next page.
     */
    public void setNextPage(Page nextPage)
    {
        this.nextPage = nextPage;
    }
}
