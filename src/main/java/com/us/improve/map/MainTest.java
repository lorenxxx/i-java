package com.us.improve.map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;

/**
 * @ClassName MainTest
 * @Desciption TODO
 * @Author Loren
 * @Date 2018/12/7 14:14
 * @Version 1.0
 **/
public class MainTest {

    public static void main(String[] args) {
        Map<String, String> hashTable = new Hashtable<>();
        Map<String, String> hashMap = new HashMap<>();
        Map<String, String> treeMap = new TreeMap<>();

        //hashTable.put(null, null);
        hashMap.put(null, null);
        //treeMap.put(null, null);

        System.out.println(hashTable.size());
        System.out.println(hashMap.size());
        System.out.println(treeMap.size());
    }

}
