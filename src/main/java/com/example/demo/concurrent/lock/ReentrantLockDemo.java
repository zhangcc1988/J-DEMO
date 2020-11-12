package com.example.demo.concurrent.lock;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {

    public static void main(String[] args) {

        ReentrantLock reentrantLock = new ReentrantLock(false);
        AtomicInteger atomicInteger = new AtomicInteger(10);
        ThreadLocal<Object> objectThreadLocal = new ThreadLocal<>();
    }
}
