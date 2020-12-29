package com.example.demo.concurrent.threadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * created by zc  2020/11/19 10:34
 */
public class ScheduledDemo {

    static ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors(),
            r -> {
                Thread thread = new Thread(r);
                thread.setDaemon(true);
                return thread;
            });

    public static void main(String[] args) throws InterruptedException {
//        scheduledExecutorService.scheduleAtFixedRate(() -> {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName());
//        },0,5, TimeUnit.MILLISECONDS);

//        System.out.println(scheduledExecutorService.isShutdown());
//        scheduledExecutorService.shutdown();
//        System.out.println(scheduledExecutorService.isShutdown());



    }



}
