package corejava.filehandling.sequence;

import java.io.*;
import java.util.*;
public class TestClass {
 
	public static void main(String[] args) throws Exception{
		FileInputStream fin1=new FileInputStream("input.txt"); 
		FileInputStream fin2=new FileInputStream("output.txt"); 
		FileInputStream fin3=new FileInputStream("output.txt"); 
		
		Vector<FileInputStream> list =new Vector<>();
		//ArrayList<FileInputStream> list=new ArrayList<>();
		list.add(fin1);
		list.add(fin2);
		list.add(fin3);
		SequenceInputStream sis=new SequenceInputStream(list.elements());
		int i=0;
		StringBuilder sb=new StringBuilder();
		do{
			i=sis.read();
			if(i!=-1)
				sb.append((char)i);
		}while(i!=-1);
		System.out.println(sb.toString());
		sis.close();
	}
}
