package com.turtledove.bookdrift.application.service;

import java.util.List;

import com.turtledove.bookdrift.domain.entity.UserLocation;

public interface UserLocationService {

	void addLoction2User(UserLocation userLoc);

	List<UserLocation> getLocationList(Integer currentLoginUserId);

}
