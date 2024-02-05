package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateData {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection1=DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "Das@2023#");
		Statement state1=connection1.createStatement();
		state1.execute("UPDATE STUDENT SET NAME='Ronne' WHERE ID=105");
		System.out.println("data updated successfully");
	}
}
