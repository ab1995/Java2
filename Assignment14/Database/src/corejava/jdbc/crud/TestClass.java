package corejava.jdbc.crud;

import java.sql.*;

public class TestClass {

	public static void main(String[] args)  throws Exception{
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "xoriant");
/*		Statement stmt = con.createStatement();	
		int res=stmt.executeUpdate("UPDATE DEPT SET LOC='PUNE' WHERE DEPTNO = 30");
		//int res=stmt.executeUpdate("DELETE FROM DEPT WHERE DEPTNO=30");
		ResultSet rs = stmt.executeQuery("SELECT * FROM DEPT");
		while(rs.next()){
			System.out.println(rs.getInt("DEPTNO")+"\t"+rs.getString("DNAME")+"\t"+rs.getString("LOC"));
		}

		rs.close();
		stmt.close();
		con.close();*/
		
/*		PreparedStatement updateStmt=con.prepareStatement("UPDATE DEPT SET LOC='BANGLORE' WHERE DEPTNO = 30");
		updateStmt.executeUpdate();
		PreparedStatement pstmt=con.prepareStatement("SELECT * FROM DEPT");
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			System.out.println(rs.getInt("DEPTNO")+"\t"+rs.getString("DNAME")+"\t"+rs.getString("LOC"));
		}*/
		
		PreparedStatement readStmt=con.prepareStatement("SELECT * FROM DEPT");
		ResultSet rs=readStmt.executeQuery();
		PreparedStatement createTableStmt=con.prepareStatement("CREATE TABLE COPY_DEPT(DEPTNO NUMERIC(4), DNAME VARCHAR(20), LOC VARCHAR(20))");
		createTableStmt.executeUpdate();
		PreparedStatement insertStmt=con.prepareStatement("INSERT INTO COPY_DEPT VALUES(?,?,?)");
		
		while(rs.next()){
			insertStmt.setInt(1, rs.getInt("DEPTNO"));
			insertStmt.setString(2, rs.getString("DNAME"));
			insertStmt.setString(3, rs.getString("LOC"));
			insertStmt.executeUpdate();
		}
	
		PreparedStatement pstmt=con.prepareStatement("SELECT * FROM COPY_DEPT");
		rs=pstmt.executeQuery();
		while(rs.next()){
			System.out.println(rs.getInt("DEPTNO")+"\t"+rs.getString("DNAME")+"\t"+rs.getString("LOC"));
		}
	}
	
}
