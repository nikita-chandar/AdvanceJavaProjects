package Com.jdbc.crud;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class CRUDOperation {

	int id;
	String Name;
	String Phone;
	public static void main(String[] args) throws SQLException {
		Scanner scanner=new Scanner(System.in);
		
		// TODO Auto-generated method stub
		System.out.println("-----------------------------------------------------------");
		System.out.println("                       CRUD OPERATION                        ");
		System.out.println("-----------------------------------------------------------");
		System.out.println("1 . Insert Record");
		System.out.println("2 .Update Record");
		System.out.println("3 .Delete Record");
		System.out.println("4.Fetch Record");
		System.out.println("5 . Exit");

		System.out.print("Enter your choice : ");
		int ch = scanner.nextInt();

		switch (ch) {
		case 1:
			System.out.println("1 . Insert Record");
			insertRecord();
			break;
		case 2:
			System.out.println("2 .Update Record");
			break;
		case 3:
			System.out.println("3 .Delete Record");
			break;
		case 4:
			System.out.println("4.Fetch Record");
			break;
		default:
			System.out.println("incorrect option!!");
		}



	}
	
	public void insertRecord()
	{
		String url="jdbc:mysql://localhost:3306/persondb?user=root & password=root";
		String query="INSERT INTO PERSON VALUES(?,?,?)";
		
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		Connection connection=DriverManager.getConnection(url);
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		preparedStatement.setString(1, Name);
		preparedStatement.setString(2,Phone);
		int count=preparedStatement.executeUpdate();
		if(count==1)
		{
			System.out.println("Record added..");
		}
		else
		{
			System.out.println("Empty set");
		}
		connection.close();
	}
	
	public void UpdateRecord()
	{
		String url="jdbc:mysql://localhost:3306/persondb?user=root & password=root";
		String query="UPDATE PERSON SET NAME=?,PHONE=? where id=1";
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		Connection connection=DriverManager.getConnection(url);
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		preparedStatement.setString(1, Name);
		preparedStatement.setString(2, Phone);
		
		
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

}
