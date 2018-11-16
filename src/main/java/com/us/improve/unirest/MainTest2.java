package com.us.improve.unirest;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

/**
 * Created by Loren on 2018/11/12.
 */
public class MainTest2 {

    public static void main(String[] args) throws Exception {
        HttpResponse<JsonNode> response = Unirest.get("https://data.riskstorm.com/v1/company/search")
            .header("Content-Type", "application/json")
            .header("apikey", "GjVA9JQaknwKvVfR0Mfc6A")
            .queryString("keyword", "广西达庆生物科技有限公司")
            .asJson();

        System.out.println(response);
        System.out.println(response.getBody());
    }

}
