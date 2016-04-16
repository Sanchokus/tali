package com.aolisov.tali.misc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;

/**
 * Created by Alex on 4/16/2016.
 */
public class AppJsonMapper extends ObjectMapper {
    public AppJsonMapper() {
        super();
        this.setDateFormat(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS a z"));
        this.enable(SerializationFeature.INDENT_OUTPUT);
    }
}
