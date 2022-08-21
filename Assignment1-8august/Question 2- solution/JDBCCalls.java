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

If while executing the main program, the roll no. is passed, then it should display the record of that particular student

Write a Java program to insert some records to the table and display all the records from student table*/
import java.sql.SQLException;
public class JDBCCalls {
	

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		System.out.print("Enter your choice : ");
		int i= Integer.parseInt(args[0]);
		System.out.print(i+"\n");
		switch(i)
		{
		    case 1:
		    	int rollno = Integer.parseInt(args[1]);
				String name = args[2];
				String std = args[3];
				String dob = args[4];
				double amt = Double.parseDouble(args[5]);
				if(DAO.insert(rollno, name, std, dob, amt)) {
					System.out.println(" Row Inserted");
				}
				
				else {
					System.out.println("Insertion not take place");
				}
				break;
		  
				
		    case 2:
		    	rollno=Integer.parseInt(args[1]);
		    	if(DAO.display(rollno))
		    	{
		    		System.out.println();
		    		System.out.println("Records of Student with  Rollno:"+ rollno+"   is displayed");
		    	}
		    	else
		    	{
		    		System.out.println("Invalid rollno records not displayed");
		    	}
		    	break;
		    default :
		    	if(DAO.displayAll()) {
					System.out.println();
					System.out.println("All records displayed...");
				}
				else {
					System.out.println("Displaying of records not possible");
				}
				break;
		    
				
		    	
		}

	}

}
