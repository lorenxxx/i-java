package com.us.improve.functionalinterface;

import org.junit.Test;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

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
        // 1、使用Consumer接口实现方法
        Consumer<String> consumer1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        Stream<String> stream1 = Stream.of("aaa", "bbb", "ccc");
        stream1.forEach(consumer1);

        System.out.println("*****************");

        // 2 使用lambda表达式，forEach方法需要的就是一个Consumer接口
        // lambda表达式返回的就是一个Consumer接口
        Consumer<String> consumer2 = (s) -> System.out.println(s);

        Stream<String> stream2 = Stream.of("aaa", "bbb", "ccc");
        stream2.forEach(consumer2);

        System.out.println("*****************");

        // 3 使用方法引用，方法引用也是一个consumer
        Consumer<String> consumer3 = System.out::println;

        Stream<String> stream3 = Stream.of("aaa", "bbb", "ccc");
        stream3.forEach(consumer3);
    }

    @Test
    public void test2() {
        Consumer<Integer> consumer = (s) -> System.out.println(s);
        Supplier<Integer> supplier = () -> 5;
    }


}
