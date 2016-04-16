package com.aolisov.tali.data.properties;

import com.aolisov.tali.misc.AppJsonMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

/**
 * Created by Alex on 4/14/2016.
 */
public class PropertiesHolder {

    private static final String PROPERTIES_JSON_FILE = "app-properties.json";

    public AppProperties getProperties() throws IOException {
        String jsonProperties = acquireAppProperties();
        ObjectMapper objectMapper = new AppJsonMapper();
        return objectMapper.readValue(jsonProperties, AppProperties.class);
    }

    private String acquireAppProperties() throws IOException {
        Resource resource = new ClassPathResource(PROPERTIES_JSON_FILE);
        InputStream inputStream = resource.getInputStream();

        StringWriter writer = new StringWriter();
        IOUtils.copy(inputStream, writer, "UTF-8");
        return writer.toString();
    }
}
