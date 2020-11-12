package com.example.demo.design.decorator;


/**
 * 装饰者模式 （静态代理）
 *
 * 在不改变原有对象基础上 将功能附加到对象上
 */
public class DecoratorPattern {

    public static void main(String[] args) {
        ConcreteComponent concreteComponent = new ConcreteComponent();
        concreteComponent.operation();

        System.out.println("--------拓展功能 -------");

        ConcreteComponentExpand concreteComponentExpand = new ConcreteComponentExpand(concreteComponent);
        concreteComponentExpand.operation();
    }
}

interface Component{
    void operation();
}

class ConcreteComponent implements Component{

    @Override
    public void operation() {
        System.out.println("拍照");
    }
}

abstract class Decorator implements Component{

    Component component;

    public Decorator(Component component) {
        this.component = component;
    }
}

class ConcreteComponentExpand extends Decorator{

    public ConcreteComponentExpand(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        component.operation();
        System.out.println("美颜");
    }
}

