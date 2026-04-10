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

package com.genologics.ri.project;

import static com.genologics.ri.Namespaces.PROJECT_NAMESPACE;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * Factory class for creating instances of JAXB content classes defined in the
 * {@code com.genologics.ri.project} package.
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

    private final static QName _Project_QNAME = new QName(PROJECT_NAMESPACE, "project");
    private final static QName _Projects_QNAME = new QName(PROJECT_NAMESPACE, "projects");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.genologics.ri.project
     *
     */
    public ObjectFactory()
    {
    }

    /**
     * Create an instance of {@link ProjectLink}.
     *
     * @return A new ProjectLink instance.
     */
    public ProjectLink createProjectLink()
    {
        return new ProjectLink();
    }

    /**
     * Create an instance of {@link ResearcherLink}.
     *
     * @return A new ResearcherLink instance.
     */
    public ResearcherLink createResearcher()
    {
        return new ResearcherLink();
    }

    /**
     * Create an instance of {@link Projects}.
     *
     * @return A new Projects instance.
     */
    public Projects createProjects()
    {
        return new Projects();
    }

    /**
     * Create an instance of {@link Project}.
     *
     * @return A new Project instance.
     */
    public Project createProject()
    {
        return new Project();
    }

    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link Project}{@code >}.
     *
     * @param value The Project to wrap.
     *
     * @return A JAXBElement wrapping the Project.
     */
    @XmlElementDecl(namespace = PROJECT_NAMESPACE, name = "project")
    public JAXBElement<Project> createProject(Project value)
    {
        return new JAXBElement<Project>(_Project_QNAME, Project.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link Projects}{@code >}.
     *
     * @param value The Projects to wrap.
     *
     * @return A JAXBElement wrapping the Projects.
     */
    @XmlElementDecl(namespace = PROJECT_NAMESPACE, name = "projects")
    public JAXBElement<Projects> createProjects(Projects value)
    {
        return new JAXBElement<Projects>(_Projects_QNAME, Projects.class, null, value);
    }
}
