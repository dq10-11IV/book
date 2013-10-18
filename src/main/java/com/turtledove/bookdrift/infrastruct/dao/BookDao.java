package com.turtledove.bookdrift.infrastruct.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.turtledove.bookdrift.common.AbstractClass.DomainObjectDao;
import com.turtledove.bookdrift.domain.entity.Book;

public interface BookDao extends DomainObjectDao<Book>{
	public Book findById(Integer bookId);
	public List<Book> findBooksByBooKName(@Param(value="bookName")String bookName);
	public List<Book> getBooksUnderUserAndTag(Map<String,String> paraMap);
	public List<Book> getBookUnderUser(Integer Id);
	public Book findByBookNameAndVerion(@Param("bookName") String bookName,@Param("version") Integer version);
	public Book findByISBN(@Param("isbn")String isbn);
	public List<Book> getBookUnderSpecialTag(String tags);
}
