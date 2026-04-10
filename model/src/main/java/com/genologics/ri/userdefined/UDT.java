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

package com.genologics.ri.userdefined;

import static com.genologics.ri.Namespaces.UDF_NAMESPACE;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.configuration.FieldType;

/**
 *
 * Type is the name and user-defined fields of a user-defined type.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "type")
public class UDT implements UDFHolder, Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = -6550385282803073762L;

    /**
     * The list of user-defined fields in this type.
     */
    @XmlElement(name = "field", namespace = UDF_NAMESPACE)
    protected List<UDF> fields;

    /**
     * The name of the user-defined type.
     */
    @XmlAttribute(name = "name", required = true)
    protected String name;

    /**
     * Default constructor.
     */
    public UDT()
    {
    }

    /**
     * Constructor with name.
     *
     * @param name The name of the user-defined type.
     */
    public UDT(String name)
    {
        this.name = name;
    }

    /**
     * Gets the list of fields in this user-defined type.
     *
     * @return The list of UDF fields.
     */
    public List<UDF> getFields()
    {
        if (fields == null)
        {
            fields = new ArrayList<UDF>();
        }
        return this.fields;
    }

    /**
     * Replicates getFields but allows the UDT to be used by the
     * UDF static helper methods.
     *
     * @return A list of UDFs on this type.
     */
    @Override
    public List<UDF> getUserDefinedFields()
    {
        return getFields();
    }

    /**
     * Adds a UDF to this user-defined type.
     *
     * @param udf The UDF to add.
     * @return The added UDF.
     */
    public UDF addField(UDF udf)
    {
        getFields().add(udf);
        return udf;
    }

    /**
     * Adds a UDF to this user-defined type.
     *
     * @param name The name of the field.
     * @param type The type of the field.
     * @param value The value of the field.
     * @return The added UDF.
     */
    public UDF addField(String name, FieldType type, String value)
    {
        return addField(new UDF(name, type, value));
    }

    /**
     * Gets the name of the user-defined type.
     *
     * @return The name of the user-defined type.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of the user-defined type.
     *
     * @param value The name to set.
     */
    public void setName(String value)
    {
        this.name = value;
    }
}
