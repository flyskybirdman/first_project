package com.zp.cloudnote.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zp.cloudnote.dao.BookDAO;
import com.zp.cloudnote.util.Resultmsg;

@Service("bookService")
public class BookServiceImpl implements BookService{
	@Resource
	private BookDAO bookDAO;
	
	public Resultmsg loadBooks(String userId) {
		List<Map>list=bookDAO.findByUserId(userId);
		Resultmsg resultmsg=new Resultmsg();
		resultmsg.setStatus(0);
		resultmsg.setMsg("加载完毕");
		resultmsg.setData(list);
		return resultmsg;
	}

}
