package com.turtledove.bookdrift.application.service;

import com.turtledove.bookdrift.domain.entity.UserLabelAss;

public interface UserLabelAssService {

	public UserLabelAss findById(Integer Id);
	public Integer insert(UserLabelAss userLabelAss);
}
