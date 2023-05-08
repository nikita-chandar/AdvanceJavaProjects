package jdbc.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentUpdate {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String className="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/employeedb";
		String username="root";
		String password="root";
		String query="UPDATE student SET SNAME='NIKHIL' WHERE ID=1";
		
		Class.forName(className);
		System.out.println("Driver Loaded..");
		Connection conn=DriverManager.getConnection(url,username,password);
		
		System.out.println("Connection Established...");
		Statement statement=conn.createStatement();
		statement.execute(query);
		conn.close();
		
		

	}

}
