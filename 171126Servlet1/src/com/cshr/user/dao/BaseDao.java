package com.cshr.user.dao;

import java.sql.*;
/**
 * 
 *<p>Title:BaseDao </p>
 *<p>Description: </p>
 *
 *@author LH
 *@date 2017-12-3����03:23:45
 *@version V1.0
 */
public class BaseDao {

	
	public static final String NAME = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost/test";
	public static final String USER = "root";
	public static final String PASSWORD ="admin";
	
	
	//�������ݿ�
	public static Connection getConn(){
	      
		Connection conn = null;
	 
		    try {
		    	//ָ���������ݿ����� 
		    	Class.forName(NAME);
		    	////��ȡ��������
				conn = DriverManager.getConnection(URL,USER, PASSWORD);
			} catch (Exception e) {
				e.printStackTrace();
			}
	    
		
	      return conn;
	}
	
	//�ر����ݿ�
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
	
	//�������ݿ�����
	public static void main(String[] args) {
		System.out.println("mysql="+getConn());
	}
}
