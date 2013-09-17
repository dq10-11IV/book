package com.turtledove.bookdrift.domain.entity;

import com.turtledove.bookdrift.common.AbstractClass.AbstractDomainObject;

public class UserLabelAss extends AbstractDomainObject{

	private Integer userId;
	private Integer labelId;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getLabelId() {
		return labelId;
	}
	public void setLabelId(Integer labelId) {
		this.labelId = labelId;
	}
	
}
