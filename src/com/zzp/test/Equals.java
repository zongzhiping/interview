package com.zzp.test;

/**
 * Created by zzy on 2017/7/24.
 */
public class Equals{

    public Equals(int a,int b,int c){

    }


    public static void add3(Integer i){
        int val = i.intValue();
        System.out.println(val);
        val += 3;
        i = new Integer(val);

    }
    public static void main(String args[]){

        Integer i=new Integer(0);
        add3(i);
        System.out.println(i.intValue());

        boolean[] bb = new boolean[1];
        System.out.print(bb[0]);
    }
}
