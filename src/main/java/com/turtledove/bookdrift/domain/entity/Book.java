package com.turtledove.bookdrift.domain.entity;

import java.util.Date;

import com.turtledove.bookdrift.common.AbstractClass.AbstractDomainObject;

public class Book  extends AbstractDomainObject {


	private String isbnId;
	private String bookName;
	private String authorName;
	private Integer bookPrice;
	private String bookPress;
	private Date publishDate;
	private int bookVersion;
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public Integer getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(Integer bookPrice) {
		this.bookPrice = bookPrice;
	}
	public String getBookPress() {
		return bookPress;
	}
	public void setBookPress(String bookPress) {
		this.bookPress = bookPress;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	public int getBookVersion() {
		return bookVersion;
	}
	public void setBookVersion(int bookVersion) {
		this.bookVersion = bookVersion;
	}
	public String getIsbnId() {
		return isbnId;
	}
	public void setIsbnId(String isbnId) {
		this.isbnId = isbnId;
	}

}
