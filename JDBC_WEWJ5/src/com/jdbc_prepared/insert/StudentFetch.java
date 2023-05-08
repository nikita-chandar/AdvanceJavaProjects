package com.jdbc_prepared.insert;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class StudentFetch {
	
	public static void main(String[] args) throws SQLException {
		Scanner scanner =new Scanner(System.in);
		System.out.println("Enter the id");
		int id=scanner.nextInt();
		String url="jdbc:mysql://localhost:3306/studentinfo?user=root & password=root";
		String query="SELECT * FROM STUDENT WHERE ID=?";
		
		Driver driver=new  com.mysql.cj.jdbc.Driver();//THIS IS UPCASTING
		DriverManager.registerDriver(driver);
		Connection connection=DriverManager.getConnection(url);
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		preparedStatement.setInt(1, id);
		ResultSet resultSet=preparedStatement.executeQuery(query);//resultset is return type of executeQuery
		while(resultSet.next())
		{
			System.out.println(resultSet.getInt(1));
			System.out.println(resultSet.getString(2));
			System.out.println(resultSet.getLong("phone"));
			System.out.println(resultSet.getString("marks"));
			System.out.println(resultSet.getString(5));
			System.out.println("*****************************");
		}
		connection.close();
		
		


	}

}
