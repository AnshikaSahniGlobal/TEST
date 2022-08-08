package jdbcCalls;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
	static Connection con;
	static PreparedStatement ps;
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
	

	
	public static boolean display(int rollno) throws SQLException {
		
		String query = "select * from student where rollno = ?";
		
		ps = con.prepareStatement(query);
		
		ps.setInt(1,rollno);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			int roll = rs.getInt("RollNo");
			String name = rs.getString("name");
			String std = rs.getString("standard");
			String dob = rs.getString("Date_of_Birth");
			double fee = rs.getDouble("fees");
			
			System.out.format("%15s %15s %15s %15s %15s\n", roll, name, std, dob, fee);
		}
		
		return true;
	}
	
	public static boolean displayAll() throws SQLException {
		
		String query = "select * from student";
		
		ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			int roll = rs.getInt("RollNo");
			String name = rs.getString("name");
			String std = rs.getString("standard");
			String dob = rs.getString("Date_of_Birth");
			double fee = rs.getDouble("fees");
			
			System.out.format("%15s %15s %15s %15s %15s\n", roll, name, std, dob, fee);
		}
		
		return true;
	}
	
}
