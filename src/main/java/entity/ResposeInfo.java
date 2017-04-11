package entity;

import javax.persistence.Entity;
import javax.persistence.Table;


public class ResposeInfo {
	private int code;//200³É¹¦
	private String msg;
	private Object data;
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
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public ResposeInfo() {
		super();
	}
	public ResposeInfo(int code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
	
	

}
