package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c1=DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "Das@2023#");
		Statement st1=c1.createStatement();
		st1.execute("create table student(id int,name varchar(20),age int)");
		System.out.println("Database created successfully");
	}
}
