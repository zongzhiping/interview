package com.zzp.sort;

import java.util.Arrays;

/**
 * Created by zzy on 2017/7/17.
 */
public class Bubbling {
    public static void main(String args[]){
        int b[] = {1,2,3,4,5};
        int a[] = new int[]{2,3,4,5,2,3,1};
        int temp;

        for(int i = 0 ; i < a.length ; i++){
            for(int j = i+1 ; j < a.length ; j++){
                if(a[i]>a[j]){
                    temp =a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(a));
    }
}
