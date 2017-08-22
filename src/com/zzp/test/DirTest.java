package com.zzp.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by zzy on 2017/8/18.
 */
public class DirTest {
    public static void main(String args[]) throws IOException {
        String s = new File("DirTest.class").getAbsolutePath();
        s = s.substring(0,s.lastIndexOf("\\"));
        File file = new File(s);
        BufferedWriter bw=new BufferedWriter(new FileWriter(new File(s+"\\tree.txt")));
        new DirTest().sayFileName(file,bw);
        bw.flush();
        bw.close();
    }

    public int k=0;
    public String getStr(int i){
        String str="";
        for (int j = 0; j <i; j++) {
            str+="\t";
        }
        return str;
    }
    public void sayFileName(File file,BufferedWriter bw) throws IOException{
        for(File f:file.listFiles()){
            if (f.isDirectory()) {
                bw.write(getStr(k)+f.getName()+"(dir)"+"\r\n");
                k++;
                sayFileName(f,bw);
                k--;
            } else {
                bw.write(getStr(k)+"|--"+f.getName()+"\r\n");
            }
        }
    }
}
