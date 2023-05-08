package com.jsp.maven;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class BatchExecution {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Product product1 = new Product();
		product1.setId(1);
		product1.setName("TV");
		product1.setCost(22000);
		product1.setManufacturer("MI");
		
		Product product2=new Product();
		product2.setId(2);
		product2.setName("Laptop");
		product2.setCost(42000);
		product2.setManufacturer("Hp");
		
		Product product3=new Product();
		product3.setId(3);
		product3.setName("Freeze");
		product3.setCost(25000);
		product3.setManufacturer("Airpool");
		
		List<Product> list =new ArrayList<Product>();
		list.add(product1);
		list.add(product2);
		list.add(product3);
		
		Driver driver=new com.mysql.cj.jdbc.Driver();//upcasting
		DriverManager.registerDriver(driver);
		
		FileInputStream fileInputStream=new FileInputStream("Productdbcfg.properties");
		Properties properties=new Properties();
		properties.load(fileInputStream);
		
		Connection connection=DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("user"),properties.getProperty("password"));
		PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO PRODUCT VALUES(?,?,?,?)");
		
		for(Product product:list)
		{
		preparedStatement.setInt(1, product.getId());
		preparedStatement.setString(2, product.getName());
		preparedStatement.setInt(3, product.getCost());
		preparedStatement.setString(4,product.getManufacturer());
		preparedStatement.addBatch();
		}
		preparedStatement.executeBatch();
		System.out.println("BATCH EXCUTION IS DONE...");
		connection.close();
							
		

	}

}
