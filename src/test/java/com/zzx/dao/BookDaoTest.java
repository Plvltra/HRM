package com.zzx.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zzx.BaseTest;
import com.zzx.dao.BookDao;
import com.zzx.entity.Book;

public class BookDaoTest extends BaseTest{

	@Autowired
	private BookDao bookDao;
	
	@Test
	public void testQueryById() throws Exception{
		long bookId = 1000;
		Book book = bookDao.queryById(bookId);
		System.out.println(book == null);
		System.out.println("1111111111111111111111");
	}

	@Test
	public void testQueryAll() throws Exception{
		List<Book> books = bookDao.queryAll(0, 4);
		books.stream().forEach(System.out::println);
		System.out.println("2222222222222222222222");
	}

	@Test
	public void testReduceNumber() throws Exception{
		long bookId = 1000;
		int update = bookDao.reduceNumber(bookId);
		System.out.println("update=" + update);
		System.out.println("33333333333333333333");
	}

}
