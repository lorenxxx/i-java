package com.us.improve.algorithm;

/**
 * @ClassName DaffodilNumber
 * @Desciption "水仙花数"是指一个三位数，其各位数字立方和等于该数本身
 * @Author Loren
 * @Date 2018/12/15 18:42
 * @Version 1.0
 **/
public class DaffodilNumber {

    public static void main(String[] args) {
        for (int i = 100; i < 999; i++) {
            if (isDaffodilNumber(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean isDaffodilNumber(int n) {
        if (n < 100 || n > 999) {
            return false;
        }

        int x = n / 100;
        int y = (n % 100) / 10;
        int z = n % 10;

        if (n == x * x * x + y * y * y + z * z * z) {
            return true;
        }

        return false;
    }

}
