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
 * Interface for links to LimsEntity objects.
 *
 * @param <E> The type of entity that is at the end of the link.
 */
public interface LimsEntityLink<E extends LimsEntity<E>> extends LimsLink<E>, LimsEntityLinkable<E>
{
    /**
     * Since anything implementing this interface is already an entity link,
     * this default implementation will just return itself.
     *
     * @return This LimsEntityLink.
     */
    @Override
    default LimsEntityLink<E> getLink()
    {
        return this;
    }
}
