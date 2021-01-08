package com.example.demo.design.observer;

import java.util.ArrayList;
import java.util.List;

/**
 *  观察者模式
 *  定义对象间的一对多关系，当一个对象的状态发生改变时，所依赖于他的对象都得到通知并自动更新
 *
 */
public class ObserverPattern {

    public static void main(String[] args) {
        Subject subject = new Subject(false);
        // 绑定 subject
        Observer observerOne = new ObserverOne(subject);
        subject.notifyObservers();

        // 修改 subject flag
        subject.setFlag(true);
        subject.notifyObservers();
    }
}

// 被观察对像
class Subject{
    private Boolean flag;
    private List<Observer> observers = new ArrayList<>();

    public Subject(Boolean flag) {
        this.flag = flag;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public void addObservers(Observer observer){
        observers.add(observer);
    }

    public void notifyObservers(){
        observers.forEach(observer -> {
            observer.update();
        });
    }

}

// 观察者抽象
abstract class Observer{
    Subject subject;
    abstract void update();
}

// 观察者
class ObserverOne extends Observer{

    public ObserverOne(Subject subject) {
        this.subject = subject;
        this.subject.addObservers(this);
    }

    @Override
    void update() {
        System.out.println(" ObserverOne see you flag is "+subject.getFlag());
    }
}


