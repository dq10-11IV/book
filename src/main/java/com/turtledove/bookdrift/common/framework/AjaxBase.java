package com.turtledove.bookdrift.common.framework;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class AjaxBase {

	public static String SUCCESS = "success";
	public Map<String,Object> result = new HashMap<String,Object>();
	
	protected void setSuccessfulResult(Collection<?> collection){
	     result.put("code", 200);
	     result.put("result",collection);
	}
}
