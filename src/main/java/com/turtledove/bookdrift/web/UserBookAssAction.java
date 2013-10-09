package com.turtledove.bookdrift.web;

import org.springframework.beans.factory.annotation.Autowired;

import com.turtledove.bookdrift.application.service.UserBookAssService;
import com.turtledove.bookdrift.common.framework.AjaxBase;
import com.turtledove.bookdrift.domain.entity.Book;

public class UserBookAssAction extends AjaxBase{

	@Autowired
	UserBookAssService userBookAssService ;
	
	public boolean ajax;
	public String addBook(){
		if(ajax==false)
			return TO_ADD_BOOK_PAGE;
		Book book = new Book();
		return SUCCESS;
	}
	public void setAjax(boolean ajax) {
		this.ajax = ajax;
	}
}
