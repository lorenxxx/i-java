package com.us.improve.function;

/**
 * @ClassName Consume
 * @Desciption TODO
 * @Author loren
 * @Date 2019/6/21 1:06 AM
 * @Version 1.0
 **/
public interface Consume {

    void preConsume();

    void doConsume();

    void afterConsume();

}