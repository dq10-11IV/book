package com.turtledove.bookdrift.application.service;

import com.turtledove.bookdrift.commom.Enum.UpdateOptionResult;
import com.turtledove.bookdrift.domain.entity.Label;
import com.turtledove.bookdrift.domain.entity.UserLabelAss;

public interface UserLabelAssService {

	public UserLabelAss findById(Integer Id);
	public Integer insert(UserLabelAss userLabelAss);
	public boolean addLabelToCurrentUser(Label label);
	public UpdateOptionResult update(Integer userId,Integer oldlabelId,Integer newLabelId);
}
