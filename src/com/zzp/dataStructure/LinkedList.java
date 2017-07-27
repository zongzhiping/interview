package com.zzp.dataStructure;

import java.util.Arrays;

/**
 * Created by zzy on 2017/7/24.
 */
public class LinkedList {


    public static void main(String args[]){
         int oldArray[] = new int[]{1,2,3,4,5,6,7,8,9,10};
         int oldArray2[] = {1,2,3,4,5,10,6,7,8,8,9};
         int oldArray3[] = new int[10];
         int oldArray4[];
         oldArray4 = new int[10];

         int newArray[] = new int[20];
//        for(int i = 0 ; i < oldArray.length ; i++){
//            newArray[i] = oldArray[i];
//        }

        System.arraycopy(oldArray,0,newArray,0,oldArray.length);

        System.out.println(Arrays.toString(oldArray)+" "+newArray.length);
    }


    /**
     * 定义一个单向列表
     */
    static class Node<String>{
        String val;
        Node next;
    }

    /**
     * 单向列表的反转
     */
    static void revSta(Node<String> node){
        Node nextNode = null;
        Node current = node;
        Node preNode = null;

        Node newNode = null;

        while (current!=null){

            nextNode = current.next;

            if(nextNode==null){
                newNode = current;
            }

           current.next = preNode;
            preNode = current;
            current = nextNode;


        }
    }
}
