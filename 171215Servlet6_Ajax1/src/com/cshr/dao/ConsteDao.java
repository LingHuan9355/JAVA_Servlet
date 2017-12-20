package com.cshr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cshr.entity.Conste;

public class ConsteDao {

	
	//查询全部星座
	public List<Conste> queryList(){
		List<Conste> list = new ArrayList<Conste>();
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			conn = BaseDao.getConn();
			String sql="select id,name,content from conste";
			pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
               Conste conste = new Conste();
               conste.setId(rs.getInt("id"));
               conste.setName(rs.getString("name"));
               conste.setContent(rs.getString("content"));
               
               list.add(conste);
            }
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return list;
	}

    //根据星座名查询星座内容
	public static  Conste queryById(String name){
		Conste conste =null;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			conn = BaseDao.getConn();
			String sql ="select * from conste where name='"+name+"'";
			pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
            	conste =  new Conste();
            	conste.setId(rs.getInt("id"));
            	conste.setName(rs.getString("name"));
            	conste.setContent(rs.getString("content"));
            }
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			 BaseDao.closeConn(rs, pst, conn);
		}
		
		return conste;
	}
}
