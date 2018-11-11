package com.us.improve.unirest;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liangliang
 * @date 2018/11/11 9:49 PM
 */
public class MainTest {

    public static void main(String[] args) throws UnirestException {
        HttpResponse<JsonNode> jsonResponse = Unirest.post("http://httpbin.org/post")
                .header("accept", "application/json")
                .queryString("apiKey", "123")
                .field("parameter", "value")
                .field("foo", "bar")
                .asJson();

        System.out.println(jsonResponse.getStatus());

        Map<String, String> headers = new HashMap();
        headers.put("accept", "application/json");

        Map<String, Object> fields = new HashMap();
        fields.put("parameter", "value");
        fields.put("foo", "bar");

        jsonResponse = Unirest.post("http://httpbin.org/post")
                .headers(headers)
                .queryString("apiKey", "123")
                .fields(fields)
                .asJson();

        System.out.println(jsonResponse.getStatus());

    }

}
