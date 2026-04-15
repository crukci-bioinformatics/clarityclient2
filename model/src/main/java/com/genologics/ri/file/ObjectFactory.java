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

package com.genologics.ri.file;

import static com.genologics.ri.Namespaces.FILE_NAMESPACE;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * Factory class for creating instances of JAXB content classes defined in the
 * {@code com.genologics.ri.file} package.
 * <p>
 * This class is required by JAXB (Java Architecture for XML Binding) and provides
 * factory methods for instantiating JAXB-managed classes and elements within this
 * package. Each factory method constructs new instances of schema-derived classes
 * that represent XML content structures.
 * </p>
 */
@XmlRegistry
public class ObjectFactory
{
    /**
     * The qualified name for the file element.
     */
    private final static QName _File_QNAME = new QName(FILE_NAMESPACE, "file");

    /**
     * The qualified name for the details element.
     */
    private final static QName _Details_QNAME = new QName(FILE_NAMESPACE, "details");

    /**
     * The qualified name for the files element.
     */
    private final static QName _Files_QNAME = new QName(FILE_NAMESPACE, "files");

    /**
     * Creates a new ObjectFactory that can be used to create new instances of
     * schema-derived classes for package: com.genologics.ri.file.
     */
    public ObjectFactory()
    {
    }

    /**
     * Creates a new instance of {@link ClarityFileBatchFetchResult}.
     *
     * @return A new ClarityFileBatchFetchResult instance.
     */
    public ClarityFileBatchFetchResult createDetails()
    {
        return new ClarityFileBatchFetchResult();
    }

    /**
     * Creates a new instance of {@link ClarityFile}.
     *
     * @return A new ClarityFile instance.
     */
    public ClarityFile createFile()
    {
        return new ClarityFile();
    }

    /**
     * Creates a new instance of {@link ClarityFiles}.
     *
     * @return A new ClarityFiles instance.
     */
    public ClarityFiles createFiles()
    {
        return new ClarityFiles();
    }

    /**
     * Creates a new instance of {@link FileLink}.
     *
     * @return A new FileLink instance.
     */
    public FileLink createFileLink()
    {
        return new FileLink();
    }

    /**
     * Creates a JAXBElement wrapping a {@link ClarityFileBatchFetchResult} instance.
     * This method is used by JAXB for marshalling/unmarshalling the details element.
     *
     * @param value The ClarityFileBatchFetchResult instance to wrap.
     *
     * @return A JAXBElement containing the provided value.
     */
    @XmlElementDecl(namespace = FILE_NAMESPACE, name = "details")
    public JAXBElement<ClarityFileBatchFetchResult> createDetails(ClarityFileBatchFetchResult value)
    {
        return new JAXBElement<ClarityFileBatchFetchResult>(_Details_QNAME, ClarityFileBatchFetchResult.class, null, value);
    }

    /**
     * Creates a JAXBElement wrapping a {@link ClarityFile} instance.
     * This method is used by JAXB for marshalling/unmarshalling the file element.
     *
     * @param value The ClarityFile instance to wrap.
     *
     * @return A JAXBElement containing the provided value.
     */
    @XmlElementDecl(namespace = FILE_NAMESPACE, name = "file")
    public JAXBElement<ClarityFile> createFile(ClarityFile value)
    {
        return new JAXBElement<ClarityFile>(_File_QNAME, ClarityFile.class, null, value);
    }

    /**
     * Creates a JAXBElement wrapping a {@link ClarityFiles} instance.
     * This method is used by JAXB for marshalling/unmarshalling the files element.
     *
     * @param value The ClarityFiles instance to wrap.
     *
     * @return A JAXBElement containing the provided value.
     */
    @XmlElementDecl(namespace = FILE_NAMESPACE, name = "files")
    public JAXBElement<ClarityFiles> createFiles(ClarityFiles value)
    {
        return new JAXBElement<ClarityFiles>(_Files_QNAME, ClarityFiles.class, null, value);
    }
}
