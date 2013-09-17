package com.turtledove.bookdrift.infrastruct.dao;

import com.turtledove.bookdrift.common.AbstractClass.DomainObjectDao;
import com.turtledove.bookdrift.domain.entity.User;

public interface UserDao extends DomainObjectDao<User>{

	public User getUser(String email);
    public int  insert(User user);
}
