package com.cshr.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDao {

	public static final String CLASSNAME="com.mysql.jdbc.Driver";
	public static final String URL="jdbc:mysql://localhost/test";
	public static final String USERNAME="root";
	public static final String PASSWORD="admin";
	
	
	//连接数据库
	public static Connection getConn(){
		Connection conn = null;
		
		 try {
			Class.forName(CLASSNAME);
			conn =DriverManager.getConnection(URL,USERNAME,PASSWORD);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	//关闭连接
	public static void closeConn(ResultSet rs, Statement st,Connection conn){
		  try {
			  if(rs != null){
				  rs.close();				  
			  }
			  if(st != null){
				  st.close();
			  }
			  if(conn != null){
				  conn.close();
			  }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
/*	public static void main(String[] args) {
		System.out.println(getConn());
	}*/
}
