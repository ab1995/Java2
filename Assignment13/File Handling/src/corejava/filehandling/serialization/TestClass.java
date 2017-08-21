package corejava.filehandling.serialization;

import java.io.*;

public class TestClass {
	

	public static void main(String[] args) throws Exception  {
		File file=new File("output.txt");
		
		FileOutputStream fos=new FileOutputStream(file);
		 
		ObjectOutputStream out = new ObjectOutputStream(fos); 
		
		Account acc=new Account(1, 100, "a", new Date(1,1,1989));
		
		out.writeObject(acc);
		out.flush();
		fos.close();
		
		FileInputStream fis=new FileInputStream(file);
		ObjectInputStream in = new ObjectInputStream(fis);
		Account temp=(Account)in.readObject();
		in.close();
		fis.close();
		
		System.out.println(temp);
	}
	
}
