package com.jdbc.www;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class RetriveDate {

	public static void main(String[] args)throws Exception 
	{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");
	Statement st=con.createStatement();
	String qry="select * from emp ";
	ResultSet rs=st.executeQuery(qry);
	while(rs.next())
	{
		int id=rs.getInt(1);
		String name=rs.getString(2);
		java.sql.Date sqldoj=rs.getDate(3);
		java.util.Date udoj=(java.util.Date)sqldoj;
		SimpleDateFormat sdf=new SimpleDateFormat("dd-mm-yyyy");
		String doj=sdf.format(udoj);
		System.out.println(id+" "+name+" "+doj);
		
		
		
	}
	rs.close();
	con.close();
	st.close();
		
	}

}
