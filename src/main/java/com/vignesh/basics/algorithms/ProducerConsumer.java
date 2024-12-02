package com.vignesh.basics.algorithms;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;

public class ProducerConsumer {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        AtomicBoolean done = new AtomicBoolean(false);
        Runnable producer = getProducer(q, done);
        Runnable consumer = getConsumer(q, done);
        new Thread(producer).start();
        new Thread(consumer).start();
    }

    private static Runnable getConsumer(Queue<Integer> q, AtomicBoolean done) {
        return () -> {
            System.out.println("Consumer: start");
            try {
                while (true) {
                    synchronized (q) {
                        if (q.isEmpty()) {
//                    System.out.println("Consumer : q is empty. so wait");
                            if (done.get()) {
                                return;
                            }
                            q.wait();
                        }
                        Integer val = q.poll();
                        System.out.println("\t\tConsumed : " + val);
                        if (q.size() == 4) {
//                    System.out.println("Consumer : q would have been full. so notify");
                            q.notify();
                        }
                    }
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                System.out.println("e = " + e.getMessage());
                throw new RuntimeException(e);
            }
        };
    }

    private static Runnable getProducer(Queue<Integer> q, AtomicBoolean done) {
        Runnable producer = () -> {
            System.out.println("Producer: start");
            try {
                for (int i = 1; i <= 20; i++) {
                    synchronized (q) {
                        if (q.size() == 5) {
//                    System.out.println("Producer : q is full. so wait");
                            q.wait();
                        }
                        q.add(i);
                        System.out.println("Produced : " + i);
                        if (q.size() == 1) {
//                    System.out.println("Producer : q would have been empty. so notify");
                            q.notify();
                        }
                    }
                    Thread.sleep(200);
                }
                done.set(true);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        return producer;
    }
}
