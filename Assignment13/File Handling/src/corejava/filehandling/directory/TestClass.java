package corejava.filehandling.directory;

import java.io.*;
public class TestClass {
	
	public static void listFiles(File file){
		if(file.isDirectory()){
			for(File f:file.listFiles())
				listFiles(f);
		}
		
		else{
			System.out.println("File Name: "+file.getName()+"\t Size: "+file.length()+"\t File type: "+(file.isFile()?"File":"Directory"));
			
		}
	}

	public static void main(String[] args) {
		File file=new File("D:\\Softwares_for_freshers_training");	
		listFiles(file);
		
	}
}
