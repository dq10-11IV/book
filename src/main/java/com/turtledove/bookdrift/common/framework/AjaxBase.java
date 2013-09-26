package com.turtledove.bookdrift.common.framework;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.turtledove.bookdrift.common.utils.JsonUtils;

public class AjaxBase {

	public static String SUCCESS = "success";
	public static String TOLOGINPAGE="tologinpage";
	public static String TO_HUB_PAGE ="tohubpage"; 
	public static String TO_LOGIN_PAGR_WITH_FAIL_MSG = "tologinpagewithfailmsg";
	public static int SUCCESS_CODE = 200;
	public static int FAILURE_CODE = 500;
	public String jsonResult = new String();
	public Map<String,Object> result = new HashMap<String,Object>();
	public Map<String,Object> dataresult = new HashMap<String, Object>();
	protected void setSuccessResult(Object object){
	     setResult(SUCCESS_CODE,object);
	}

	protected void  setFailureResult(Object msg) {
		setResult(FAILURE_CODE, msg);
	}
	
	public void setSuccessResultWithList(List<?> list) {
		//Map<String, Object> row = getMsg(list);
		setResult(SUCCESS_CODE, list);
	}

	private Map<String, Object> getMsg(List<?> list) {
		int rowCount = 0;

		if (list != null)
			rowCount = list.size();

		Map<String, Object> row = new HashMap<String, Object>();
	//	row.put("total", rowCount);
		row.put("data", list);
		return row;
	}
	private void setResult(int code, Object object) {
		 result.put("code",code);
         result.put("data",object);
         
	}
	protected String enCoding(String key) throws UnsupportedEncodingException{
		String key_copy = new String(key.getBytes("ISO-8859-1"), "UTF-8");
		key = key_copy;
		return key;
	}
	
	public void setDateResult(){
		result.put("data", dataresult);
	}
	public void setDateWithErrorMsg(String errorMsg){
		setErrorMsg(errorMsg);
		setDateResult();
	}
	public void setElementInDate(String key,Object value){
		dataresult.put(key, value);
	}
    public void setErrorMsg(String errorMsg){
    	dataresult.put("error", errorMsg);
    }
	public void setTopElementInResult(String key,String value){
		result.put(key, value);
	}
	public void setJsonResult(){
		
		jsonResult = JsonUtils.ObjectToJson(result);
		System.out.println(jsonResult);
	}
}
