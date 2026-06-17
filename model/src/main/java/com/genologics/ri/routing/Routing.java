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

package com.genologics.ri.routing;

import java.io.Serial;
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
 *
 * The root element for a routing API call.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "routing", propOrder = { "assignedRoutes", "unassignedRoutes" })
@XmlRootElement(name = "routing")
public class Routing implements Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 4810146731548918326L;

    /**
     * Platform dependent end of line string.
     */
    private static final String EOL = System.getProperty("line.separator");

    /**
     * The list of artifact assignments to assign to workflows/stages.
     */
    @XmlElement(name = "assign")
    protected List<ExtArtifactAssignments> assignedRoutes;

    /**
     * The list of artifact assignments to unassign from workflows/stages.
     */
    @XmlElement(name = "unassign")
    protected List<ExtArtifactAssignments> unassignedRoutes;

    /**
     * Gets the list of assigned routes.
     *
     * @return A list of artifact assignments to assign.
     */
    public List<ExtArtifactAssignments> getAssign()
    {
        if (assignedRoutes == null)
        {
            assignedRoutes = new ArrayList<>();
        }
        return assignedRoutes;
    }

    /**
     * Gets the list of unassigned routes.
     *
     * @return A list of artifact assignments to unassign.
     */
    public List<ExtArtifactAssignments> getUnassign()
    {
        if (unassignedRoutes == null)
        {
            unassignedRoutes = new ArrayList<>();
        }
        return unassignedRoutes;
    }

    /**
     * Display the routings as configured for this object. Lists each of the assigned
     * routes if present and unassigned routes if present.
     *
     * @return A string representation of the routing. This string includes line breaks.
     *
     * @see ExtArtifactAssignments#toString()
     */
    @Override
    public String toString()
    {
        int assignedCount = collectionSize(assignedRoutes);
        int unassignedCount = collectionSize(unassignedRoutes);

        StringBuilder sb = new StringBuilder(256 * (assignedCount + unassignedCount + 1));
        sb.append("Routing").append(EOL);
        if (assignedCount == 0 && unassignedCount == 0)
        {
            sb.append("  No routes").append(EOL);
        }
        if (assignedCount > 0)
        {
            sb.append("  Assigned:").append(EOL);
            for (var ext : assignedRoutes)
            {
                sb.append("    ").append(ext).append(EOL);
            }
        }
        if (unassignedCount > 0)
        {
            sb.append("  Unassigned:").append(EOL);
            for (var ext : unassignedRoutes)
            {
                sb.append("    ").append(ext).append(EOL);
            }
        }
        return sb.toString();
    }

    /**
     * Helper to classes in this package to get the null-safe size of a collection
     * rather than have a dependency on commons-collections.
     *
     * @param collection The collection. May be null.
     *
     * @return The size of the collection, zero if it is null.
     */
    static int collectionSize(Collection<?> collection)
    {
        return collection == null ? 0 : collection.size();
    }
}
