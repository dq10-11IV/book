package com.turtledove.bookdrift.domain.entity;

import com.turtledove.bookdrift.common.AbstractClass.AbstractDomainObject;

public class Label extends AbstractDomainObject{

	private String labelName;
	private Integer creatorId;
	public String getLabelName() {
		return labelName;
	}
	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}
	public Integer getCreatorId() {
		return creatorId;
	}
	public void setCreatorId(Integer creatorId) {
		this.creatorId = creatorId;
	}
}
