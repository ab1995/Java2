package corejava.jdbc.image;

import java.sql.*;
import java.io.*;

public class TestClass {

	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "xoriant");

/*		PreparedStatement pstmt=con.prepareStatement("INSERT INTO IMGTABLE VALUES(?,?)");  
	  
		File file=new File("D:\\sample.jpg");
		FileInputStream fis=new FileInputStream(file);  
		pstmt.setString(1, file.getName());
		pstmt.setBinaryStream(2,fis,fis.available());  
		int i=pstmt.executeUpdate();  
		        
		fis.close();
		pstmt.close();
		con.close();*/  
		
		PreparedStatement ps=con.prepareStatement("select * from imgtable");  
		ResultSet rs=ps.executeQuery();  
		if(rs.next()){
		              
		Blob b=rs.getBlob(2);
		byte barr[]=b.getBytes(1,(int)b.length());
		              
		FileOutputStream fout=new FileOutputStream("D:\\output.jpg");  
		fout.write(barr);  
		              
		fout.close();  
		}//end of if  
		System.out.println("ok");
	}

}
