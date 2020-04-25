package com.us.improve.map;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * @ClassName TreeMapDemo
 * @Desciption TODO
 * @Author Loren
 * @Date 2018/12/7 16:05
 * @Version 1.0
 **/
public class TreeMapDemo {

    public static void main(String[] args) {
        TreeMap<Integer, String> treeMap = new TreeMap<>(Comparator.reverseOrder());

        treeMap.put(4, "Jack");
        treeMap.put(2, "Loren");
        treeMap.put(1, "Lily");
        treeMap.put(3, "Tom");
        treeMap.put(5, "Pale");

        System.out.println(treeMap.keySet());

        System.out.println(treeMap.firstKey());
        System.out.println(treeMap.lastKey());
    }

}
