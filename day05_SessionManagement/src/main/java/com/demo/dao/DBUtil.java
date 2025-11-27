package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	static Connection conn=null;

	public static Connection getMyConnection() {
		if(conn==null) {
			try {
				DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
				String url="jdbc:mysql://192.168.10.117:3306//dac29useSSL=false";
				conn=DriverManager.getConnection(url,"uname","pass");
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conn;
	}
	
	

}
