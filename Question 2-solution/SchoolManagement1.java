
/*2)

 1)Inserting a record

ABC International School wants to computerize students details.

The school maintains a database of students in MYSQL.

The student table contains information related to students and is shown in the following student table structure.

Column Name Type Constraint

Rollno Number (4) Primary Key

StudentName Varchar (20) Not Null

Standard Varchar (2) Not Null

Date_Of_Birth Date

Fees Number (9,2)

 When a new student joins the school, the student record is inserted in the student table.

The valid student details are as follows:

• Rollno: Valid value is a 4-digit number

• StudentName: Valid value can contain maximum 20 letters in uppercase

• Standard : Valid values are Roman Letters representing I to X(I, II, III, IV….IX, X)

Display Student details

Write the code to display details of all the students, if no roll no. is passed, while executing the main program.

If while executing the main program, the roll no. is passed, then it should display the record of that particular student*/

/*Write a Java program to insert some records to the table and display all the records from student table*/


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SchoolManagement1 {

	public static void main(String[] args) throws Exception {
		
		Scanner sc= new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gl", "root", "root");
		//while(true)
		//{
			System.out.println("Press 1 to insert Student record");
			System.out.println("press 2 to delete student record");
			System.out.println("Press any other key to exit");
			System.out.println();
			int i=Integer.parseInt(args[0]);
			switch(i) 
			{ 
			   case 1:
				   int rollno;
				   String s="";
				   boolean rollflag=false;
				   do 
				   {   
					   System.out.println("Enter the 4 digit Rollno");
					   rollno=sc.nextInt();
					   s=String.valueOf(rollno);
					   if(s.length()==4)
					   {
						   rollno=Integer.parseInt(s);
						   rollflag=true;
					   }
					   else
					   {   
						   System.out.println("Invalid input! Please enter 4 digit Rollno.");
						   System.out.println();
					   }
					 
				   }
				   while(!rollflag);
				   
				   String name;
				   boolean nameflag=false;
				   sc.nextLine();
				   do 
				   {
					    System.out.println("Enter the name of student in UpperCase with length<=20");
					    
					    name=sc.nextLine();
					    String name1=name.toUpperCase();
					    if(name.equals(name1) && name.length()<=20)
					    {
					    	nameflag=true;
					    }
					    else
					    {
					    	System.out.println("Please enter the name in upper case or length of name should be less than 20!!");
					    	System.out.println();
					    }

					    
				   }
				   while(!nameflag);
				  
				   String std = "";
				   boolean stdflag= false;
					  List<String> list = new ArrayList<String>();
					  
					  list.add("I");
					  list.add("II");
					  list.add("III");
					  list.add("IV");
					  list.add("V");
					  list.add("VI");
					  list.add("VII");
					  list.add("VIII");
					  list.add("IX");
					  list.add("X");
				  do 
				  {  
				  System.out.println("Enter the standard in Roman");
				  std=sc.nextLine();
				  if(list.contains(std))
				  { 
					  stdflag=true;
					  
				  }
				  else
				  {   
					  System.out.println("Please enter Standard in range(I-X)!!");
					  System.out.println();
				
				  }
				  }
				  while(!stdflag);
					  
				  System.out.print("Enter Date of Birth : ");
				  String dob = sc.nextLine();
	              System.out.println();
				  System.out.print("Enter fees of the student : ");
				  double fees = sc.nextDouble();
				  
				  String query = "insert into student values(?, ?, ?, ?, ?)";
				  PreparedStatement p= con.prepareStatement(query);
				  p.setInt(1, rollno);
				  p.setString(2, name);
				  p.setString(3, std);
				  p.setString(4, dob);
				  p.setDouble(5, fees);
				  p.executeUpdate();
				  System.out.println("Student registered successfully...");
				  System.out.println();
				  break;
			 
			   case 2:
				   rollno = Integer.parseInt(args[1]);

				   System.out.println(DAO.display(rollno));
				   break;
				  
				default:
					 System.out.println(DAO.displayAll());
				     break;
			
			}
			   
			
			
			
			
	
		
		
		

		

	}

}
