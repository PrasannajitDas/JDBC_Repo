package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecuteStatement {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "Das@2023#");
		Statement s=c.createStatement();
		s.execute("create database hospital");
		s.execute("create database school");//creating database hospital and school
		
	}
}
