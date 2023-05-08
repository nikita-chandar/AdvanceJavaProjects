package com.jdbc_prepared.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class StudentDelete {

	public static void main(String[] args) throws SQLException {
		
		String url="jdbc:mysql://localhost:3306/ studentinfo?user=root& password=root";
		String query="DELETE FROM STUDENT WHERE ID=1";
		
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
	Connection connection=DriverManager.getConnection(url);
	PreparedStatement preparedStatement=connection.prepareStatement(query);
	int res=preparedStatement.executeUpdate(query);
	if(res==1)
	{
		System.out.println("Deleted");
	}
	else
	{
		System.out.println("Not Deleted");
	}
	
	connection.close();
}



	
	}

