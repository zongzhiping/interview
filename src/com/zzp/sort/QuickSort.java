package com.zzp.sort;

import java.util.Arrays;

/**
 * Created by zzy on 2017/7/18.
 */
public class QuickSort {
    public static void main(String[] args) {
        //int []a = {23,45,32,13,56,7,34,33,24} ;
        int []a = {45,32,56,34,33,24} ;
        sort(a,0,a.length-1) ;
        System.out.println(Arrays.toString(a));
    }


    public static void sort(int a[],int low,int high){
        int middle = getMiddle(a,low,high);
        getMiddle(a,low,middle-1);
        getMiddle(a,middle+1,high);
    }

    public static int getMiddle(int a[],int low,int high){
        int temp = a[low];
        while (low<high){
            while (low<high&&temp<a[high]){
                high--;
            }
            if(a[low]>a[high]){
                int aa = a[high];
                a[high] = a[low];
                a[low] = aa;
            }


            while (low<high&&temp>=a[low]){
                low++;
            }
            if(temp<a[low]){
                int aa = a[low];
                a[low] = a[high];
                a[high] = aa;
            }

        }
        a[low] = temp;
        return low;
    }
}
