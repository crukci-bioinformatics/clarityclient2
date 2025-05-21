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

package com.genologics.ri.jaxb;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;

import javax.xml.transform.stream.StreamSource;

import jakarta.xml.bind.JAXBElement;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.oxm.Unmarshaller;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.genologics.ri.BatchUpdate;
import com.genologics.ri.LimsEntity;
import com.genologics.ri.artifact.Artifact;
import com.genologics.ri.container.Container;
import com.genologics.ri.file.ClarityFile;
import com.genologics.ri.sample.Sample;
import com.genologics.ri.unittests.ClarityModelTestConfiguration;

@SpringJUnitConfig(classes = ClarityModelTestConfiguration.class)
public class BatchFetchDecodingTest
{
    @Autowired
    @Qualifier("clarityJaxbUnmarshaller")
    protected Unmarshaller unmarshaller;

    public BatchFetchDecodingTest()
    {
    }

    @Test
    public void testDecodeBatchFetchArtifactResult() throws Exception
    {
        File resultFile = new File("src/test/xml/batchfetchdecodingtest-artifacts.xml");

        var result = unmarshal(resultFile, Artifact.class);

        assertEquals(5, result.getSize(), "Wrong number of artifacts decoded");
    }

    @Test
    public void testDecodeBatchFetchContainerResult() throws Exception
    {
        File resultFile = new File("src/test/xml/batchfetchdecodingtest-containers.xml");

        var result = unmarshal(resultFile, Container.class);

        assertEquals(5, result.getSize(), "Wrong number of containers decoded");
    }

    @Test
    public void testDecodeBatchFetchSampleResult() throws Exception
    {
        File resultFile = new File("src/test/xml/batchfetchdecodingtest-samples.xml");

        var result = unmarshal(resultFile, Sample.class);

        assertEquals(4, result.getSize(), "Wrong number of samples decoded");
    }

    @Test
    public void testDecodeBatchFetchClarityFileResult() throws Exception
    {
        File resultFile = new File("src/test/xml/batchfetchdecodingtest-files.xml");

        var result = unmarshal(resultFile, ClarityFile.class);

        assertEquals(7, result.getSize(), "Wrong number of files decoded");
    }

    @SuppressWarnings("unchecked")
    private <E extends LimsEntity<E>, T extends BatchUpdate<E>>
    T unmarshal(File file, Class<E> entity) throws Exception
    {
        Object thing = unmarshaller.unmarshal(new StreamSource(file));
        if (thing instanceof JAXBElement<?> element)
        {
            thing = element.getValue();
        }
        return (T)thing;
    }
}
