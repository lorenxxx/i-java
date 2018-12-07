package com.us.improve.map;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
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

        Map<String, String> map = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });

        map.put("c", "cc");
        map.put("b", "bb");
        map.put("a", "aa");

        display(map);
    }

    public static void display(Map map) {
        Iterator<Map.Entry> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

}
