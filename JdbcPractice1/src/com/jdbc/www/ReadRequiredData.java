package com.jdbc.www;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ReadRequiredData
{
	public static void main(String[] args)throws Exception 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the sno");
		int no=sc.nextInt();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");
		Statement st=con.createStatement();
		String qry="select * from student where sno="+no;
		ResultSet rs=st.executeQuery(qry);
		int cnt=0;
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+""+rs.getString(2)+""+rs.getString(3));
			cnt=1;
		}
		if(cnt==0)
		{
			System.out.println("no record selected");
		}
		st.close();
		con.close();
		rs.close();
	}
}