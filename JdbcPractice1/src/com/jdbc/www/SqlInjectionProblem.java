package com.jdbc.www;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class SqlInjectionProblem
{
	public static void main(String[] args)throws Exception
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the username :");
		String name=sc.next();
		System.out.println("enter the password");
		String pwd=sc.next();
		name="'"+name+"'";
		pwd="'"+pwd+"'";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");
		Statement st=con.createStatement();
		String qry="select count(*) from userList where username="+name+"and password="+pwd;
		ResultSet rs=st.executeQuery(qry);
		int result=0;
		while(rs.next())
		{
			result=rs.getInt(1);
		}
		if(result==0)
			System.out.println("invalid credential");
		else
			System.out.println("valid credential");
		st.close();
		rs.close();
		con.close();
	}
}
