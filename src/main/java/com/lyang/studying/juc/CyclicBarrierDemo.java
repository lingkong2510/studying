package com.lyang.studying.juc;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 木子易
 * @version 1.0
 * @date 2022/1/17 11:00 上午
 * @desc CyclicBarrierDemo
 */
public class CyclicBarrierDemo {

    private static int num = 1;

    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        int ballNumber = 7;
        collectDragonBall(ballNumber);

    }

    public static void collectDragonBall(int ballNumber) {
//        ExecutorService es = Executors.newFixedThreadPool(ballNumber);
        ExecutorService es = new ThreadPoolExecutor(7, 10, 3, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5));
        CyclicBarrier barrier = new CyclicBarrier(ballNumber, () -> System.out.println("集齐七颗龙珠，召唤神龙"));

        for (int i = 1; i < 8; i++) {
            int finalI = i;
            es.execute(() -> {
                try {
                    System.out.println("收集" + finalI + "星龙珠,龙珠的别称是：" + Thread.currentThread().getName());
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    public static void threadCollectDragonBall(int ballNumber) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(ballNumber, () -> System.out.println("集齐七颗龙珠，召唤神龙"));
        for (int i = 0; i < ballNumber; i++) {
            try {
                lock.lock();
                new MyThread(cyclicBarrier, num).start();
                num++;
            } finally {
                lock.unlock();
            }
        }
    }

    static class MyThread extends Thread {
        private CyclicBarrier cyclicBarrier;
        private int num;

        public MyThread(CyclicBarrier cyclicBarrier, int num) {
            this.cyclicBarrier = cyclicBarrier;
            this.num = num;
        }

        @Override
        public void run() {
            System.out.println("正在收集龙珠");
            try {
                Thread.sleep(3000);
                System.out.println(num + "星龙珠收集完成");
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
