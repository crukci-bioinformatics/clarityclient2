
package com.genologics.ri.step;

import java.io.Serializable;
import java.net.URI;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.LimsLink;
import com.genologics.ri.Linkable;


/**
 * Identifies the resource that represents the arrangements (if any) for the step.
 *
 * @since 2.34
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "arrangements-link")
public class ArrangementsLink implements LimsLink<Arrangements>, Serializable
{
    private static final long serialVersionUID = 3342543381947203376L;

    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    public ArrangementsLink()
    {
    }

    public ArrangementsLink(URI uri)
    {
        this.uri = uri;
    }

    public ArrangementsLink(Linkable<Arrangements> arrangements)
    {
        this.uri = arrangements == null ? null : arrangements.getUri();
    }

    @Override
    public URI getUri()
    {
        return uri;
    }

    @Override
    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    @Override
    public Class<Arrangements> getEntityClass()
    {
        return Arrangements.class;
    }
}
