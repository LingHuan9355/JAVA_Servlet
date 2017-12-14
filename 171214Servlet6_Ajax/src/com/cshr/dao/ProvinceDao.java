package com.cshr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cshr.entity.Province;

public class ProvinceDao {

	
	//≤È—Ø °∑›
	public static List<Province> queryList(){
		   List<Province> list = new ArrayList<Province>();
		   Connection conn = null;
		   PreparedStatement pst= null;
		   ResultSet rs = null;
		   
		try {
			
			   conn = BaseDao.getConn();
			   String sql = "select * from province";
			   pst = conn.prepareStatement(sql);
		       rs = pst.executeQuery();
		       while(rs.next()){
		    	   Province pro = new Province();
		    	   pro.setPid(rs.getInt("pid"));
		    	   pro.setName(rs.getString("name"));
		    	   
		    	   list.add(pro);
		       }
			   
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(rs, pst, conn);
		}
		   
		   
		   return list;
	}
}
