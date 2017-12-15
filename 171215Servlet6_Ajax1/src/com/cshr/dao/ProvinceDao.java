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
	public List<Province> queryList(){
		    List<Province> list = new ArrayList<Province>();
		    Connection conn = null;
		    PreparedStatement pst = null;
		    ResultSet rs = null;
		    
		    try {
		    	conn = BaseDao.getConn();
		    	String sql = "select pid,name from province ";		    	
				pst = conn.prepareStatement(sql);
				rs = pst.executeQuery();
				while(rs.next()){
					Province pro = new Province();
					pro.setPid(rs.getInt("pid"));
					pro.setPname(rs.getString("name"));
					
					list.add(pro);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		    		    
		    return list;
	}
}
