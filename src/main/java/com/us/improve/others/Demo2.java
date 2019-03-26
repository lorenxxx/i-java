package com.us.improve.others;

import java.util.*;

/**
 * @ClassName Demo2
 * @Desciption retainAll
 * @Author loren
 * @Date 2019/3/26 7:17 PM
 * @Version 1.0
 **/
public class Demo2 {

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList(Arrays.asList(1, 1, 2));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(1, 2));
        //list1.retainAll(list2);

        list1 = retainAll(list1, list2);

        System.out.println(list1);
    }

    public static List retainAll(Collection c1, Collection c2) {
        Set set1 = new HashSet(c1);
        Set set2 = new HashSet(c2);

        set1.retainAll(set2);

        return new ArrayList(set1);
    }

}
