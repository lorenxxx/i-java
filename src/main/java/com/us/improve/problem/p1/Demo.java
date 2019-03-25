package com.us.improve.problem.p1;

import com.google.common.base.Stopwatch;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName Demo
 * @Desciption TODO
 * @Author loren
 * @Date 2019/3/22 11:57 AM
 * @Version 1.0
 **/
public class Demo {

    // list大小
    private static final int LIST_LENGTH = 30000000;

    // 线程数量
    private static final int THREAD_COUNT = 100;

    // 每个线程需要处理的切片大小
    private static final int SLICE_LENGTH = LIST_LENGTH / THREAD_COUNT;

    public static void main(String[] args) throws Exception {
        System.out.println("ArrayList中存在100万个对象，某些对象的属性type值为2，问怎么取到这些对象的个数？");
        System.out.println();

        // 初始化数据
        Stopwatch watch = Stopwatch.createUnstarted();

        watch.start();
        List<Item> list = Lists.newArrayListWithCapacity(LIST_LENGTH);
        int itemEqual2Count = 0;

        Random random = new Random();
        for (int i = 0; i < LIST_LENGTH; i++) {
            if (random.nextBoolean()) {
                list.add(new Item(2));
                itemEqual2Count++;
            } else {
                list.add(new Item(1));
            }
        }

        watch.stop();
        System.out.println("初始化消耗时间: " + watch.elapsed(TimeUnit.MILLISECONDS) + "ms");
        System.out.println("list大小: " + list.size());
        System.out.println("正确结果数量: " + itemEqual2Count);

        System.out.println();

        // 第一种方法，单线程直接循环遍历
        System.out.println("第一种方法，单线程直接循环遍历");
        int count1 = 0;

        watch.reset();
        watch.start();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getType() == 2) {
                count1++;
            }
        }

        watch.stop();

        System.out.println("花费时间: " + watch.elapsed(TimeUnit.MILLISECONDS) + "ms");
        System.out.println("结果数量: " + count1);

        System.out.println();

        // 第二种方法，fork/join，用100个线程来分别跑，用原子变量计数
        System.out.println("第二种方法，fork/join，100个线程切片，用原子变量计数");
        AtomicInteger count2 = new AtomicInteger(0);
        ExecutorService pool1 = Executors.newFixedThreadPool(THREAD_COUNT);

        watch.reset();
        watch.start();

        for (int i = 0; i < THREAD_COUNT; i++) {
            final int THREAD_NO = i;
            pool1.execute(new Runnable() {
                @Override
                public void run() {
                    for (int i = THREAD_NO * SLICE_LENGTH; i < (THREAD_NO + 1) * SLICE_LENGTH; i++) {
                        if (list.get(i).getType() == 2) {
                            count2.addAndGet(1);
                        }
                    }
                }
            });
        }

        pool1.shutdown();
        pool1.awaitTermination(1, TimeUnit.DAYS);

        watch.stop();
        System.out.println("线程数量: " + THREAD_COUNT + ", 花费时间: " + watch.elapsed(TimeUnit.MILLISECONDS) + "ms");
        System.out.println("结果数量: " + count2.get());

        System.out.println();

        // 第三种方法，fork/join，用100个线程来分别跑，用数组计数，最后遍历数组汇总结果
        System.out.println("第三种方法，fork/join，100个线程切片，用数组计数，最后遍历数组汇总结果");
        int[] result = new int[THREAD_COUNT];
        ExecutorService pool2 = Executors.newFixedThreadPool(THREAD_COUNT);

        watch.reset();
        watch.start();

        for (int i = 0; i < THREAD_COUNT; i++) {
            final int THREAD_NO = i;
            pool2.execute(new Runnable() {
                @Override
                public void run() {
                    for (int i = THREAD_NO * SLICE_LENGTH; i < (THREAD_NO + 1) * SLICE_LENGTH; i++) {
                        if (list.get(i).getType() == 2) {
                            result[THREAD_NO]++;
                        }
                    }
                }
            });
        }

        pool2.shutdown();
        pool2.awaitTermination(1, TimeUnit.DAYS);

        watch.stop();
        System.out.println("线程数量: " + THREAD_COUNT + ", 花费时间: " + watch.elapsed(TimeUnit.MILLISECONDS) + "ms");
        int count3 = 0;
        for (int i = 0; i < result.length; i++) {
            count3 += result[i];
        }
        System.out.println("结果数量: " + count3);

        System.out.println();

        // 第四种方法，fork/join，获取本机CPU核心数 * 2，设置为线程数量，用来计数的变量是数组
        System.out.println("第四种方法，fork/join，获取本机CPU核心数 * 2，设置为线程数量，用数组计数，最后遍历数组汇总结果");
        int serverProcessorCount = Runtime.getRuntime().availableProcessors();
        int newSliceLength = LIST_LENGTH / serverProcessorCount;

        int[] result2 = new int[THREAD_COUNT];
        AtomicInteger count4 = new AtomicInteger(0);
        ExecutorService pool3 = Executors.newFixedThreadPool(serverProcessorCount);

        watch.reset();
        watch.start();

        for (int i = 0; i < serverProcessorCount; i++) {
            final int THREAD_NO = i;
            pool3.execute(new Runnable() {
                @Override
                public void run() {
                    for (int i = THREAD_NO * newSliceLength; i < (THREAD_NO + 1) * newSliceLength; i++) {
                        if (list.get(i).getType() == 2) {
                            count4.addAndGet(1);
                        }
                    }
                }
            });
        }

        pool3.shutdown();
        pool3.awaitTermination(1, TimeUnit.DAYS);

        watch.stop();
        System.out.println("线程数量: " + serverProcessorCount + ", 花费时间: " + watch.elapsed(TimeUnit.MILLISECONDS) + "ms");
        System.out.println("结果数量: " + count4.get());

        System.out.println();

        // 第五种方法，Stream API，
        System.out.println("第五种方法，Stream API，parallelStream, 线程数量默认为本机CPU核心数, 用原子变量计数");
        AtomicInteger count5 = new AtomicInteger(0);

        watch.reset();
        watch.start();
        list.parallelStream().forEach(element -> {
            if (element.getType() == 2) {
                count5.addAndGet(1);
            }
        });

        watch.stop();

        System.out.println("线程数: " + 8 + ", 花费时间: " + watch.elapsed(TimeUnit.MILLISECONDS) + "ms");
        System.out.println("结果数量: " + count5);
    }

}
