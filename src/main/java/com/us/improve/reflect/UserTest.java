package com.us.improve.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @ClassName UserTest
 * @Desciption TODO
 * @Author loren
 * @Date 2019/4/19 3:00 PM
 * @Version 1.0
 **/
public class UserTest {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<User> clazz = User.class;

        Constructor<?> constructor = clazz.getConstructor(String.class, String.class);
        User user = (User) constructor.newInstance("Hello", "World");
        System.out.println(user);


        constructor = clazz.getConstructor();
        user = (User) constructor.newInstance();
        System.out.println(user);
    }

}
