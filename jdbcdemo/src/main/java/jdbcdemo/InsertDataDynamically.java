package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertDataDynamically {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "Das@2023#");
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter id");
		int id=sc.nextInt();
		
		System.out.println("Enter name");
		String name=sc.next();
		
		System.out.println("Enter age");
		int age=sc.nextInt();
		
		PreparedStatement ps=con.prepareStatement("insert into student(id,name,age) values(?,?,?)"); 
		//?--> Placeholder (bcz we don't know the values that user will enter at runtime), so its an incomplete query.
		
		ps.setInt(1, id);//(Placeholder index, id taking input dynamically)
		ps.setString(2, name);
		ps.setInt(3, age);
		 
		ps.execute();//have to execute
		
		System.out.println("Data inserted successfully");
		
	}
}
