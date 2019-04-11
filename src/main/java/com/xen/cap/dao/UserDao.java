package com.xen.cap.dao;

import com.xen.cap.entity.User;

public interface UserDao {
	public User getUserByUsername(String username);
	public User getUserByCredentials(String username, String password);
	public void saveUser(User user);
}
