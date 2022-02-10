package com.lyang.studying.juc;

import java.util.concurrent.*;

/**
 * @author 木子易
 * @version 1.0
 * @date 2022/1/13 3:17 下午
 * @desc countDownLatch
 */
public class CountDownLatchDemo {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        ExecutorService es = new ThreadPoolExecutor(3, 5, 300, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5));
        es.execute(()->{
            try {
                Thread.sleep(1000);
                System.out.println("当前线程是："+Thread.currentThread().getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
        });

        es.execute(()->{
            try {
                Thread.sleep(2000);
                System.out.println("当前线程是："+Thread.currentThread().getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
        });

        Future<Integer> submit = es.submit(() -> {
                Thread.sleep(3000);
                System.out.println("当前线程是：" + Thread.currentThread().getName());
                return 2;
        });
        countDownLatch.countDown();

        try {
            Thread.sleep(5000);
            Integer value = submit.get();
            System.out.println("睡2s后得到执行结果输出结果为："+value);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("等待两个线程执行完毕…… ……");
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("上述三个线程都执行完了！！！！！放假回家");

    }

}
