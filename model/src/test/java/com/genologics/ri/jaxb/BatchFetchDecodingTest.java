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

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.oxm.Unmarshaller;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.genologics.ri.artifact.ArtifactBatchFetchResult;
import com.genologics.ri.container.ContainerBatchFetchResult;
import com.genologics.ri.file.ClarityFileBatchFetchResult;
import com.genologics.ri.sample.SampleBatchFetchResult;
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

        Object result = unmarshaller.unmarshal(new StreamSource(resultFile));

        assertEquals(ArtifactBatchFetchResult.class, result.getClass(), "Decoded result is unexpected");

        ArtifactBatchFetchResult fetch = (ArtifactBatchFetchResult)result;

        assertEquals(5, fetch.getSize(), "Wrong number of artifacts decoded");
    }

    @Test
    public void testDecodeBatchFetchContainerResult() throws Exception
    {
        File resultFile = new File("src/test/xml/batchfetchdecodingtest-containers.xml");

        Object result = unmarshaller.unmarshal(new StreamSource(resultFile));

        assertEquals(ContainerBatchFetchResult.class, result.getClass(), "Decoded result is unexpected");

        ContainerBatchFetchResult fetch = (ContainerBatchFetchResult)result;

        assertEquals(5, fetch.getSize(), "Wrong number of containers decoded");
    }

    @Test
    public void testDecodeBatchFetchSampleResult() throws Exception
    {
        File resultFile = new File("src/test/xml/batchfetchdecodingtest-samples.xml");

        Object result = unmarshaller.unmarshal(new StreamSource(resultFile));

        assertEquals(SampleBatchFetchResult.class, result.getClass(), "Decoded result is unexpected");

        SampleBatchFetchResult fetch = (SampleBatchFetchResult)result;

        assertEquals(4, fetch.getSize(), "Wrong number of samples decoded");
    }

    @Test
    public void testDecodeBatchFetchClarityFileResult() throws Exception
    {
        File resultFile = new File("src/test/xml/batchfetchdecodingtest-files.xml");

        Object result = unmarshaller.unmarshal(new StreamSource(resultFile));

        assertEquals(ClarityFileBatchFetchResult.class, result.getClass(), "Decoded result is unexpected");

        ClarityFileBatchFetchResult fetch = (ClarityFileBatchFetchResult)result;

        assertEquals(7, fetch.getSize(), "Wrong number of files decoded");
    }

}
