package com.zzp.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by zzy on 2017/8/22.
 * 通道的读写操作
 */
public class ChannelDemo2 {
    public static void main(String args[]) throws IOException {
        FileInputStream fis = new FileInputStream(new File("d:\\13.txt"));
        FileOutputStream fos = new FileOutputStream(new File("d:\\14.txt"));
        ByteBuffer bbf = ByteBuffer.allocateDirect(1024);

        FileChannel fcin = fis.getChannel();
        FileChannel fcout = fos.getChannel();

        int a ;
        while((a=fcin.read(bbf))!=-1){
            bbf.flip();
            fcout.write(bbf);
            bbf.clear();
        }

        fcout.close();
        fcin.close();
        fos.close();
        fis.close();

    }
}
