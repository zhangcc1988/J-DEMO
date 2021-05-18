package com.example.demo.JProxy;

/**
 * created by zc  2020/11/16 18:40
 */
public class ProxyM {

    public static void main(String[] args) {
        AddService proxy = AddServiceHandler.getProxy(new Calculate());
        proxy.add(1, 2);

        System.out.println("-------------------");

        SubtractService proxy_two = AddServiceHandler.getProxy_two(new Calculate());
        proxy_two.sub(1,2);
    }

}
