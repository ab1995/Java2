package corejava.filehandling.datainput;

import java.io.*;

public class TestClass {

	public static void main(String[] args) throws Exception {
		File file=new File("input.txt");
		FileInputStream fis=new FileInputStream(file);
		FileOutputStream fos=new FileOutputStream(file);
		DataInputStream dis = new DataInputStream(fis);
		DataOutputStream dos = new DataOutputStream(fos);
		
		Account[] accs=new Account[3];
		accs[0]=new Account(1,100,"a");
		accs[1]=new Account(2,200,"b");
		accs[2]=new Account(3,300,"c");
		
		for(int i=0;i<3;i++)
		{
			dos.writeInt(accs[i].getId());
			dos.writeDouble(accs[i].getBalance());
			dos.writeBytes(accs[i].getName());
			dos.flush();
			fos.flush();
		}
		
		dos.close();
		fos.close();
		
		for(int i=0;i<3;i++)
		{
			System.out.println("Name: "+dis.readInt()+"\t Balance: "+dis.readDouble()+"\t Name: "+dis.readByte());
		}		
		dis.close();
		fis.close();
	}
}
