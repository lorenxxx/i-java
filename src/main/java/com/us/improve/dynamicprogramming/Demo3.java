package com.us.improve.dynamicprogramming;

/**
 * @ClassName Demo3
 * @Desciption 真正的动态规划实现
 * @Author Loren
 * @Date 2018/11/24 14:41
 * @Version 1.0
 **/
public class Demo3 {

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

        int a = 1;
        int b = 2;
        int temp = 0;
        for (int i = 3; i <= n; i++) {
            temp = a + b;
            a = b;
            b = temp;
        }

        return temp;
    }

}
