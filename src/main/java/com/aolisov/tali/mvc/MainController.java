package com.aolisov.tali.mvc;

import com.aolisov.tali.data.properties.AppProperties;
import com.aolisov.tali.data.properties.PropertiesHolder;
import com.aolisov.tali.data.store.ResponseStore;
import com.aolisov.tali.misc.AppJsonMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * Created by Alex on 4/14/2016.
 */

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    ResponseStore responseStore;

    @Autowired
    PropertiesHolder propertiesHolder;

    @RequestMapping(value = "/hello")
    @ResponseBody
    public String hello() {
        return "Hi, I'm Tali and welcome to the Leviathan!";
    }

    @RequestMapping(value = "/properties")
    @ResponseBody
    public AppProperties getProperties() throws IOException {
        return propertiesHolder.getProperties();
    }

    @RequestMapping(value = "/response")
    @ResponseBody
    public String getResponse() throws JsonProcessingException {
        return new AppJsonMapper().writeValueAsString(responseStore.get());
    }
}
