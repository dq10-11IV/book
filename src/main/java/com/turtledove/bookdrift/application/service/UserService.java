package com.turtledove.bookdrift.application.service;

import com.turtledove.bookdrift.domain.entity.User;

public interface UserService {

	public User getUserByEmail(String email);
}
