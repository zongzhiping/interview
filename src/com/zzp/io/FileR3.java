package com.zzp.io;

import java.io.*;

/**
 * Created by zzy on 2017/8/20.
 */
public class FileR3 {
    public static void main(String args[]) throws IOException {
        String filePath = new File("").getAbsolutePath();
        BufferedReader br = new BufferedReader(new FileReader(new File(filePath+"\\tree.txt")));
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(filePath+"\\b.txt")));
        String bb;
        while((bb = br.readLine())!=null){
            System.out.println(bb);
        }
    }
}
