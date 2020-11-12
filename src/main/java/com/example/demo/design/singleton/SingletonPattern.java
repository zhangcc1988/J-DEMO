package com.example.demo.design.singleton;


/**
 * 单例模式(饿汉模式)
 * 类加载过程中完成实例的初始化
 */
public class SingletonPattern {

    private static final SingletonPattern singleton = new SingletonPattern();

    private SingletonPattern(){};

    public static SingletonPattern getInstance(){
        return singleton;
    }
}
