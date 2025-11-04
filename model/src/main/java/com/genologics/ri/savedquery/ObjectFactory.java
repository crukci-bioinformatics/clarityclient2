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
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the com.genologics.ri.savedquery package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 *
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SavedQuery_QNAME = new QName(SAVED_QUERY_NAMESPACE, "saved-query");
    private final static QName _SavedQueries_QNAME = new QName(SAVED_QUERY_NAMESPACE, "saved-queries");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.genologics.ri.savedquery
     *
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SavedQuery }
     *
     */
    public SavedQuery createSavedQuery() {
        return new SavedQuery();
    }

    /**
     * Create an instance of {@link SavedQueries }
     *
     */
    public SavedQueries createSavedQueries() {
        return new SavedQueries();
    }

    /**
     * Create an instance of {@link SavedQueryLink }
     *
     */
    public SavedQueryLink createSavedQueryLink() {
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
    public JAXBElement<SavedQuery> createSavedQuery(SavedQuery value) {
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
    public JAXBElement<SavedQueries> createSavedQueries(SavedQueries value) {
        return new JAXBElement<SavedQueries>(_SavedQueries_QNAME, SavedQueries.class, null, value);
    }

}
