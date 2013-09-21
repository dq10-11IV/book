package com.turtledove.bookdrift.common.utils;

import net.sf.json.JSONObject;

import com.turtledove.bookdrift.common.AbstractClass.AbstractDomainObject;

public class JsonUtils {

	public static  <T> T  JsonToJavaBean(String jsonStr,Class<T> clazz){

		JSONObject obj = new JSONObject().fromObject(validationStr(jsonStr));
		return (T) JSONObject.toBean(obj, clazz);
	}
	private static String validationStr(String str){
		if(!str.endsWith("}")) str +="}";
		if(!str.startsWith("{")) str = "{"+str;
		return str;
	}
}
