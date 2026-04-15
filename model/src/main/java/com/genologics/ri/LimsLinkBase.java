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
import java.util.stream.Stream;

/**
 * Helper base class for {@code LimsLink} implementations that implements
 * {@link #hashCode()} and {@link #equals(Object)} to consider links that point
 * to the same entities as equivalent. It also calls a standard implementation
 * of {@link #toString()} for links.
 * <p>
 * Properly implementing {@code equals} and {@code hashCode} for links allows them to
 * be collected in a set for uniqueness or otherwise tested for equivalence without having
 * to create maps of them where the id is the key and the link is the value. It is simpler
 * to just put the links into a set, or stream with {@link Stream#distinct() distinct()}.
 * </p>
 * <p>
 * The static implementations in {@link LimsLink} are used in all cases. Having these
 * methods separate and static means any link class that already inherits from another
 * class (so cannot inherit from this one) can easily use them.
 * In these cases, their hashCode(), equals() and toString() methods can simply
 * call the {@code LimsLink} static methods passing in {@code this}.
 * This can also be the case where a class in annotated with the JAXB {@code @XmlValue}
 * annotation. JAXB throws errors with those classes saying they can't inherit from
 * base classes.
 * </p>
 *
 * @param <E> The type of Locatable that is at the end of the link.
 *
 * @since 2.34.2
 *
 * @see LimsLink#hashCode(LimsLink)
 * @see LimsLink#equals(LimsLink, Object)
 * @see LimsLink#toString(LimsLink)
 */
public abstract class LimsLinkBase<E extends Locatable> implements LimsLink<E>, Serializable
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
     *
     * @see LimsLink#hashCode(LimsLink)
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
     *
     * @see LimsLink#equals(LimsLink, Object)
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
     *
     * @see LimsLink#toString(LimsLink)
     */
    public String toString()
    {
        return LimsLink.toString(this);
    }
}
