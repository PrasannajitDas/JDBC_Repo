package batchprocessing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchProcessingWithStatement {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "Das@2023#");
		Statement st=con.createStatement();
		st.addBatch("insert into user(id,name,mobileno,email,password,age) values(1011,'mikul',44551,'a@gmail.com','das',25)");
		st.addBatch("insert into user(id,name,mobileno,email,password,age) values(1022,'ranga',44751,'n@gmail.com','fas',27)");
		st.addBatch("update user set name='kula' where id=1045");
		st.addBatch("insert into user(id,name,mobileno,email,password,age) values(1031,'burger',4587,'c@gmail.com','hgs',49)");
		st.addBatch("insert into user(id,name,mobileno,email,password,age) values(1531,'nolan',7851,'cf@gmail.com','458',99)");
		st.executeBatch();
		System.out.println("Batch executed sucessfully");
	}
}
