package com.xen.cap.dao;

import com.xen.cap.entity.User;

public interface UserDao {
	public User getUserById(long userID);
	public User getUserByCredentials(String username, String password);
}
