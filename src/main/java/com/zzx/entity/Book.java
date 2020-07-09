package com.zzx.entity;

public class Book {
	
	private long bookId;
	
	private String name;
	
	private int number;

	public Book() {

	}
	
	public Book(long bookId, String name, int number) {
		super();
		this.bookId = bookId;
		this.name = name;
		this.number = number;
	}

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public String getName() {
		return name;
	}

	public void setBookName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	@Override
	public String toString() {
		return "bookId:" + bookId + " name:" + name + " number:" + number;
	}
}
