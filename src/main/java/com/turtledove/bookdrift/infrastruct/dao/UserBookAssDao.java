package com.turtledove.bookdrift.infrastruct.dao;

import org.apache.ibatis.annotations.Param;

import com.turtledove.bookdrift.common.AbstractClass.DomainObjectDao;
import com.turtledove.bookdrift.domain.entity.UserBookAss;

public interface UserBookAssDao  extends DomainObjectDao<UserBookAss>{

	public UserBookAss findById(Integer Id);
	public UserBookAss findByUserIdAndBookId(@Param("userId")Integer userId, @Param("bookId")Integer bookId); 
}
