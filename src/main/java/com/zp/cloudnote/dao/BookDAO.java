package com.zp.cloudnote.dao;

import java.util.List;
import java.util.Map;

public interface BookDAO {
	public List<Map> findByUserId(String userId);
}
