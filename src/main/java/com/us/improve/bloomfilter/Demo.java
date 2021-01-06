package com.us.improve.bloomfilter;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnel;
import com.google.common.hash.PrimitiveSink;

/**
 * @Author loren
 * @Description TODO
 * @Date 2020-12-26 18:00
 * @Version 1.0
 **/
public class Demo
{

	public static void main(String[] args)
	{
		BloomFilter<String> bloomFilter = BloomFilter.create(new Funnel<String>()
		{

			@Override
			public void funnel(String from, PrimitiveSink into)
			{
				into.putString(from, Charsets.UTF_8);
			}
		}, 1024 * 1024 * 32);

		bloomFilter.put("Loren");

		System.out.println(bloomFilter.mightContain("Loren"));
		System.out.println(bloomFilter.mightContain("Tom"));
		System.out.println(bloomFilter.mightContain("Tom"));
	}

}
