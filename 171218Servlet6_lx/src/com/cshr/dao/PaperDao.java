package com.cshr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cshr.entity.Paper;

/**
 * 
 *<p>Title:PaperDao </p>
 *Description: 
 *试卷表
 *@author LH
 *@date 2017-12-18下午03:59:15
 *@version V1.0
 */
public class PaperDao {

	//查询题目内容
	public static List<Paper> queryList(){
		List<Paper> list = new ArrayList<Paper>();
	     Connection conn = null;
	     PreparedStatement pst=null;
	     ResultSet rs = null;
	     
	     try {
	    	conn = BaseDao.getConn();
	    	String sql = "select * from paper_Info";
			pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
            	Paper paper = new Paper();
            	paper.setId(rs.getInt("id"));
            	paper.setContent(rs.getString("content"));
            	paper.setAnswer(rs.getString("answer"));
            	
            	list.add(paper);
            }
	     
	     } catch (SQLException e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(rs, pst, conn);
		}
	     
	    return list;
	
	}

	//根据答案查询
	public  static Paper/*List<Paper>*/ queryByContent(String content){
		 /*List<Paper> list = new ArrayList<Paper>();*/
		 Paper paper = null;
		 Connection conn =null;
		 PreparedStatement pst = null;
		 ResultSet rs = null;
		 
		 try {
			conn = BaseDao.getConn();
			String sql="select * from paper_Info where content = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, content);
	        rs = pst.executeQuery();
	        while(rs.next()){
	            paper = new Paper();
	        	paper.setId(rs.getInt("id"));
	        	paper.setContent(rs.getString("content"));
	        	paper.setAnswer(rs.getString("answer"));
	            
	        	//list.add(paper);
	        }
			
		 } catch (SQLException e) {
			e.printStackTrace();
		 }finally{
			 BaseDao.closeConn(rs, pst, conn);
		 }
		 
		 //return list;
		 return paper;
	}
	
	
	
}
