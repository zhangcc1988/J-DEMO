package com.example.demo.design.adapter;


/**
 *  适配器模式
 *
 *  将一个接口转化成客户希望另一个接口
 *  Adapter 模式将原本由于接口不兼容而不能一起工作的类 可以一起工作
 */
public class AdapterPattern {

    // 转换电压
    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        Adapter adapter = new Adapter(adaptee);
        adapter.outPut5V();
    }
}


// 输出220v
class Adaptee{
    public int outPut220V(){
        return 220;
    }
}

interface Target{
    int outPut5V();
}

class Adapter implements Target{

    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public int outPut5V() {
        int i = adaptee.outPut220V();
        System.out.println(String.format("原始电压 %d v --> 输出电压 %d v",i,5));
        return 5;
    }
}
