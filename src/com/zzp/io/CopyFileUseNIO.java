package com.zzp.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by zzy on 2017/8/20.
 * 标准输入输出NIO
 */
public class CopyFileUseNIO {
    public static void copyFileuseNIO(File fileIn,File fileOut) throws IOException {
        FileInputStream fis = new FileInputStream(fileIn);
        FileOutputStream fos = new FileOutputStream(fileOut);
        FileChannel channelIn = fis.getChannel();
        FileChannel channelOut = fos.getChannel();

        ByteBuffer bb = ByteBuffer.allocate(1024);
        int aa;
        while((aa=channelIn.read(bb))!=-1){
            bb.flip();
            channelOut.write(bb);
            bb.clear();
        }
        channelOut.close();
        channelIn.close();
    }


    public static void main(String args[]) throws IOException {
        String filePath = new File("").getAbsolutePath();
        File inFile = new File(filePath+"\\tree.txt");
        File outFile = new File(filePath+"\\c.txt");
        copyFileuseNIO(inFile,outFile);
    }

}
