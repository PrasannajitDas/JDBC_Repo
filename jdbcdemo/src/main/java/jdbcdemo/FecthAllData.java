package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FecthAllData {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "Das@2023#");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from user");
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "    " + rs.getString(2) + "    " + rs.getInt(3) + "             "
					+ rs.getString(4) + "                   " + rs.getString(5) + "                 " + rs.getInt(6));
		}
	}
}
