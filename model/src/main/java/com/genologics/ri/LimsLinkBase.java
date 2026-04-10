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
import java.net.URI;
import java.util.Objects;

import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Helper base class for {@code LimsLink} implementations that implements
 * {@link #hashCode()} and {@link #equals(Object)} to consider links that point
 * to the same entities as equivalent.
 *
 * @param <E> The type of the entity implementing this interface (a self reference).
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
     * Get a port number for a URI. If the URI is not null and has an explicit port set, return that.
     * If it is not null but indicates no explcit port is set, try to return the default port for
     * its protocol.
     *
     * @param uri THe URI to check.
     *
     * @return The port number if the URI has one set or a one can be determined from its scheme,
     * otherwise return -1 (including if {@code uri} is null).
     */
    private int resolvePort(URI uri)
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

    /**
     * {@inheritDoc}
     * <p>
     * The hash is made up of the hash of the entity class this link points to, and if the URI
     * is not null the hash of its user info, scheme, host, port and path.
     * </p>
     * <p>
     * Where the URI has no explicit port set, we try get to get the default port for the protocol. This
     * covers HTTP (80), HTTPS (443), SFTP (22).
     * </p>
     */
    public int hashCode()
    {
        HashCodeBuilder b = new HashCodeBuilder();
        b.append(getEntityClass());

        URI u = getUri();
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
     * {@inheritDoc}
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
     */
    public boolean equals(Object obj)
    {
        boolean equal = obj == this;
        if (!equal)
        {
            if (obj instanceof LimsLink<?> other)
            {
                equal = Objects.equals(getEntityClass(), other.getEntityClass());
                if (equal)
                {
                    URI u1 = getUri();
                    URI u2 = other.getUri();

                    equal = (u1 == null) == (u2 == null);
                    if (equal && u1 != null && u2 != null)
                    {
                        equal = Objects.equals(u1.getUserInfo(), u2.getUserInfo());
                        equal = Objects.equals(u1.getScheme(), u2.getScheme());
                        equal = Objects.equals(u1.getHost(), u2.getHost());
                        equal = Objects.equals(resolvePort(u1), resolvePort(u2));
                        equal = Objects.equals(u1.getPath(), u2.getPath());
                    }
                }
            }
        }
        return equal;
    }
}
