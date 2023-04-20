package com.jdbc.www;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.Statement;

public class Dbmdss
{
	public static void main(String[] args)throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");

		DatabaseMetaData dbmd=con.getMetaData();
		
		System.out.println(dbmd.getDatabaseProductName());
		System.out.println(dbmd.getUserName());
		con.close();
	}
}
 