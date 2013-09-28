package com.turtledove.bookdrift.infrastruct.dao;

import com.turtledove.bookdrift.common.AbstractClass.DomainObjectDao;
import com.turtledove.bookdrift.domain.entity.UserLabelAss;

public interface UserLabelAssDao extends DomainObjectDao<UserLabelAss>{

	public UserLabelAss findById(Integer Id); 
}
