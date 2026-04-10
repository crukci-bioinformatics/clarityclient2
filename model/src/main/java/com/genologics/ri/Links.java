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

package com.genologics.ri;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * The representation of a list of resource links.
 */
@XmlRootElement(name = "links")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "links")
public class Links implements Batch<Link>, Serializable
{
    /**
     * Class version for serialisation.
     */
    @java.io.Serial
    private static final long serialVersionUID = 8838137119064380847L;

    /**
     * The list of links.
     */
    @XmlElement(name = "link")
    protected List<Link> linkList;

    /**
     * Default constructor.
     */
    public Links()
    {
    }

    /**
     * Constructor with initial capacity.
     *
     * @param capacity The initial capacity of the link list.
     */
    public Links(int capacity)
    {
        linkList = new ArrayList<>(capacity);
    }

    /**
     * Constructor from a collection of links.
     *
     * @param links The collection of links.
     */
    public Links(Collection<Link> links)
    {
        linkList = new ArrayList<>(links);
    }

    /**
     * Copy constructor.
     *
     * @param links The Links object to copy.
     */
    public Links(Links links)
    {
        this(links.getLinks());
    }

    /**
     * Gets the list of links.
     *
     * @return The list of links.
     */
    public List<Link> getLinks()
    {
        if (linkList == null)
        {
            linkList = new ArrayList<Link>(128);
        }
        return this.linkList;
    }

    /**
     * Adds a link to this collection.
     *
     * @param link The link to add.
     * @return The link that was added.
     */
    public Link add(Link link)
    {
        getLinks().add(link);
        return link;
    }

    /**
     * Adds a linkable object as a link to this collection.
     *
     * @param link The linkable object to add.
     * @return The link that was created and added.
     */
    public Link add(Linkable<?> link)
    {
        Link l = new Link(link);
        getLinks().add(l);
        return l;
    }

    /**
     * Adds all links from another Links object.
     *
     * @param links The Links object containing links to add.
     */
    public void addAll(Links links)
    {
        addAll(links.getLinks());
    }

    /**
     * Adds all links from a collection.
     *
     * @param links The collection of links to add.
     */
    public void addAll(Collection<Link> links)
    {
        getLinks().addAll(links);
    }

    /**
     * Gets the list of links for the Batch interface.
     *
     * @return The list of links.
     */
    @Override
    public List<Link> getList()
    {
        return getLinks();
    }

    /**
     * Gets the number of links in this collection.
     *
     * @return The number of links.
     */
    @Override
    public int getSize()
    {
        return linkList == null ? 0 : linkList.size();
    }
}
