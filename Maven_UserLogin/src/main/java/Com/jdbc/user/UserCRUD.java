
package Com.jdbc.user;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class UserCRUD {
//INSIDE A JDBC  getConnectin() IS OVELOADED METHOD
	
	public Connection getConnection() throws IOException, ClassNotFoundException, SQLException
	{
		FileInputStream fileInputStream=new FileInputStream("dbcfg.properties");
		Properties properties =new Properties();
		properties.load(fileInputStream);
		
		Class.forName(properties.getProperty("className"));
		Connection connection=DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("user"),properties.getProperty("password"));
		return connection;
		
	}
	
	public void signupUser(User user) throws Exception
	{
		Connection connection=getConnection();
		PreparedStatement preparedstament=connection.prepareStatement("INSERT INTO USER(ID,NAME,EMAIL,PASSWORD,ADDRESS) VALUES(?,?,?,?,?)");
		preparedstament.setInt(1,user.getId());
		preparedstament.setString(2,user.getName());
		preparedstament.setString(3, user.getEmail());
		preparedstament.setString(4, user.getPassword());
		preparedstament.setString(5, user.getAddress());
		int count=preparedstament.executeUpdate();
		if(count==1)
		{
			System.out.println("SignedUp Succesfully!!");
			
		}
		else
		{
			System.out.println("Failed to sign up");
		}
		connection.close();
		
	}
	//for email we are using excuteQuery
	public boolean userLogin(User user) throws ClassNotFoundException, IOException, SQLException
	{
		Connection connection=getConnection();
		PreparedStatement preparedstatement=connection.prepareStatement(" SELECT * FROM USER WHERE EMAIL=?");
		preparedstatement .setString(1,user.getEmail());
		ResultSet resultset=preparedstatement.executeQuery();
		String password=null;//here we are writing password outside for providing it a global scope so hole method can access it.
		while(resultset.next())
		{
			password=resultset.getString("password");	
		}
		connection.close();
		if(password.equals(user.getPassword())) {
			
			return true;
			
		}
			return false;
		
		  
		  
	}
	public void displayPassword(String email) throws Exception
	{
		Connection connection=getConnection();
		PreparedStatement preparedstatement=connection.prepareStatement(" SELECT * FROM USER WHERE EMAIL=?");
		preparedstatement .setString(1,email);
		ResultSet resultset=preparedstatement.executeQuery();
		
		while(resultset.next())
		{
			System.out.println("The Saved Passwords are:");
			System.out.println("Facebook:"+resultset.getString("facebook"));
			System.out.println("Instagram:"+resultset.getString("instagram"));
			System.out.println("Whatsapp:"+resultset.getString("whatsapp"));
			System.out.println("Twitter:"+resultset.getString("twitter"));
			System.out.println("Snapchaat:"+resultset.getString("snapchaat"));
			
		}
		connection.close();
	}
	public void updatePassword(User user) throws SQLException, ClassNotFoundException, IOException
	{
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(
				"UPDATE USER SET FACEBOOK=?,INSTAGRAM=?,WHATSAPP=?,TWITTER=?,SNAPCHAAT=?WHERE EMAIL=?" );
		preparedStatement.setString(1, user.getFacebook());
		preparedStatement.setString(2, user.getInstagram());
		preparedStatement.setString(3, user.getWhatsapp());
		preparedStatement.setString(4, user.getTwitter());
		preparedStatement.setString(5, user.getSnapchaat());
		preparedStatement.setString(6, user.getEmail());
		
		int count=preparedStatement.executeUpdate();
		if(count==1)
		{
			System.out.println("Updated Succesfully!!");
		}
		else
		{
			System.out.println("Failed to Update");
		}
		connection.close();
	}
	
	
}	
	

