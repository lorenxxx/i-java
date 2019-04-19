package com.us.improve.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName SubjectProxy
 * @Desciption JDK动态代理类
 * @Author loren
 * @Date 2019/4/19 12:18 AM
 * @Version 1.0
 **/
public class SubjectProxy implements InvocationHandler {

    private Object target;

    public SubjectProxy(Object target) {
        this.target = target;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before...");
        Object result = method.invoke(target, args);
        System.out.println("after...");
        return result;
    }

}
