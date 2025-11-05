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

package com.genologics.ri.globaltoken;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.ClarityQueryResult;
import com.genologics.ri.Page;
import com.genologics.ri.PaginatedBatch;


/**
 * List of global token links. There is currently no end point in Clarity, hence there
 * is no {@code @XmlRootElement} annotation here. It will need to be added if there is
 * an end point in a later release.
 *
 * @since 2.34
 */
@ClarityQueryResult(entityClass = GlobalToken.class)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "global-tokens", propOrder = { "globalTokens", "previousPage", "nextPage" })
public class GlobalTokens implements PaginatedBatch<GlobalTokenLink>, Serializable
{
    private static final long serialVersionUID = -6362088116923564852L;

    @XmlElement(name = "global-token")
    protected List<GlobalTokenLink> globalTokens;

    @XmlElement(name = "previous-page")
    protected Page previousPage;

    @XmlElement(name = "next-page")
    protected Page nextPage;

    public GlobalTokens() { }

    public List<GlobalTokenLink> getGlobalTokens()
    {
        if (globalTokens == null)
        {
            globalTokens = new ArrayList<>();
        }
        return globalTokens;
    }

    @Override
    public List<GlobalTokenLink> getList()
    {
        return getGlobalTokens();
    }

    @Override
    public int getSize()
    {
        return globalTokens == null ? 0 : globalTokens.size();
    }

    public Page getPreviousPage()
    {
        return previousPage;
    }

    public void setPreviousPage(Page previousPage)
    {
        this.previousPage = previousPage;
    }

    public Page getNextPage()
    {
        return nextPage;
    }

    public void setNextPage(Page nextPage)
    {
        this.nextPage = nextPage;
    }
}
