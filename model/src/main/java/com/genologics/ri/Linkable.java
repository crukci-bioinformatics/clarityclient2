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


/**
 * Marker interface that indicates a locatable object can be linked to.
 * Typically, entities and the links to entities will be linkable.
 *
 * @param <E> The type of entity that is at the end of the link.
 */
public interface Linkable<E extends Locatable> extends Locatable
{
    /**
     * Get a concrete link object to this {@code Linkable} thing.
     *
     * @return A {@code LimsLink} to this object.
     *
     * @since Clarity Client version 2, 2.31.0
     */
    LimsLink<E> getLink();
}
