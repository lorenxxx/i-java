package com.us.improve.dynamicprogramming;

import java.util.Map;

/**
 * @ClassName Demo2
 * @Desciption 用递归的方式求解动态规划问题，同时使用备忘录进行优化
 * @Author Loren
 * @Date 2018/11/24 14:34
 * @Version 1.0
 **/
public class Demo2 {

    int getClimbingWays(int n, Map<Integer, Integer> map) {
        if (n < 1) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        if (map.containsKey(n)) {
            return map.get(n);
        } else {
            int value = getClimbingWays(n - 1, map) + getClimbingWays(n - 2, map);
            map.put(n, value);
            return value;
        }
    }

}
