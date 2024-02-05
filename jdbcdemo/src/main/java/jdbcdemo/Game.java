package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Game {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		int chances = 3;
		int[] sys_gen_num = new int[chances];
		int[] user_inp_num = new int[chances];

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id : ");
		int id = sc.nextInt();

		System.out.println("Enter name : ");
		String name = sc.next();

		Timestamp time = new Timestamp(System.currentTimeMillis());

		int score = 0;

		System.out.println("You have 3 chances!\nEnter number between 0 to 9... : \n");
		for (int i = 0; i < 3; i++) {
			Random r = new Random();
			int sysGen = r.nextInt(10);

			int userInp = sc.nextInt();

			sys_gen_num[i] = sysGen;
			user_inp_num[i] = userInp;

			if (sysGen == userInp) {
				score += 10;
			} else {
				score -= 10;
			}
		}

		System.out.println("System generated numbers are : " + Arrays.toString(sys_gen_num));
		System.out.println("User input numbers are : " + Arrays.toString(user_inp_num));
		System.out.println("Your score is : " + score + " at time " + time);

		/* Adding the available data to MySql DataBase */

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "Das@2023#");
		PreparedStatement ps = con
				.prepareStatement("insert into game(id,name,SysGenNum,UserInpNum,Time,score) values(?,?,?,?,?,?)");
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setString(3, Arrays.toString(sys_gen_num));
		ps.setString(4, Arrays.toString(user_inp_num));
		ps.setTimestamp(5, time);
		ps.setInt(6, score);

		ps.execute();

		System.out.println("Data Stored in Database Successfully.");
	}
}
