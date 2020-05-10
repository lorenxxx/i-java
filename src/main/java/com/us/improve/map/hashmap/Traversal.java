package com.us.improve.map.hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @ClassName Traversal
 * @Desciption HashMap的遍历方式
 * @Author loren
 * @Date 2020/5/10 12:20 PM
 * @Version 1.0
 **/
public class Traversal {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Java");
        map.put(2, "JDK");
        map.put(3, "Spring Framework");
        map.put(4, "MyBatis framework");
        map.put(5, "Java中文社群");

        // 使用迭代器（Iterator）EntrySet 的方式进行遍历
        Iterator<Map.Entry<Integer, String>> entryIterator = map.entrySet().iterator();
        while (entryIterator.hasNext()) {
            Map.Entry<Integer, String> entry = entryIterator.next();
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println("-----------------------");

        // 使用迭代器（Iterator）KeySet 的方式进行遍历
        Iterator<Integer> keyIterator = map.keySet().iterator();
        while (keyIterator.hasNext()) {
            Integer key = keyIterator.next();
            System.out.println(key + " : " + map.get(key));
        }

        System.out.println("-----------------------");
        
        // 使用 For Each EntrySet 的方式进行遍历
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println("-----------------------");

        // 使用 For Each KeySet 的方式进行遍历
        for (Integer key : map.keySet()) {
            System.out.println(key + " : " + map.get(key));
        }

        System.out.println("-----------------------");

        // 使用 Lambda 表达式的方式进行遍历
        map.forEach((k, v) -> System.out.println(k + " : " + v));

        System.out.println("-----------------------");

        // 使用 Streams API 单线程的方式进行遍历
        map.entrySet().stream().forEach((entry) -> System.out.println(entry.getKey() + " : " + entry.getValue()));

        System.out.println("-----------------------");

        // 使用 Streams API 多线程的方式进行遍历
        map.entrySet().parallelStream().forEach((entry) -> System.out.println(entry.getKey() + " : " + entry.getValue()));

    }

}
