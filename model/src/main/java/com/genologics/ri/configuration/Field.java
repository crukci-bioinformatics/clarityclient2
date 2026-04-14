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

import java.io.Serial;
import java.io.Serializable;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.ClarityEntity;
import com.genologics.ri.LimsLink;
import com.genologics.ri.Link;
import com.genologics.ri.Linkable;

/**
 *
 * The detailed representation of the configuration of a user-defined field.
 */
@ClarityEntity(uriSection = "configuration/udfs", updateable = true)
@XmlRootElement(name = "field")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "field",
         propOrder = { "name", "attachToName", "precision", "unitLabel", "typeDefinition", "showInLablink",
                       "allowNonPresetValues", "firstPresetIsDefaultValue", "dynamicPresets", "showInTables", "editable",
                       "deviation", "controlledVocabulary", "parentUri", "childUris", "presets",
                       "minValue", "maxValue", "required", "attachToCategory" })
public class Field implements Linkable<Field>, Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = -1997333408044717019L;

    /**
     * The name of the field.
     */
    @XmlElement(name = "name")
    protected String name;

    /**
     * The name of the entity type this field is attached to.
     */
    @XmlElement(name = "attach-to-name")
    protected String attachToName;

    /**
     * The display precision for numeric fields.
     */
    @XmlElement(name = "precision")
    protected Integer precision;

    /**
     * The unit label for numeric fields.
     */
    @XmlElement(name = "unit")
    protected String unitLabel;

    /**
     * The type definition for complex types.
     */
    @XmlElement(name = "type-definition")
    protected TypeDefinition typeDefinition;

    /**
     * Whether this field should be shown in Lablink.
     */
    @XmlElement(name = "show-in-lablink")
    protected Boolean showInLablink;

    /**
     * Whether values other than preset values are allowed.
     */
    @XmlElement(name = "allow-non-preset-values")
    protected Boolean allowNonPresetValues;

    /**
     * Whether the first preset value is the default.
     */
    @XmlElement(name = "first-preset-is-default-value")
    protected Boolean firstPresetIsDefaultValue;

    /**
     * Whether this field uses dynamic presets.
     *
     * @since 2.34
     */
    @XmlElement(name = "is-dynamic-presets")
    protected Boolean dynamicPresets;

    /**
     * Whether this field should be shown in tables.
     */
    @XmlElement(name = "show-in-tables")
    protected Boolean showInTables;

    /**
     * Whether this field is editable.
     */
    @XmlElement(name = "is-editable")
    protected Boolean editable;

    /**
     * Whether this field represents a deviation.
     */
    @XmlElement(name = "is-deviation")
    protected Boolean deviation;

    /**
     * Whether this field uses a controlled vocabulary.
     */
    @XmlElement(name = "is-controlled-vocabulary")
    protected Boolean controlledVocabulary;

    /**
     * The URI of the parent field for hierarchical fields.
     */
    @XmlElement(name = "parent-uri")
    @XmlSchemaType(name = "anyURI")
    protected URI parentUri;

    /**
     * The URIs of child fields for hierarchical fields.
     */
    @XmlElement(name = "child-uri")
    protected List<String> childUris;

    /**
     * The list of preset values for this field.
     */
    @XmlElement(name = "preset")
    protected List<String> presets;

    /**
     * The minimum value for numeric fields.
     */
    @XmlElement(name = "min-value")
    protected Double minValue;

    /**
     * The maximum value for numeric fields.
     */
    @XmlElement(name = "max-value")
    protected Double maxValue;

    /**
     * Whether this field is required.
     */
    @XmlElement(name = "is-required")
    protected Boolean required;

    /**
     * The category this field is attached to.
     */
    @XmlElement(name = "attach-to-category")
    protected String attachToCategory;

    /**
     * The type of this field.
     */
    @XmlAttribute(name = "type")
    protected FieldType type;

    /**
     * The URI of this field configuration.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * Constructor for creating an empty Field object.
     */
    public Field()
    {
    }

    /**
     * Convenience method for getting the field's id from its URI.
     *
     * @return The fields id. Will be null if this object has no URI.
     */
    public String getId()
    {
        return uri == null ? null : Link.limsIdFromUri(uri);
    }

    /**
     * Gets the list of child URIs for hierarchical fields.
     * Creates a new list if one doesn't exist.
     *
     * @return The list of child URIs.
     */
    public List<String> getChildUris()
    {
        if (childUris == null)
        {
            childUris = new ArrayList<String>();
        }
        return childUris;
    }

    /**
     * Gets the list of preset values for this field.
     * Creates a new list if one doesn't exist.
     *
     * @return The list of preset values.
     */
    public List<String> getPresets()
    {
        if (presets == null)
        {
            presets = new ArrayList<String>();
        }
        return presets;
    }

    /**
     * Gets the name of this field.
     *
     * @return The field name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of this field.
     *
     * @param name The field name.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Gets the name of the entity type this field is attached to.
     *
     * @return The entity type name.
     */
    public String getAttachToName()
    {
        return attachToName;
    }

    /**
     * Sets the name of the entity type this field is attached to.
     *
     * @param attachToName The entity type name.
     */
    public void setAttachToName(String attachToName)
    {
        this.attachToName = attachToName;
    }

    /**
     * Gets the display precision for numeric fields.
     *
     * @return The display precision.
     */
    public Integer getDisplayPrecision()
    {
        return precision;
    }

    /**
     * Sets the display precision for numeric fields.
     *
     * @param precision The display precision.
     */
    public void setDisplayPrecision(Integer precision)
    {
        this.precision = precision;
    }

    /**
     * Gets the unit label for numeric fields.
     *
     * @return The unit label.
     */
    public String getUnitLabel()
    {
        return unitLabel;
    }

    /**
     * Sets the unit label for numeric fields.
     *
     * @param unit The unit label.
     */
    public void setUnitLabel(String unit)
    {
        this.unitLabel = unit;
    }

    /**
     * Gets the type definition for complex types.
     *
     * @return The type definition.
     */
    public TypeDefinition getTypeDefinition()
    {
        return typeDefinition;
    }

    /**
     * Sets the type definition for complex types.
     *
     * @param typeDefinition The type definition.
     */
    public void setTypeDefinition(TypeDefinition typeDefinition)
    {
        this.typeDefinition = typeDefinition;
    }

    /**
     * Checks if this field should be shown in Lablink.
     *
     * @return {@code true} if the field should be shown in Lablink, {@code false} otherwise.
     */
    public boolean isShowInLablink()
    {
        return showInLablink == null ? false : showInLablink.booleanValue();
    }

    /**
     * Sets whether this field should be shown in Lablink.
     *
     * @param showInLablink {@code true} to show in Lablink, {@code false} otherwise.
     */
    public void setShowInLablink(Boolean showInLablink)
    {
        this.showInLablink = showInLablink;
    }

    /**
     * Checks if values other than preset values are allowed.
     *
     * @return {@code true} if non-preset values are allowed, {@code false} otherwise.
     */
    public boolean isAllowNonPresetValues()
    {
        return allowNonPresetValues == null ? false : allowNonPresetValues.booleanValue();
    }

    /**
     * Sets whether values other than preset values are allowed.
     *
     * @param allowNonPresetValues {@code true} to allow non-preset values, {@code false} otherwise.
     */
    public void setAllowNonPresetValues(Boolean allowNonPresetValues)
    {
        this.allowNonPresetValues = allowNonPresetValues;
    }

    /**
     * Checks if the first preset value is the default.
     *
     * @return {@code true} if the first preset is the default, {@code false} otherwise.
     */
    public boolean isFirstPresetDefaultValue()
    {
        return firstPresetIsDefaultValue == null ? false : firstPresetIsDefaultValue.booleanValue();
    }

    /**
     * Sets whether the first preset value is the default.
     *
     * @param firstPresetIsDefaultValue {@code true} to make first preset the default, {@code false} otherwise.
     */
    public void setFirstPresetDefaultValue(Boolean firstPresetIsDefaultValue)
    {
        this.firstPresetIsDefaultValue = firstPresetIsDefaultValue;
    }

    /**
     * Checks if this field uses dynamic presets.
     *
     * @return {@code true} if dynamic presets are used, {@code false} otherwise.
     */
    public boolean isDynamicPresets()
    {
        return dynamicPresets == null ? false : dynamicPresets.booleanValue();
    }

    /**
     * Sets whether this field uses dynamic presets.
     *
     * @param isDynamicPresets {@code true} to use dynamic presets, {@code false} otherwise.
     */
    public void setDynamicPresets(Boolean isDynamicPresets)
    {
        this.dynamicPresets = isDynamicPresets;
    }

    /**
     * Checks if this field should be shown in tables.
     *
     * @return {@code true} if the field should be shown in tables, {@code false} otherwise.
     */
    public boolean isShowInTables()
    {
        return showInTables == null ? false : showInTables.booleanValue();
    }

    /**
     * Sets whether this field should be shown in tables.
     *
     * @param showInTables {@code true} to show in tables, {@code false} otherwise.
     */
    public void setShowInTables(Boolean showInTables)
    {
        this.showInTables = showInTables;
    }

    /**
     * Checks if this field is editable.
     *
     * @return {@code true} if the field is editable, {@code false} otherwise.
     */
    public boolean isEditable()
    {
        return editable == null ? false : editable.booleanValue();
    }

    /**
     * Sets whether this field is editable.
     *
     * @param editable {@code true} to make the field editable, {@code false} otherwise.
     */
    public void setEditable(Boolean editable)
    {
        this.editable = editable;
    }

    /**
     * Checks if this field represents a deviation.
     *
     * @return {@code true} if this is a deviation field, {@code false} otherwise.
     */
    public boolean isDeviation()
    {
        return deviation == null ? false : deviation.booleanValue();
    }

    /**
     * Sets whether this field represents a deviation.
     *
     * @param deviation {@code true} to mark as deviation, {@code false} otherwise.
     */
    public void setDeviation(Boolean deviation)
    {
        this.deviation = deviation;
    }

    /**
     * Checks if this field uses a controlled vocabulary.
     *
     * @return {@code true} if controlled vocabulary is used, {@code false} otherwise.
     */
    public boolean isControlledVocabulary()
    {
        return controlledVocabulary == null ? false : controlledVocabulary.booleanValue();
    }

    /**
     * Sets whether this field uses a controlled vocabulary.
     *
     * @param controlledVocabulary {@code true} to use controlled vocabulary, {@code false} otherwise.
     */
    public void setControlledVocabulary(Boolean controlledVocabulary)
    {
        this.controlledVocabulary = controlledVocabulary;
    }

    /**
     * Gets the URI of the parent field for hierarchical fields.
     *
     * @return The parent URI.
     */
    public URI getParentUri()
    {
        return parentUri;
    }

    /**
     * Sets the URI of the parent field for hierarchical fields.
     *
     * @param parentUri The parent URI.
     */
    public void setParentUri(URI parentUri)
    {
        this.parentUri = parentUri;
    }

    /**
     * Gets the minimum value for numeric fields.
     *
     * @return The minimum value.
     */
    public Double getMinValue()
    {
        return minValue;
    }

    /**
     * Sets the minimum value for numeric fields.
     *
     * @param minValue The minimum value.
     */
    public void setMinValue(Double minValue)
    {
        this.minValue = minValue;
    }

    /**
     * Gets the maximum value for numeric fields.
     *
     * @return The maximum value.
     */
    public Double getMaxValue()
    {
        return maxValue;
    }

    /**
     * Sets the maximum value for numeric fields.
     *
     * @param maxValue The maximum value.
     */
    public void setMaxValue(Double maxValue)
    {
        this.maxValue = maxValue;
    }

    /**
     * Checks if this field is required.
     *
     * @return {@code true} if the field is required, {@code false} otherwise.
     */
    public boolean isRequired()
    {
        return required == null ? false : required.booleanValue();
    }

    /**
     * Sets whether this field is required.
     *
     * @param required {@code true} to make the field required, {@code false} otherwise.
     */
    public void setRequired(Boolean required)
    {
        this.required = required;
    }

    /**
     * Gets the category this field is attached to.
     *
     * @return The category name.
     */
    public String getAttachToCategory()
    {
        return attachToCategory;
    }

    /**
     * Sets the category this field is attached to.
     *
     * @param attachToCategory The category name.
     */
    public void setAttachToCategory(String attachToCategory)
    {
        this.attachToCategory = attachToCategory;
    }

    /**
     * Gets the type of this field.
     *
     * @return The field type.
     */
    public FieldType getType()
    {
        return type;
    }

    /**
     * Sets the type of this field.
     *
     * @param type The field type.
     */
    public void setType(FieldType type)
    {
        this.type = type;
    }

    /**
     * Gets the URI of this field configuration.
     *
     * @return The URI.
     */
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI of this field configuration.
     *
     * @param uri The URI.
     */
    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LimsLink<Field> getLink()
    {
        return new FieldLink(this);
    }
}
