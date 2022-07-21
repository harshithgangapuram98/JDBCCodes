package mypackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCCode7 {
	private static Connection con;
	private static Statement stmt;
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");//loading the driver
		System.out.println("Driver Loaded");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/simplijdbc", "root", "root");//establishing connection
		System.out.println("Enter the table name:");
		String tb_name = sc.next();
		String sql = "Create table "+tb_name+" (empid int, "+"emp_name varchar(40), "+"emp_company varchar(60))";
		
		stmt = con.createStatement();
		stmt.executeUpdate(sql);
		System.out.println("execution completed");
	}
}