package com.us.improve.optional;

import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * @ClassName OptionalTest
 * @Desciption TODO
 * @Author loren
 * @Date 2020/6/23 7:39 PM
 * @Version 1.0
 **/
public class OptionalTest {

    @Test(expected = NoSuchElementException.class)
    public void test1() {
        Optional<User> op = Optional.empty();
        op.get();
    }

    @Test(expected = NullPointerException.class)
    public void test2() {
        User user = null;
        Optional<User> op = Optional.of(user);
    }

    @Test
    public void test3() {
        User user = null;
        Optional<User> op = Optional.ofNullable(user);
    }

}
