package com.turtledove.bookdrift.web;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.turtledove.bookdrift.application.service.BookService;
import com.turtledove.bookdrift.application.service.LabelService;
import com.turtledove.bookdrift.application.service.QueryService;
import com.turtledove.bookdrift.common.framework.AjaxBase;
import com.turtledove.bookdrift.common.utils.LoginUtils;
import com.turtledove.bookdrift.domain.entity.Book;
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
	public int  label;
	public String query() throws UnsupportedEncodingException {
		
		Map<String,Object> para = new HashMap<String,Object>();
		para.put("userId", LoginUtils.getCurrentLoginUserId());
		para.put("bookName", bookName);
		List<Book> bookList = queryService.query(para);
		setElementInDate("books", bookList);
		setDateResult();
		return SUCCESS;
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
		Map<String,Object> para = new HashMap<String, Object>();
		para.put("currentUserId", LoginUtils.getCurrentLoginUserId());
		para.put("labelId", label);
		List<Book> bookList = queryService.getBooksUnderLableExceptCurrentUser(para);
		setElementInDate("books", bookList);
		setDateResult();
		setTopElementInResult("label", label);
		return SUCCESS;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	public void setQueryService(QueryService queryService) {
		this.queryService = queryService;
	}
	public void setLabelService(LabelService labelService) {
		this.labelService = labelService;
	}
	public void setData(String data) {
		this.data = data;
	}
	public void setAjax(boolean isAjax) {
		this.isAjax = isAjax;
	}
	public void setLabel(int label) {
		this.label = label;
	}
	
}
