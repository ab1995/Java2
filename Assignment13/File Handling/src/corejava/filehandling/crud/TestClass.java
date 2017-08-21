package corejava.filehandling.crud;

import java.io.*;
import java.util.*;

public class TestClass {
	
	static File file = new File("accounts.txt");
	
	public static void insertRecord() throws Exception{
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		raf.seek(raf.length());
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Name: ");
		StringBuilder name=new StringBuilder(sc.nextLine());
		//String name=sc.nextLine();
		System.out.println("Enter id: ");
		int id=sc.nextInt();
		System.out.println("Enter Balance");
		double balance=sc.nextDouble();
		
		/*for(int i=name.length()-1;i<24;i++)
			name.append( " " );*/
		
		raf.writeInt(id);
		raf.writeDouble(balance);
		raf.writeUTF(name.toString()+"\n");
		raf.close();
		
	}
	
	public static void readRecord() throws Exception{
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		raf.seek(0);
		
		System.out.println("ID \tBalance \tName");
		while(true){
			   try{
				   	int id=raf.readInt();
				   	if(id!=-1)
				   		System.out.println(id+"\t"+raf.readDouble()+"\t\t"+raf.readUTF());
				   	else{
				   		raf.readDouble();
				   		raf.readUTF();
				   	}
					
			   } catch(EOFException e){
			      break;
			   }
			}
		raf.close();
	}
	
	public static void findRecord() throws Exception{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter ID: ");
		int idToSearch=sc.nextInt();
		
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		raf.seek(0);
		boolean flag=false;
		while(true){
			   try{
					if(raf.readInt()==idToSearch){
						raf.seek(raf.getFilePointer()-4);
						System.out.println("ID \tBalance \tName");
						System.out.println(+raf.readInt()+"\t"+raf.readDouble()+"\t\t"+raf.readUTF());
						flag=true;
						break;
					}
					else{
						raf.readLine();
					}
					
			   } catch(EOFException e){
			      break;
			   }
			}
		if(flag==false){
			System.out.println("No Record Found!");
		}
		raf.close();
		
	}
	
	public static void deleteRecord() throws Exception{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter ID: ");
		int idToSearch=sc.nextInt();
		
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		raf.seek(0);
		boolean flag=false;
		while(true){
			   try{
					if(raf.readInt()==idToSearch){
						raf.seek(raf.getFilePointer()-4);
						raf.writeInt(-1);
						flag=true;
						break;
					}
					else{
						raf.readLine();
					}
					
			   } catch(EOFException e){
			      break;
			   }
			}
		if(flag==false){
			System.out.println("No Record Found!");
		}
		else{
			System.out.println("Entry Deleted Successfully!");
		}
		raf.close();
	}
	
	public static void updateRecord() throws Exception{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter ID: ");
		int idToSearch=sc.nextInt();
		
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		raf.seek(0);
		boolean flag=false;
		while(true){
			   try{
					if(raf.readInt()==idToSearch){
						
						System.out.println("Enter new Balance");
						double balance=sc.nextDouble();
						
						sc.nextLine();
						
						System.out.println("Enter new Name: ");
						String name=sc.nextLine();
						
						raf.writeDouble(balance);							
						raf.writeUTF(name);
						flag=true;
						break;
					}
					else{
						raf.readLine();
					}
					
			   } catch(EOFException e){
			      break;
			   }
			}
		if(flag==false){
			System.out.println("No Record Found!");
		}
		raf.close();
	}

	public static void main(String[] args) throws Exception {
		
		
		
		Scanner sc=new Scanner(System.in);
		int choice;
		do{
			System.out.println(" 1) Insert Record. \n 2) Display Records\n 3) Find Record\n 4) Update Record\n 5) Delete Record\n 6) Exit\n Enter your Choice: ");
			choice=sc.nextInt();
			
			switch(choice){
			case 1:	insertRecord();
					break;
			case 2: readRecord();
				break;
			case 3: findRecord();
					break;
			case 4: updateRecord();
				break;
			case 5: deleteRecord();
				break;
			case 6: break;
			default: System.out.println("Please enter valid choice.");
			}
			
		}while(choice!=6);
	}
}
