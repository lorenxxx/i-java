package com.us.improve.optional;

import lombok.Data;

/**
 * @ClassName Competition
 * @Desciption TODO
 * @Author Loren
 * @Date 2018/11/17 13:36
 * @Version 1.0
 **/
@Data
public class Competition {

    private Result result;

    @Data
    public static class Result {
        private User user;
    }

    public void test() {

    }

}
