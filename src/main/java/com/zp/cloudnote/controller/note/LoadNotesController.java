package com.zp.cloudnote.controller.note;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zp.cloudnote.service.NoteService;
import com.zp.cloudnote.util.Resultmsg;
@Controller
public class LoadNotesController {
	@Resource
	private NoteService noteService;
	
	@RequestMapping("/note/loadbooknote.do")
	@ResponseBody
	public Resultmsg execute(String bookid){
		Resultmsg resultmsg=noteService.loadnotes(bookid);
		return resultmsg;
	}	
	
}
