package jdbc.crud;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
	System.out.print("\n1.insert"); 
	System.out.print("\n2.update");
	System.out.print("\n3.Delete");
	System.out.print("\nEnter your choice : ");
	
	int option=scanner.nextInt();

	switch(option)
	{
		case 1 :System.out.println("insert");
				
				 break;
			    
		case 2 : System.out.println("update");
				
		 		 break;
		case 3 : System.out.println("delete");
					
				 break;
		case 4 : System.out.println("User want to exist..");
		 		 System.exit(0);
		 		 break;
	 default:System.out.println("incorrect option!!plz...Try again");
	 
	}
	}

}
