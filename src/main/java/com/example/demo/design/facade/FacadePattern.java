package com.example.demo.design.facade;



/**
 * 门面模式
 * 为系统中的一组接口提供一个一致的接口，facade 模式定义了一个高层接口，这个接口使得子系统更加容易使用
 */
public class FacadePattern {

    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.doSomethingFacade();
    }

}



class SubSystemOne{
    public void method(){
        System.out.println(" subSystemOne method execute");
    }
}

class SubSystemTwo{
    public void method(){
        System.out.println(" subSystemTwo method execute");
    }
}

class Facade{

    SubSystemOne subSystemOne = new SubSystemOne();
    SubSystemTwo subSystemTwo = new SubSystemTwo();

    public void doSomethingFacade(){
        subSystemOne.method();
        subSystemTwo.method();
    }

}
