package com.turtledove.bookdrift.infrastruct.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.turtledove.bookdrift.common.AbstractClass.DomainObjectDao;
import com.turtledove.bookdrift.domain.entity.Label;
import com.turtledove.bookdrift.domain.entity.User;

public interface UserDao extends DomainObjectDao<User>{

	public User getUser(String email);
    public int  insert(User user);
	public List<Label> getTags(String email);
}
