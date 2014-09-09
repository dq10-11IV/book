package com.turtledove.bookdrift.web.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.turtledove.bookdrift.application.service.UserLocationService;
import com.turtledove.bookdrift.common.agent.LogServiceAgent;
import com.turtledove.bookdrift.common.utils.LoginUtils;
import com.turtledove.bookdrift.domain.entity.UserLocation;

public class UserController extends AbstractController{

	private String longitude;
	private String latitude;
	private String address;
	@Autowired
	private UserLocationService userLoctionService;
	
	public String addLocation(){
		try{
			UserLocation userLoc = fillUserLoc();
			userLoctionService.addLoction2User(userLoc);
			setSuccessResult("分享成功");
		}catch(Exception e){
			LogServiceAgent.error(e.getMessage(), e);
			setFailureResult("分享失败!");
		}
		
		return SUCCESS;
	}

	public String getUserLocs(){
		
		try{
			List<UserLocation> locations = userLoctionService.getLocationList(LoginUtils.getCurrentLoginUserId());
			setSuccessResultWithList(locations);
		}catch(Exception e){
			LogServiceAgent.error(e.getMessage(), e);
			setFailureResult("获取位置列表失败!");
		}
		return SUCCESS;
	}
	private UserLocation fillUserLoc() {
		UserLocation userLoc = new UserLocation();
		userLoc.setLatitude(latitude);
		userLoc.setLongitude(longitude);
		userLoc.setUserId(LoginUtils.getCurrentLoginUserId());
		userLoc.setAddress(address);
		return userLoc;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
