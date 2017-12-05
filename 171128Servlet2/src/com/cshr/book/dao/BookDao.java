package com.cshr.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cshr.book.entity.Book;

/**
 * 
 *<p>Title:BookDao </p>
 *<p>Description: </p>
 *操作数据类
 *@author LH
 *@date 2017-12-4下午11:25:00
 *@version V1.0
 */
public class BookDao {

	//查询数据
	public static List<Book> selList(){
		List<Book> list = new ArrayList<Book>();
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			conn = DBHelper.getConn();
			String sql = "select * from books";
			pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
            	Book book = new Book();
            	book.setBookId(rs.getInt("book_id"));
            	book.setBookName(rs.getString("book_name"));
            	book.setBookPrice(rs.getDouble("book_price"));
            	book.setBookWrite(rs.getString("book_write"));
            	
            	list.add(book);
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBHelper.closeConn(rs, pst, conn);
		}
		
		return list;
	}
	//查询单个数据
	public static List<Book> selById(int id){
		List<Book> list = new ArrayList<Book>();
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
	
		try{	
			conn = DBHelper.getConn();
			String sql = "select * from books where book_id =?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
	        rs = pst.executeQuery();
	        while(rs.next()){
	        	Book book = new Book();
	        	book.setBookId(rs.getInt("book_id"));
	        	book.setBookName(rs.getString("book_name"));
	        	book.setBookPrice(rs.getDouble("book_price"));
	        	book.setBookWrite(rs.getString("book_write"));
	        	
	        	list.add(book);
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBHelper.closeConn(rs, pst, conn);
		}
		return list;
	}
	//添加数据
	public static int addBook(Book book){
		int num = 0;
		Connection conn = null;
		PreparedStatement pst = null;
		
		try {
			conn = DBHelper.getConn();
			String sql = "insert into books (book_name,book_price,book_write) values(?,?,?)";
			pst = conn.prepareStatement(sql);
			pst.setString(1, book.getBookName());
			pst.setDouble(2,book.getBookPrice());
			pst.setString(3, book.getBookWrite());

			num = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBHelper.closeConn(null, pst, conn);
		}
		
		return num;
	}

	//删除数据
	public static int delBook(int id){
		int num = 0;
		Connection conn = null;
		PreparedStatement pst = null;
		
		try {
			conn = DBHelper.getConn();
			String sql = "delete from books where book_id = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			num = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBHelper.closeConn(null, pst, conn);
		}
	    
		return num;
	}
	
	
	//修改数据
    public static int updateBook(Book book){
    	int num = 0;
    	Connection conn = null;
    	PreparedStatement pst = null;
    	
    	try {
    		conn = DBHelper.getConn();
    		String sql = "update books set name=?,price=?,writer=?  where id=?";
			pst = conn.prepareStatement(sql);
            pst.setString(1, book.getBookName());
            pst.setDouble(2,book.getBookPrice());
            pst.setString(3, book.getBookWrite());
            pst.setInt(4, book.getBookId());
            
            num = pst.executeUpdate();
    	} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBHelper.closeConn(null, pst, conn);
		}
		
    	return num;
    }
}
