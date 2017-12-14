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
 *���ݷ��ʶ���
 *һ�㽫�����ݵĲ���(��ӡ��޸ġ���ѯ��ɾ��  )�������dao�������
 *CRUD
 *BaseDao:һ���ṩ���ݿ������˵ķ���(���ݿ��ȡ���ӡ���Դ�Ĺر�)
 *@author LH
 *@date 2017-12-14����01:33:54
 *@version V1.0
 */
public class BaseDao {

	public static final String CLASSName = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost/test";
	public static final String USERNAME = "root";
	public static final String PASSWORD = "admin";
	
	//�������ݿ�
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
	
	//�ر�����
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
	
	//�������ݿ�����
	/*public static void main(String[] args) {
		 System.out.println(getConn());
	}*/
}
