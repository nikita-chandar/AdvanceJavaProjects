
package jdbc.update;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeUpdate {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String className="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/employeedb";
		String userName="root";
		String password="root";
		String query="UPDATE EMPLOYEE SET NAME='RAJ' WHERE ID=1";
		
		Class.forName(className);
		System.out.println("Driver loaded..");
		Connection conn;
			conn = DriverManager.getConnection(url,userName,password);
		
		System.out.println("Connection Establish");
		Statement statement=conn.createStatement();
		statement.execute(query);
		conn.close();
		
	}

}
