package com.zp.cloudnote.controller.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.zp.cloudnote.service.UserService;
import com.zp.cloudnote.util.Resultmsg;

@Controller
public class UserController {
	
	@Resource(name="userService")
	private UserService userService;
	@RequestMapping("/user/login.do")
	@ResponseBody
	public Resultmsg execute(String name,String password){
		Resultmsg resultmsg=userService.checklogin(name, password);		
		return resultmsg;
	}
}
