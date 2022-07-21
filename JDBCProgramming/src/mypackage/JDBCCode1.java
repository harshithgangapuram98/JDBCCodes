
package mypackage;
import java.util.Scanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBCCode1 {

	private static Connection con;
	private static PreparedStatement pstmt;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");//loading the driver
		System.out.println("Driver Loaded");
	con =	DriverManager.getConnection("jdbc:mysql://localhost:3306/simplijdbc","root","root");//est connection
		
	//	query to insert data into database table
	
	String sql ="insert into student values(?,?,?,?)";//sid,sname,percentage,sem
	
	//prepare statemnt to be creted as we are using placeholders in the query
	
	pstmt = con.prepareStatement(sql);
	//static
//	pstmt.setInt(1, 1);
//	pstmt.setString(2, "Harshith");
//	pstmt.setInt(3, 81);
//	pstmt.setString(4, "4th sem");
	
	//dynamic
	System.out.println("Enter the student id : ");
	pstmt.setInt(1, sc.nextInt());
	System.out.println("Enter the student name : ");
	pstmt.setString(2, sc.next());
	System.out.println("Enter the percentage : ");
	pstmt.setInt(3, sc.nextInt());
	System.out.println("Enter the sem : ");
	pstmt.setString(4, sc.next());
	
	int x = pstmt.executeUpdate();
	if(x>0)
		System.out.println("Data inserted");
	else
		System.out.println("Failed to insert data");
	
	pstmt.close();
	con.close();
	

	}

}
