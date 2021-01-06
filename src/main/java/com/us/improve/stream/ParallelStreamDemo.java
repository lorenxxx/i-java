package com.us.improve.stream;/**
 * @author liangliang
 * @date 1/6/21 7:31 PM
 */

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @Author loren
 * @Description TODO
 * @Date 2021-01-06 19:31
 * @Version 1.0
 **/
public class ParallelStreamDemo
{

	public static void main(String[] args)
	{
		List<Item> itemList = new ArrayList<>();
		for (int i = 1; i <= 100; i++)
		{
			itemList.add(new Item(i, "item-" + i));
		}

		List<Item> itemListCopy = Lists.newArrayList();
		itemList.parallelStream().forEach(item -> {
			try
			{
				if (new Random().nextInt(10) % 2 == 0)
				{
					TimeUnit.MILLISECONDS.sleep(new Random().nextInt(1000));
				}
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			itemListCopy.add(item);
		});

		Integer size = itemListCopy.size();
		System.out.println("size: " + size);
		System.out.println("elements: " + itemListCopy);

		//        Map<Integer, User> map = new HashMap<>();
		//
		//        map = users.stream().collect(Collectors.toMap(User::getId, item -> item));
		//        System.out.println(map);
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
