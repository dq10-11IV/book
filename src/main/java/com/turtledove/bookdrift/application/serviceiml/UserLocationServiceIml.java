package com.turtledove.bookdrift.application.serviceiml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turtledove.bookdrift.application.service.UserLocationService;
import com.turtledove.bookdrift.domain.entity.UserLocation;
import com.turtledove.bookdrift.infrastruct.dao.UserLocationDao;

@Service
public class UserLocationServiceIml implements UserLocationService {

	@Autowired
	private UserLocationDao userLocationDao;
	public void addLoction2User(UserLocation userLoc) {
		userLocationDao.insert(userLoc);
	}
	public List<UserLocation> getLocationList(Integer currentLoginUserId) {
		return userLocationDao.getLocationList(currentLoginUserId);
	}

}
