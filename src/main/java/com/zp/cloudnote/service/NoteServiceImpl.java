package com.zp.cloudnote.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zp.cloudnote.dao.NoteDAO;
import com.zp.cloudnote.entity.Note;
import com.zp.cloudnote.util.Resultmsg;
@Service("noteService")
public class NoteServiceImpl implements NoteService{
	@Resource
	private NoteDAO noteDAO;
	
	public Resultmsg loadnotes(String userid) {
		List<Map>list=noteDAO.findByBookId(userid);
		Resultmsg resultmsg=new Resultmsg();
		resultmsg.setStatus(0);
		resultmsg.setMsg("加载笔记完成");
		resultmsg.setData(list);
		return resultmsg;
	}

	public Resultmsg loadnote(String noteid) {
		Note note=noteDAO.findById(noteid);
		Resultmsg resultmsg=new Resultmsg();
		resultmsg.setStatus(0);
		resultmsg.setMsg("笔记加载完成");
		resultmsg.setData(note);
		return resultmsg;
	}

}
