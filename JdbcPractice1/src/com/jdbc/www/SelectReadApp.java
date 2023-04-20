package com.jdbc.www;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class SelectReadApp {

	public static void main(String[] args)throws Exception 
	{
//		Scanner sc=new Scanner(System.in);
//		System.out.println("enter the number");
//		int no=sc.nextInt();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from student ");
//		String qry="select * from student where sno="+no;
//		int cnt=0;
//		ResultSet rs=st.executeQuery(qry);
		while(rs.next())
		{
			//System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
			System.out.println(rs.getInt("sno")+" "+rs.getString("sname")+" "+rs.getString("sadd"));
		//	cnt=1;
		}
//		if(cnt==0)
//		{
//			System.out.println("no record selected");
//		}
		rs.close();
		con.close();
		st.close();
	}

}
