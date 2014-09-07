package com.turtledove.bookdrift.web.app;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.turtledove.bookdrift.application.service.LabelService;
import com.turtledove.bookdrift.application.service.QueryService;
import com.turtledove.bookdrift.application.service.UserBookAssService;
import com.turtledove.bookdrift.commom.Enum.ActionResult;
import com.turtledove.bookdrift.common.agent.LogServiceAgent;
import com.turtledove.bookdrift.common.utils.LoginUtils;
import com.turtledove.bookdrift.domain.entity.Book;
import com.turtledove.bookdrift.domain.entity.UserBookAss;

public class BookController extends AbstractController{
    
    private String publisher;
    private String isbn13;
    private String isbn10;
    private String title;
    private String image;
    private String author ;
    private String summary;
    private String price;

    private int labelId;
    private long bookId;
    @Autowired
    UserBookAssService userBookAssService ;
    
    @Autowired 
    QueryService queryService;
    
    @Autowired
    LabelService labelService;
    
    public String shareBook(){
        try{
            UserBookAss userBookAss = createUserBookWithUserId();
            Book book = createBookWithHttpParam();
            ActionResult actionReuslt = userBookAssService.save(book, userBookAss);
            setSuccessResult(actionReuslt.getDesc());
        }catch(Exception e ){
            e.printStackTrace();
            setFailureResult(ActionResult.FAIL.getDesc());          
        }
        return  SUCCESS;
    }
    
    public String myBook(){
        try{
            List<Book> books = queryService.getBookUnderUser(LoginUtils.getCurrentLoginUserId());
            setSuccessResultWithList(books);
        }catch(Exception e){
            e.printStackTrace();
            setFailureResult("加载失败");
        }
        return SUCCESS;
    }
    
    public String cancleShare(){
    	
    	try{
    		long userId = LoginUtils.getCurrentLoginUserId();
    		boolean result = userBookAssService.remove(userId,bookId);
    		if(result)
    			setSuccessResult("已取消分享！");
    		else setFailureResult("取消失败！");
    	}catch(Exception e){
    		setFailureResult("取消分享失败！");
    		LogServiceAgent.error(e.getMessage(), e);
    	}
    	return SUCCESS;
    }
    public String bookUnderLabel(){
        try {
            Map<String,Object> para = new HashMap<String, Object>();
            para.put("currentUserId", LoginUtils.getCurrentLoginUserId());
            para.put("labelId", labelId);
            List<Book> books = queryService.getBooksUnderLableExceptCurrentUser(para); 
            setSuccessResultWithList(books);
        } catch (Exception e) {
           LogServiceAgent.error("book-under-label", e);
           setFailureResult("load error");
        }
           return SUCCESS;
    }
    public String query(){
        
        try {
            Map<String,Object> para = new HashMap<String,Object>();
            para.put("userId", LoginUtils.getCurrentLoginUserId());
            para.put("bookName", title);
            List<Book> books = queryService.query(para);
            setSuccessResultWithList(books);
        } catch (Exception e) {
            LogServiceAgent.error("book-under-query", e);
            setFailureResult("load error");
        }
        return SUCCESS;
    }
    private Book createBookWithHttpParam() {
        Book book = new Book();
        book.setAuthorName(author);
        book.setBookName(title);
        book.setBookPress(publisher);
        book.setIsbn(isbn13);
        book.setImageUrl(image);
        if(summary != null)
        book.setSummary(summary);
        if(price != null && price.length() != 0)
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
  

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public void setIsbn10(String isbn10) {
        this.isbn10 = isbn10;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public String getIsbn10() {
        return isbn10;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public String getAuthor() {
        return author;
    }

    public String getSummary() {
        return summary;
    }

    public String getPrice() {
        return price;
    }
    public int getLabelId() {
        return labelId;
    }
    public void setLabelId(int labelId) {
        this.labelId = labelId;
    }

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}
}