package com.us.improve.dynamicproxy;

/**
 * @ClassName MainTest
 * @Desciption TODO
 * @Author loren
 * @Date 2019/4/19 12:22 AM
 * @Version 1.0
 **/
public class MainTest {

    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        ISubject subject = (ISubject) new SubjectProxy(new Subject()).getProxy();
        subject.doSomething();
        subject.doNothing("dp");
    }

}
