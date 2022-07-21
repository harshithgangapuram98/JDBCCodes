package mypackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCCode6 {
	private static Connection con;
	private static Statement stmt;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");//loading the driver
		System.out.println("Driver Loaded");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/simplijdbc", "root", "root");//establishing connection
		System.out.println("Enter the database name");
		String db_name = sc.next();
		
		String sql = "Create database "+db_name;
		
		stmt = con.createStatement();
		stmt.executeUpdate(sql);
		System.out.println("execution completed");
		
		
}
}