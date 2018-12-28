package com.us.improve.extendz;

/**
 * @ClassName EnglishBook
 * @Desciption TODO
 * @Author loren
 * @Date 2018/12/25 11:07 AM
 * @Version 1.0
 **/
public class EnglishBook extends Book implements IReadable {

    @Override
    public void read() {
        System.out.println(author);
        System.out.println("Child");
    }

}
