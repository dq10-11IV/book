package com.turtledove.bookdrift.application.serviceiml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turtledove.bookdrift.application.service.UserLabelAssService;
import com.turtledove.bookdrift.domain.entity.UserLabelAss;
import com.turtledove.bookdrift.infrastruct.dao.UserLabelAssDao;

@Service
public class UserLabelAssServiceIml implements UserLabelAssService {

	@Autowired
	UserLabelAssDao userLabelAssDao;
	public UserLabelAss findById(Integer Id) {
		return userLabelAssDao.findById(Id);
	}
	public Integer insert(UserLabelAss userLabelAss) {
		return userLabelAssDao.insert(userLabelAss);
	}

}
