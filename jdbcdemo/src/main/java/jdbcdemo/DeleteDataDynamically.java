package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteDataDynamically {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "Das@2023#");
		PreparedStatement ps=con.prepareStatement("delete from user where name=?");
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter name : ");
		String name=sc.next();
		
		ps.setString(1, name);
		ps.execute();
		System.out.println("Data Deleted Successfully");
	}
}
