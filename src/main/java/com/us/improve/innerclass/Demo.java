package com.us.improve.innerclass;

/**
 * @ClassName Demo
 * @Desciption TODO
 * @Author Loren
 * @Date 2018/12/8 19:39
 * @Version 1.0
 **/
public class Demo {

    public void test() {
        OuterCls.StaticInnerCls staticInnerCls = new OuterCls.StaticInnerCls();

        OuterCls outerCls = new OuterCls();
        OuterCls.InnerCls innerCls = outerCls.new InnerCls();
    }

}
