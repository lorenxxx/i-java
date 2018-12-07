package com.us.improve.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * @ClassName MainTest
 * @Desciption TODO
 * @Author Loren
 * @Date 2018/12/7 14:11
 * @Version 1.0
 **/
public class MainTest {

    public static void main(String[] args) {
        List<String> vector = new Vector<>();
        List<String> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();

        vector.add(null);
        arrayList.add(null);
        linkedList.add(null);

        System.out.println(vector.size());
        System.out.println(arrayList.size());
        System.out.println(linkedList.size());
    }

}
