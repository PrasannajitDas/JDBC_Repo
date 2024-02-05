package jdbcdemo;

import java.sql.SQLException;
import java.util.Scanner;

public class CRUDDriver {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		CRUD crud=new CRUD();
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter option : ");
		System.out.println("1.Insert Data\n2.Delete Data\n3.Update Data\n4.Fetch Data");
		int n=sc.nextInt();
		
		switch(n) {
		case 1: 
			crud.insertData();
			break;
		case 2:
			crud.deleteData();
			break;
		case 3:
			crud.updateData();
			break;
		case 4:
			crud.fetchData();
			break;
		default :
			System.out.println("Invalid Input");
			break;
		
		}
	}
}
