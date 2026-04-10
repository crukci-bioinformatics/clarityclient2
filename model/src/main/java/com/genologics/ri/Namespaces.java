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

package com.genologics.ri;

import static org.apache.commons.lang3.StringUtils.EMPTY;

import jakarta.xml.bind.annotation.XmlSchema;

/**
 * Static list of all the namespaces in the Genologics API.
 */
public final class Namespaces
{
    /**
     * The root namespace.
     */
    public static final String ROOT_NAMESPACE = "http://genologics.com/ri";
    /**
     * The artifact namespace.
     */
    public static final String ARTIFACT_NAMESPACE = "http://genologics.com/ri/artifact";
    /**
     * The artifact group namespace.
     */
    public static final String ARTIFACT_GROUP_NAMESPACE = "http://genologics.com/ri/artifactgroup";
    /**
     * The automation namespace.
     */
    public static final String AUTOMATION_NAMESPACE = "http://genologics.com/ri/automation";
    /**
     * The configuration namespace.
     */
    public static final String CONFIGURATION_NAMESPACE = "http://genologics.com/ri/configuration";
    /**
     * The container namespace.
     */
    public static final String CONTAINER_NAMESPACE = "http://genologics.com/ri/container";
    /**
     * The container type namespace.
     */
    public static final String CONTAINER_TYPE_NAMESPACE = "http://genologics.com/ri/containertype";
    /**
     * The control type namespace.
     */
    public static final String CONTROL_TYPE_NAMESPACE = "http://genologics.com/ri/controltype";
    /**
     * The exception namespace.
     */
    public static final String EXCEPTION_NAMESPACE = "http://genologics.com/ri/exception";
    /**
     * The file namespace.
     */
    public static final String FILE_NAMESPACE = "http://genologics.com/ri/file";
    /**
     * The global token namespace.
     */
    public static final String GLOBAL_TOKEN_NAMESPACE = "http://genologics.com/ri/globaltoken";
    /**
     * The instrument namespace.
     */
    public static final String INSTRUMENT_NAMESPACE = "http://genologics.com/ri/instrument";
    /**
     * The instrument type namespace.
     */
    public static final String INSTRUMENT_TYPE_NAMESPACE = "http://genologics.com/ri/instrumenttype";
    /**
     * The lab namespace.
     */
    public static final String LAB_NAMESPACE = "http://genologics.com/ri/lab";
    /**
     * The permission namespace.
     */
    public static final String PERMISSION_NAMESPACE = "http://genologics.com/ri/permission";
    /**
     * The process namespace.
     */
    public static final String PROCESS_NAMESPACE = "http://genologics.com/ri/process";
    /**
     * The process execution namespace.
     */
    public static final String PROCESS_EXECUTION_NAMESPACE = "http://genologics.com/ri/processexecution";
    /**
     * The process template namespace.
     */
    public static final String PROCESS_TEMPLATE_NAMESPACE = "http://genologics.com/ri/processtemplate";
    /**
     * The process type namespace.
     */
    public static final String PROCESS_TYPE_NAMESPACE = "http://genologics.com/ri/processtype";
    /**
     * The project namespace.
     */
    public static final String PROJECT_NAMESPACE = "http://genologics.com/ri/project";
    /**
     * The property namespace.
     */
    public static final String PROPERTY_NAMESPACE = "http://genologics.com/ri/property";
    /**
     * The protocol configuration namespace.
     */
    public static final String PROTOCOL_CONFIGURATION_NAMESPACE = "http://genologics.com/ri/protocolconfiguration";
    /**
     * The queue namespace.
     */
    public static final String QUEUE_NAMESPACE = "http://genologics.com/ri/queue";
    /**
     * The reagent kit namespace.
     */
    public static final String REAGENT_KIT_NAMESPACE = "http://genologics.com/ri/reagentkit";
    /**
     * The reagent lot namespace.
     */
    public static final String REAGENT_LOT_NAMESPACE = "http://genologics.com/ri/reagentlot";
    /**
     * The reagent type namespace.
     */
    public static final String REAGENT_TYPE_NAMESPACE = "http://genologics.com/ri/reagenttype";
    /**
     * The role namespace.
     */
    public static final String ROLE_NAMESPACE = "http://genologics.com/ri/role";
    /**
     * The routing namespace.
     */
    public static final String ROUTING_NAMESPACE = "http://genologics.com/ri/routing";
    /**
     * The researcher namespace.
     */
    public static final String RESEARCHER_NAMESPACE = "http://genologics.com/ri/researcher";
    /**
     * The sample namespace.
     */
    public static final String SAMPLE_NAMESPACE = "http://genologics.com/ri/sample";
    /**
     * The saved query namespace.
     */
    public static final String SAVED_QUERY_NAMESPACE = "http://genologics.com/ri/savedquery";
    /**
     * The stage namespace.
     */
    public static final String STAGE_NAMESPACE = "http://genologics.com/ri/stage";
    /**
     * The step namespace.
     */
    public static final String STEP_NAMESPACE = "http://genologics.com/ri/step";
    /**
     * The step configuration namespace.
     */
    public static final String STEP_CONFIGURATION_NAMESPACE = "http://genologics.com/ri/stepconfiguration";
    /**
     * The user-defined field (UDF) namespace.
     */
    public static final String UDF_NAMESPACE = "http://genologics.com/ri/userdefined";
    /**
     * The version namespace.
     */
    public static final String VERSION_NAMESPACE = "http://genologics.com/ri/version";
    /**
     * The workflow configuration namespace.
     */
    public static final String WORKFLOW_CONFIGURATION_NAMESPACE = "http://genologics.com/ri/workflowconfiguration";

    /**
     * The empty namespace. Used for some inner elements.
     */
    public static final String EMPTY_NAMESPACE = EMPTY;

    /**
     * Private constructor to prevent instantiation.
     */
    private Namespaces()
    {
    }

    /**
     * Extract package level information for the named package.
     * No longer used, but kept for reference.
     *
     * @param packageName The name of the package to interrogate.
     *
     * @return The namespace attribute on the package's XmlSchema annotation.
     */
    @SuppressWarnings("unused")
    private static String findNamespace(String packageName)
    {
        Class<?> objectFactoryClass;
        try
        {
            objectFactoryClass = Class.forName(packageName + ".ObjectFactory");
        }
        catch (ClassNotFoundException e)
        {
            throw new AssertionError("No ObjectFactory class in package " + packageName);
        }

        Package p = objectFactoryClass.getPackage(); // Package.getPackage(packageName);
        if (p == null)
        {
            throw new NullPointerException("There is no package '" + packageName + "'.");
        }
        XmlSchema a = p.getAnnotation(XmlSchema.class);
        if (a == null)
        {
            throw new NullPointerException("There is no XmlSchema annotation on the package '" + packageName + "'.");
        }
        String ns = a.namespace();
        if (ns == null)
        {
            throw new NullPointerException("There is no namespace set on the package '" + packageName + "'.");
        }
        return ns;
    }
}
