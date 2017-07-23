package com.zzp.thread;

/**
 * Created by zzy on 2017/7/20.
 */
public class WrongWayStopThread extends Thread {
    public static void main(String args[]){
        WrongWayStopThread thread = new WrongWayStopThread();
        System.out.println("thread is start");
        thread.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Interrupt thread");
        thread.interrupt();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Stop Application!");
    }

    @Override
    public void run() {
/*        while (!this.isInterrupted()){
            System.out.println(Thread.currentThread().getName()+"is running");
            long time = System.currentTimeMillis();
            while(System.currentTimeMillis()-time<1000){

            }
        }*/

        while (!Thread.interrupted()){
            System.out.println(Thread.currentThread().getName()+"is running");
            long time = System.currentTimeMillis();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
