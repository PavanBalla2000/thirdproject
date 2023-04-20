package com.jdbc.www;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class NonSelectInsert {

	public static void main(String[] args)throws Exception
	
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the student no :");
		int no=sc.nextInt();
		//System.out.println("enter the student name :");
		//String name=sc.next();
		//System.out.println("enter the student add :");
		//String add=sc.next();
		//name="'"+name+"'";
		//add="'"+add+"'";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");
		Statement st=con.createStatement();
		//String qry="insert into student values("+no+","+name+","+add+")";
		//String qry="update student set sname="+name+"where sno="+no;
		String qry="delete from student where sno="+no;
		int result=st.executeUpdate(qry);
		if(result==0)
		
			System.out.println("no record updated"+result);
			else
				System.out.println("record updated"+result);
		
		st.close();
		con.close();
		}
			
		
		
	}



