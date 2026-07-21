package JDBC_Connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
public static void main(String args[])
{
	try {
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/SeleniumAutomation","root","983703");
		System.out.println("Database Connected Successfully");
		con.close();
		
	}
	catch(Exception e)
	{
		System.out.println("Database Connection Failed");
	}
}
}
