package com.us.improve.lambda;

import com.google.common.collect.Lists;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName MainTest
 * @Desciption TODO
 * @Author loren
 * @Date 2019/5/17 5:59 PM
 * @Version 1.0
 **/
public class MainTest {

    private static List<Car> carSource = Lists.newArrayList();

    static {
        carSource.add(Car.builder().brand("Audi").model("A7").color("blue").price(81.99).build());
        carSource.add(Car.builder().brand("Audi").model("A7").color("gray").price(86.99).build());
        carSource.add(Car.builder().brand("Audi").model("A4L").color("white").price(36.99).build());
        carSource.add(Car.builder().brand("BMW").model("330Li").color("white").price(37.99).build());
        carSource.add(Car.builder().brand("BMW").model("330Li").color("gray").price(37.99).build());
    }

    public static void main(String[] args) {
        List<String> allModels = carSource.stream().map(Car::getModel).collect(Collectors.toList());
        System.out.println(allModels);

        List<String> a7Models = carSource.stream().filter(c -> c.getModel() == "A7").map(Car::getModel).collect(Collectors.toList());
        System.out.println(a7Models);

        List<Car> sortedA7Model = carSource.stream().filter(c -> c.getModel() == "A7").sorted(Comparator.comparing(Car::getPrice).reversed()).collect(Collectors.toList());
        System.out.println(sortedA7Model);
    }

}
