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

package com.genologics.ri.container;

import static com.genologics.ri.Namespaces.UDF_NAMESPACE;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

import java.io.Serializable;
import java.net.URI;
import java.util.ArrayList;
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
import com.genologics.ri.LimsEntity;
import com.genologics.ri.LimsEntityLink;
import com.genologics.ri.LimsEntityLinkable;
import com.genologics.ri.Linkable;
import com.genologics.ri.artifact.Artifact;
import com.genologics.ri.containertype.ContainerType;
import com.genologics.ri.userdefined.UDF;
import com.genologics.ri.userdefined.UDFHolder;
import com.genologics.ri.userdefined.UDT;

/**
 * Container entity representing a physical container in the Clarity LIMS.
 */
@ClarityEntity(uriSection = "containers", creatable = true, updateable = true, removable = true)
@XmlRootElement(name = "container")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "container",
         propOrder = { "name", "containerType", "occupiedWells", "placements", "type", "fields", "state" })
public class Container implements LimsEntity<Container>, UDFHolder, Serializable
{
    /**
     * Class version for serialisation.
     */
    @java.io.Serial
    private static final long serialVersionUID = -5274665844559069140L;

    /**
     * The name of the container.
     */
    @XmlElement(name = "name")
    protected String name;

    /**
     * Link to the container type.
     */
    @XmlElement(name = "type")
    protected ContainerTypeLink containerType;

    /**
     * The number of occupied wells in the container.
     */
    @XmlElement(name = "occupied-wells")
    protected Long occupiedWells;

    /**
     * The list of placements in the container.
     */
    @XmlElement(name = "placement")
    protected List<Placement> placements;

    /**
     * The user-defined type for the container.
     */
    @XmlElement(name = "type", namespace = UDF_NAMESPACE)
    protected UDT type;

    /**
     * The list of user-defined fields for the container.
     */
    @XmlElement(name = "field", namespace = UDF_NAMESPACE)
    protected List<UDF> fields;

    /**
     * Container state. Note this has changed from a string to an enum from
     * release 2.31.6.
     */
    @XmlElement(name = "state")
    protected ContainerState state;

    /**
     * The LIMS id of the container.
     */
    @XmlAttribute(name = "limsid")
    protected String limsid;

    /**
     * The URI of the container.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * Default constructor.
     */
    public Container()
    {
    }

    /**
     * Constructor with container type link.
     *
     * @param containerType the container type link.
     */
    public Container(Linkable<ContainerType> containerType)
    {
        setContainerType(containerType);
    }

    /**
     * Constructor with container type link and name.
     *
     * @param containerType the container type link.
     * @param name the name of the container.
     */
    public Container(Linkable<ContainerType> containerType, String name)
    {
        setContainerType(containerType);
        setName(name);
    }

    /**
     * Constructor with container type.
     *
     * @param containerType the container type.
     */
    public Container(ContainerType containerType)
    {
        setContainerType(containerType);
    }

    /**
     * Constructor with container type and name.
     *
     * @param containerType the container type.
     * @param name the name of the container.
     */
    public Container(ContainerType containerType, String name)
    {
        setContainerType(containerType);
        setName(name);
    }

    /**
     * Gets the LIMS id.
     *
     * @return the LIMS id.
     */
    public String getLimsid()
    {
        return limsid;
    }

    /**
     * Sets the LIMS id.
     *
     * @param value the LIMS id.
     */
    public void setLimsid(String value)
    {
        this.limsid = value;
    }

    /**
     * Gets the URI.
     *
     * @return the URI.
     */
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI.
     *
     * @param value the URI.
     */
    public void setUri(URI value)
    {
        this.uri = value;
    }

    /**
     * Gets the name.
     *
     * @return the name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name the name.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Gets the container type link.
     *
     * @return the container type link.
     */
    public ContainerTypeLink getContainerType()
    {
        return containerType;
    }

    /**
     * Sets the container type from a linkable.
     *
     * @param link the linkable container type.
     */
    public void setContainerType(Linkable<ContainerType> link)
    {
        this.containerType = new ContainerTypeLink(link);
    }

    /**
     * Sets the container type.
     *
     * @param containerType the container type.
     */
    public void setContainerType(ContainerType containerType)
    {
        this.containerType = new ContainerTypeLink(containerType);
    }

    /**
     * Gets the number of occupied wells.
     *
     * @return the number of occupied wells.
     */
    public Long getOccupiedWells()
    {
        return occupiedWells;
    }

    /**
     * Sets the number of occupied wells.
     *
     * @param occupiedWells the number of occupied wells.
     */
    public void setOccupiedWells(Long occupiedWells)
    {
        this.occupiedWells = occupiedWells;
    }

    /**
     * Gets the list of placements.
     *
     * @return the list of placements.
     */
    public List<Placement> getPlacements()
    {
        if (placements == null)
        {
            placements = new ArrayList<Placement>();
        }
        return placements;
    }

    /**
     * Sets the placements from a collection of artifact links.
     *
     * @param links the collection of artifact links.
     */
    public void setPlacements(Collection<? extends LimsEntityLinkable<Artifact>> links)
    {
        getPlacements().clear();
        for (LimsEntityLinkable<Artifact> link : links)
        {
            placements.add(new Placement(link));
        }
    }

    /**
     * Adds a placement to the container.
     *
     * @param p the placement to add.
     * @return the added placement.
     */
    public Placement addPlacement(Placement p)
    {
        getPlacements().add(p);
        return p;
    }

    /**
     * Adds a placement to the container with an artifact and well position.
     *
     * @param artifact the artifact to place.
     * @param wellPosition the well position.
     * @return the added placement.
     */
    public Placement addPlacement(LimsEntityLinkable<Artifact> artifact, String wellPosition)
    {
        Placement p = new Placement(artifact, wellPosition);
        getPlacements().add(p);
        return p;
    }

    /**
     * Gets the user-defined type.
     *
     * @return the user-defined type.
     */
    public UDT getUserDefinedType()
    {
        return type;
    }

    /**
     * Sets the user-defined type.
     *
     * @param type the user-defined type.
     * @return the user-defined type.
     */
    public UDT setUserDefinedType(UDT type)
    {
        this.type = type;
        return this.type;
    }

    /**
     * Sets the user-defined type from a string.
     *
     * @param type the type name.
     * @return the user-defined type.
     */
    public UDT setUserDefinedType(String type)
    {
        this.type = new UDT(type);
        return this.type;
    }

    /**
     * Gets the list of user-defined fields.
     *
     * @return the list of user-defined fields.
     */
    @Override
    public List<UDF> getUserDefinedFields()
    {
        if (fields == null)
        {
            fields = new ArrayList<>();
        }
        return fields;
    }

    /**
     * Gets the container state.
     *
     * @return the container state.
     */
    public ContainerState getState()
    {
        return state;
    }

    /**
     * Sets the container state.
     *
     * @param state the container state.
     */
    public void setState(ContainerState state)
    {
        this.state = state;
    }

    /**
     * Returns a string representation of the container.
     *
     * @return a string representation.
     */
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(limsid);
        if (isNotBlank(name))
        {
            sb.append(' ').append(name);
        }
        if (containerType != null)
        {
            sb.append(' ').append(containerType.getName());
        }
        return sb.toString();
    }

    /**
     * Gets a link to this container.
     *
     * @return a link to this container.
     */
    @Override
    public LimsEntityLink<Container> getLink()
    {
        return new ContainerLink(this);
    }
}
