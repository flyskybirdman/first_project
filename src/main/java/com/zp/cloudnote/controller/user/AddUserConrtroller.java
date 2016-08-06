package com.zp.cloudnote.controller.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zp.cloudnote.service.UserService;
import com.zp.cloudnote.util.Resultmsg;

@Controller
public class AddUserConrtroller {
	@Resource
	private UserService service;
	
	@RequestMapping("/user/add.do")
	@ResponseBody
	public Resultmsg regist(String name, String password, String nick){
		Resultmsg resultmsg=service.addUser(name, password, nick);
		return resultmsg;
	}
	
	@RequestMapping("/user/checkname.do")
	@ResponseBody
	public Resultmsg checkname(String name){
		Resultmsg resultmsg=service.checkUser(name);
		return resultmsg;
	}
	
}
