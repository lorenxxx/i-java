package com.us.improve.dynamicproxy;

/**
 * @ClassName Subject
 * @Desciption 具体主题类
 * @Author loren
 * @Date 2019/4/19 12:14 AM
 * @Version 1.0
 **/
public class Subject implements ISubject {

    @Override
    public void doSomething() {
        System.out.println("do something");
    }

    @Override
    public void doNothing(String str) {
        System.out.println("do " + str);
    }

}
