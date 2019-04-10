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

	public List<UserDto> getAllUserAccounts() {
		return null;
	}

	public UserDto getUserDto(String userId) {
		Long id = Long.parseLong(userId);
		User user = userDao.getUserById(id);

		return UserConverter.convertToDto(user);
	}

	public List<UserDto> getFbAdsDaily(String accId) {
		return null;
	}

	public List<UserDto> getFbAdInsights(List<User> adsList) {
		return null;
	}
}
