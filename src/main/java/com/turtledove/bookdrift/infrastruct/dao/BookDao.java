package com.turtledove.bookdrift.infrastruct.dao;

import com.turtledove.bookdrift.common.AbstractClass.DomainObjectDao;
import com.turtledove.bookdrift.domain.entity.Book;

public interface BookDao extends DomainObjectDao<Book>{
	public Book findById(Integer bookId);
}
