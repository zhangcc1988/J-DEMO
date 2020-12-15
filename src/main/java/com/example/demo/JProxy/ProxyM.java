package com.example.demo.JProxy;

/**
 * created by zc  2020/11/16 18:40
 */
public class ProxyM {

    public static void main(String[] args) {
        AddService proxy = AddServiceHandler.getProxy(null);
        int num = proxy.add(1, 2);
        System.out.println(num);

    }

}
