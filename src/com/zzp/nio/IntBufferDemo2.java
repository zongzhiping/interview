package com.zzp.nio;

import java.nio.IntBuffer;

/**
 * Created by zzy on 2017/8/22.
 * <p>
 * 创建子缓冲区
 */
public class IntBufferDemo2 {
    public static void main(String args[]) {
        IntBuffer ib = IntBuffer.allocate(10);
        IntBuffer sub = null;

        for (int i = 0; i < ib.capacity(); i++) {
            ib.put(2 * i + 1);
        }

        ib.position(2);
        ib.limit(6);
        sub = ib.slice();

        for (int i = 0; i < sub.capacity(); i++) {
            int temp = sub.get(i);
            sub.put(temp - 1);
        }

        ib.flip();
        ib.limit(ib.capacity());

        while (ib.hasRemaining()) {
            int temp = ib.get();
            System.out.print(temp + ",");
        }


    }
}
