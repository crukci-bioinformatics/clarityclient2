
package com.genologics.ri.step;

import java.io.Serial;
import java.io.Serializable;
import java.net.URI;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.LimsLink;
import com.genologics.ri.container.Container;


/**
 * Provides a URI linking to the output container and Tube Rack arrangement.
 *
 * @since 2.34
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "output-arrangement")
public class OutputArrangement implements LimsLink<Container>, Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = -1273770265893773445L;

    /**
     * The rack location for the output arrangement.
     */
    @XmlElement(name = "rack-location")
    protected RackLocation rackLocation;

    /**
     * URI of the output container.
     */
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    /**
     * Default constructor.
     */
    public OutputArrangement()
    {
    }

    /**
     * Constructor with URI.
     *
     * @param uri The URI of the output container.
     */
    public OutputArrangement(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Gets the rack location.
     *
     * @return The rack location.
     */
    public RackLocation getRackLocation()
    {
        return rackLocation;
    }

    /**
     * Sets the rack location.
     *
     * @param rackLocation The rack location.
     */
    public void setRackLocation(RackLocation rackLocation)
    {
        this.rackLocation = rackLocation;
    }

    /**
     * Gets the URI.
     *
     * @return The URI.
     */
    public URI getUri()
    {
        return uri;
    }

    /**
     * Sets the URI.
     *
     * @param uri The URI.
     */
    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    /**
     * Gets the entity class.
     *
     * @return The Container class.
     */
    @Override
    public Class<Container> getEntityClass()
    {
        return Container.class;
    }
}
