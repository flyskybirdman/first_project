package com.zp.cloudnote.service;

import com.zp.cloudnote.util.Resultmsg;

public interface UserService {
	public Resultmsg checklogin(String name,String password);
	public Resultmsg addUser(String name,String password,String nick);
	public Resultmsg checkUser(String name);
}
