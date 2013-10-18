package com.turtledove.bookdrift.commom.Enum;

public enum UpdateOptionResult {

	SUCCESS(1,"更新成功"),
	EXIT(2,"已存在"),
	Exception(3,"操作异常");
	private int code;
	private String desc;
	
	private UpdateOptionResult(int code,String desc){
		
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
