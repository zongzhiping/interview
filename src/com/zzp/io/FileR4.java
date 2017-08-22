package com.zzp.io;

import java.io.*;

/**
 * Created by zzy on 2017/8/20.
 */
public class FileR4 {
    public static void main(String args[]) throws IOException {
        LineNumberReader lr = new LineNumberReader(
                new FileReader(new File(new File("").getAbsolutePath()+"\\tree.txt")));
        lr.setLineNumber(100);
        String aa;
        while((aa=lr.readLine())!=null){
            System.out.print(lr.getLineNumber());
            System.out.println(aa);
        }
    }
}
