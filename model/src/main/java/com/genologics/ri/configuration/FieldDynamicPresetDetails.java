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

package com.genologics.ri.configuration;

import java.io.Serializable;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.ClarityEntity;
import com.genologics.ri.Locatable;
import com.genologics.ri.Namespaces;

/*
Added API endpoint for creation of dynamic udf presets. POST /api/{version}/configuration/udfs/{udfid}/dynamicpresets/{attachToLimsId}
Added API endpoint for listing of dynamic udf presets. GET /api/{version}/configuration/udfs/{udfid}/dynamicpresets/{attachToLimsId}
Added API endpoint for updating of dynamic udf presets. PUT /api/{version}/configuration/udfs/{udfid}/dynamicpresets/{attachToLimsId}

https://d10e8rzir0haj8.cloudfront.net/6.3/rest.version.configuration.udfs.udfid.dynamicpresets.attach-to-limsid.html
 */

/**
 * The representation of a list of field dynamic UDF preset.
 * <p>
 * Illumina have said that this class is not actually released, and there's
 * nothing in Clarity that uses it.
 * </p>
 *
 * @since 2.34
 */
@ClarityEntity(primaryEntity = Field.class, uriSection = "dynamicpresets", creatable = true, updateable = true)
@XmlRootElement(name = "field-dynamic-preset-details")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "field-dynamic-preset-details")
public class FieldDynamicPresetDetails implements Locatable, Serializable
{
    private static final long serialVersionUID = -8814597927446111161L;

    // With Clarity 6.3.3, this element must have the namespace set on it as well.
    @XmlElement(name = "field-dynamic-preset", namespace = Namespaces.CONFIGURATION_NAMESPACE)
    protected List<FieldDynamicPreset> presets;

    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    public FieldDynamicPresetDetails()
    {
    }

    public FieldDynamicPresetDetails(URI uri)
    {
        setUri(uri);
    }

    public FieldDynamicPresetDetails(Collection<String> presets)
    {
        setPresets(presets);
    }

    public FieldDynamicPresetDetails(URI uri, Collection<String> presets)
    {
        setUri(uri);
        setPresets(presets);
    }

    public FieldDynamicPresetDetails(String... presets)
    {
        setPresets(presets);
    }

    public FieldDynamicPresetDetails(URI uri, String... presets)
    {
        setUri(uri);
        setPresets(presets);
    }

    public List<FieldDynamicPreset> getPresets()
    {
        if (presets == null)
        {
            presets = new ArrayList<>();
        }
        return presets;
    }

    public FieldDynamicPreset addPreset(FieldDynamicPreset preset)
    {
        if (preset != null)
        {
            getPresets().add(preset);
        }
        return preset;
    }

    public FieldDynamicPreset addPreset(String preset)
    {
        FieldDynamicPreset fdp = null;
        if (preset != null)
        {
            fdp = new FieldDynamicPreset(preset);
            getPresets().add(fdp);
        }
        return fdp;
    }

    public void setPresets(String... newPresets)
    {
        setPresets(Arrays.asList(newPresets));
    }

    public void setPresets(Collection<String> newPresets)
    {
        presets = newPresets == null ? null :
            newPresets.stream().filter(preset -> preset != null).map(preset -> new FieldDynamicPreset(preset)).toList();
    }

    public boolean isEmpty()
    {
        return presets == null ? true : presets.isEmpty();
    }

    public URI getUri()
    {
        return uri;
    }

    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    @Override
    public String toString()
    {
        return uri == null ? null : uri.toString();
    }
}
