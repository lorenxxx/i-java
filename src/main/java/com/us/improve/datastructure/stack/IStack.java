package com.us.improve.datastructure.stack;

/**
 * @ClassName IStack
 * @Desciption 栈接口定义
 * @Author loren
 * @Date 2019/3/27 11:58 AM
 * @Version 1.0
 **/
public interface IStack<T> {

    boolean push(T t);

    T pop();

    int size();

    boolean isEmpty();

}