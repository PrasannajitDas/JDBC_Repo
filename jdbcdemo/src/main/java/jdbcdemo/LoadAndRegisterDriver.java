package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class LoadAndRegisterDriver {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//Registering Driver 
		Class.forName("com.mysql.cj.jdbc.Driver");
		//(This is the other way for creating a class without using "new" keyword)
		//(forName is a static method, here it is creating the object of Driver class which is present in com.mysql.cj.jdbc package)
		System.out.println("Driver Registered successfully");
		
		//Establishing the Connection 
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "Das@2023#");
		//(Connection interface) (Helper class)	 (static method)  (Database url)	  (DB username)	(DB password)
		System.out.println("Connection Established");
		
		
	}

}
