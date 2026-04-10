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

import java.util.Iterator;
import java.util.List;

/**
 * Interface for objects that hold batches of linkable items (links or entities).
 *
 * @param <L> The type of linkable object.
 */
public interface Batch<L> extends Iterable<L>
{
    /**
     * Gets the list of items in this batch.
     *
     * @return The list of items.
     */
    List<L> getList();

    /**
     * Gets the number of items in this batch.
     *
     * @return The size of the batch.
     */
    default int getSize()
    {
        return getList().size();
    }

    /**
     * Checks if this batch is empty.
     *
     * @return {@code true} if the batch contains no items, {@code false} otherwise.
     */
    default boolean isEmpty()
    {
        return getSize() == 0;
    }

    /**
     * Returns an iterator over the items in this batch.
     *
     * @return An iterator.
     */
    @Override
    default Iterator<L> iterator()
    {
        return getList().iterator();
    }
}
