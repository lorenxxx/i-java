package com.us.improve.innerclass;

/**
 * @ClassName OuterCls
 * @Desciption TODO
 * @Author Loren
 * @Date 2018/12/8 18:45
 * @Version 1.0
 **/
public class OuterCls {

    private String outerStr;

    private static String staticOuterStr;

    public void outerPrint() {
        System.out.println(outerStr);
    }

    public static void staticOuterPrint() {
        System.out.println(staticOuterStr);
    }

    public void test() {
        StaticInnerCls staticInnerCls = new StaticInnerCls();
    }

    // 静态内部类
    static class StaticInnerCls {
        private String area;

        private static String area2;

        public void test() {
            // 静态内部类只能访问外部类的静态成员，包括私有静态成员
            staticOuterStr = "Loren";
            staticOuterPrint();
        }
    }

    // 非静态内部类-成员内部类
    class InnerCls {
        private String speed;

        // 成员内部类不能含有static的变量和方法。
        //private static String speed2;

        public void test() {
            // 非静态内部类能访问外部类的一切成员，包括私有成员
            outerStr = "Loren";
            staticOuterStr = "L";
            outerPrint();
            staticOuterPrint();
        }
    }

}
