package com.banking.util;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBUtil {
	public static Connection getDBConn()
	{
		Connection con=null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
		if(con==null)
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinebanking_3","root","root");
		}catch(Exception e){
			e.printStackTrace();
		}
			return con;
	}

}
