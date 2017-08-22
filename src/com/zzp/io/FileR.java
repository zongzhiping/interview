package com.zzp.io;

import java.io.*;

/**
 * Created by zzy on 2017/8/20.
 */
public class FileR {
    public static void main(String args[]) throws IOException {
        String Fpath = new File("").getAbsolutePath();
        InputStream is = new FileInputStream(new File(Fpath+"\\a.txt"));
        FileOutputStream fos = new FileOutputStream(new File(Fpath+"\\b.txt"));
        int a;
        byte[] b = new byte[10];
        while ((a =is.read(b))!=-1){
            fos.write(b,0,10);
        }
        fos.close();
        is.close();
    }
}
