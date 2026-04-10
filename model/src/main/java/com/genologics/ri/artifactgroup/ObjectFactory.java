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

package com.genologics.ri.artifactgroup;

import static com.genologics.ri.Namespaces.ARTIFACT_GROUP_NAMESPACE;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * Factory class for creating instances of JAXB content classes defined in the
 * {@code com.genologics.ri.artifactgroup} package.
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
public class ObjectFactory {

    /**
     * QName for artifactgroup element.
     */
    private final static QName _Artifactgroup_QNAME = new QName(ARTIFACT_GROUP_NAMESPACE, "artifactgroup");

    /**
     * QName for artifactgroups element.
     */
    private final static QName _Artifactgroups_QNAME = new QName(ARTIFACT_GROUP_NAMESPACE, "artifactgroups");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.genologics.ri.artifactgroup
     *
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ArtifactGroup}.
     *
     * @return A new ArtifactGroup instance.
     */
    public ArtifactGroup createArtifactgroup() {
        return new ArtifactGroup();
    }

    /**
     * Create an instance of {@link ArtifactGroupLink}.
     *
     * @return A new ArtifactGroupLink instance.
     */
    public ArtifactGroupLink createArtifactgroupLink() {
        return new ArtifactGroupLink();
    }

    /**
     * Create an instance of {@link Artifacts}.
     *
     * @return A new Artifacts instance.
     */
    public Artifacts createArtifacts() {
        return new Artifacts();
    }

    /**
     * Create an instance of {@link ArtifactGroups}.
     *
     * @return A new ArtifactGroups instance.
     */
    public ArtifactGroups createArtifactgroups() {
        return new ArtifactGroups();
    }

    /**
     * Create an instance of {@link JAXBElement}&lt;{@link ArtifactGroup}&gt;.
     *
     * @param value The ArtifactGroup value to wrap.
     * @return A JAXBElement wrapping the ArtifactGroup.
     */
    @XmlElementDecl(namespace = ARTIFACT_GROUP_NAMESPACE, name = "artifactgroup")
    public JAXBElement<ArtifactGroup> createArtifactgroup(ArtifactGroup value) {
        return new JAXBElement<ArtifactGroup>(_Artifactgroup_QNAME, ArtifactGroup.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement}&lt;{@link ArtifactGroups}&gt;.
     *
     * @param value The ArtifactGroups value to wrap.
     * @return A JAXBElement wrapping the ArtifactGroups.
     */
    @XmlElementDecl(namespace = ARTIFACT_GROUP_NAMESPACE, name = "artifactgroups")
    public JAXBElement<ArtifactGroups> createArtifactgroups(ArtifactGroups value) {
        return new JAXBElement<ArtifactGroups>(_Artifactgroups_QNAME, ArtifactGroups.class, null, value);
    }
}
