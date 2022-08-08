

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
	static Connection con=null;
	static PreparedStatement p=null;
	static {
		
		 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 try {
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gl", "root", "root");
			} 
			 catch (SQLException e) {
				e.printStackTrace();
			}
		}
		 catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
 
	}
	public static boolean insert (int rollno,String name,String std,String dob ,double fee)throws SQLException
	{
		String query = "insert into student values(?, ?, ?, ?, ?)";
		  PreparedStatement p= con.prepareStatement(query);
		  p.setInt(1, rollno);
		  p.setString(2, name);
		  p.setString(3, std);
		  p.setString(4, dob);
		  p.setDouble(5, fee);
		  p.executeUpdate();
		  return true;
	}
	
	
   public static boolean display(int rollno)throws SQLException {
		
		String query = "select * from student where rollno = ?";
		
		p = con.prepareStatement(query);
		
		p.setInt(1,rollno);
		ResultSet rs = p.executeQuery();
		
		while(rs.next()) {
			int roll = rs.getInt("RollNo");
			String name = rs.getString("studentname");
			String std = rs.getString("standard");
			String dob = rs.getString("Date_of_Birth");
			double fee = rs.getDouble("fee");
			
			System.out.format("%15s %15s %15s %15s %15s\n", roll, name, std, dob, fee);
		}
		
		return true;
	}
    public static boolean displayAll() throws SQLException{

		String query = "select * from student";
		
		p = con.prepareStatement(query);
		ResultSet rs = p.executeQuery();
		
		while(rs.next()) {
			int roll = rs.getInt("RollNo");
			String name = rs.getString("studentname");
			String std = rs.getString("standard");
			String dob = rs.getString("Date_of_Birth");
			double fee = rs.getDouble("fee");
			
			System.out.format("%15s %15s %15s %15s %15s\n", roll, name, std, dob, fee);
		}
		
		return true;
     }
	
}
