package com.vignesh.basics.concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ProducerConsumerExecutor {
    public static void main(String[] args) {
        ArrayBlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(5);
        LinkedBlockingQueue<Integer> producerQueue = new LinkedBlockingQueue<>(5);
        try (ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 5,
                1, TimeUnit.SECONDS, workQueue)) {
            new Thread(() -> {
                for (int i = 1; i <= 20; i++) {
                    try {
                        boolean offer = producerQueue.offer(i, 300, TimeUnit.MILLISECONDS);
                        if(offer)
                            System.out.println("produced = " + i);
                        else
                            System.out.println("Produce timeout = " + i);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }).start();

            for (int i = 0; i < 20; i++) {
                threadPoolExecutor.submit(() -> {
                    Integer consumed = null;
                    try {
                        consumed = producerQueue.poll(100, TimeUnit.MILLISECONDS);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("consumed = " + consumed);
                });
            }

        }
    }
}
