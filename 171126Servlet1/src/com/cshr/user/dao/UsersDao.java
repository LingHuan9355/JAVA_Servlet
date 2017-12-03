package com.cshr.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cshr.user.entity.Users;



public class UsersDao {

	//查询用户
	public static List<Users> select(){
		List<Users> list =new ArrayList<Users>();
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			conn =BaseDao.getConn();
			//SQL语句
			String sql = "select * from users";
			//准备执行语句  
			pst = conn.prepareStatement(sql);
			//执行语句，得到结果集  
			rs = pst.executeQuery();
			//显示数据
			while(rs.next()){
				Users user = new Users();
				user.setId(rs.getInt("user_id"));
				user.setUserName(rs.getString("user_name"));
				user.setUserPwd(rs.getString("user_pwd"));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//关闭连接
			BaseDao.closeConn(rs, pst, conn);
		}
		
		
		return list;
	}
	
	//删除用户
	public static int delUser(int uid){
		int num = 0;
		Connection conn = null;
		PreparedStatement pst = null;
		
		try {
			conn = BaseDao.getConn();
			String sql = "delete from users where user_id = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1,uid);
			
			num = pst.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(null, pst, conn);
		}
		return num;
	}

	//添加用户
	public static int addUser(Users user){
		int num =0;
		Connection conn = null;
		PreparedStatement pst = null;
		
		try {
			conn =BaseDao.getConn();
			String sql = "insert into Users (user_name,user_pwd) values(?,?)";
			pst = conn.prepareStatement(sql);
            pst.setString(1, user.getUserName());
            pst.setString(2,user.getUserPwd());
            num = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(null, pst, conn);
		}
		
		return num;
	}

	//修改用户
	public static int updateUser(Users user){
		int num =0;
		Connection conn = null;
		PreparedStatement pst = null;
		
		try {
			conn = BaseDao.getConn();
			String sql = "update users set user_name=?,user_pwd=? where user_id=?";
			pst = conn.prepareStatement(sql);
            pst.setString(1,user.getUserName());
            pst.setString(2,user.getUserPwd());
            pst.setInt(3,user.getId());
            num = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(null, pst, conn);
		}
		
		return num;
	}
}
