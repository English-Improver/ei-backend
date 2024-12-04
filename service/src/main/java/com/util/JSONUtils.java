package com.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author yitiansong
 * json工具类
 * 2024/5/2
 */
public class JSONUtils {
    private static final ObjectMapper mapper = new ObjectMapper();


    /**
     * Converts a JSON string to an object of the specified class.
     *
     * @param jsonStr the JSON string to convert
     * @param clazz   the class of the object to convert to
     * @param <R>     the type of the object to convert to
     * @return the converted object
     * @throws RuntimeException if an error occurs during the conversion
     */
    public static <R> R toObject(String jsonStr, Class<R> clazz) {

        try {
            return mapper.readValue(jsonStr, clazz);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 将q进行字符串话
     *
     * @param q
     * @param <Q>
     * @return
     */
    public static <Q> String toJSONString(Q q) {
        String jsonStr = null;
        try {
            jsonStr = mapper.writeValueAsString(q);
        } catch (JsonProcessingException e) {
            System.out.println("e = " + e);
        }
        return jsonStr;
    }

}
