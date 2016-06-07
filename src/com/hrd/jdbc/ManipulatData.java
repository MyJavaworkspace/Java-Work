package com.hrd.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class ManipulatData {
	
	Connection con=DBManager.getConnection();
	PreparedStatement ps=null;
	ResultSet rs=null;
	private Scanner sc;
	public static void Menu(){
		System.out.println("ID\tName\tGender\tClass");
		for(int i=0;i<50;i++){
			System.out.print("-");
		}
		System.out.println();
	}
	public void LoadData(){
		con=DBManager.getConnection();
		String sql="select * from tbStudent Order by Id";
		try{
			ps= con.prepareStatement(sql);
			rs=	ps.executeQuery();
			Menu();
			while(rs.next()){
				int id= rs.getInt(1);
				String name= rs.getString(2);
				String sex=rs.getString(3);
				String cls= rs.getString(4);
				
				System.out.println(id+"\t"+name+"\t"+sex+"\t"+cls);
				
				for(int i=0;i<50;i++){
					System.out.print("-");
				}
				System.out.println();
			}
			rs.close();
			ps.close();
			con.close();
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void Update(){
		con=DBManager.getConnection();
		String sql ="Update tbStudent set Name=? where id=? ";
		try{
			ps=con.prepareStatement(sql);
			ps.setString(1, "Sok");
			ps.setInt(2, 1);
			ps.executeUpdate();
			System.out.println("Successfully update");			
			LoadData();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
	public void Delete(){
		con=DBManager.getConnection();
		String sql ="Delete From tbStudent where id=? ";
		try{
			ps=con.prepareStatement(sql);
			ps.setInt(1, 1);
			ps.executeUpdate();
			System.out.println("Successfully Delete");			
			LoadData();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		
	}
	public void Insert(int id,String name,String gender,String cls){
		con=DBManager.getConnection();
		String sql ="Insert Into tbStudent(Id,Name,Gender,Class) values(?,?,?,?)";
		try{
			ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, gender);
			ps.setString(4, cls);
			ps.executeUpdate();
			System.out.println("1 row inserted");			
			LoadData();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
	public void showMenu(){
		sc = new Scanner(System.in);
		for(int i=0;i<50;i++){
			System.out.print((char)61);
		}
		System.out.println();
		System.out.println("1. Show 2.Update 3. Delete 4. Insert 5.Exit");
		for(int i=0;i<50;i++){
			System.out.print((char)61);
		}
		System.out.println();
		System.out.println("Choose option: ");
		int num= sc.nextInt();
		switch(num){
			case 1: LoadData();
					showMenu();
				break;
			case 2: Update();
					showMenu();
				break;
			case 3: Delete();
					showMenu();
				break;
			case 4: Insert(5, "Pheara","Male", "SR");
					showMenu();
				break;
				
			case 5: 
				System.out.println("GoodBye........");
				System.exit(0);
				
				break;
		}
		
	}
			

}
