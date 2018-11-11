package com.us.improve.unirest;

/**
 * @author liangliang
 * @date 2018/11/11 10:55 PM
 */
public class HttpUtilTest {

    public static void main(String[] args) {
        HttpUtil<Object> httpUtil = new HttpUtil();
        Class c = GenericSuperclassUtil.getActualTypeArgument(httpUtil);
        System.out.println(c);
    }

}
