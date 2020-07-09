package com.zzx.service;

import java.util.List;

import com.zzx.dto.AppointExecution;
import com.zzx.entity.Book;

public interface BookService {
	
	Book getBookById(long bookId);
	
	List<Book> getAllBooks();
	
	AppointExecution appointBook(long bookId, long studentId);
}
