package com.turtledove.bookdrift.domain.entity;

import com.turtledove.bookdrift.common.AbstractClass.AbstractDomainObject;

public class UserBookAss extends AbstractDomainObject {

	private Integer userId;
	private Integer bookId;
	private Boolean isOnHand;
	private Boolean isWanted;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public Boolean getIsOnHand() {
		return isOnHand;
	}
	public void setIsOnHand(Boolean isOnHand) {
		this.isOnHand = isOnHand;
	}
	public Boolean getIsWanted() {
		return isWanted;
	}
	public void setIsWanted(Boolean isWanted) {
		this.isWanted = isWanted;
	}
	
}
