package com.zzp.thread;

/**
 * Created by zzy on 2017/7/20.
 */
public class MyThread extends Thread {
    public void run(){
        super.run();
        System.out.println(Thread.currentThread().getName()+"11111");
        for(int i=0; i<500000; i++){
            i++;
//            System.out.println("i="+(i+1));
        }
    }
}

