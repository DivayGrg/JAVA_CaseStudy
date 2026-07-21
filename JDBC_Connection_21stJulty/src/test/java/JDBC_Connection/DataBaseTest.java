package JDBC_Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class DataBaseTest {
	@Test
	public void testDatabaseConnection() throws SQLException, ClassNotFoundException{
		//1.Defining Connection Parameter
		String dbUrl="jdbc:mysql://localhost:3306/SeleniumAutomation";
		String username="root";
		String password="983703";
		//2.Load JDBC Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(dbUrl,username,password);
		Statement stmt=con.createStatement();
		//3. Execute a qurey
		String query="SELECT * FROM seleniumautomation.book_detl;";
		ResultSet res=stmt.executeQuery(query);
		
		//Process the result
		while(res.next()){
			String auth=res.getString("author");
			String tt=res.getString("title");
			System.out.println("author: "+ auth + ", title: "+ tt);
		}
		con.close();
	}
}
