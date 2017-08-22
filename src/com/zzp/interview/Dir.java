package com.zzp.interview;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Dir {
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
	public static void main(String[] args) throws Exception {
		String s=new File("Dir.class").getAbsolutePath();
		s=s.substring(0,s.lastIndexOf("\\"));
		long l=System.currentTimeMillis();
		File file=new File(s);
		BufferedWriter bw=new BufferedWriter(new FileWriter(new File(s+"\\dir.txt")));
		new Dir().sayFileName(file,bw);
		bw.flush();
		bw.close();
		System.out.println("success-->"+(System.currentTimeMillis()-l)+"ms");

	}

}
