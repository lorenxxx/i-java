package com.us.improve.unirest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.awt.print.Book;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.util.Map;

/**
 * @author liangliang
 * @date 2018/11/11 10:05 PM
 */
public class HttpUtil<R> {

    static {
        Unirest.setObjectMapper(new ObjectMapper() {
            private com.fasterxml.jackson.databind.ObjectMapper jacksonObjectMapper = new com.fasterxml.jackson.databind.ObjectMapper();

            @Override
            public <T> T readValue(String value, Class<T> valueType) {
                try {
                    return jacksonObjectMapper.readValue(value, valueType);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            @Override
            public String writeValue(Object value) {
                try {
                    return jacksonObjectMapper.writeValueAsString(value);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    public <T> Class<T> getClz() {
        return (Class<T>)(((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    }

    public <T> T post(String url, Map<String, Object> parameters, Class<T> clazz) {
        try {
            HttpResponse<T> response = Unirest.post(url).fields(parameters).asObject(clazz);
            if (response.getStatus() != 200) {
                throw new RuntimeException("");
            }
            T object = response.getBody();
            return object;
        } catch (UnirestException e) {
            e.printStackTrace();
            throw new RuntimeException("");
        }
    }

}

