package com.example.demo.concurrent.lock;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {


    private final ReentrantLock lock = new ReentrantLock(true);

    private final Condition available = lock.newCondition();

    private LinkedBlockingQueue<String> q1 = new LinkedBlockingQueue<>(100);
    private LinkedBlockingQueue<String> q2 = new LinkedBlockingQueue<>(100);

    private static volatile boolean flag = false;


    public void c() {
        ScheduledExecutorService scheduler1 = Executors.newScheduledThreadPool(
                Runtime.getRuntime().availableProcessors(),
                (r) -> {
                    Thread t = new Thread(r);
                    t.setName(String.valueOf(Math.random()));
                    t.setDaemon(true);
                    return t;
                });
        ScheduledExecutorService scheduler2 = Executors.newScheduledThreadPool(
                Runtime.getRuntime().availableProcessors(),
                (r) -> {
                    Thread t = new Thread(r);
                    t.setName(String.valueOf(Math.random()));
                    t.setDaemon(true);
                    return t;
                });



        scheduler1.scheduleAtFixedRate(() -> {
            for (int i = 0; i < q1.size(); i++) {
                System.out.println(Thread.currentThread().getName() + "- " + q1.poll() + "-size:" + q1.size());
            }
        }, 0, 5, TimeUnit.SECONDS);

        scheduler2.scheduleAtFixedRate(() -> {
            for (int i = 0; i < q2.size(); i++) {
                System.out.println(Thread.currentThread().getName() + "- " + q2.poll() + "-size:" + q2.size());
            }
        }, 0, 5, TimeUnit.SECONDS);

    }


    public void qInit() {
        for (int i = 0; i < 100; i++) {
            q1.offer("q1_" + i);
        }
        for (int i = 0; i < 100; i++) {
            q2.offer("q2_" + i);
        }
    }

    public void getS() {
        new Thread(() -> {
            while (q1.size() > 0) {
                System.out.println(Thread.currentThread().getName() + "- " + q1.poll() + "-size:" + q1.size());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        new Thread(() -> {
            while (true) {
                System.out.println(Thread.currentThread().getName() + "-size:" + q1.size());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }


    public static void main(String[] args) throws InterruptedException {


        ReentrantLockDemo demo = new ReentrantLockDemo();
        demo.qInit();
        demo.c();
//        demo.getS();


        while (true) {
//            System.out.println("$");
            Thread.sleep(1000);
        }

    }
}
