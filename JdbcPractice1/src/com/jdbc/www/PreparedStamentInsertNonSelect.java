package com.jdbc.www;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class PreparedStamentInsertNonSelect {

	public static void main(String[] args)throws Exception
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the student no :");
		int no=sc.nextInt();
//		System.out.println("enter the student name :");
//		String name=sc.next();
//		System.out.println("enter the student add :");
//		String add=sc.next();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");
		//String qry="insert into student values(?,?,?)";
		String qry="update student set sname=?where sno=?";
		//String qry="delete from student where sno=?";
		
		PreparedStatement ps=con.prepareStatement(qry);
		//ps.setInt(1, no);
	//	ps.setString(2, name);
		//ps.setString(3, add);
		// ps.setString(1, name);
		ps.setInt(2, no);
		ps.setInt(1, no);
		int result=ps.executeUpdate();
		if(result==0)
		{
			System.out.println("no record selected");
			
		}
		else 
			System.out.println("record selected");
		ps.close();
		con.close();
	}

}
