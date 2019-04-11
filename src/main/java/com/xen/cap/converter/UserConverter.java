package com.xen.cap.converter;

import com.xen.cap.dto.UserDto;
import com.xen.cap.entity.User;

public class UserConverter {

	public static UserDto convertToDto(User user) {
		if(user==null) {
			UserDto userDto = new UserDto();
			userDto.setUsername("null user");
			return userDto;
		}
		UserDto userDto = new UserDto();
		userDto.setBalance(user.getBalance());
		userDto.setPassword(user.getPassword());
		userDto.setRole(user.getRole());
		userDto.setUsername(user.getUsername());
		return userDto;
	}
	public static User convertFromDto(UserDto user) {
		
		User userDto = new User();
		if(user==null) {
			
			userDto.setUsername("null user");
			return userDto;
		}

		userDto.setBalance(user.getBalance());
		userDto.setPassword(user.getPassword());
		userDto.setRole(user.getRole());
		userDto.setUsername(user.getUsername());
		return userDto;
	}

}
