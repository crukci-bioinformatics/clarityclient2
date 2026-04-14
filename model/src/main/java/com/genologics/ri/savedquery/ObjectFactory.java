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

package com.genologics.ri.savedquery;

import static com.genologics.ri.Namespaces.SAVED_QUERY_NAMESPACE;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * Factory class for creating instances of JAXB content classes defined in the
 * {@code com.genologics.ri.savedquery} package.
 * <p>
 * This class is required by JAXB (Java Architecture for XML Binding) and provides
 * factory methods for instantiating JAXB-managed classes and elements within this
 * package. Each factory method constructs new instances of schema-derived classes
 * that represent XML content structures.
 * </p>
 * <p>
 * The {@code @XmlRegistry} annotation marks this class as a JAXB object factory,
 * allowing JAXB to discover and use these factory methods during marshalling and
 * unmarshalling operations.
 * </p>
 */
@XmlRegistry
public class ObjectFactory
{
    /**
     * QName for the saved-query XML element.
     */
    private final static QName _SavedQuery_QNAME = new QName(SAVED_QUERY_NAMESPACE, "saved-query");

    /**
     * QName for the saved-queries XML element.
     */
    private final static QName _SavedQueries_QNAME = new QName(SAVED_QUERY_NAMESPACE, "saved-queries");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.genologics.ri.savedquery
     *
     */
    public ObjectFactory()
    {
    }

    /**
     * Create an instance of {@link SavedQuery}.
     *
     * @return The new instance of {@link SavedQuery}.
     */
    public SavedQuery createSavedQuery()
    {
        return new SavedQuery();
    }

    /**
     * Create an instance of {@link SavedQueries}.
     *
     * @return The new instance of {@link SavedQueries}.
     */
    public SavedQueries createSavedQueries()
    {
        return new SavedQueries();
    }

    /**
     * Create an instance of {@link SavedQueryLink}.
     *
     * @return The new instance of {@link SavedQueryLink}.
     */
    public SavedQueryLink createSavedQueryLink()
    {
        return new SavedQueryLink();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SavedQuery }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SavedQuery }{@code >}
     */
    @XmlElementDecl(namespace = SAVED_QUERY_NAMESPACE, name = "saved-query")
    public JAXBElement<SavedQuery> createSavedQuery(SavedQuery value)
    {
        return new JAXBElement<SavedQuery>(_SavedQuery_QNAME, SavedQuery.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SavedQueries }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SavedQueries }{@code >}
     */
    @XmlElementDecl(namespace = SAVED_QUERY_NAMESPACE, name = "saved-queries")
    public JAXBElement<SavedQueries> createSavedQueries(SavedQueries value)
    {
        return new JAXBElement<SavedQueries>(_SavedQueries_QNAME, SavedQueries.class, null, value);
    }

}
