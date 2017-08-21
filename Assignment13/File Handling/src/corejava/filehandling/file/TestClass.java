package corejava.filehandling.file;

import java.io.*;
import java.io.FileInputStream;

public class TestClass {

	public static void main(String[] args) throws Exception {
		File file1=new File("output.txt");
		File file2=new File("input.txt");
		
/*		FileOutputStream fos=new FileOutputStream(file2);
		
		fos.write("Hello".getBytes());
		fos.flush();
		fos.close();*/
		
		FileInputStream fis=new FileInputStream(file1);
		int i=0;
		StringBuilder sb=new StringBuilder();
		do{
			i=fis.read();
			if(i!=-1)
				sb.append((char)i);
		}while(i!=-1);
		System.out.println(sb.toString());
		fis.close();
	}
}
