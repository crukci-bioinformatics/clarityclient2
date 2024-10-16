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

package org.cruk.clarity.api.filestore.mina;

import static org.apache.commons.lang3.StringUtils.isNotEmpty;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.io.File;
import java.io.IOException;
import java.net.ConnectException;
import java.net.URI;
import java.util.Properties;
import java.util.concurrent.TimeoutException;

import jakarta.annotation.PostConstruct;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.cruk.clarity.api.filestore.ClaritySFTPUploader;
import org.cruk.clarity.api.impl.URLInputStreamResource;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.genologics.ri.file.ClarityFile;

@SpringJUnitConfig(TestConfiguration.class)
public class ClarityMinaSSHFileUploaderTest
{
    Logger logger = LoggerFactory.getLogger(ClarityMinaSSHFileUploaderTest.class);

    String user;
    String password;
    int port;

    @Autowired
    ClaritySFTPUploader uploader;

    File baseDir;
    File testDir;

    public ClarityMinaSSHFileUploaderTest()
    {
        String currentDir = System.getProperty("basedir");
        assertNotNull(currentDir, "No 'basedir' property available.");

        baseDir = new File(currentDir);
        File target = new File(baseDir, "target");
        testDir = new File(target, "jschTest");
    }

    @Autowired
    @Qualifier("testCredentials")
    public void setCredentials(Properties props)
    {
        user = props.getProperty("filestore.user");
        password = props.getProperty("filestore.pass");
        try
        {
            port = Integer.parseInt(props.getProperty("filestore.ssh.port", "22"));
        }
        catch (NumberFormatException e)
        {
            port = 22;
        }
    }

    @PostConstruct
    public void setOnUploader()
    {
        uploader.setFilestoreCredentials(user, password);
        uploader.setTimeout(500);
    }

    @BeforeEach
    public void setup() throws IOException
    {
        FileUtils.deleteQuietly(testDir);
        FileUtils.forceMkdir(testDir);
    }

    @AfterEach
    public void cleanup()
    {
        FileUtils.deleteQuietly(testDir);
    }

    @Test
    public void testUpload() throws Throwable
    {
        assumeTrue(isNotEmpty(user), "User not set - no test credentials available?");

        File pom = new File(baseDir, "pom.xml");
        assertTrue(pom.exists());

        File storeFile = new File(testDir, "pom_copy.xml");

        URI clarityURI = new URI("sftp://localhost:" + port + storeFile.getAbsolutePath());

        ClarityFile clarityFile = new ClarityFile();
        clarityFile.setContentLocation(clarityURI);
        clarityFile.setOriginalLocation(pom.getAbsolutePath());
        clarityFile.setOriginalName(pom.getName());

        URLInputStreamResource resource = new URLInputStreamResource(pom.toURI().toURL());

        try
        {
            try
            {
                uploader.upload(resource, clarityFile);

                assertTrue(storeFile.exists(), "Didn't upload: " + storeFile.getAbsolutePath() + " does not exist.");

                assertEquals(pom.length(), storeFile.length(), "Uploaded file doesn't match the original's size.");
            }
            catch (IOException e)
            {
                throwInner(e);
            }
        }
        catch (TimeoutException | ConnectException e)
        {
            logger.error(e.getMessage());
            assumeTrue(false, e.getMessage());
        }
    }

    @Test
    public void testDelete() throws Throwable
    {
        assumeTrue(isNotEmpty(user), "User not set - no test credentials available?");

        File pom = new File(baseDir, "pom.xml");
        assertTrue(pom.exists());

        File storeFile = new File(testDir, "pom_copy.xml");

        URI clarityURI = new URI("sftp://localhost:" + port + storeFile.getAbsolutePath());

        ClarityFile clarityFile = new ClarityFile();
        clarityFile.setContentLocation(clarityURI);
        clarityFile.setOriginalLocation(pom.getAbsolutePath());
        clarityFile.setOriginalName(pom.getName());

        FileUtils.copyFile(pom, storeFile);

        assertTrue(storeFile.exists());

        try
        {
            try
            {
                uploader.delete(clarityFile);

                assertFalse(storeFile.exists(), "Didn't delete: " + storeFile.getAbsolutePath());
            }
            catch (IOException e)
            {
                throwInner(e);
            }
        }
        catch (TimeoutException | ConnectException e)
        {
            logger.error(e.getMessage());
            assumeTrue(false, e.getMessage());
        }
    }

    private void throwInner(Exception e) throws Throwable
    {
        Throwable e2 = ExceptionUtils.getRootCause(e);
        throw e2 == null ? e : e2;
    }
}
