package com.zp.cloudnote.util;

import java.io.Serializable;

public class Resultmsg implements Serializable {
	
	private int status;
	private String msg;
	private Object data;
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
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
	
	@Override
	public String toString() {
		return "Resultmsg [status=" + status + ", msg=" + msg + ", data=" + data + "]";
	}
	
	
}
