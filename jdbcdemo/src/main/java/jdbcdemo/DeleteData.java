package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteData {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection ct1=DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "Das@2023#");
		Statement stt2=ct1.createStatement();
		stt2.execute("delete from student where id=105");
		System.out.println("Data Deleted Successfully");
	}

}
