package com.example.demo.concurrent.threadPool;



public class ThreadLocalDemo {

    static final ThreadLocal<String>  threadLocal = new ThreadLocal<>();
    static final ThreadLocal<String> stringThreadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {

        stringThreadLocal.set("hello --- main");

        Thread threadOne = new Thread(() -> {
            threadLocal.set("hello --- one");
            System.out.println(threadLocal.get()+"----- threadLocal");
            System.out.println(stringThreadLocal.get()+"----- stringThreadLocal");
            stringThreadLocal.set("hello ----one main");

        });

        Thread threadTwo = new Thread(() -> {
            threadLocal.set("hello --- two");
            System.out.println(threadLocal.get()+"----- threadLocal");
            System.out.println(stringThreadLocal.get()+"----- stringThreadLocal");
            stringThreadLocal.set("hello ----two main");
        });

        threadOne.start();
        threadTwo.start();
        threadOne.join();
        threadTwo.join();

        System.out.println(stringThreadLocal.get());

    }

}
