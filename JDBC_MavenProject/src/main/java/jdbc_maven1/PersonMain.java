package jdbc_maven1;

import java.io.IOException;


import java.sql.SQLException;
import java.util.Scanner;

public class PersonMain {
	             
			public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
				Person person=new Person();
			
				Scanner sc=new Scanner(System.in);
				PersonCRUD crud=new PersonCRUD();
				boolean condition=true;
				do
				{
				System.out.println("Enter the choice \n1.Save Person \n2.Update Person \n3.Delete Person \n4.get personBy Id \n5.get person for All \n6.Exit");
				int choice=sc.nextInt();
				switch(choice)
				{
				case 1:
				{
				System.out.println("Enter id:");
				int id=sc.nextInt();
				System.out.println("Enter Name:");
				String name=sc.next();
				System.out.println("Enter Phone:");
				long phone=sc.nextLong();
				
				person.setId(id);
				person.setName(name);
				person.setPhone(phone);
				
				crud.savePerson(person);
				}
				break;
				case 2:
				{
				System.out.println("Enter id:");
				int id=sc.nextInt();
				System.out.println("Enter Name:");
				String name=sc.next();
				System.out.println("Enter Phone:");
				long phone=sc.nextLong();
				
				person.setId(id);
				person.setName(name);
				person.setPhone(phone);
				
				crud.updatePerson(person);
				}
				break;
				case 3:
				{
				System.out.println("Enter id:");
				int id=sc.nextInt();
				crud.deletePerson(id);
				}
				break;
				
				case 4:{
					System.out.println("Enter id:");
					int id=sc.nextInt();
				    crud.getpersonById(id);	
				}
				break;
				
				case 5:
				{	crud.getpersonForAll();
				}
				break;
				case 6:
				{	
					System.out.println("5.Exit.");
				}
				break;
				
				default:
					System.out.println("Incorrect statement ..plz try Again");
					condition=false;
				}

			}
				while(condition=false);
}
}

