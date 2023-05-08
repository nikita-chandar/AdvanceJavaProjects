package Com.jdbc.user;

import java.util.Scanner;

public class UserMain {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub 
		
		Scanner scanner=new Scanner(System.in);
		
		User user=new User();
		UserCRUD crud=new UserCRUD();
		boolean condition=true;
		do
		{
		System.out.println("Enter the choice");
		System.out.println("\n1.SignUP user  \n2.Login User \n3.Exit");
		int choice=scanner.nextInt();
		switch(choice)
		{
		case 1:
		{
		System.out.println("Enter the id");
		user.setId(scanner.nextInt());
		System.out.println("Enter the name");
		user.setName(scanner.next());
		System.out.println("Enter the email");
		user.setEmail(scanner.next());
		System.out.println("Enter the password:");
		user.setPassword(scanner.next());
		System.out.println("Enter the address");
		user.setAddress(scanner.next());
		
		crud.signupUser(user);
		}
		break;
		case 2:
		{
			System.out.println("Enter Username as email");
			String email=scanner.next();
			user.setEmail(email);
			System.out.println("Enter Password");
			user.setPassword(scanner.next());
			
			boolean result=crud.userLogin(user);
			if(result)
			{
				System.out.println("Logged in Succesfully!!");
				crud.displayPassword(email);
				boolean flag=true;
				
				do
				{
				System.out.println("Enter the choice \n1.Update Password \n2.Logout");
				int choice1=scanner.nextInt();
					switch(choice1)
					{
					case 1:{
						System.out.println("Enter facebook password");
						 String	facebbok=scanner.next();
						 System.out.println("Enter instagram password");
						 String	instagram=scanner.next();
						 System.out.println("Enter whatsapp password");
						 String	whatsapp=scanner.next();
						 System.out.println("Enter twitter password");
						 String	twitter=scanner.next();
						 System.out.println("Enter snapchaat password");
						 String	snapchaat=scanner.next();
						 		 
						 user.setFacebook(facebbok);
						 user.setInstagram(instagram);
						 user.setWhatsapp(whatsapp);
						 user.setTwitter(twitter);
						 user.setSnapchaat(snapchaat);
						 
						 crud.updatePassword(user);
					}
					 break;
					default:
						flag=false;
			     }		
				}while(flag);
				
	           }else
					{
						System.out.println("failed to login!!");
					}
				
			}
					
		case 3:System.out.println("Exit..");
		break;
		default:
			System.out.println("Incorrect statement.plz try Again");
			condition=false;
		}
	}while(condition);
	}
}
	
