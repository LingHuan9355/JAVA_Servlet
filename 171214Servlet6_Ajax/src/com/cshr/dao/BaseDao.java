package com.cshr.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 *<p>Title:BaseDao </p>
 *Description: 
 *dao: date access object
 *数据访问对象
 *一般将对数据的操作(添加、修改、查询、删除  )代码放在dao这个包中
 *CRUD
 *BaseDao:一般提供数据库操作最核的方法(数据库获取连接、资源的关闭)
 *@author LH
 *@date 2017-12-14下午01:33:54
 *@version V1.0
 */
public class BaseDao {

	public static final String CLASSName = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost/test";
	public static final String USERNAME = "root";
	public static final String PASSWORD = "admin";
	
	//连接数据库
	public static Connection getConn(){
	     Connection conn = null;
	     try {
			Class.forName(CLASSName);
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		 } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
	     
	     return conn;
		
	}
	
	//关闭连接
	public static void closeConn(ResultSet rs,Statement st, Connection conn){
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
	
	//测试数据库连接
	/*public static void main(String[] args) {
		 System.out.println(getConn());
	}*/
}
