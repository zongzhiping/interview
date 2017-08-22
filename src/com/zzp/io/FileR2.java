package com.zzp.io;

import java.io.*;

/**
 * Created by zzy on 2017/8/20.
 */
public class FileR2 {
    public static void main(String args[]) throws IOException {
        String s = new File("").getAbsolutePath();
        Reader reader = new InputStreamReader(new FileInputStream(new File(s+"\\tree.txt")));
        Writer writer = new OutputStreamWriter(new FileOutputStream(new File(s+"\\b.txt")));
        int a = 0 ;
        while((a=reader.read())!=-1){
            writer.write(a);
        }
        writer.close();
        reader.close();
    }
}
