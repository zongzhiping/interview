package com.zzp.nio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by zzy on 2017/8/22.
 *
 * //双向传输
 */
public class ChannelDemo1 {
    public static void main(String args[]) throws IOException {
        File f = new File("d:\\12.txt");
        FileOutputStream fos = new FileOutputStream(f);
        FileChannel fc = fos.getChannel();

        ByteBuffer bbf = ByteBuffer.allocateDirect(1024);

        String str[] = {"zzz","bbb","ccc","ddadf"};
        for(int i = 0 ; i < str.length; i++){
            bbf.put(str[i].getBytes());
        }

        bbf.flip();

        fc.write(bbf);
        fc.close();;
        fos.close();;



    }
}
