package org.cruk.clarity.api.sftp.jsch;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.cruk.clarity.api.sftp", excludeFilters = @Filter(Configuration.class))
public class TestConfiguration
{
    public TestConfiguration()
    {
    }

    @Bean
    public Properties testCredentials()
    {
        Properties credentials = new Properties();
        try (InputStream propsIn = getClass().getResourceAsStream("/testcredentials.properties"))
        {
            if (propsIn != null)
            {
                credentials.load(propsIn);
            }
        }
        catch (IOException e)
        {
            Logger logger = LoggerFactory.getLogger(getClass());
            logger.error("Could not read from credentials file: ", e);
        }
        return credentials;
    }
}
