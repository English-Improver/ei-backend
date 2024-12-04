package com.srq.ai.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author yitiansong
 * @since 9/29/24
 */

public class DtoParse {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    public static <T> T parse(String json, Class<T> clazz) throws JsonProcessingException {
        return OBJECT_MAPPER.readValue(json, clazz);

    }
}
