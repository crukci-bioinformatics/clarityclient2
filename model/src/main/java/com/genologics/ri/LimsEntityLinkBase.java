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

import java.io.Serial;
import java.io.Serializable;

/**
 * Helper base class for {@code LimsEntityLink} implementations extending from
 * {@link LimsLinkBase}. See that class for all the details.
 *
 * @param <E> The type of LimsEntity that is at the end of the link.
 *
 * @since 2.34.2
 */
public abstract class LimsEntityLinkBase<E extends LimsEntity<E>> extends LimsLinkBase<E> implements LimsEntityLink<E>, Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 1270112019741356772L;

    /**
     * Protected constructor.
     */
    protected LimsEntityLinkBase()
    {
    }
}
