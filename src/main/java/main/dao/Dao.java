package main.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Dao {

	private String urlOld  = "jdbc:mysql://localhost:3306/schema_old?serverTimezone=UTC&useSSL=false";
	private String urlNew  = "jdbc:mysql://localhost:3306/schema_new?serverTimezone=UTC&useSSL=false";

	protected Connection getConnectionOld() throws SQLException {
		return DriverManager.getConnection(urlOld,"root","root");
	}
	protected Connection getConnectionNew() throws SQLException {
		return DriverManager.getConnection(urlNew,"root","root");
	}

}
