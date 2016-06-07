package com.hrd.jdbc;

public class Loading extends Thread{
	public void run(){
		String str="Welcome to Our program";
			try {
				for(int i=0; i<str.length();i++){
					Thread.sleep(30);
					System.out.print(str.charAt(i));
				}
				System.out.println();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
		
	}

}
