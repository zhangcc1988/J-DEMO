package com.example.demo.concurrent.blockingQueue;


import java.util.concurrent.ArrayBlockingQueue;


/**
 * ArrayBlockingQueue
 *
 */
public class ArrayBlockingQueueDemo {

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