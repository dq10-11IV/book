package com.turtledove.bookdrift.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.turtledove.bookdrift.application.service.BookService;
import com.turtledove.bookdrift.application.service.QueryService;
import com.turtledove.bookdrift.common.framework.ActionMessage;
import com.turtledove.bookdrift.common.framework.AjaxBase;
import com.turtledove.bookdrift.common.utils.JsonUtils;
import com.turtledove.bookdrift.common.utils.LoginUtils;
import com.turtledove.bookdrift.domain.entity.Book;
import com.turtledove.bookdrift.domain.entity.BookInfo;
public class BookAction extends AjaxBase {

	@Autowired
	BookService bookService;
	@Autowired 
	QueryService queryService;
	public String bookName;
	public String data;
	public boolean isAjax;
	public String  tag;
	public String query() {
		try{
			BookInfo bookInfo = JsonUtils.JsonToJavaBean(enCoding(data), BookInfo.class);
			List<Book> bookList = bookService.query(bookInfo);
			setSuccessResultWithList(bookList);	
		}catch(Exception e ){
			setFailureResult(ActionMessage.FINAL_EXCEPTION_MESSAGE);
		}
		return SUCCESS;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
   
	public String getBooksUnderTag(){
		String email = LoginUtils.getCurrentLoginUserEmail();
		List<Book> bookList = queryService.getBookUnderEmailAndSpecailTag(email, tag);
		setElementInDate("books", bookList);
		setDateWithErrorMsg("");
		setTopElementInResult("tag", tag);
		return SUCCESS;
	}
}
