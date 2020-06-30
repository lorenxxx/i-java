package com.us.improve.functionalinterface;

import org.junit.Test;

import java.util.Random;
import java.util.function.Supplier;

/**
 * @ClassName SupplierTest
 * @Desciption TODO
 * @Author loren
 * @Date 2020/6/29 9:52 PM
 * @Version 1.0
 **/
public class SupplierTest {

    @Test
    public void test() {
        // 1、使用Supplier接口实现方法，只有一个get方法，无参数，返回一个值
        Supplier<Integer> supplier1 = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return new Random().nextInt();
            }
        };
        System.out.println(supplier1.get());

        System.out.println("********************");

        // 2、使用lambda表达式
        Supplier<Integer> supplier2 = () -> new Random().nextInt();
        System.out.println(supplier2.get());

        System.out.println("********************");

        // 3、使用方法引用
        Supplier<Double> supplier3 = Math::random;
        System.out.println(supplier3.get());
    }

}
