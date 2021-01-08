package com.example.demo.design.factory;


/**
 * 工厂方法模式
 *
 * 将产品与创建者解耦
 * 符合单一职责原则
 * 符合开闭原则
 *
 */
public class FactoryMethod {

    public static void main(String[] args) {
        Application concreteProduct_a = new ConcreteProduct_A();
        Application concreteProduct_b = new ConcreteProduct_B();

        concreteProduct_a.getObject().method();
        concreteProduct_b.getObject().method();
    }
}

abstract class Application{

    abstract Product createProduct();

    Product getObject(){
        Product product = createProduct();
        // ...
        // ... todo 公共的一些操作
        return product;
    }
}


class ConcreteProduct_A extends Application{

    @Override
    Product createProduct() {
        // .. todo 子类的一些操作
        return new Product_A();
    }
}


class ConcreteProduct_B extends Application{

    @Override
    Product createProduct() {
        // .. todo 子类的一些操作
        return new Product_B();
    }
}
