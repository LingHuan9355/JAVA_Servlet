package com.cshr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cshr.entity.City;

public class CityDao {

	
	//≤È—Ø≥« –
	public static List<City> queryList(int pid){
		List<City> list = new ArrayList<City>();
	
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			conn = BaseDao.getConn();
			String sql = "select * from city where pid="+pid;
			pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
            	City city = new City();
            	city.setCid(rs.getInt("cid"));
            	city.setCname(rs.getString("name"));
            	city.setPid(rs.getInt("pid"));
            	
            	list.add(city);
            }
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			BaseDao.closeConn(rs, pst, conn);
		}
		return list;
	}
}
