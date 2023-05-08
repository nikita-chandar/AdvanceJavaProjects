package jdbc.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeInsert {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//TODO Auto-generated method stub
		
		//1.Load or Register the Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver loaded..");
		//2.Establish Connection
		Connection conn;
		
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306 /employeedb","root","root");
		
		System.out.println("Connection Establish");
		//create statment
		Statement statement=conn.createStatement();
		
		//4.Excute Statement
		statement.execute("Insert into Employee Values(1,'RAM',9870618976,'pune'),(2,'RAKESH',9876543210,'MUMBAI'),(3,'NIKHIL',9898007766,'DHULE')");
		
		//5.close connection
		conn.close();
		
	}

}
