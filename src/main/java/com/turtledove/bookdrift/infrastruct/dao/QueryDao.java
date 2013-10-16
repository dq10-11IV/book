package com.turtledove.bookdrift.infrastruct.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.turtledove.bookdrift.common.AbstractClass.DomainObjectDao;
import com.turtledove.bookdrift.domain.entity.Book;

public interface QueryDao extends DomainObjectDao<Book> {
	List<Book> query(@Param("para")Map<String,Object> para);
	List<Book> getBooksUnderLableExceptCurrentUser(@Param("para")Map<String,Object> para);
}
