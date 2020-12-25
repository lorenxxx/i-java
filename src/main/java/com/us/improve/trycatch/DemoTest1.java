package com.us.improve.trycatch;

/**
 * @ClassName DemoTest1
 * @Desciption TODO
 * @Author Loren
 * @Date 2018/11/26 19:23
 * @Version 1.0
 **/
public class DemoTest1 {

    public static void main(String[] args) {
        test1();
    }

    public static int getAge() {
        int i = 0;
        try {
            System.out.println("try lock execute");
            i = 10;
            int j = 10 / 0;
            return i;
        } catch (Exception e) {
            System.out.println("catch lock execute");
            i = 20;
            return i;
        } finally {
            System.out.println("finally lock execute");
            i = 30;
        }
    }

    public static void test1() {
        try {
            for (int i = 0; i < 10; i++) {
                if (i == 5) {
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("catch");
        } finally {
            System.out.println("finally");
        }
    }

}
