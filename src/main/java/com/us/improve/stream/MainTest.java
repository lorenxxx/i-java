package com.us.improve.stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Created by Loren on 2018/11/6.
 */
public class MainTest {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        int count = (int) list.stream().filter(item -> item.isEmpty()).count();
        System.out.println(count);
        count = (int) list.parallelStream().filter(item -> item.isEmpty()).count();
        System.out.println(count);

        List<String> filtered = list.stream().filter(item -> !item.isEmpty()).collect(Collectors.toList());
        filtered.forEach(System.out::println);

        String merged = list.stream().filter(item -> !item.isEmpty()).collect(Collectors.joining(", "));
        System.out.println(merged);

        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        List<Integer> squares = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        squares.forEach(System.out::println);

        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);

        IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println(stats.getMax());
        System.out.print(stats.getAverage());

    }

}
