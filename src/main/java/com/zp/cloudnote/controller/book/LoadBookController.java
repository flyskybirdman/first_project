package com.zp.cloudnote.controller.book;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.zp.cloudnote.service.BookService;
import com.zp.cloudnote.util.Resultmsg;

@Controller
public class LoadBookController {
	@Resource
	private BookService bookService;
	
	@RequestMapping("/book/loadbooks.do")
	@ResponseBody
	public Resultmsg execute(String userId){
		Resultmsg resultmsg=bookService.loadBooks(userId);
		return resultmsg;
	}
}
