package com.us.improve.datastructure;

/**
 * @ClassName ICollection
 * @Desciption TODO
 * @Author loren
 * @Date 2019/3/27 5:05 PM
 * @Version 1.0
 **/
public interface ICollection<E> {

    int size();

    boolean isEmpty();

    boolean contains(E e);

}