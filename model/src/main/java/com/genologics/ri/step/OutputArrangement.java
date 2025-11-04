
package com.genologics.ri.step;

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
    private static final long serialVersionUID = -1273770265893773445L;

    @XmlElement(name = "rack-location")
    protected RackLocation rackLocation;

    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    public OutputArrangement()
    {
    }

    public OutputArrangement(URI uri)
    {
        this.uri = uri;
    }

    public RackLocation getRackLocation()
    {
        return rackLocation;
    }

    public void setRackLocation(RackLocation rackLocation)
    {
        this.rackLocation = rackLocation;
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
    public Class<Container> getEntityClass()
    {
        return Container.class;
    }
}
