package com.cshr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.cshr.entity.Score;

/**
 * 
 *<p>Title:ScoreDao </p>
 *Description: 
 *�Ծ��
 *@author LH
 *@date 2017-12-18����04:00:36
 *@version V1.0
 */
public class ScoreDao {

	//��ѯ�û�
	public static boolean queryByName(String userName){
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = BaseDao.getConn();
			String sql = "select count(*) from score_Info where username='"+userName+"'";
			pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
            	int count = rs.getInt(1);
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
	
	//�����û����޸ļӷ�
	public static int editAddScore(String userName){
		int count =0;
		Connection conn = null;
		PreparedStatement pst = null;
		
		try {
			conn = BaseDao.getConn();
			String sql = "update score_Info set scroe = scroe + 5 where username='"+userName+"'";
			pst = conn.prepareStatement(sql);
			count = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(null, pst, conn);
		}
		
		return count;
	}
	//�����û����޸ļ���
	public static int editPointsScore(String userName){
		int count =0;
		Connection conn = null;
		PreparedStatement pst = null;
		
		try {
			conn = BaseDao.getConn();
			String sql = "update score_Info set scroe = scroe - 5 where username='"+userName+"'";
			pst = conn.prepareStatement(sql);
			count = pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(null, pst, conn);
		}
		
		return count;
	}

	//�����û�����ѯ����
	public static Score showScoreByName(String userName){
		Score score = null;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
        try {
        	conn = BaseDao.getConn();
        	String sql="select * from score_Info where username='"+userName+"'";
			pst=conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
            	score = new Score();
            	score.setId(rs.getInt("id"));
            	score.setUsername(rs.getString("username"));
            	score.setScore(rs.getInt("scroe"));
            	
            }
        } catch (SQLException e) {
			e.printStackTrace();
		}
        
        return score;		
		
	}
	
}
