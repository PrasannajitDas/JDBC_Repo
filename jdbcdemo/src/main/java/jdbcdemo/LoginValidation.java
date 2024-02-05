package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LoginValidation {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);

		System.out.println("Please enter your email address : ");
		String email = sc.next();

		System.out.println("Please enter your Password : ");
		String password = sc.next();

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "Das@2023#");
		PreparedStatement ps = con.prepareStatement("select * from user where email=? and password=?");

		ps.setString(1, email);
		ps.setString(2, password);
//		(Here we we are taking input from user email and password , if the credentials will be correct then only the data will be fetched
//		and stored in ResultSet, otherwise ResultSet Object will be created,but no data will be stored in the ResultSet,
//		then we will get false, i.e. Invalid Credentials.)

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			System.out.println("Welcome to Mikul's Territory -->");
		} else {
			System.out.println("Invalid Credentials...!!!");
		}
	}
}
