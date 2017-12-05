package com.cshr.book.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 *<p>Title:DBHelper </p>
 *<p>Description: </p>
 *�������ݿ������
 *@author LH
 *@date 2017-12-4����11:11:27
 *@version V1.0
 */
public class DBHelper {

	public static final String className = "com.mysql.jdbc.Driver";
	//public static final String url = "jdbc:mysql://localhost/test";
	public static final String url = "jdbc:mysql://127.0.0.1/test";
	public static final String userName = "root";
	public static final String passWord = "admin";
	//�������ݿ�
	public static Connection getConn(){
		Connection conn = null;
	
		try {
			Class.forName(className);
			conn = DriverManager.getConnection(url, userName, passWord);
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
	
	//�����������ݿ�
	/*public static void main(String[] args) {
		System.out.println(getConn());
	}*/
	
}
