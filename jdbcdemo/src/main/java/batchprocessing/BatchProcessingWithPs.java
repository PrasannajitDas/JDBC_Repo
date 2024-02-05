package batchprocessing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class BatchProcessingWithPs {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "Das@2023#");
		PreparedStatement ps = con.prepareStatement("insert into student(id,name,age) values(?,?,?)");
		Scanner sc = new Scanner(System.in);
		for (int i = 1; i <= 3; i++) {
			System.out.println("Enter id : ");
			int id = sc.nextInt();

			System.out.println("Enter name : ");
			String name = sc.next();

			System.out.println("Enter age : ");
			int age = sc.nextInt();

			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setInt(3, age);

			ps.addBatch();
		}
		ps.executeBatch();
		System.out.println("BatchProcessing executed successfully");
	}
}
