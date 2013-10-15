package com.turtledove.bookdrift.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.turtledove.bookdrift.application.service.BookService;
import com.turtledove.bookdrift.application.service.LabelService;
import com.turtledove.bookdrift.application.service.QueryService;
import com.turtledove.bookdrift.common.framework.ActionMessage;
import com.turtledove.bookdrift.common.framework.AjaxBase;
import com.turtledove.bookdrift.common.utils.JsonUtils;
import com.turtledove.bookdrift.common.utils.LoginUtils;
import com.turtledove.bookdrift.domain.entity.Book;
import com.turtledove.bookdrift.domain.entity.BookInfo;
import com.turtledove.bookdrift.domain.entity.Label;
import com.turtledove.bookdrift.domain.entity.User;
public class BookAction extends AjaxBase {

	@Autowired
	BookService bookService;
	@Autowired 
	QueryService queryService;
	@Autowired
	LabelService labelService;
	public String bookName;
	public String data;
	public boolean isAjax;
	public String  label;
	public String query() {
		return SUCCESS;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String myBook(){
		User currentUser = LoginUtils.getCurrentLoginUser();
		List<Label> lableList = labelService.getLabelsByEmail(LoginUtils.getCurrentLoginUserEmail());
		List<Book> bookList = queryService.getBookUnderUser(LoginUtils.getCurrentLoginUserId());
		setElementInDate("user", currentUser);
		setElementInDate("labels", lableList);
		setElementInDate("books", bookList);
		setDateResult();
		setJsonResult();
		getRequest().put("jsonResult", jsonResult);
		
		return SUCCESS;
	}
	public String getBooksUnderLabel(){
		String email = LoginUtils.getCurrentLoginUserEmail();
		List<Book> bookList = queryService.getBookUnderSpecialTag(label);
		setElementInDate("books", bookList);
		setDateResult();
		setTopElementInResult("label", label);
		return SUCCESS;
	}
}
