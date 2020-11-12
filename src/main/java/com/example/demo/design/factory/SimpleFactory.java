package com.example.demo.design.factory;


/**
 * 利用java多态特性实现简单工厂
 */
public class SimpleFactory {


    public static void main(String[] args) {

        Product product_a = new Product_A();
        Product product_b = new Product_B();

        product_a.method();
        product_b.method();
    }
}


interface Product{
    void method();
}

class Product_A implements Product {

    @Override
    public void method() {
        System.out.println("product_a method used");
    }
}

class Product_B implements Product {

    @Override
    public void method() {
        System.out.println("product_b method used");
    }
}


