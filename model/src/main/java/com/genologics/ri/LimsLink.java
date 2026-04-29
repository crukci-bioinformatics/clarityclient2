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

import static com.genologics.ri.Link.UNSET;
import static java.util.Objects.requireNonNull;
import static org.apache.commons.lang3.StringUtils.isEmpty;

import java.net.URI;
import java.util.Objects;

import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Interface for classes that are links to real LIMS objects.
 * <p>
 * From release 2.34.2 onwards, all concrete implementations of
 * {@code LimsLink} should have their {@code hashCode()} and
 * {@code equals()} methods implemented so links pointing to the
 * same entity class with the same core URI (scheme, host, port and path)
 * are considered equal, even if the concrete classes are not the
 * same or the URI differs only by a query part. To this end,
 * the {@link LimsLinkBase} or {@link LimsEntityLinkBase} classes
 * provide convenience superclasses whose {@code hashCode()} and
 * {@code equals()} methods call the {@link #hashCode(LimsLink) hashCode}
 * and {@link #equals(LimsLink, Object) equals} methods given on this
 * interface. Those classes that cannot inherit from these base
 * classes should themselves implement {@code hashCode()} and
 * {@code equals()} in the same way.
 * </p>
 * <p>
 * This interface also provides a {@link #toString(LimsLink) toString}
 * implementation that can give a default string representation for any link.
 * </p>
 *
 * @param <E> The type of entity that is at the end of the link.
 *
 * @see LimsLinkBase
 */
public interface LimsLink<E extends Locatable> extends Linkable<E>
{
    /**
     * Get the URI of the object we are linking to.
     *
     * @return The URI.
     */
    URI getUri();

    /**
     * Get the class of the true, full LIMS entity this object links to.
     *
     * @return The real object class.
     */
    Class<E> getEntityClass();

    /**
     * Since anything implementing this interface is already a link, this
     * default implementation will just return itself.
     *
     * @return This LimsLink.
     */
    @Override
    default LimsLink<E> getLink()
    {
        return this;
    }

    /**
     * Calculate a hash code for the given link.
     * <p>
     * The hash is made up of the hash of the entity class this link points to, and if the URI
     * is not null the hash of its user info, scheme, host, port and path.
     * </p>
     * <p>
     * Where the URI has no explicit port set, we try get to get the default port for the protocol. This
     * covers HTTP (80), HTTPS (443), SFTP (22).
     * </p>
     *
     * @param link The link to calculate the hash code for. Cannot be null.
     *
     * @return A hash code for the link.
     *
     * @throws NullPointerException if {@code link} is null.
     *
     * @since 2.34.2
     */
    public static int hashCode(LimsLink<?> link)
    {
        requireNonNull(link, "Need a non-null link for hashCode.");

        HashCodeBuilder b = new HashCodeBuilder();
        b.append(link.getEntityClass());

        URI u = link.getUri();
        if (u != null)
        {
            b.append(u.getUserInfo());
            b.append(u.getScheme());
            b.append(u.getHost());
            b.append(resolvePort(u));
            b.append(u.getPath());
        }

        return b.toHashCode();
    }

    /**
     * Test a LimsLink against another object for equivalence.
     * <p>
     * To be considered equal, two LimsLink objects must:
     * </p>
     * <ol>
     * <li>Point to entities of the same class ({@link LimsLink#getEntityClass() getEntityClass} must be the same).</li>
     * <li>Both links need their URIs to both be null, or both be set.</li>
     * <li>If the URIs are set, some elements are compared to be equivalent:
     * <ol>
     * <li>The user information (almost certainly null always with Clarity URIs).</li>
     * <li>The scheme (protocol).</li>
     * <li>The host.</li>
     * <li>The port.</li>
     * <li>The path.</li>
     * </ol>
     * </li>
     * </ol>
     * <p>
     * Note that the query part of the URI <b>is not compared</b>. Thus URIs that point to the same stateful
     * entity that request different states will be considered equivalent.
     * </p>
     * <p>
     * Where the URI has no explicit port set, we try get to get the default port for the protocol. This
     * covers HTTP (80), HTTPS (443), SFTP (22).
     * </p>
     *
     * @param link The left link for comparison. Cannot be null.
     * @param obj The right other object for testing. Can be null.
     *
     * @return true if the link and the object it is compared to are equivalent, false if not.
     *
     * @throws NullPointerException if {@code link} is null.
     *
     * @since 2.34.2
     */
    public static boolean equals(LimsLink<?> link, Object obj)
    {
        requireNonNull(link, "Need a non-null link for equals.");

        boolean equal = obj == link;
        if (!equal)
        {
            if (obj instanceof LimsLink<?> other)
            {
                equal = Objects.equals(link.getEntityClass(), other.getEntityClass());
                if (equal)
                {
                    URI u1 = link.getUri();
                    URI u2 = other.getUri();

                    equal = (u1 == null) == (u2 == null);
                    if (equal && u1 != null && u2 != null)
                    {
                        equal = Objects.equals(u1.getUserInfo(), u2.getUserInfo()) &&
                                Objects.equals(u1.getScheme(), u2.getScheme()) &&
                                Objects.equals(u1.getHost(), u2.getHost()) &&
                                Objects.equals(resolvePort(u1), resolvePort(u2)) &&
                                Objects.equals(u1.getPath(), u2.getPath());
                    }
                }
            }
        }
        return equal;
    }

    /**
     * An implementation of {@code toString()} for links.
     * The string form of a link is the name of the entity class and the LIMS id
     * of the instance in the format "{@code LimsLink<entity>[lims id]}".
     * If there is no LIMS id set, the value "unset" is given.
     *
     * @param link The link to convert to a string. Cannot be null.
     *
     * @return The string form of the link.
     *
     * @throws NullPointerException if {@code link} is null.
     *
     * @since 2.34.2
     */
    public static String toString(LimsLink<?> link)
    {
        requireNonNull(link, "Need a non-null link for toString.");

        String entity = ClassUtils.getShortClassName(link.getEntityClass());
        String id = null;
        if (link instanceof LimsEntityLink lel)
        {
            id = lel.getLimsid();
        }
        if (isEmpty(id))
        {
            id = Link.limsIdFromUri(link.getUri());
        }
        if (isEmpty(id))
        {
            id = UNSET;
        }
        StringBuilder b = new StringBuilder(64);
        b.append("LimsLink<").append(entity).append(">[").append(id).append(']');
        return b.toString();
    }


    /**
     * Get a port number for a URI. If the URI is not null and has an explicit port set, return that.
     * If it is not null but indicates no explcit port is set, try to return the default port for
     * its protocol.
     *
     * @param uri The URI to check.
     *
     * @return The port number if the URI has one set or a one can be determined from its scheme,
     * otherwise return -1 (including if {@code uri} is null).
     *
     * @since 2.34.2
     */
    private static int resolvePort(URI uri)
    {
        if (uri != null)
        {
            if (uri.getPort() >= 0)
            {
                return uri.getPort();
            }
            switch (uri.getScheme())
            {
                case "http":  return 80;
                case "https": return 443;
                case "sftp":  return 22;
            }
        }
        return -1;
    }
}
