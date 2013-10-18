package com.turtledove.bookdrift.infrastruct.dao;

import org.apache.ibatis.annotations.Param;

import com.turtledove.bookdrift.common.AbstractClass.DomainObjectDao;
import com.turtledove.bookdrift.domain.entity.UserLabelAss;

public interface UserLabelAssDao extends DomainObjectDao<UserLabelAss>{

	public UserLabelAss findById(Integer Id);
	public UserLabelAss ValidateUserLabelAss(UserLabelAss userLabelAss); 
	public void update(@Param("userId")Integer userId,@Param("oldlabelId")Integer oldlabelId,@Param("newLabelId")Integer newLabelId);
	public UserLabelAss findByUserIdAndLabelId(@Param("userId")Integer userId,@Param("labelId")Integer labelId);
}
