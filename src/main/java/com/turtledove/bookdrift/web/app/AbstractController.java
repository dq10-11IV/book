package com.turtledove.bookdrift.web.app;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AbstractController {
    public static final int SUCCESS_CODE = 200;
    public static final int FAILURE_CODE = 500;
    
    public static final String SUCCESS ="success";
    
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
    //  row.put("total", rowCount);
        row.put("data", list);
        return row;
    }
    private void setResult(int code, Object object) {
         result.put("code",code);
         result.put("msg",object);
         
    }
    protected String enCoding(String key) throws UnsupportedEncodingException{
        String key_copy = new String(key.getBytes("ISO-8859-1"), "UTF-8");
        key = key_copy;
        return key;
    }
    
}
