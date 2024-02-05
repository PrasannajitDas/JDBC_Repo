package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertData {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connn=DriverManager.getConnection("jdbc:mysql://localhost:3306/School", "root", "Das@2023#");
		Statement stt=connn.createStatement();
//		stt.execute("insert into student(id,name,age) values(101,'Mikul',22)");
//		stt.execute("insert into Student(id,name,age) values(102,'Rishita',21)");
		stt.execute("INSERT INTO STUDENT VALUES(105,'Kathia',25)");
		stt.execute("INSERT INTO STUDENT VALUES(107,'Pratyasha',24)");
		System.out.println("Data inserted into the Table");
	}
}
