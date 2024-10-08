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

package com.genologics.ri.jaxb;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Adapter for those dates that are exchanged with the API in the long timestamp format.
 */
public class LongTimestampAdapter extends AbstractDateAdapter
{
    /**
     * Empty constructor.
     */
    public LongTimestampAdapter()
    {
    }

    /**
     * Create a date formatter for the long timestamp format.
     *
     * @return The DateFormat object.
     */
    @Override
    protected DateFormat createFormatter()
    {
        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    }
}
