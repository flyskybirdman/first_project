package com.zp.cloudnote.service;

import java.security.NoSuchAlgorithmException;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zp.cloudnote.dao.UserDAO;
import com.zp.cloudnote.entity.User;
import com.zp.cloudnote.util.NoteException;
import com.zp.cloudnote.util.NoteUtil;
import com.zp.cloudnote.util.Resultmsg;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Resource(name="userDAO")
	private UserDAO dao;
	
	public Resultmsg checklogin(String name, String password) {
		
		User user=dao.findByName(name);		
		Resultmsg rs=new Resultmsg();
		
		if(user==null){
			rs.setStatus(1);
			rs.setMsg("该用户不存在");
			return rs;
		}
		
		try {			
			String pwd=NoteUtil.md5(password);
			if(! user.getCn_user_password().equals(pwd)){
				rs.setStatus(2);
				rs.setMsg("输入密码错误");
				return rs;
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			throw new NoteException("登录异常",e);		
		}

			rs.setStatus(0);
			rs.setMsg("登录成功");
			rs.setData(user);
			return rs;
		
	}

	public Resultmsg addUser(String name, String password, String nick) {
		Resultmsg resultmsg=new Resultmsg();		
		try {
			
		/*
			if(dao.findByName(name)!=null){
				resultmsg.setStatus(1);
				resultmsg.setMsg("该用户名已存在");
				return resultmsg;
			}
		*/
			resultmsg=checkUser(name);
			if (resultmsg.getStatus()==1) {
				return resultmsg;
			}
		
			User user=new User();
			user.setCn_user_name(name);
			user.setCn_user_nick(nick);
			String  pwd = NoteUtil.md5(password);
			user.setCn_user_password(pwd);
			user.setCn_user_id(NoteUtil.createId());
			dao.save(user);
			resultmsg.setStatus(0);
			resultmsg.setMsg("注册成功");
			return resultmsg;
		} catch (Exception e) {
			e.printStackTrace();
			throw new NoteException("注册异常",e);
		}
	}
	
	public Resultmsg checkUser(String name){
		
		Resultmsg resultmsg=new Resultmsg();		
			if(dao.findByName(name)!=null){
				resultmsg.setStatus(1);
				resultmsg.setMsg("该用户名已存在");
				return resultmsg;
			}else{
				resultmsg.setStatus(0);
				resultmsg.setMsg("该用户名可用");
				return resultmsg;
			}
	}
}
