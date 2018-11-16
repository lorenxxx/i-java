package com.us.improve.unirest;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

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
        System.out.println(jsonResponse.getStatusText());
        System.out.println(jsonResponse.getHeaders());
        System.out.println(jsonResponse.getBody());
        System.out.println(jsonResponse.getRawBody());
    }

}
