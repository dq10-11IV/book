package com.turtledove.bookdrift.application.serviceiml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turtledove.bookdrift.application.service.UserBookAssService;
import com.turtledove.bookdrift.domain.entity.UserBookAss;
import com.turtledove.bookdrift.infrastruct.dao.UserBookAssDao;

@Service
public class UserBookServiceIml implements UserBookAssService {

	@Autowired
	UserBookAssDao userBookAssDao;
	
	public int insert(UserBookAss userBookAss) {
		return userBookAssDao.insert(userBookAss);
	}

	public UserBookAss findById(Integer Id) {
		return userBookAssDao.findById(Id);
	}

}
