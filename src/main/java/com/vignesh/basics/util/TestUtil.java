package com.vignesh.basics.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestUtil {

    public static final ObjectMapper objectMapper = new ObjectMapper();

    public static String marshalToJSON(Object obj) throws JsonProcessingException {
        return objectMapper.writeValueAsString(obj);
    }
}
