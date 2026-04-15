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

package org.cruk.clarity.api.search.internal;

import com.genologics.ri.LimsLink;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

/**
 * JAXB adapter for dealing with LimsLink objects.
 */
public class LimsLinkAdapter extends XmlAdapter<Object, LimsLink<?>>
{
    /**
     * Constructor.
     */
    public LimsLinkAdapter()
    {
    }

    /**
     * Converts an XML object to a LimsLink object during unmarshalling.
     *
     * @param v The object value from XML.
     *
     * @return The LimsLink object.
     *
     * @throws ClassCastException if for some reason the {@code v} does
     * not implement LimsLink.
     */
    @Override
    public LimsLink<?> unmarshal(Object v)
    {
        return LimsLink.class.cast(v);
    }

    /**
     * Converts a LimsLink object to an XML-compatible object during marshalling.
     *
     * @param v The LimsLink object to convert.
     *
     * @return {@code v}, unchanged.
     */
    @Override
    public Object marshal(LimsLink<?> v)
    {
        return v;
    }
}
