package com.edu.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author joven
 *通用的返回json数据类，并包含了状态等信息
 */
public class JsonWithMsg {

	//状态码，100-处理成功，200-处理失败
	private int code;
	//提示信息
	private String msg;
	//要返回给浏览器的数据
	private Map<String,Object> extend =new HashMap<String,Object>();
	
	public static JsonWithMsg success(){
		JsonWithMsg result=new JsonWithMsg();
		result.setCode(100);
		result.setMsg("处理成功");
		return result;
	}
	
	public static JsonWithMsg fail(){
		JsonWithMsg result=new JsonWithMsg();
		result.setCode(200);
		result.setMsg("处理失败");
		return result;
	}
	
	public JsonWithMsg add(String key,Object value){
		this.getExtend().put(key, value);
		return this;
	}
	
	
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Map<String, Object> getExtend() {
		return extend;
	}
	public void setExtend(Map<String, Object> extend) {
		this.extend = extend;
	}
	
}
