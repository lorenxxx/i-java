package com.us.improve.functionalinterface;

import org.junit.Test;

import java.util.function.Consumer;

/**
 * @ClassName ConsumerTest
 * @Desciption TODO
 * @Author loren
 * @Date 2020/6/24 5:50 PM
 * @Version 1.0
 **/
public class ConsumerTest {

    @Test
    public void test1() {
        Consumer<Integer> square = x -> System.out.println(x * x);
        square.accept(2);
    }

}
