package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class FetchDataDynamically {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "Das@2023#");
		PreparedStatement ps=con.prepareStatement("select * from user where id=?");
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter id : ");
		int id=sc.nextInt();
		
		ps.setInt(1, id);
		
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getInt(3));
			System.out.println(rs.getString(4));
			System.out.println(rs.getString(5));
			System.out.println(rs.getInt(6));
			System.out.println("---------------------------");
//			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3))+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getInt(6));
		}else {
			System.out.println("Invalid Data");
		}
		
	}
}
