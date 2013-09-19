package com.turtledove.bookdrift.infrastruct.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.turtledove.bookdrift.common.AbstractClass.DomainObjectDao;
import com.turtledove.bookdrift.domain.entity.Book;

public interface BookDao extends DomainObjectDao<Book>{
	public Book findById(Integer bookId);
	public List<Book> findBooksByBooKName(@Param(value="bookName")String bookName);
}
