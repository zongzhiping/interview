package com.zzp.thread;

/**
 * Created by zzy on 2017/7/21.
 */
/**
 * 	案例：卖票 第二种方式创建线程 同步代码块
 */
public class SaleTicketDemo02 {
    public static void main(String[] args) {
        SaleWindThread_2 swt2 = new SaleWindThread_2();
        new Thread(swt2).start();
        new Thread(swt2).start();
    }
}

class SaleWindThread_2 implements Runnable {
    Integer count = 100;

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
           synchronized (this) {
                if(count>0){
                    System.out.println(Thread.currentThread().getName() + "卖出了"+ count + "张票。。");
                    count--;
                }else{
                    break;
                }
            }
        }
    }
}
