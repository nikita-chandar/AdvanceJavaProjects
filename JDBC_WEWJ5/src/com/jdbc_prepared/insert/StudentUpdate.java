package com.jdbc_prepared.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class StudentUpdate {

	public static void main(String[] args) throws SQLException {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the id:");//sysou
		int id=sc.nextInt();
		System.out.println("Enter name:");
		String name=sc.next();
		System.out.println("Enter phoneNo:");
		long phone=sc.nextLong();
		System.out.println("Enter marks:");
		int marks=sc.nextInt();
		System.out.println("Enter Email:");
		String email=sc.next();
		
		String url="jdbc:mysql://localhost:3306/studentinfo?user=root &password=root";
		String query="UPDATE STUDENT SET NAME=?,PHONE=?,MARKS=?,EMAIL=? WHERE ID=1";
		
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		Connection connection=DriverManager.getConnection(url);
		PreparedStatement preparedStatement=connection.prepareStatement(query);
	
		preparedStatement.setString(1, name);
		preparedStatement.setLong(2, phone);
		preparedStatement.setInt(3, marks);
		preparedStatement.setString(4, email);
		int count=preparedStatement.executeUpdate();
		if(count==1)
		{
			System.out.println("updated");
		}
		else
		{
			System.out.println("not updated..");
		}
		connection.close();
	}

}
