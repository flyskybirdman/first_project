package com.zp.cloudnote.service;

import com.zp.cloudnote.util.Resultmsg;

public interface NoteService {
	public Resultmsg loadnotes(String userid);
	public Resultmsg loadnote(String noteid);
}
