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

package org.cruk.clarity.model.jaxb;

import java.net.URI;
import java.net.URISyntaxException;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Convert to and from URI objects, correctly encoding the query string.
 */
public class URIAdapter extends XmlAdapter<String, URI>
{
    public URIAdapter()
    {
    }

    /**
     * Convert a string into a URI.
     *
     * @param v The string to convert.
     *
     * @return A {@code URI} object for the string, or null if {@code v} is null.
     *
     * @throws URISyntaxException if the string cannot be parsed.
     */
    @Override
    public URI unmarshal(String v) throws URISyntaxException
    {
        return v == null ? null : new URI(v);
    }

    /**
     * Convert the given URI into its string format.
     *
     * @param v The URI to print.
     *
     * @return The URI as a string, or null if {@code v} is null.
     *
     * @throws URISyntaxException if the URI cannot be parsed.
     */
    @Override
    public String marshal(URI v) throws URISyntaxException
    {
        return v == null ? null : v.toString();
    }
}
