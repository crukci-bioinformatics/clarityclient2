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

package com.genologics.ri.instrument;

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
 * The representation of a list of instrument links.
 * <p>
 * The system enforces a maximum number of elements when generating the list of
 * links. When the size of the request result set is larger than the system
 * maximum, the list represents a paged view of the overall results, and the
 * previous-page and next-page elements provide URIs linking to the previous or
 * next page of links in the overall results.
 * </p>
 */
@ClarityQueryResult(entityClass = Instrument.class)
@XmlRootElement(name = "instruments")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "instruments", propOrder = { "instruments", "previousPage", "nextPage" })
public class Instruments implements PaginatedBatch<InstrumentLink>, Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = -525885513170744397L;

    /**
     * The list of instrument links.
     */
    @XmlElement(name = "instrument")
    protected List<InstrumentLink> instruments;

    /**
     * The previous page reference.
     */
    @XmlElement(name = "previous-page")
    protected Page previousPage;

    /**
     * The next page reference.
     */
    @XmlElement(name = "next-page")
    protected Page nextPage;

    /**
     * Default constructor.
     */
    public Instruments()
    {
    }

    /**
     * Get the list of instrument links.
     *
     * @return The list of instrument links.
     */
    public List<InstrumentLink> getInstruments()
    {
        if (instruments == null)
        {
            instruments = new ArrayList<>();
        }
        return instruments;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<InstrumentLink> getList()
    {
        return getInstruments();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getSize()
    {
        return instruments == null ? 0 : instruments.size();
    }

    /**
     * {@inheritDoc}
     */
    public Page getPreviousPage()
    {
        return previousPage;
    }

    /**
     * {@inheritDoc}
     */
    public void setPreviousPage(Page previousPage)
    {
        this.previousPage = previousPage;
    }

    /**
     * {@inheritDoc}
     */
    public Page getNextPage()
    {
        return nextPage;
    }

    /**
     * {@inheritDoc}
     */
    public void setNextPage(Page nextPage)
    {
        this.nextPage = nextPage;
    }

}
