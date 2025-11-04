
package com.genologics.ri.step;

import static java.util.Objects.requireNonNull;
import static org.apache.commons.lang3.StringUtils.SPACE;

import java.io.Serializable;
import java.net.URI;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import com.genologics.ri.LimsLink;
import com.genologics.ri.Linkable;
import com.genologics.ri.researcher.Researcher;


/**
 * Technician is a child element of Step and provides a URI linking to the detailed representation of the technician that ran the Step.
 *
 * @since 2.34
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "technician", propOrder = { "firstName", "lastName" })
public class Technician implements LimsLink<Researcher>, Serializable
{
    @XmlElement(name = "first-name")
    protected String firstName;

    @XmlElement(name = "last-name")
    protected String lastName;

    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    public Technician()
    {
    }

    public Technician(URI uri)
    {
        this.uri = uri;
    }

    public Technician(Linkable<Researcher> technician)
    {
        requireNonNull(technician, "technician cannot be null");
        this.uri = technician.getUri();
    }

    public Technician(Researcher technician)
    {
        requireNonNull(technician, "technician cannot be null");
        this.uri = technician.getUri();
        this.firstName = technician.getFirstName();
        this.lastName = technician.getLastName();
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
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
    public Class<Researcher> getEntityClass()
    {
        return Researcher.class;
    }

    @Override
    public String toString()
    {
        return firstName + SPACE + lastName;
    }
}
