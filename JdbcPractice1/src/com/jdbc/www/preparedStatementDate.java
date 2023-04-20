package com.jdbc.www;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class preparedStatementDate {

	public static void main(String[] args)throws Exception 
	{
		Scanner sc =new Scanner(System.in);
		System.out.println("enter the emp id");
		int id=sc.nextInt();
		System.out.println("enter the emp name");
		String name=sc.next();
		System.out.println("enter the emp doj");
		String doj=sc.next();
		SimpleDateFormat sdf=new SimpleDateFormat("dd-mm-yyyy");
		java.util.Date udoj=sdf.parse(doj);
		long ms=udoj.getTime();
		java.sql.Date sqldoj=new java.sql.Date(ms);
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");
		String qry="insert into emp values(?,?,?)";
		
		PreparedStatement ps=con.prepareStatement(qry);
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setDate(3, sqldoj);
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

	


