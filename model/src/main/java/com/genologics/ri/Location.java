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

import static java.util.Objects.requireNonNull;

import java.io.Serial;
import java.io.Serializable;
import java.net.URI;
import java.util.regex.Pattern;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.genologics.ri.container.Container;

/**
 * <p>
 * Location provides a URI linking to the detailed representation of a Container
 * along with the well location within that Container.
 * </p>
 * <p>
 * Location is used by representations to describe their location within a
 * Container. For example Artifact and reagent use location to describe which
 * Container they are located in.
 * </p>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "location", propOrder = { "container", "wellPosition" })
public class Location implements LimsEntityLink<Container>, Serializable, Comparable<Location>
{
    /**
     * Pattern for splitting well position strings.
     */
    public static final Pattern WELL_POSITION_SPLITTER = Pattern.compile(":");

    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = -2461753783129402323L;

    /**
     * The container link.
     */
    @XmlElement(name = "container")
    private ContainerLink container;

    /**
     * The well position within the container.
     */
    @XmlElement(name = "value")
    private String wellPosition;

    /**
     * Cached hash code.
     */
    private transient Integer hc;

    /**
     * Default constructor.
     */
    public Location()
    {
    }

    /**
     * Constructor with container and position.
     *
     * @param container The container link.
     * @param position The well position.
     */
    public Location(LimsEntityLinkable<Container> container, String position)
    {
        requireNonNull(container, "container cannot be null");
        this.container = new ContainerLink(container);
        this.wellPosition = position;
    }

    /**
     * Constructor with container and position.
     *
     * @param container The linkable container.
     * @param position The well position.
     */
    public Location(Linkable<Container> container, String position)
    {
        requireNonNull(container, "container cannot be null");
        this.container = new ContainerLink(container);
        this.wellPosition = position;
    }

    /**
     * Gets the container link.
     *
     * @return The container link.
     */
    public ContainerLink getContainer()
    {
        return container;
    }

    /**
     * Sets the container from a LIMS entity linkable.
     *
     * @param link The LIMS entity linkable container.
     * @return The new container link.
     */
    public ContainerLink setContainer(LimsEntityLinkable<Container> link)
    {
        container = new ContainerLink(link);
        hc = null;
        return container;
    }

    /**
     * Gets the well position.
     *
     * @return The well position.
     */
    public String getWellPosition()
    {
        return wellPosition;
    }

    /**
     * Sets the well position.
     *
     * @param wellPosition The well position.
     */
    public void setWellPosition(String wellPosition)
    {
        this.wellPosition = wellPosition;
        hc = null;
    }

    /**
     * Computes a hash code for this location.
     *
     * @return The hash code.
     */
    @Override
    public int hashCode()
    {
        if (hc == null)
        {
            HashCodeBuilder b = new HashCodeBuilder();
            b.append(container);
            b.append(wellPosition);
            hc = b.toHashCode();
        }
        return hc.intValue();
    }

    /**
     * Compares this location with another object for equality.
     *
     * @param obj The object to compare with.
     * @return {@code true} if the objects are equal, {@code false} otherwise.
     */
    @Override
    public boolean equals(Object obj)
    {
        boolean equal = obj == this;
        if (!equal && obj != null)
        {
            if (getClass().equals(obj.getClass()))
            {
                Location other = (Location)obj;

                EqualsBuilder b = new EqualsBuilder();
                b.append(container, other.container);
                b.append(wellPosition, other.wellPosition);
                equal = b.isEquals();
            }
        }
        return equal;
    }

    /**
     * Compares this location with another location.
     *
     * @param o The location to compare with.
     * @return A negative integer, zero, or a positive integer as this location
     *         is less than, equal to, or greater than the specified location.
     */
    @Override
    public int compareTo(Location o)
    {
        if (o == null)
        {
            return 1;
        }

        if (StringUtils.isBlank(wellPosition) || StringUtils.isBlank(o.wellPosition))
        {
            return 0;
        }

        String[] myparts = WELL_POSITION_SPLITTER.split(wellPosition);
        String[] itsparts = WELL_POSITION_SPLITTER.split(wellPosition);

        int result = 0;
        for (int p = 0; result == 0 && p < Math.min(myparts.length, itsparts.length); p++)
        {
            try
            {
                int p1v = Integer.parseInt(myparts[p]);
                int p2v = Integer.parseInt(itsparts[p]);
                result = p1v - p2v;
            }
            catch (NumberFormatException e)
            {
                result = myparts[p].compareTo(itsparts[p]);
            }
        }
        return result;
    }

    /**
     * Returns a string representation of this location.
     *
     * @return The container and well position as a string.
     */
    @Override
    public String toString()
    {
        return container + " " + wellPosition;
    }

    // Convenience methods to implement LimsEntityLink.
    // Just pass through to the container link.

    /**
     * Gets the LIMS id of the container.
     *
     * @return The LIMS id.
     */
    @Override
    public String getLimsid()
    {
        return container == null ? null : container.getLimsid();
    }

    /**
     * Sets the LIMS id of the container.
     *
     * @param id The LIMS id.
     */
    @Override
    public void setLimsid(String id)
    {
        if (container != null)
        {
            container.setLimsid(id);
        }
    }

    /**
     * Gets the URI of the container.
     *
     * @return The URI.
     */
    @Override
    public URI getUri()
    {
        return container == null ? null : container.getUri();
    }

    /**
     * Sets the URI of the container.
     *
     * @param uri The URI.
     */
    @Override
    public void setUri(URI uri)
    {
        if (container != null)
        {
            container.setUri(uri);
        }
    }

    /**
     * Gets the entity class for this link.
     *
     * @return The Container class.
     */
    @Override
    public Class<Container> getEntityClass()
    {
        return Container.class;
    }
}
