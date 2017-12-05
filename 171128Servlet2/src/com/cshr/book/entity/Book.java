package com.cshr.book.entity;

/**
 * 
 *<p>Title:Book </p>
 *<p>Description:
 *实体类book
 * </p>
 *
 *@author LH
 *@date 2017-12-4下午11:04:39
 *@version V1.0
 */
public class Book {

	 private int bookId;
	 private String bookName;
	 private double bookPrice;
	 private String bookWrite;
	 
	 
	public Book() {
	}
	
	public Book(int bookId, String bookName, double bookPrice, String bookWrite) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.bookWrite = bookWrite;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}

	public String getBookWrite() {
		return bookWrite;
	}

	public void setBookWrite(String bookWrite) {
		this.bookWrite = bookWrite;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName
				+ ", bookPrice=" + bookPrice + ", bookWrite=" + bookWrite + "]";
	}
	
	
	
	
	 
	 
}
