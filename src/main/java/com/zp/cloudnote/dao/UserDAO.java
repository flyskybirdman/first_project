package com.zp.cloudnote.dao;

import com.zp.cloudnote.entity.User;

//@Repository("userDAO")
public interface UserDAO {
	public User findByName(String name);
	public void save(User user);
}
