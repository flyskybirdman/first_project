package com.zp.cloudnote.dao;

import java.util.List;import java.util.Map;
import com.zp.cloudnote.entity.Note;

public interface NoteDAO {
	public List<Map> findByBookId(String bookid);
	public Note findById(String noteid);
}
