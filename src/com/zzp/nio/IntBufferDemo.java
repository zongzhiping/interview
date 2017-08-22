package com.zzp.nio;

import java.nio.IntBuffer;

/**
 * Created by zzy on 2017/8/22.
 */
public class IntBufferDemo {
    public static void main(String args[]){
        IntBuffer ib = IntBuffer.allocate(10);
        System.out.println("写入数据之前的position,limit,capacity");
        System.out.println("position:"+ib.position()+" ,limit:"+ib.limit()+" ,capacity:"+ib.capacity());
        ib.put(2);
        int[] temp = {12,4,6};
        ib.put(temp);
        System.out.println("写入数据之后的position,limit,capacity");
        System.out.println("position:"+ib.position()+" ,limit:"+ib.limit()+" ,capacity:"+ib.capacity());

        ib.flip();//重设缓冲区
        System.out.println("------------------------");
        System.out.println("position:"+ib.position()+" ,limit:"+ib.limit()+" ,capacity:"+ib.capacity());

        while(ib.hasRemaining()){
            System.out.print(ib.get()+",");
        }

    }
}
