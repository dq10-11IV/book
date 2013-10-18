package com.turtledove.bookdrift.web;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.turtledove.bookdrift.application.service.UserBookAssService;
import com.turtledove.bookdrift.commom.Enum.ActionResult;
import com.turtledove.bookdrift.common.framework.ActionMessage;
import com.turtledove.bookdrift.common.framework.AjaxBase;
import com.turtledove.bookdrift.common.framework.ProjectConstants;
import com.turtledove.bookdrift.common.utils.LoginUtils;
import com.turtledove.bookdrift.domain.entity.Book;
import com.turtledove.bookdrift.domain.entity.UserBookAss;

public class UserBookAssAction extends AjaxBase{

	public boolean ajax;
	public String publisher;
	public String isbn13;
	public String title;
	public String image;
	public String author ;
	public String summary;
	public String price;
	@Autowired
	UserBookAssService userBookAssService ;
	
	public String addBook(){
		if(ajax==false)
			return TO_ADD_BOOK_PAGE;
		UserBookAss userBookAss = createUserBookWithUserId();
		Book book = createBookWithHttpParam();
		ActionResult actionReuslt = userBookAssService.save(book, userBookAss);
		
		if(actionReuslt == ActionResult.EXIST)
			setDateWithErrorMsg(ActionMessage.BOOK_EXIS);
		else if(actionReuslt == ActionResult.SUCCESS)
			setDateWithErrorMsg(ActionMessage.ADD_BOOK_SUCCESS);
		return SUCCESS;
	}
	private Book createBookWithHttpParam() {
		Book book = new Book();
		book.setAuthorName(author);
		book.setBookName(title);
		book.setBookPress(publisher);
		book.setIsbn(isbn13);
		book.setImageUrl(image);
		book.setSummary(summary.length() <=ProjectConstants.SUMMARY_LENGTH ?summary:summary.substring(0, ProjectConstants.SUMMARY_LENGTH));
		book.setBookPrice(Double.valueOf(price.length() > 2 ?price.substring(0, price.length() - 2):"-1"));
		book.setCreateDate(new Date());
		book.setLastUpdateDate(new Date());
		return book;
	}
	private UserBookAss createUserBookWithUserId() {
		UserBookAss userBookAss = new UserBookAss();
		userBookAss.setCreateDate(new Date());
		userBookAss.setIsOnHand(true);
		userBookAss.setIsWanted(false);
		userBookAss.setUserId(LoginUtils.getCurrentLoginUserId());
		userBookAss.setCreateDate(new Date());
		userBookAss.setLastUpdateDate(new Date());
		return userBookAss;
	}
	public void setAjax(boolean ajax) {
		this.ajax = ajax;
	}
}
