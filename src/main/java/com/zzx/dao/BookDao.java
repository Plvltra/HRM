package com.zzx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zzx.entity.Book;

public interface BookDao {
	
	Book queryById(long bookId);
	
	List<Book> queryAll(@Param("offset") int offset, @Param("limit") int limit);
	
	int reduceNumber(long bookId);
}
