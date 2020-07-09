package com.zzx.service.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzx.BaseTest;
import com.zzx.dto.AppointExecution;
import com.zzx.service.BookService;

public class BookServiceImplTest extends BaseTest{

	@Autowired
	private BookService bookService;
	
	@Test
	public void testGetBookById() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllBooks() {
		fail("Not yet implemented");
	}

	@Test
	public void testAppointBook() throws Exception{
		long bookId = 10010;
		long studentId = 12345678910L;
		AppointExecution execution = bookService.appointBook(bookId, studentId);
		System.out.println(execution);
	}
}
