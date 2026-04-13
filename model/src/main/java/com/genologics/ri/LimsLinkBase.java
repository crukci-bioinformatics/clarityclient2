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
 * Helper base class for {@code LimsLink} implementations that implements
 * {@link #hashCode()} and {@link #equals(Object)} to consider links that point
 * to the same entities as equivalent.
 * <p>
 * THe static implementations are used in all cases but are made separate where
 * a link class already inherits from another class. In these cases, their
 * hashCode() and equals() methods can simply call these static methods passing
 * in {@code this}.
 * </p>
 *
 * @param <E> The type of entity that is at the end of the link.
 */
public abstract class LimsLinkBase<E extends LimsEntity<E>> implements LimsLink<E>, Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = -3855777262069587770L;

    /**
     * Protected constructor.
     */
    protected LimsLinkBase()
    {
    }

    /**
     * {@inheritDoc}
     * <p>
     * What goes into the hash code is described in {@link LimsLink#hashCode(LimsLink)}.
     * </p>
     */
    public int hashCode()
    {
        return LimsLink.hashCode(this);
    }

    /**
     * {@inheritDoc}
     * <p>
     * The description of what makes another link equivalent to this link is described in
     * {@link LimsLink#equals(LimsLink, Object)}.
     * </p>
     */
    public boolean equals(Object obj)
    {
        return LimsLink.equals(this, obj);
    }

    /**
     * {@inheritDoc}
     * <p>
     * The form of the string is described in {@link LimsLink#toString(LimsLink)}.
     * </p>
     */
    public String toString()
    {
        return LimsLink.toString(this);
    }
}
