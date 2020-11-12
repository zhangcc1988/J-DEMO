package com.example.demo.design.template;


/**
 * 模板方法模式
 *
 * 定义一个操作算法的骨架，而将一些步骤延迟到子类中，
 * Template Method 使得子类可以不改变算法的结构，重新定义该算法的某些特定步骤
 *
 * 类似工厂方法(用于创建对象)，模板方法（）
 *
 */
public class TemplateMethod {

    public static void main(String[] args) {

        Game football = new Football();
        football.play();

        //还可以定义更多子类实现Game


    }
}

abstract class Game{

    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();

    // 模板
    public final void play(){
        initialize();
        startPlay();
        endPlay();
    }

}

class Football extends Game {

    @Override
    void endPlay() {
        System.out.println("Football Game Finished!");
    }

    @Override
    void initialize() {
        System.out.println("Football Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Football Game Started. Enjoy the game!");
    }
}