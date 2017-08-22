package com.zzp.nio;

import java.nio.IntBuffer;

/**
 * Created by zzy on 2017/8/22.
 * 只读缓冲区
 */
public class IntBufferDemo3 {
    public static void main(String args[]){
        IntBuffer ib = IntBuffer.allocate(10);
        IntBuffer sub  = null;
        for(int i = 0 ; i < ib.capacity() ; i++){
            ib.put(2*i+1);
        }

        sub = ib.asReadOnlyBuffer();

        sub.flip();
        while(sub.hasRemaining()){
            int temp = sub.get();
            System.out.print(temp+",");
        }

        sub.put(2);

    }
}
