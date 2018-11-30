package com.us.improve.reference;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * @ClassName MainTest
 * @Desciption 测试强引用、软引用、弱引用和虚引用
 * @Author loren
 * @Date 2018/11/30 11:18 PM
 * @Version 1.0
 **/
public class MainTest {

    public static void main(String[] args) {

        // all these objects have strong reference
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();

        // other references to these objects
        Object strongRef = a;
        SoftReference<Object> softRef = new SoftReference<Object>(b);
        WeakReference<Object> weakRef = new WeakReference<Object>(c);

        a = null;
        b = null;
        c = null;
        System.out.println("Before gc...");
        System.out.println(String.format("strongRef = %s, softRef = %s, weakRef = %s", strongRef, softRef.get(), weakRef.get()));

        System.out.println("Run GC...");

        System.gc();

        System.out.println("After gc...");
        System.out.println(String.format("strongRef = %s, softRef = %s, weakRef = %s", strongRef, softRef.get(), weakRef.get()));
    }

}
