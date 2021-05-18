package com.example.demo.JProxy;

/**
 * created by zc  2021/5/18 15:23
 */
public class Calculate implements AddService,SubtractService {

    @Override
    public int add(int a, int b) {
        System.out.println(a + b);
        return a + b;
    }

    @Override
    public int sub(int a, int b) {
        System.out.println(a - b);
        return a - b;
    }
}
