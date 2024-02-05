package storedprocedure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateStoredProcedure {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "Das@2023#");
		Statement st=con.createStatement();
		st.execute("create Procedure fetchdata()"
				+ "begin " 
				+ "select * from student ; " 
				+ "end");
		System.out.println("Procedure Created");
	}

}
 