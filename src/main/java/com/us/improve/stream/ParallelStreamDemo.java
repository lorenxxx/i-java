package com.us.improve.stream;/**
 * @author liangliang
 * @date 1/6/21 7:31 PM
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author loren
 * @Description TODO
 * @Date 2021-01-06 19:31
 * @Version 1.0
 **/
public class ParallelStreamDemo
{

//	public static void main(String[] args)
//	{
//		List<Integer> list = new ArrayList<>();
//		IntStream.range(0, 50).parallel().map(e -> e * 2).forEach(list::add);
//		System.out.println("size = " + list.size() + "\n" + list);
//	}

		public static void main(String[] args)
		{
			List<Integer> itemList = new ArrayList<>();
			for (int i = 1; i <= 100; i++)
			{
				itemList.add(i * 2);
			}

			List<Integer> itemListCopy = new ArrayList<>();
			itemList.parallelStream().forEach(item -> {
				itemListCopy.add(item);
			});

			Integer size = itemListCopy.size();
			System.out.println("size: " + size);
			System.out.println("elements: " + itemListCopy);
		}

	@NoArgsConstructor
	@AllArgsConstructor
	@Data
	public static class Item
	{

		private Integer id;

		private String name;

	}

}
