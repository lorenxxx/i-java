package com.us.improve.random;

import java.util.Random;

/**
 * @Author loren
 * @Description TODO
 * @Date 2020-12-25 11:34
 * @Version 1.0
 **/
public class RandomTest
{

	public static void main(String[] args)
	{
		RandomTest test = new RandomTest();
		test.run();

		Math.random();
	}

	public void run()
	{
		System.out.println("Random不设置种子：");
		for (int i = 0; i < 5; i++)
		{
			Random random = new Random();
			for (int j = 0; j < 10; j++)
			{
				System.out.print(" " + random.nextInt(100) + ", ");
			}
			System.out.println("");
		}

		System.out.println("");

		System.out.println("Random设置种子1：");
		for (int i = 0; i < 5; i++)
		{
			Random random = new Random();
			random.setSeed(99);
			for (int j = 0; j < 10; j++)
			{
				System.out.print(" " + random.nextInt(100) + ", ");
			}
			System.out.println("");
		}
		System.out.println("");

		System.out.println("Random设置种子2：");
		for (int i = 0; i < 5; i++)
		{
			Random random = new Random();
			random.setSeed(99);
			for (int j = 0; j < 10; j++)
			{
				System.out.print(" " + random.nextInt(100) + ", ");
			}
			System.out.println("");
		}

	}

}
