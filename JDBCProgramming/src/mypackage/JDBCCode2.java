package mypackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCCode2 {
	private static Connection con;
	private static PreparedStatement pstmt;
	private static Statement stmt;
	private static ResultSet res;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");//loading the driver
		System.out.println("Driver Loaded");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/simplijdbc", "root", "root");//establishing connection
		
		//query to insert data into database table
		String sq1 = "select * from student";
		
		//create statement to be created
		stmt = con.createStatement();
		
		//execute the query
		res = stmt.executeQuery(sq1);
		
		while(res.next()==true) {
			System.out.println(res.getInt(1)+"-----"+res.getString(2)+"----"+res.getInt(3)+"----"+res.getString(4));
		}
		res.close();
		stmt.close();
		con.close();
		
	}
}