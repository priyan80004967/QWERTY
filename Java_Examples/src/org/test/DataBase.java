package org.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBase {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		// load the driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		// connect to database
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","HR", "Priyan@2024");

		// write a querry
		String s="select * from employees";
		
		// prepare the statement
		PreparedStatement statement = connection.prepareStatement(s);
		
		// execute querry
		ResultSet executeQuery = statement.executeQuery();
		
		// iterate the resut
		while(executeQuery.next()) {
			String firstname = executeQuery.getString("First_Name");
			String lastname = executeQuery.getString("Last_Name");
			
			System.out.println(firstname + "__" + lastname);
		}
		
		// close the connection
		connection.close();
		
		
		
		
		
		
		
		
		
	}
}
