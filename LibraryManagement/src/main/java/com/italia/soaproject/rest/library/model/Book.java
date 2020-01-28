package com.italia.soaproject.rest.library.model;

public class Book {
	
	
	public String bookname;
	public String bookcategory;
	public String bookISBN;
	public String bookauthor;
	public String bookpublisher;
	public int bookpublished_year;
	
	public Book() {
		
	}
	
	
	public Book(String bookname, String bookcategory, String bookISBN,String bookauthor,String bookpublisher,int bookpublished_year) {
		this.bookname = bookname;
		this.bookcategory = bookcategory;
		this.bookISBN = bookISBN;
		this.bookauthor = bookauthor;
		this.bookpublisher = bookpublisher;
		this.bookpublished_year = bookpublished_year;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getBookcategory() {
		return bookcategory;
	}

	public void setBookcategory(String bookcategory) {
		this.bookcategory = bookcategory;
	}

	public String getBookISBN() {
		return bookISBN;
	}

	public void setBookISBN(String bookISBN) {
		this.bookISBN = bookISBN;
	}

	public String getBookauthor() {
		return bookauthor;
	}

	public void setBookauthor(String bookauthor) {
		this.bookauthor = bookauthor;
	}

	public String getBookpublisher() {
		return bookpublisher;
	}

	public void setBookpublisher(String bookpublisher) {
		this.bookpublisher = bookpublisher;
	}

	public int getBookpublished_year() {
		return bookpublished_year;
	}

	public void setBookpublished_year(int bookpublished_year) {
		this.bookpublished_year = bookpublished_year;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.bookname+","+this.bookauthor;
	}
	

}
