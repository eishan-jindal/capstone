package com.xen.cap.dao;

import com.xen.cap.entity.User;

public interface UserDao {
	public User getUserByUsername(String username);
	public User getUserByCredentials(String username, String password);
	public void saveUser(long id, String balance, String role, String password, String username);
	public void saveUser(User user);
}
