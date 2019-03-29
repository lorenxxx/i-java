package com.us.improve.datastructure.array;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

/**
 * @ClassName Demo
 * @Desciption TODO
 * @Author loren
 * @Date 2019/3/27 11:54 AM
 * @Version 1.0
 **/
public class Demo {

    public static void main(String[] args) {
        int[] a1 = new int[10];
        int a2[] = new int[10];
        int[] a3 = new int[] {1, 2, 3};

        // 打印内存地址
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);

        XPath xPath = XPathFactory.newInstance().newXPath();
    }

}
