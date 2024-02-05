package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FetchData {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection ctn=DriverManager.getConnection("jdbc:mysql://localhost:3306/SCHOOL", "root", "Das@2023#");
		Statement stm=ctn.createStatement();
		ResultSet rs=stm.executeQuery("SELECT * FROM STUDENT where id=107");
		rs.next();
		
		System.out.println("Fetched Data is:-\n-----------------");
		System.out.println(rs.getInt("ID"));//here we are passing the column names
		System.out.println(rs.getString("name"));
		System.out.println(rs.getInt("age"));
		System.out.println();
		System.out.println("Fetched Data is:-\n-----------------");
		System.out.println(rs.getInt(1));//here we are passing the index value of the columns ,in sql index value starts from 1.
		System.out.println(rs.getString(2));
		System.out.println(rs.getInt(3));
	}
}
