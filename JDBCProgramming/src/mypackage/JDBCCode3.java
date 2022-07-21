package mypackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCCode3 {
	private static Connection con;
	private static ResultSet res;
	private static PreparedStatement pstmt;
	

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");//loading the driver
		System.out.println("Driver Loaded");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/simplijdbc", "root", "root");//establishing connection
		
		//query to insert data into database table
		String sq1 = "select * from student where sid=?";
		
		//create statement to be created
		pstmt = con.prepareStatement(sq1);
		
		//complete the query using prepared statement
		//pstmt.setInt(1, 1); //static
		
		System.out.println("Enter the student id to be searched");
		pstmt.setInt(1, sc.nextInt());//dynamic
		//execute the query
		res = pstmt.executeQuery();
		
		//fetch information from result set
		while(res.next()==true) {
		//	System.out.println(res.getInt(1)+"-----"+res.getString(2)+"----"+res.getInt(3)+"----"+res.getString(4));
			System.out.println(res.getInt("sid")+"-----"+res.getString("sname")+"----"+res.getInt("percentage")+"----"+res.getString("sem"));
		}
		res.close();
		pstmt.close();
		con.close();
		
	}
}