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

package com.genologics.ri.unittests;

import static jakarta.xml.bind.Marshaller.JAXB_ENCODING;
import static jakarta.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.genologics.ri.Locatable;

@Configuration
@ComponentScan("com.genologics.ri.jaxb")
@SuppressWarnings("exports")
public class ClarityModelTestConfiguration
{
    private Jaxb2Marshaller jaxb2;

    public ClarityModelTestConfiguration()
    {
        Module module = Locatable.class.getModule();
        Set<String> packages = module.getPackages().stream()
                .filter(p -> p.startsWith("com.genologics.ri"))
                .collect(Collectors.toSet());

        Map<String, Object> marshallerProps = new HashMap<>();
        marshallerProps.put(JAXB_FORMATTED_OUTPUT, true);
        marshallerProps.put(JAXB_ENCODING, "UTF-8");

        jaxb2 = new Jaxb2Marshaller();
        jaxb2.setPackagesToScan(packages.toArray(new String[packages.size()]));
        jaxb2.setMarshallerProperties(marshallerProps);

        // Expands the packages into classes.
        jaxb2.getJaxbContext();
        assert ObjectUtils.isNotEmpty(jaxb2.getClassesToBeBound()) : "Classes have not been found from packages.";

        // Cannot have both packages and classes set if afterPropertiesSet() is called more than once.
        jaxb2.setPackagesToScan();
    }

    // This bean must be qualified when used.
    @Bean
    public Marshaller clarityJaxbMarshaller()
    {
        return jaxb2;
    }

    // This bean must be qualified when used.
    @Bean
    public Unmarshaller clarityJaxbUnmarshaller()
    {
        return jaxb2;
    }
}
