package com.turtledove.bookdrift.web;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.turtledove.bookdrift.application.service.BookService;
import com.turtledove.bookdrift.common.framework.ActionMessage;
import com.turtledove.bookdrift.common.framework.AjaxBase;
import com.turtledove.bookdrift.common.utils.JsonUtils;
import com.turtledove.bookdrift.domain.entity.Book;
import com.turtledove.bookdrift.domain.entity.BookInfo;
public class BookAction extends AjaxBase {

	@Autowired
	BookService bookService;
	public String bookName;
	public String data;
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

	private String enCoding(String key) throws UnsupportedEncodingException{
		String key_copy = new String(key.getBytes("ISO-8859-1"), "UTF-8");
		key = key_copy;
		return key;
	}
}
