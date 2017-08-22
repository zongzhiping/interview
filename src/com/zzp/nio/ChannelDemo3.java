package com.zzp.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by zzy on 2017/8/22.
 * 通道内存映射
 */
public class ChannelDemo3 {
    public static void main(String args[]) throws IOException{
        File file = new File("d:"+ File.separator+"mld.txt");
        FileInputStream fis = new FileInputStream(file);
        FileChannel fcin = fis.getChannel();
        MappedByteBuffer mbb = fcin.map(FileChannel.MapMode.READ_ONLY,0, file.length());

        byte[] b = new byte[(int) file.length()];
        while(mbb.hasRemaining()){
            for(int i = 0 ; i < b.length ; i++){
                b[i] = mbb.get();
            }
        }

        System.out.println(new String(b,"UTF-8"));

    }
}
