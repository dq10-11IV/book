package com.turtledove.bookdrift.web;

import com.turtledove.bookdrift.common.framework.AjaxBase;

public class UserBookAssAction extends AjaxBase{

	
	public boolean ajax;
	public String addBook(){
		if(ajax==false)
			return TO_ADD_BOOK_PAGE;
		return SUCCESS;
	}
	public void setAjax(boolean ajax) {
		this.ajax = ajax;
	}
}
