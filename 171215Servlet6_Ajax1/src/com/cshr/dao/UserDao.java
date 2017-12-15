package com.cshr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

	/**
	 * 	查询用户是否存在
	 */
	public static boolean findByName(String name){
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			conn = BaseDao.getConn();
			String sql = "select count(*) from users where user_name = '"+name+"'";
			pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
		    while(rs.next()){
		    	int count =rs.getInt(1); 
		    	if(count > 0){
		    		flag = true;
		    	}
		    }
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(rs, pst, conn);
		}
		
		return flag;
	}
}
