package com.cshr.user.dao;

import java.sql.*;
/**
 * 
 *<p>Title:BaseDao </p>
 *<p>Description: </p>
 *
 *@author LH
 *@date 2017-12-3下午03:23:45
 *@version V1.0
 */
public class BaseDao {

	
	public static final String NAME = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost/test";
	public static final String USER = "root";
	public static final String PASSWORD ="admin";
	
	
	//连接数据库
	public static Connection getConn(){
	      
		Connection conn = null;
	 
		    try {
		    	//指定连接数据库类型 
		    	Class.forName(NAME);
		    	////获取连接驱动
				conn = DriverManager.getConnection(URL,USER, PASSWORD);
			} catch (Exception e) {
				e.printStackTrace();
			}
	    
		
	      return conn;
	}
	
	//关闭数据库
	public static void closeConn(ResultSet rs,PreparedStatement pst,Connection conn){
		    
		try {
		     if(rs != null){
				rs.close();	
		     }
		     if(pst != null){
		    	 pst.close();
		     }
		     if(conn != null){
		    	 conn.close();
		     }
		} catch (SQLException e) {
				e.printStackTrace();
		}
		
	}
	
	//测试数据库连接
	public static void main(String[] args) {
		System.out.println("mysql="+getConn());
	}
}
