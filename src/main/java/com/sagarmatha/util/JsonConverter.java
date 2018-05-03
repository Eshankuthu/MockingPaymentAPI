package com.sagarmatha.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonConverter {
	
	private static final ObjectMapper mapper = new ObjectMapper();

    public static <T> T jsonToObject(String data, Class<T> clazz) throws IOException, NullPointerException {
        T t = mapper.readValue(data, clazz);
        return t;
    }

    public static <T> String objectToJson(T t) throws JsonProcessingException {
       return mapper.writeValueAsString(t);
    }

}
