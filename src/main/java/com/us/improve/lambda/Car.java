package com.us.improve.lambda;

import lombok.Builder;
import lombok.Data;

/**
 * @ClassName Car
 * @Desciption TODO
 * @Author loren
 * @Date 2019/5/17 5:57 PM
 * @Version 1.0
 **/
@Data
@Builder
public class Car {

    private String brand;

    private String model;

    private String color;

    private Double price;

}
