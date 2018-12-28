package com.us.improve.extendz;

/**
 * @ClassName Book
 * @Desciption TODO
 * @Author loren
 * @Date 2018/12/25 11:05 AM
 * @Version 1.0
 **/
public class Book implements IReadable {

    private String name;

    protected String author;

    @Override
    public void read() {
        System.out.println("Parent");
    }

}
