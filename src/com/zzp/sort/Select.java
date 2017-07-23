package com.zzp.sort;

import java.util.Arrays;

/**
 * Created by zzy on 2017/7/17.
 */
public class Select {
    public static void main(String args[]){
        int a[] = new int[]{4,3,4,5,2,3,1,3};
        int temp;
        for(int i = 0 ; i <a.length ; i++){
            int k = i;
            for(int j = i+1 ; j < a.length ; j++){
                if(a[k]>a[j]){
                    k = j ;

                }
            }


            temp = a[k];
            a[k] = a[i];
            a[i] = temp;
        }
        System.out.println(Arrays.toString(a));

        selectSort(a);
        System.out.println(Arrays.toString(a));

    }

    static void selectSort(int b[]){
        for(int i = 0 ; i < b.length ; i++){
            int k = i,temp;
            for(int j = i+1 ; j < b.length ; j++){
                if(b[k]>b[j]){
                    k = j;
                }
            }

            temp = b[i];
            b[i] = b[k];
            b[k] = temp;
        }
    }
}
