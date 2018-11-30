package com.us.improve.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author liangliang
 * @date 2018/11/20 11:28 PM
 */
public class MainTest {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class<?> c = Class.forName("com.us.improve.reflect.DemoTest");

        System.out.println(c.getName());
        System.out.println(c.getCanonicalName());
        System.out.println(c.getSimpleName());
        System.out.println(c.getTypeName());


        Class<?>[] interfaces = c.getInterfaces();
        System.out.println(interfaces[0]);

        Constructor<?> constructor = c.getConstructor(String.class, int.class);
        System.out.println(constructor.getName());

        DemoTest dt = (DemoTest) constructor.newInstance("Hello", 10);
        System.out.println(dt.getAge());

        Field field = c.getDeclaredField("age");
        field.setAccessible(true);
        System.out.println(field);
        System.out.println(field.get(dt));

        Method method = c.getMethod("sayHello", String.class);
        method.invoke(dt, "Loren");
    }

}
