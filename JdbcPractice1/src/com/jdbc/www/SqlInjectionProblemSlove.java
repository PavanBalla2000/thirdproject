package com.jdbc.www;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SqlInjectionProblemSlove {

	public static void main(String[] args)throws Exception 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the username :");
		String name=sc.next();
		System.out.println("enter the password :");
		String pwd=sc.next();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");
		String qry="select count(*) from userlist where username=?"+"and password=?";
		PreparedStatement ps=con.prepareStatement(qry);
		ps.setString(1, name);
		ps.setString(2, pwd);
		
		ResultSet rs=ps.executeQuery();
		int result=0;
		while(rs.next())
		{
			result=rs.getInt(1);
			result=1;
		}
		if(result==0)
			System.out.println("it is not valid");
		else
			System.out.println("is valid");
		ps.close();
		con.close();
		rs.close();

	}

}
