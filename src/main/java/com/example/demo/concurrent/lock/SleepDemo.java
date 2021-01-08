package com.example.demo.concurrent.lock;


/**
 *  测试一下sleep的打断效果
 *
 *  sleep 不会释放锁，可以被打断
 */
public class SleepDemo {

    public static void main(String[] args) {

        sofa sofa = new sofa();

        Thread t1 = new Thread(sofa);
        t1.setName("t1");
        t1.start();
        Thread t2 = new Thread(sofa);
        t2.setName("t2");
        t2.start();
        if (t1.getState() == Thread.State.RUNNABLE){
            try {
                Thread.sleep(3000);
                t1.interrupt();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            try {
                Thread.sleep(3000);
                t2.interrupt();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class sofa implements Runnable{

    @Override
    public void run() {
        try {
            getSofa();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public synchronized void getSofa() throws InterruptedException {
        for (int i=0;i<10;i++){
            Thread.sleep(1000);
            System.out.println(" this is perfect!!--"+Thread.currentThread().getName()+"---"+i);
        }
    }

}
