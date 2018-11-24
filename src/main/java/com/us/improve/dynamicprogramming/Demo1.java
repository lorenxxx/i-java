package com.us.improve.dynamicprogramming;

/**
 * @ClassName Demo1
 * @Desciption 用递归的方式求解动态规划问题
 * @Author Loren
 * @Date 2018/11/24 14:28
 * @Version 1.0
 **/
public class Demo1 {

    int getClimbingWays(int n) {
        if (n < 1) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        return getClimbingWays(n - 1) + getClimbingWays(n - 2);
    }

}
