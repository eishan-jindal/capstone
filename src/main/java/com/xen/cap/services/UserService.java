package com.xen.cap.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xen.cap.converter.UserConverter;
import com.xen.cap.dao.UserDao;
import com.xen.cap.dto.UserDto;
import com.xen.cap.entity.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;

	public void saveUser(UserDto userDto) {
		
		userDao.saveUser(UserConverter.convertFromDto(userDto));
		return;
	}

	public UserDto getUserDto(String username) {

		User user = userDao.getUserByUsername(username);

		return UserConverter.convertToDto(user);
	}
	
	public UserDto getUserDtoByCredentials(String username, String password) {

		User user = userDao.getUserByCredentials(username, password);

		return UserConverter.convertToDto(user);
	}

}
