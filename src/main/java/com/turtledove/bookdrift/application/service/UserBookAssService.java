package com.turtledove.bookdrift.application.service;

import com.turtledove.bookdrift.domain.entity.UserBookAss;

public interface UserBookAssService {

	public int insert(UserBookAss userBook);
	public UserBookAss findById(Integer Id);
}
