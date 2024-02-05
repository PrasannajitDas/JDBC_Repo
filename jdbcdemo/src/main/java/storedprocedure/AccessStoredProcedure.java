package storedprocedure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.CallableStatement;

public class AccessStoredProcedure {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "Das@2023#");
		java.sql.CallableStatement cs = con.prepareCall("{call fetchdata()}");
		ResultSet rs = cs.executeQuery();
		System.err.println("id\tname\tage");
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3));
		}
	}

}
