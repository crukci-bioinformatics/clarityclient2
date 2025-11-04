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

package com.genologics.ri.globaltoken;

import static com.genologics.ri.Namespaces.*;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the com.genologics.ri.globaltoken package.
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

    private final static QName _GlobalToken_QNAME = new QName(GLOBAL_TOKEN_NAMESPACE, "global-token");
    private final static QName _GlobalTokens_QNAME = new QName(GLOBAL_TOKEN_NAMESPACE, "global-tokens");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.genologics.ri.globaltoken
     *
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GlobalToken }
     *
     */
    public GlobalToken createGlobalToken() {
        return new GlobalToken();
    }

    /**
     * Create an instance of {@link GlobalTokens }
     *
     */
    public GlobalTokens createGlobalTokens() {
        return new GlobalTokens();
    }

    /**
     * Create an instance of {@link GlobalTokenLink }
     *
     */
    public GlobalTokenLink createGlobalTokenLink() {
        return new GlobalTokenLink();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GlobalToken }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GlobalToken }{@code >}
     */
    @XmlElementDecl(namespace = GLOBAL_TOKEN_NAMESPACE, name = "global-token")
    public JAXBElement<GlobalToken> createGlobalToken(GlobalToken value) {
        return new JAXBElement<GlobalToken>(_GlobalToken_QNAME, GlobalToken.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GlobalTokens }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GlobalTokens }{@code >}
     */
    @XmlElementDecl(namespace = GLOBAL_TOKEN_NAMESPACE, name = "global-tokens")
    public JAXBElement<GlobalTokens> createGlobalTokens(GlobalTokens value) {
        return new JAXBElement<GlobalTokens>(_GlobalTokens_QNAME, GlobalTokens.class, null, value);
    }
}
