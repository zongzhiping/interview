package com.zzp.thread;

/**
 * Created by zzy on 2017/7/21.
 */
class Printer{}
class Scanner{}
class empThread01 implements Runnable{
    @Override
    public void run() {
        synchronized (DeadLockDemo1.printer) {
            System.out.println("emp01使用"+DeadLockDemo1.printer+"打印文章。。。。");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (DeadLockDemo1.scanner) {
                System.out.println("emp01使用"+DeadLockDemo1.scanner+"扫描图片。。。。");
            }
        }
    }
}
class empThread02 implements Runnable{
    @Override
    public void run() {
        synchronized (DeadLockDemo1.scanner) {
            System.out.println("emp02使用"+DeadLockDemo1.scanner+"扫描图片。。。。");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (DeadLockDemo1.printer) {
                System.out.println("emp02使用"+DeadLockDemo1.printer+"打印文章。。。。");
            }
        }
    }
}
public class DeadLockDemo1 {
    public static Printer printer = new Printer();
    public static Scanner scanner = new Scanner();

    public static void main(String[] args) {
        new Thread(new empThread01()).start();
        new Thread(new empThread02()).start();
    }


}
