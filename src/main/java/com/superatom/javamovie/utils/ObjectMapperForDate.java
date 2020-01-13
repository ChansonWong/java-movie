package com.superatom.javamovie.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ObjectMapperForDate extends ObjectMapper {
    private static final long serialVersionUID = 1L;

    public ObjectMapperForDate(){
        //this.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false);
        this.configure(SerializationFeature.WRITE_NULL_MAP_VALUES,true);
        this.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        this.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        this.configure(SerializationFeature.INDENT_OUTPUT, true);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.setDateFormat(df);
    }
}
