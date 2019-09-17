package com.imooc.producter.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author zxlei
 * @date 2019/8/29 10:22
 * ----------------------------------------------
 * TODO
 * ----------------------------------------------
 */
public class JsonUtil {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static String toJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

}
