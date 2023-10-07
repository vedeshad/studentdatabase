package jdbcproject;

import java.sql.SQLException;
import java.util.Scanner;

public class MainClass 
{
	static Scanner sc = new  Scanner(System.in);
	public static void main(String[] args) throws SQLException
	{
		
		boolean check = true;
		while(check)
		{
			System.out.println("Press 1 To Insert Student Details");
			System.out.println("Press 2 To Delete Student Details");
			System.out.println("Press 3 To See the Student Details");
			System.out.println("Press 4 To See Full Details");
			System.out.println("Press 5 To Exit");
			int val = sc.nextInt();
			switch(val)
			{
			case 1:
				Student a =new Student();
				System.out.println("Enter Student ID");
				a.setId(sc.nextInt());
				System.out.println("Enter Student Name");
				a.setName(sc.next());
				System.out.println("Enter Student Email");
				a.setEmail(sc.next());
				System.out.println("Enter Student Contact");
				a.setContact(sc.nextLong());
				
				Methods.insertMethod(a);
				System.out.println();
				break;
			case 2 :
				System.out.println("Enter Student ID");
				Student a1 = new Student();
				a1.setId(sc.nextInt());
				Methods.deleteMethod(a1);
				System.out.println();
				break;
				
			case 3 :
				System.out.println("Enter Student ID to See Details");
				Student a2 = new Student();
				a2.setId(sc.nextInt());
				Methods.retriveMethod(a2);
				System.out.println();
				break;
				
			case 4 :
				Student.setList(Methods.findAll());
				for(Student s : Student.getList())
				{
					System.out.println("Student ID : "+s.getId());
					System.out.println("Student Name : "+s.getName());
					System.out.println("Student Email : "+s.getEmail());
					System.out.println("Student Contact : "+s.getContact());
					System.out.println();
				}
				break;
				
			case 5:
				System.out.println("Thank You");
				check=false;
				break;
				
			default :
				System.out.println("Enter The Correct Number...");
				System.out.println();
						
			}
		}
		
	}
	

}
