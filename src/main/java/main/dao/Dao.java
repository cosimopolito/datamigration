package main.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Dao {

 	private String urlNew  = "jdbc:mysql://localhost:3306/schema_new?serverTimezone=UTC&useSSL=false";

	protected Connection getConnection() throws SQLException {
		return DriverManager.getConnection(urlNew,"root","root");
	}

}
