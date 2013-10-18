package com.turtledove.bookdrift.commom.Enum;

public enum ActionResult {

	SUCCESS(1,"添加成功"),
	EXIST(2,"已存在"),
	FAIL(3,"操作失败");

	private int code;
	private String desc;
	
	private ActionResult(int code,String desc){
		
		this.code = code;
		this.desc = desc;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

}
