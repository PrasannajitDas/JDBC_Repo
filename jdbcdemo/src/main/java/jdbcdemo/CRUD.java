package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUD {
	
	public static Statement getStatement() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "Das@2023#");
		Statement st = con.createStatement();
		return st;
	}

	public void insertData() throws ClassNotFoundException, SQLException {
		CRUD.getStatement().execute("insert into student(id,name,age) values(105,'Kathi',25)");
		System.out.println("Data Inserted Successfully");
	}

	public void updateData() throws ClassNotFoundException, SQLException {
		CRUD.getStatement().execute("update student set name='Ronne' where id=107");
		System.out.println("Data updated successfully");
	}

	public void deleteData() throws ClassNotFoundException, SQLException {
		CRUD.getStatement().execute("delete from student where id=105");
		System.out.println("Data deleted successfully");
	}

	public void fetchData() throws ClassNotFoundException, SQLException {
		ResultSet rs = CRUD.getStatement().executeQuery("select * from student where id=101");
		rs.next();
		System.out.println(rs.getInt(1));
		System.out.println(rs.getString(2));
		System.out.println(rs.getInt(3));
		System.out.println("Data Fetched Successfully");
	}
}
