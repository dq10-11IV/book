package com.turtledove.bookdrift.infrastruct.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.turtledove.bookdrift.domain.entity.UserLocation;

public interface UserLocationDao {

	void insert(UserLocation userLoc);
	List<UserLocation> getLocationList(@Param("currentLoginUserId")Integer currentLoginUserId);

}
