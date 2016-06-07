package com.hrd.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager {
	private static Connection cnn;
	private DBManager(){}
	
	public static Connection getConnection(){
		String url="jdbc:postgresql://localhost:5432/dbStudent";
		String user="postgres";
		String pass="123";
		try{
			Class.forName("org.postgresql.Driver");
			cnn=DriverManager.getConnection(url,user,pass);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return cnn;
	}
	
}
