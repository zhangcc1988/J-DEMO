package com.example.demo.concurrent.blockingQueue;


import java.util.concurrent.ArrayBlockingQueue;


/**
 * ArrayBlockingQueue
 * 先进先出队列（队列头的是最先进队的元素；队列尾的是最后进队的元素）
 * 有界队列（即初始化时指定的容量，就是队列最大的容量，不会出现扩容，容量满，则阻塞进队操作；容量空，则阻塞出队操作）
 * 队列不支持空元素
 *
 * add:队满抛异常，offer实现；
 * offer:成功返回true，失败返回false；
 * put:阻塞，可中断
 *
 * remove：成功返回true，失败返回false；
 * poll:直接返回被移除的值，或者返回null;
 * take:直接返回被移除的值，否者阻塞;
 * drainTo：一次性从BlockingQueue获取所有可用的数据对象（还可以指定获取数据的个数），
 * 　　　　  通过该方法，可以提升获取数据效率；不需要多次分批加锁或释放锁
 *
 * peek:查看队首数据
 */
public class ArrayBlockingQueueDemo{

    public static void main(String[] args) {

        ArrayBlockingQueue<Bread> queue = new ArrayBlockingQueue<>(10);
        for (int i=2;i>0;i--){
            new Thread(new Producer(queue)).start();
        }
        new Thread(new Consumer(queue)).start();


    }
}

class Bread {

    void eat() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println(" delicious! ");
    }
}

class Producer implements Runnable {

    private final ArrayBlockingQueue<Bread> arrayBlockingQueue;

    Producer(ArrayBlockingQueue<Bread> arrayBlockingQueue) {
        this.arrayBlockingQueue = arrayBlockingQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Bread bread = new Bread();
                Thread.sleep(2000);
                System.out.println(" perfect! ! !");
                arrayBlockingQueue.put(bread);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }

        }
    }
}

class Consumer implements Runnable {

    private final ArrayBlockingQueue<Bread> arrayBlockingQueue;

    Consumer(ArrayBlockingQueue<Bread> arrayBlockingQueue) {
        this.arrayBlockingQueue = arrayBlockingQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                /**
                 * take()方法和put()方法是对应的，从中拿一个数据，如果拿不到线程挂起
                 * poll()方法和offer()方法是对应的，从中拿一个数据，如果没有直接返回null
                 */
                Bread bread = arrayBlockingQueue.take();
                bread.eat();
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}