package jdbc.Delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeDelete {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String className="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/employeedb";
		String userName="root";
		String password="root";
		String query="Delete FROM EMPLOYEE WHERE ID=1";
		
		Class.forName(className);
		Connection conn=DriverManager.getConnection(url,userName,password);
		Statement statement=conn.createStatement();
		int res=statement.executeUpdate(query);
		if(res==1)
		{
			System.out.println("Deleted");
		}
		else
		{
			System.out.println("Not Deleted");
		}
		
		conn.close();
	}

}
