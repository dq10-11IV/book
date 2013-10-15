package com.turtledove.bookdrift.domain.entity;

import java.util.Date;

import com.turtledove.bookdrift.common.AbstractClass.AbstractDomainObject;

public class BookInfo extends AbstractDomainObject{
	
	private Integer userId;
	private Integer userName;
	private String isbn;
	private String bookName;
	private String authorName;
	private Double bookPrice;
	private String bookPress;
	private Date publishDate;
	private int bookVersion;
	private String imageUrl;
	private String summary;
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
	public Double getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(Double bookPrice) {
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
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getUserName() {
		return userName;
	}
	public void setUserName(Integer userName) {
		this.userName = userName;
	}
}
