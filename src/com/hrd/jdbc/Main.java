package com.hrd.jdbc;

import java.sql.Connection;

public class Main {

	public static void main(String[] args) {
	//	Connection con= DBManager.getConnection();
		Loading lo= new Loading();
		ManipulatData md=new ManipulatData();
		
		try {
			lo.start();
			lo.join();
			md.showMenu();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
