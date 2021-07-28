package com.us.improve.classloader;

/**
 * @Author loren
 * @Description TODO
 * @Date 2021-07-09 17:07
 * @Version 1.0
 **/
public class Demo {

	public static void main(String[] args) throws ClassNotFoundException {
		Class<String> clazz = (Class<String>) Class.forName("java.lang.String");
		System.out.println(clazz);
	}

}
